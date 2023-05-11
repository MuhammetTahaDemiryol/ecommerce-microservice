package com.tahademiryol.commonpackage.events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductCreatedEvent {
    private UUID productId;
    private UUID categoryId;
    private UUID saleId;
    private int stockQuantity;
    private double unitPrice;
    private boolean status;
    private String name;
    private String categoryName;
    private String description;
}
