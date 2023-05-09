package com.tahademiryol.inventoryservice.business.dto.request.create;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateSaleRequest {
    private int productId;
    private int numberOfPurchases;
    private double unitPrice;
}
