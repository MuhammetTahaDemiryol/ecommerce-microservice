package com.tahademiryol.filterservice.business.abstracts;

import com.tahademiryol.filterservice.business.dto.responses.GetAllFiltersResponses;
import com.tahademiryol.filterservice.business.dto.responses.GetFilterResponse;
import com.tahademiryol.filterservice.entities.Filter;

import java.util.List;
import java.util.UUID;

public interface FilterService {
    List<GetAllFiltersResponses> getAll();

    GetFilterResponse getById(UUID id);

    //! Will not be used outside the service layer
    void add(Filter filter);

    void delete(UUID id);

    void deleteAllByCategoryId(UUID categoryId); //! Bulk delete

    void deleteAllByProductId(UUID productId); //! Bulk delete
}
