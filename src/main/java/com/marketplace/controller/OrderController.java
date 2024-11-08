package com.marketplace.controller;

import com.marketplace.dto.OrderDTO;
import com.marketplace.entity.Response;
import com.marketplace.exceptions.NotFoundException;
import com.marketplace.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> getOrderById(@PathVariable Long id) {
        return orderService.findById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new NotFoundException("Order with id " + id + " not found"));
    }

    @GetMapping
    public ResponseEntity<List<OrderDTO>> getAllOrders() {
        return ResponseEntity.ok(orderService.findAll());
    }

    @PostMapping
    public ResponseEntity<OrderDTO> createOrder(@RequestBody OrderDTO orderDTO) {
        OrderDTO createdOrder = orderService.save(orderDTO);
        return ResponseEntity.ok(createdOrder);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderDTO> updateOrder(@PathVariable Long id, @RequestBody OrderDTO orderDTO) {
        return orderService.update(id, orderDTO)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new NotFoundException("Order with id " + id + " not found"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<OrderDTO> deleteOrder(@PathVariable Long id) {
        return orderService.findById(id).map(o->{
                    orderService.deleteById(id);
                    return ResponseEntity.ok().body(o);
                }

        ).orElseThrow(()->new NotFoundException("Order with id "+id+" not found"));
    }
}
