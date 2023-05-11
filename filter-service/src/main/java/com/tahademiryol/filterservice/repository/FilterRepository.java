package com.tahademiryol.filterservice.repository;

import com.tahademiryol.filterservice.entities.Filter;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface FilterRepository extends MongoRepository<Filter, String> {
    void deleteByProductId(UUID productId);

    void deleteAllByCategoryId(UUID categoryId);
}
