package org.aom.coffeeshop_orderservice.model;

import java.time.LocalDateTime;

public record OrderSummary(
        String orderNumber,
        OrderStatus status,
        LocalDateTime createdAt) {
}
