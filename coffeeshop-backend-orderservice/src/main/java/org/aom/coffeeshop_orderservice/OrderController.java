package org.aom.coffeeshop_orderservice;

import jakarta.validation.Valid;
import org.aom.coffeeshop_orderservice.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
class OrderController {

    private static final Logger log = LoggerFactory.getLogger(OrderController.class);

    private final OrderService orderService;

    OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    CreateOrderResponse createOrder(@Valid @RequestBody CreateOrderRequest request) {
        //String userName = securityService.getLoginUserName();
        String userName = "dummy_user";
        log.info("Creating order for user: {}", userName);
        return orderService.createOrder(userName, request);
    }

    @GetMapping("{orderNumber}")
    OrderDTO getOrder(@PathVariable(name = "orderNumber") String orderNum) {
        log.info("Inside OrderController::getOrder() with orderNumber: {}", orderNum);
        return orderService
                .getOrderByOrderNumber(orderNum)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }

    @GetMapping()
    PagedResult<OrderSummary> getOrders(@RequestParam(name = "page", defaultValue = "1") int pageNo){
        log.info("OrderController:getOrders() was invoked with pageNo: {}", pageNo);
        return orderService.getOrders(pageNo);
    }
}
