package com.tahademiryol.inventoryservice.api.controller;

import com.tahademiryol.inventoryservice.business.abstracts.ProductService;
import com.tahademiryol.inventoryservice.business.dto.request.create.CreateProductRequest;
import com.tahademiryol.inventoryservice.business.dto.request.update.ChangeProductStatusRequest;
import com.tahademiryol.inventoryservice.business.dto.request.update.UpdateProductRequest;
import com.tahademiryol.inventoryservice.business.dto.response.create.CreateProductResponse;
import com.tahademiryol.inventoryservice.business.dto.response.get.GetAllProductsResponse;
import com.tahademiryol.inventoryservice.business.dto.response.get.GetAllProductsWithCategoriesResponse;
import com.tahademiryol.inventoryservice.business.dto.response.get.GetProductResponse;
import com.tahademiryol.inventoryservice.business.dto.response.get.GetProductWithCategoriesResponse;
import com.tahademiryol.inventoryservice.business.dto.response.update.UpdateProductResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/products")
public class ProductsController {
    private final ProductService service;

    public ProductsController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/getAll/{status}")
    public List<GetAllProductsResponse> getAll(@PathVariable String status) {
        return service.getAll(status);
    }

    @GetMapping("/with-categories/{status}")
    public List<GetAllProductsWithCategoriesResponse> getAllProductsWithCategories(@PathVariable String status) {
        return service.getAllProductsWithCategories(status);
    }

    @GetMapping("/{id}")
    public GetProductResponse getById(@PathVariable UUID id) {
        return service.getById(id);
    }

    @GetMapping("/with-category/{id}")
    public GetProductWithCategoriesResponse getProductWithCategoriesById(@PathVariable UUID id) {
        return service.getProductWithCategoriesById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateProductResponse add(@RequestBody CreateProductRequest request) {
        return service.add(request);
    }

    @PutMapping("/{id}")
    public UpdateProductResponse update(@PathVariable UUID id, @RequestBody UpdateProductRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }

    @PutMapping("/{id}/false")
    public GetProductResponse changeStatus(@PathVariable UUID id, @RequestBody ChangeProductStatusRequest request) {
        return service.changeStatus(id, request);
    }
}
