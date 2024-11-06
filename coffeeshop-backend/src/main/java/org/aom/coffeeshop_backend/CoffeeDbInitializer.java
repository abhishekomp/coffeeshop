package org.aom.coffeeshop_backend;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.List;

@Component
public class CoffeeDbInitializer implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(CoffeeDbInitializer.class);
    @Autowired
    private final CoffeeRepository coffeeRepository;

    @Autowired
    ObjectMapper objectMapper;

    public CoffeeDbInitializer(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("Attempting to read coffee.json file to load into the database");
        //List<Post> posts = objectMapper.readValue("classpath:posts.json", new TypeReference<List<Post>>() {});
//        List<CoffeeEntity> posts = objectMapper
//                .readValue(new File("src/main/resources/coffees.json"), new TypeReference<List<CoffeeEntity>>() {});
        //ResourceUtils.getFile("classpath:demo.txt")
        List<CoffeeEntity> coffees = objectMapper
                .readValue(ResourceUtils.getFile("classpath:coffees.json"), new TypeReference<List<CoffeeEntity>>() {});

        //coffees.forEach(System.out::println);

        coffeeRepository.saveAll(coffees);
        logger.info("coffee.json file read and {} records loaded to the database", coffees.size());
    }
}
