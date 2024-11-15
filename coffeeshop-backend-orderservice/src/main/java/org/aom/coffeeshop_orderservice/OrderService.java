package org.aom.coffeeshop_orderservice;

import org.aom.coffeeshop_orderservice.model.CreateOrderRequest;
import org.aom.coffeeshop_orderservice.model.CreateOrderResponse;
import org.aom.coffeeshop_orderservice.model.OrderDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class OrderService {
    private static final Logger log = LoggerFactory.getLogger(OrderService.class);
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public CreateOrderResponse createOrder(String userName, CreateOrderRequest request) {
        log.info("OrderService::createOrder() was called");
        //orderValidator.validate(request);
        OrderEntity newOrder = OrderMapper.convertToEntity(request);
        newOrder.setUserName(userName);
        OrderEntity savedOrder = this.orderRepository.save(newOrder);
        log.info("Created Order with orderNumber={}", savedOrder.getOrderNumber());

        return new CreateOrderResponse(savedOrder.getOrderNumber());
    }

    public Optional<OrderDTO> getOrderByOrderNumber(String orderNum) {
        log.info("OrderService::getOrderByOrderNumber() was called");
        return orderRepository.findByOrderNumber(orderNum)
                .map(OrderMapper::convertToDTO);
    }
}
