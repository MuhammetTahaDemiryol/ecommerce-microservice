package com.tahademiryol.inventoryservice.business.concretes;

import com.tahademiryol.commonpackage.utils.mappers.ModelMapperService;
import com.tahademiryol.inventoryservice.business.abstracts.CategoryService;
import com.tahademiryol.inventoryservice.business.abstracts.ProductService;
import com.tahademiryol.inventoryservice.business.dto.request.create.CreateProductRequest;
import com.tahademiryol.inventoryservice.business.dto.request.update.ChangeProductStatusRequest;
import com.tahademiryol.inventoryservice.business.dto.request.update.UpdateProductRequest;
import com.tahademiryol.inventoryservice.business.dto.response.create.CreateProductResponse;
import com.tahademiryol.inventoryservice.business.dto.response.get.*;
import com.tahademiryol.inventoryservice.business.dto.response.update.UpdateProductResponse;
import com.tahademiryol.inventoryservice.entities.Category;
import com.tahademiryol.inventoryservice.entities.Product;
import com.tahademiryol.inventoryservice.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductManager implements ProductService {
    private final ProductRepository repository;
    private final ModelMapperService mapper;
    private final CategoryService categoryService;

    public ProductManager(ProductRepository repository, ModelMapperService mapper, CategoryService categoryService) {
        this.repository = repository;
        this.mapper = mapper;
        this.categoryService = categoryService;
    }


    @Override
    public List<GetAllProductsResponse> getAll(String Status) {
        List<Product> products = repository.findAll();
        return products.stream()
                //It's case-insensitive, other than true it will return false
                .filter(product -> product.isStatus() == Boolean.parseBoolean(Status))
                .map(product -> mapper.forResponse().map(product, GetAllProductsResponse.class)).toList();

    }

    @Override
    public List<GetAllProductsWithCategoriesResponse> getAllProductsWithCategories(String Status) {

        return repository.findAll().stream()
                //It's case-insensitive, other than true it will return false
                .filter(product -> product.isStatus() == Boolean.parseBoolean(Status))
                .map(product -> {
                    List<GetAllCategoriesResponse> getAllCategoriesResponse =
                            product.getCategories().stream()
                                    .map(category -> mapper.forResponse().map(category, GetAllCategoriesResponse.class))
                                    .collect(Collectors.toList());
                    GetAllProductsWithCategoriesResponse getAllProductsWithCategoriesResponse1 =
                            mapper.forResponse().map(product, GetAllProductsWithCategoriesResponse.class);
                    getAllProductsWithCategoriesResponse1.setCategoryResponses(getAllCategoriesResponse);
                    return getAllProductsWithCategoriesResponse1;
                })
                .collect(Collectors.toList());
    }

    @Override
    public GetProductResponse getById(UUID id) {
        return mapper.forResponse().map(repository.findById(id).orElseThrow(), GetProductResponse.class);
    }

    @Override
    public GetProductWithCategoriesResponse getProductWithCategoriesById(UUID id) {
        Product product = repository.findById(id).orElseThrow();
        List<GetAllCategoriesResponse> productWithCategoriesResponses =
                product.getCategories()
                        .stream()
                        .map(category -> mapper.forResponse().map(category, GetAllCategoriesResponse.class)).toList();
        GetProductWithCategoriesResponse response = mapper.forResponse().map(product, GetProductWithCategoriesResponse.class);
        response.setCategoryResponses(productWithCategoriesResponses);
        return response;
    }

    @Override
    public CreateProductResponse add(CreateProductRequest request) {

        return mapper.forResponse().map(repository.save(mapper.forRequest().map(request, Product.class)), CreateProductResponse.class);
    }

    @Override
    public UpdateProductResponse update(UUID id, UpdateProductRequest request) {
        Product product = repository.findById(id).orElseThrow();
        Category category = mapper.forRequest().map(categoryService.getById(request.getCategoryId()), Category.class);
        product.setDescription(request.getDescription());
        product.setName(request.getName());
        product.setStockQuantity(request.getStockQuantity());
        product.setUnitPrice(request.getUnitPrice());
        product.getCategories().add(category);
        repository.save(product);
        return mapper.forResponse().map(product, UpdateProductResponse.class);
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public GetProductResponse changeStatus(UUID id, ChangeProductStatusRequest request) {
        Product product = repository.findById(id).orElseThrow();
        product.setStatus(request.isStatus());
        repository.save(product);
        return mapper.forResponse().map(product, GetProductResponse.class);
    }
}
