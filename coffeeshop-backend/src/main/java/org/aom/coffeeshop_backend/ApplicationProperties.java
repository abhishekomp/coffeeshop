package org.aom.coffeeshop_backend;

import jakarta.validation.constraints.Min;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.DefaultValue;

@ConfigurationProperties(prefix = "products")
public record ApplicationProperties(
        @DefaultValue("10")
        @Min(1)
        int pageSize) {}
