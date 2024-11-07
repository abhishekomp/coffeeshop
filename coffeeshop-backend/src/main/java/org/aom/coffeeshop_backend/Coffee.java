package org.aom.coffeeshop_backend;

import java.math.BigDecimal;

public record Coffee(String code, String name, String description, String imageUrl, BigDecimal price) {
}
