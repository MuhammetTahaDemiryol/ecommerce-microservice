package com.tahademiryol.inventoryservice.business.concretes;

import com.tahademiryol.commonpackage.events.CategoryDeletedEvent;
import com.tahademiryol.commonpackage.utils.mappers.ModelMapperService;
import com.tahademiryol.inventoryservice.business.abstracts.CategoryService;
import com.tahademiryol.inventoryservice.business.dto.request.create.CreateCategoryRequest;
import com.tahademiryol.inventoryservice.business.dto.request.update.UpdateCategoryRequest;
import com.tahademiryol.inventoryservice.business.dto.response.create.CreateCategoryResponse;
import com.tahademiryol.inventoryservice.business.dto.response.get.GetAllCategoriesResponse;
import com.tahademiryol.inventoryservice.business.dto.response.get.GetCategoryResponse;
import com.tahademiryol.inventoryservice.business.dto.response.update.UpdateCategoryResponse;
import com.tahademiryol.inventoryservice.business.kafka.InventoryProducer;
import com.tahademiryol.inventoryservice.entities.Category;
import com.tahademiryol.inventoryservice.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CategoryManager implements CategoryService {
    private final CategoryRepository repository;

    private final ModelMapperService mapper;
    private final InventoryProducer producer;

    public CategoryManager(CategoryRepository repository, ModelMapperService mapper,
                           InventoryProducer producer) {
        this.repository = repository;
        this.mapper = mapper;
        this.producer = producer;

    }


    @Override
    public List<GetAllCategoriesResponse> getAll() {
        List<Category> categories = repository.findAll();
        return categories.stream()
                .map(category -> mapper.forResponse().map(category, GetAllCategoriesResponse.class)).toList();
    }

    @Override
    public GetCategoryResponse getById(UUID id) {
        return mapper.forResponse().map(repository.findById(id).orElseThrow(), GetCategoryResponse.class);
    }

    @Override
    public CreateCategoryResponse add(CreateCategoryRequest request) {
        return mapper.forResponse()
                .map(repository.save(mapper.forRequest()
                        .map(request, Category.class)), CreateCategoryResponse.class);
    }

    @Override
    public UpdateCategoryResponse update(UUID id, UpdateCategoryRequest request) {
        Category category = repository.findById(id).orElseThrow();
        category.setName(request.getName());
        repository.save(category);
        return mapper.forResponse().map(category, UpdateCategoryResponse.class);
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
        producer.sendCategoryDeleteMessage(new CategoryDeletedEvent(id));
    }


}
