package org.aom.coffeeshop_backend;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.ResourceUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author : abhishekomprakash
 * @since : Thu, 2024-Nov-07
 * Created with IntelliJ IDEA
 */

public class CoffeeClassUtil {
    public static void main(String[] args) throws IOException {
        CoffeeClassUtil coffeeClassUtil = new CoffeeClassUtil();
        coffeeClassUtil.serializeCoffee();
    }

    private void serializeCoffee() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<CoffeeEntity> coffees = objectMapper
                .readValue(ResourceUtils.getFile("classpath:coffees.json"), new TypeReference<List<CoffeeEntity>>() {});
        List<CoffeeSQLRecord> list = coffees.stream().map(CoffeeMapper::toCoffeeSQLRecord).toList();

        list.forEach(System.out::println);
    }
}
