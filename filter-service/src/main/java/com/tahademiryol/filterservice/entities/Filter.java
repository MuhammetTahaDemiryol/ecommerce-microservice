package com.tahademiryol.filterservice.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.UUID;

@Document
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Filter {
    @Id
    private UUID id;
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
