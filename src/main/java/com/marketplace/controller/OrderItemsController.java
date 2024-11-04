package com.marketplace.controller;

import com.marketplace.dto.OrderItemsDTO;
import com.marketplace.service.OrderItemsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/order-items")
public class OrderItemsController {

    private final OrderItemsService orderItemsService;

    public OrderItemsController(OrderItemsService orderItemsService) {
        this.orderItemsService = orderItemsService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderItemsDTO> getOrderItemById(@PathVariable Long id) {
        return orderItemsService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<OrderItemsDTO> getAllOrderItems() {
        return orderItemsService.findAll();
    }

    @PostMapping
    public ResponseEntity<OrderItemsDTO> createOrderItem(@RequestBody OrderItemsDTO orderItemsDTO) {
        OrderItemsDTO createdOrderItem = orderItemsService.save(orderItemsDTO);
        return ResponseEntity.ok(createdOrderItem);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderItemsDTO> updateOrderItem(@PathVariable Long id, @RequestBody OrderItemsDTO orderItemsDTO) {
        return orderItemsService.update(id, orderItemsDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrderItem(@PathVariable Long id) {
        orderItemsService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
