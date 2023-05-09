package com.tahademiryol.inventoryservice.business.dto.request.update;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateSaleRequest {
    private int productId;
    private int numberOfPurchases;
    private double unitPrice;
}
