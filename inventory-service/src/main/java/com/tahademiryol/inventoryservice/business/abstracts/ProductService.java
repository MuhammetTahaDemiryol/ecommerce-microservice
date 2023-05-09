package com.tahademiryol.inventoryservice.business.abstracts;

import com.tahademiryol.inventoryservice.business.dto.request.create.CreateProductRequest;
import com.tahademiryol.inventoryservice.business.dto.request.update.ChangeProductStatusRequest;
import com.tahademiryol.inventoryservice.business.dto.request.update.UpdateProductRequest;
import com.tahademiryol.inventoryservice.business.dto.response.create.CreateProductResponse;
import com.tahademiryol.inventoryservice.business.dto.response.get.GetAllProductsResponse;
import com.tahademiryol.inventoryservice.business.dto.response.get.GetAllProductsWithCategoriesResponse;
import com.tahademiryol.inventoryservice.business.dto.response.get.GetProductResponse;
import com.tahademiryol.inventoryservice.business.dto.response.get.GetProductWithCategoriesResponse;
import com.tahademiryol.inventoryservice.business.dto.response.update.UpdateProductResponse;

import java.util.List;
import java.util.UUID;

public interface ProductService {

    List<GetAllProductsResponse> getAll(String Status);

    List<GetAllProductsWithCategoriesResponse> getAllProductsWithCategories(String Status);


    GetProductResponse getById(UUID id);

    GetProductWithCategoriesResponse getProductWithCategoriesById(UUID id);


    CreateProductResponse add(CreateProductRequest request);

    UpdateProductResponse update(UUID id, UpdateProductRequest request);

    void delete(UUID id);


    GetProductResponse changeStatus(UUID id, ChangeProductStatusRequest request);
}
