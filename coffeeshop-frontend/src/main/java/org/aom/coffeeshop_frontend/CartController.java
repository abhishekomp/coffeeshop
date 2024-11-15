package org.aom.coffeeshop_frontend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class CartController {

    private static final Logger logger = LoggerFactory.getLogger(CartController.class);

    @GetMapping("/cart")
    String displayCart(){
        logger.info("Inside CartController:displayCart()");
        return "cart";
    }
}
