package com.tahademiryol.inventoryservice.business.dto.response.get;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetAllProductsWithCategoriesResponse {
    private UUID id;
    private int stockQuantity;
    private double unitPrice;
    private boolean status;
    private String description;
    private String name;
    private List<GetAllCategoriesResponse> categoryResponses;
}
