package org.aom.coffeeshop_backend;

/**
 * @author : abhishekomprakash
 * @since : Thu, 2024-Nov-07
 * Created with IntelliJ IDEA
 */

public class CoffeeMapper {
    static Coffee toProduct(CoffeeEntity productEntity) {
        return new Coffee(
                productEntity.getCode(),
                productEntity.getName(),
                productEntity.getDescription(),
                productEntity.getImageUrl(),
                productEntity.getPrice());
    }
}
