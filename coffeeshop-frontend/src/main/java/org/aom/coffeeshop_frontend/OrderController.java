package org.aom.coffeeshop_frontend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
class OrderController {

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @GetMapping("/orders/{orderNumber}")
    String showOrderDetails(@PathVariable(name = "orderNumber") String orderNum, Model model){
        logger.info("OrderController:showOrderDetails() called with orderNumber: {}", orderNum);
        model.addAttribute("orderNumber", orderNum);
        return "order_details";
    }

    @GetMapping("/orders")
    String showOrders(@RequestParam(name = "page", defaultValue = "1") int pageNo, Model model){
        logger.info("CoffeeUIController:showOrders() called with pageNo: {}", pageNo);
        model.addAttribute("pageNo", pageNo);
        return "orders";
    }
}
