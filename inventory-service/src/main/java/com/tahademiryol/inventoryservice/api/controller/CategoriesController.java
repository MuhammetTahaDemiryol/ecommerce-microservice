package com.tahademiryol.inventoryservice.api.controller;


import com.tahademiryol.inventoryservice.business.abstracts.CategoryService;
import com.tahademiryol.inventoryservice.business.dto.request.create.CreateCategoryRequest;
import com.tahademiryol.inventoryservice.business.dto.request.update.UpdateCategoryRequest;
import com.tahademiryol.inventoryservice.business.dto.response.create.CreateCategoryResponse;
import com.tahademiryol.inventoryservice.business.dto.response.get.GetAllCategoriesResponse;
import com.tahademiryol.inventoryservice.business.dto.response.get.GetCategoryResponse;
import com.tahademiryol.inventoryservice.business.dto.response.update.UpdateCategoryResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/categories")
public class CategoriesController {
    private final CategoryService service;

    public CategoriesController(CategoryService service) {
        this.service = service;
    }

    @GetMapping
    public List<GetAllCategoriesResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public GetCategoryResponse getById(@PathVariable UUID id) {
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateCategoryResponse add(@RequestBody CreateCategoryRequest request) {
        return service.add(request);
    }

    @PutMapping("/{id}")
    public UpdateCategoryResponse update(@PathVariable UUID id, @RequestBody UpdateCategoryRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}
