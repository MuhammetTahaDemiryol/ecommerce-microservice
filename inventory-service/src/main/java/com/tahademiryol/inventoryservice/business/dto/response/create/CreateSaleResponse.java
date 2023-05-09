package com.tahademiryol.inventoryservice.business.dto.response.create;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateSaleResponse {
    private UUID id;
    private int productId;
    private int numberOfPurchases;
    private double unitPrice;
    private double totalPrice;
    private LocalDateTime dateOfPurchase;
}

