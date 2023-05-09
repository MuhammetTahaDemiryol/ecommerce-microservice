package com.tahademiryol.inventoryservice.business.abstracts;

import com.tahademiryol.inventoryservice.business.dto.request.create.CreateCategoryRequest;
import com.tahademiryol.inventoryservice.business.dto.request.update.UpdateCategoryRequest;
import com.tahademiryol.inventoryservice.business.dto.response.create.CreateCategoryResponse;
import com.tahademiryol.inventoryservice.business.dto.response.get.GetAllCategoriesResponse;
import com.tahademiryol.inventoryservice.business.dto.response.get.GetCategoryResponse;
import com.tahademiryol.inventoryservice.business.dto.response.update.UpdateCategoryResponse;

import java.util.List;
import java.util.UUID;

public interface CategoryService {
    List<GetAllCategoriesResponse> getAll();

    GetCategoryResponse getById(UUID id);

    CreateCategoryResponse add(CreateCategoryRequest request);

    UpdateCategoryResponse update(UUID id, UpdateCategoryRequest request);

    void delete(UUID id);
}
