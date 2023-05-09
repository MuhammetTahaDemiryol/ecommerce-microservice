package com.tahademiryol.inventoryservice.business.concretes;

import com.tahademiryol.commonpackage.utils.mappers.ModelMapperService;
import com.tahademiryol.inventoryservice.business.abstracts.SaleService;
import com.tahademiryol.inventoryservice.business.dto.request.create.CreateSaleRequest;
import com.tahademiryol.inventoryservice.business.dto.request.update.UpdateSaleRequest;
import com.tahademiryol.inventoryservice.business.dto.response.create.CreateSaleResponse;
import com.tahademiryol.inventoryservice.business.dto.response.get.GetAllSalesResponse;
import com.tahademiryol.inventoryservice.business.dto.response.get.GetSaleResponse;
import com.tahademiryol.inventoryservice.business.dto.response.update.UpdateSaleResponse;
import com.tahademiryol.inventoryservice.entities.Sale;
import com.tahademiryol.inventoryservice.repository.SaleRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class SaleManager implements SaleService {
    private final SaleRepository repository;
    private final ModelMapperService mapper;

    public SaleManager(SaleRepository repository, ModelMapperService mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<GetAllSalesResponse> getAll() {
        return null;
    }

    @Override
    public GetSaleResponse getById(UUID id) {
        return null;
    }

    @Override
    public CreateSaleResponse add(CreateSaleRequest request) {
        Sale sale = mapper.forRequest().map(request, Sale.class);
        sale.setId(null);
        sale.setTotalPrice(getTotalPrice(sale));
        sale.setProductId(request.getProductId());
        sale.setDateOfPurchase(LocalDateTime.now());
        repository.save(sale);
        return mapper.forResponse().map(sale, CreateSaleResponse.class);
    }

    @Override
    public UpdateSaleResponse update(UUID id, UpdateSaleRequest request) {
        Sale sale = mapper.forRequest().map(request, Sale.class);
        sale.setId(id);
        sale.setTotalPrice(getTotalPrice(sale));
        repository.save(sale);

        return mapper.forResponse().map(sale, UpdateSaleResponse.class);
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }


    private double getTotalPrice(Sale sale) {
        return sale.getUnitPrice() * sale.getNumberOfPurchases();
    }
}
