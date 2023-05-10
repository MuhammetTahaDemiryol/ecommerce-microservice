package com.tahademiryol.filterservice.api.controller;

import com.tahademiryol.filterservice.business.abstracts.FilterService;
import com.tahademiryol.filterservice.business.dto.responses.GetAllFiltersResponses;
import com.tahademiryol.filterservice.business.dto.responses.GetFilterResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController

@RequestMapping("/api/filters")
public class FiltersController {
    private final FilterService service;

    public FiltersController(FilterService service) {
        this.service = service;
    }

    @GetMapping
    public List<GetAllFiltersResponses> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public GetFilterResponse getById(@PathVariable UUID id) {
        return service.getById(id);
    }
}
