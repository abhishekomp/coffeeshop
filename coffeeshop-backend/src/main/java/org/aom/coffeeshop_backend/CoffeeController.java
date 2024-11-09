package org.aom.coffeeshop_backend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/coffeeShop")
public class CoffeeController {
    private static final Logger logger = LoggerFactory.getLogger(CoffeeController.class);

    private final CoffeeService coffeeService;

    public CoffeeController(CoffeeService coffeeService) {
        this.coffeeService = coffeeService;
    }

//    @GetMapping("")
//    public ResponseEntity<List<CoffeeEntity>> getAllPosts(){
//        logger.info("PostController::getAllPosts() was invoked");
//        List<CoffeeEntity> all = coffeeService.getAllCoffee();
//        return ResponseEntity.ok(all);
//    }

    @GetMapping
    PagedResult<Coffee> getProducts(@RequestParam(name = "page", defaultValue = "1") int pageNo){
        logger.info("CoffeeController:getProducts() was invoked with pageNo: {}", pageNo);
        return coffeeService.getProducts(pageNo);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public CoffeeEntity addNewCoffee(@RequestBody CoffeeEntity coffee){
        logger.info("CoffeeController::addNewCoffee() was invoked with coffee: {}", coffee);
        return coffeeService.addNewCoffee(coffee);
    }
}
