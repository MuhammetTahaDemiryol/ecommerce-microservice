package com.tahademiryol.inventoryservice.business.abstracts;

import com.tahademiryol.inventoryservice.business.dto.request.create.CreateSaleRequest;
import com.tahademiryol.inventoryservice.business.dto.request.update.UpdateSaleRequest;
import com.tahademiryol.inventoryservice.business.dto.response.create.CreateSaleResponse;
import com.tahademiryol.inventoryservice.business.dto.response.get.GetAllSalesResponse;
import com.tahademiryol.inventoryservice.business.dto.response.get.GetSaleResponse;
import com.tahademiryol.inventoryservice.business.dto.response.update.UpdateSaleResponse;

import java.util.List;
import java.util.UUID;

public interface SaleService {
    List<GetAllSalesResponse> getAll();

    GetSaleResponse getById(UUID id);

    CreateSaleResponse add(CreateSaleRequest request);

    UpdateSaleResponse update(UUID id, UpdateSaleRequest request);

    void delete(UUID id);
}
