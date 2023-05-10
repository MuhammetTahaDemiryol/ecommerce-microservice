package com.tahademiryol.filterservice.business.concretes;

import com.tahademiryol.commonpackage.utils.mappers.ModelMapperService;
import com.tahademiryol.filterservice.business.abstracts.FilterService;
import com.tahademiryol.filterservice.business.dto.responses.GetAllFiltersResponses;
import com.tahademiryol.filterservice.business.dto.responses.GetFilterResponse;
import com.tahademiryol.filterservice.entities.Filter;
import com.tahademiryol.filterservice.repository.FilterRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FilterManager implements FilterService {
    private final FilterRepository repository;
    private final ModelMapperService mapper;

    public FilterManager(FilterRepository repository, ModelMapperService mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<GetAllFiltersResponses> getAll() {
        var filters = repository.findAll();

        return filters.stream()
                .map(filter -> mapper.forResponse().map(filter, GetAllFiltersResponses.class))
                .toList();
    }

    @Override
    public GetFilterResponse getById(UUID id) {
        var filter = repository.findById(id).orElseThrow();
        return mapper.forResponse().map(filter, GetFilterResponse.class);
    }

    @Override
    public void add(Filter filter) {
        filter.setId(UUID.randomUUID());
        repository.save(filter);
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public void deleteAllByCategoryId(UUID categoryId) {

    }

    @Override
    public void deleteAllByProductId(UUID productId) {

    }

}
