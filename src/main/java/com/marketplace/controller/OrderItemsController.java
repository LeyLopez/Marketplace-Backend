package com.marketplace.controller;

import com.marketplace.dto.OrderItemsDTO;
import com.marketplace.exceptions.NotFoundException;
import com.marketplace.service.OrderItemsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
                .orElseThrow(() -> new NotFoundException("Order item with id " + id + " not found"));
    }

    @GetMapping
    public ResponseEntity<List<OrderItemsDTO>> getAllOrderItems() {
        return ResponseEntity.ok(orderItemsService.findAll());
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
                .orElseThrow(() -> new NotFoundException("Order item with id " + id + " not found"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<OrderItemsDTO> deleteOrderItem(@PathVariable Long id) {
        return orderItemsService.findById(id).map(o->{
            orderItemsService.delete(id);
            return ResponseEntity.ok().body(o);
        }).orElseThrow(()->new NotFoundException("Order item with id " + id + " not found"));
    }
}
