package org.aom.coffeeshop_backend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class CoffeeService {
    private static final Logger logger = LoggerFactory.getLogger(CoffeeService.class);
    private final CoffeeRepository coffeeRepository;

    CoffeeService(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }

    CoffeeEntity addNewCoffee(CoffeeEntity coffee){
        logger.info("CoffeeService:addNewCoffee() called with coffee: {}", coffee);
        CoffeeEntity save = coffeeRepository.save(coffee);
        logger.info("CoffeeService:addNewCoffee() saved coffee: {}", save);
        return save;
    }

    public List<CoffeeEntity> getAllCoffee() {
        return coffeeRepository.findAll();
    }
}
