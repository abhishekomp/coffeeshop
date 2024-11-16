package org.aom.coffeeshop_orderservice;

import org.aom.coffeeshop_orderservice.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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

    PagedResult<OrderSummary> getOrders(int pageNo){
        log.info("OrderService:getOrders() called with pageNo: {}", pageNo);
        pageNo = pageNo <= 1 ? 0: pageNo - 1;
        Sort sortByCreatedDateDesc = Sort.by("createdAt").descending();
        Pageable pageable = PageRequest.of(pageNo, 5, sortByCreatedDateDesc);
        Page<OrderSummary> orderSummaryPage = orderRepository.findAll(pageable).map(OrderMapper::convertToOrderSummary);
        log.info("orderSummaryPage.getSize(): {}", orderSummaryPage.getSize());
        log.info("orderSummaryPage.getContent().size(): {}", orderSummaryPage.getContent().size());
        return new PagedResult<OrderSummary>(
                orderSummaryPage.getContent(),
                orderSummaryPage.getTotalElements(),
                orderSummaryPage.getNumber() + 1,
                orderSummaryPage.getTotalPages(),
                orderSummaryPage.isFirst(),
                orderSummaryPage.isLast(),
                orderSummaryPage.hasNext(),
                orderSummaryPage.hasPrevious()
        );
    }

/*    List<OrderSummary> getOrders(int pageNo){
        log.info("OrderService:getOrders() called with pageNo: {}", pageNo);
        return orderRepository
                .findAll()
                .stream()
                .map(OrderMapper::convertToOrderSummary)
                .toList();
    }*/
}
