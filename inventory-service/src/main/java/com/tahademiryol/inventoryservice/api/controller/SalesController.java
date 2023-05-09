package com.tahademiryol.inventoryservice.api.controller;

import com.tahademiryol.inventoryservice.business.abstracts.SaleService;
import com.tahademiryol.inventoryservice.business.dto.request.create.CreateSaleRequest;
import com.tahademiryol.inventoryservice.business.dto.request.update.UpdateSaleRequest;
import com.tahademiryol.inventoryservice.business.dto.response.create.CreateSaleResponse;
import com.tahademiryol.inventoryservice.business.dto.response.get.GetAllSalesResponse;
import com.tahademiryol.inventoryservice.business.dto.response.get.GetSaleResponse;
import com.tahademiryol.inventoryservice.business.dto.response.update.UpdateSaleResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/sales")
public class SalesController {
    private final SaleService service;

    public SalesController(SaleService service) {
        this.service = service;
    }

    @GetMapping
    public List<GetAllSalesResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public GetSaleResponse getById(@PathVariable UUID id) {
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateSaleResponse add(@RequestBody CreateSaleRequest request) {
        return service.add(request);
    }

    @PutMapping("/{id}")
    public UpdateSaleResponse update(@PathVariable UUID id, @RequestBody UpdateSaleRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}
