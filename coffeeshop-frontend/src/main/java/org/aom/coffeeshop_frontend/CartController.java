package org.aom.coffeeshop_frontend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class CartController {

    @GetMapping("/cart")
    String displayCart(){
        return "cart";
    }
}
