package com.tahademiryol.inventoryservice.business.dto.request.create;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductRequest {
    private UUID categoryId;
    private int stockQuantity;
    private double unitPrice;
    private boolean status;
    private String name;
    private String description;
}
