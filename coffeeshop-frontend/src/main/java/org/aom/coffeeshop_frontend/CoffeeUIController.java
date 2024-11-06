package org.aom.coffeeshop_frontend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author : abhishekomprakash
 * @since : Wed, 2024-Nov-06
 * Created with IntelliJ IDEA
 */

@Controller
//@RequestMapping("/")
class CoffeeUIController {

    private static final Logger log = LoggerFactory.getLogger(CoffeeUIController.class);

    @GetMapping
    String index() {
        return "redirect:/products";
    }

    @GetMapping("/products")
    String showProductsPage(@RequestParam(name = "page", defaultValue = "1") int page, Model model) {
        model.addAttribute("pageNo", page);
        return "products";
    }

}
