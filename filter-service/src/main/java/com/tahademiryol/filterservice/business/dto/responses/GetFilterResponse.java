package com.tahademiryol.filterservice.business.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetFilterResponse {
    private String id;
    private UUID productId;
    private UUID categoryId;
    private UUID saleId;

    private int stockQuantity;
    private double productUnitPrice;
    private boolean Status;

    private int numberOfPurchases;
    private double saleUnitPrice;
    private double totalPrice;
    private LocalDateTime dateOfPurchase;

    private String categoryName;
    private String productName;
    private String productDescription;
}
