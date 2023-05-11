package com.tahademiryol.filterservice.business.kafka.consumer;

import com.tahademiryol.commonpackage.events.CategoryDeletedEvent;
import com.tahademiryol.commonpackage.events.ProductCreatedEvent;
import com.tahademiryol.commonpackage.events.ProductDeletedEvent;
import com.tahademiryol.commonpackage.utils.mappers.ModelMapperService;
import com.tahademiryol.filterservice.business.abstracts.FilterService;
import com.tahademiryol.filterservice.entities.Filter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class InventoryConsumer {
    private final FilterService service;
    private final ModelMapperService mapper;

    @KafkaListener(topics = "Product-created", groupId = "filter-product-created")
    public void consume(ProductCreatedEvent event) {
        var filter = mapper.forRequest().map(event, Filter.class);
        service.add(filter);
        log.info("Product created event consumed {}", event);
    }

    @KafkaListener(topics = "Product-deleted", groupId = "filter-product-deleted")
    public void consume(ProductDeletedEvent event) {
        service.deleteByProductId(event.getProductId());
        log.info("Product deleted event consumed {}", event);
    }

    @KafkaListener(topics = "Category-deleted", groupId = "filter-category-deleted")
    public void deleteCategory(CategoryDeletedEvent event) {
        service.deleteAllByCategoryId(event.getCategoryId());
        log.info("Category deleted event consumed {}", event);
    }


}
