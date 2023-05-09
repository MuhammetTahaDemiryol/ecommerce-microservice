package com.tahademiryol.inventoryservice.repository;

import com.tahademiryol.inventoryservice.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SaleRepository extends JpaRepository<Sale, UUID> {
}
