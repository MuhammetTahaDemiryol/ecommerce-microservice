package com.tahademiryol.inventoryservice.business.kafka;

import com.tahademiryol.commonpackage.events.CategoryDeletedEvent;
import com.tahademiryol.commonpackage.events.ProductCreatedEvent;
import com.tahademiryol.commonpackage.events.ProductDeletedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class InventoryProducer {
    private final KafkaTemplate<String, Object> kafkaTemplate;


    public void sendMessage(ProductCreatedEvent event) {
        log.info(String.format("Product-created-event sent -> %s", event.toString()));
        Message<ProductCreatedEvent> message = MessageBuilder
                .withPayload(event)
                .setHeader(KafkaHeaders.TOPIC, "Product-created")
                .build();

        kafkaTemplate.send(message);
    }

    public void sendMessage(ProductDeletedEvent event) {
        log.info(String.format("Product-deleted-event sent -> %s", event.toString()));
        Message<ProductDeletedEvent> message = MessageBuilder
                .withPayload(event)
                .setHeader(KafkaHeaders.TOPIC, "Product-deleted")
                .build();

        kafkaTemplate.send(message);
    }

    public void sendCategoryDeleteMessage(CategoryDeletedEvent event) {
        log.info(String.format("Category-deleted-event sent -> %s", event));
        Message<CategoryDeletedEvent> message = MessageBuilder
                .withPayload(event)
                .setHeader(KafkaHeaders.TOPIC, "Category-deleted")
                .build();

        kafkaTemplate.send(message);
    }


}
