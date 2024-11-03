package com.marketplace.service;

import com.marketplace.dto.OrderDTO;
import com.marketplace.dto.OrderMapper;
import com.marketplace.entity.Order;
import com.marketplace.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderServiceImp implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    public OrderServiceImp(OrderRepository orderRepository, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }


    @Override
    public Optional<OrderDTO> findById(Long id) {
        return orderRepository.findById(id).map(orderMapper::toDto);
    }

    @Override
    public List<OrderDTO> findAll() {
        return orderRepository.findAll().stream()
                .map(dto->orderMapper.toDto(dto)).collect(Collectors.toList());
    }

    @Override
    public OrderDTO save(OrderDTO orderDTO) {
        Order order = orderRepository.save(orderMapper.toEntity(orderDTO));
        return orderMapper.toDto(order);
    }

    @Override
    public void deleteById(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public Optional<OrderDTO> update(Long id, OrderDTO orderDTO) {
        return orderRepository.findById(id)
                .map(orderInBD->{
                    orderInBD.setClient(orderDTO.client());
                    orderInBD.setStatus(orderDTO.status());
                    orderInBD.setTotal(orderDTO.total());

                    return orderRepository.save(orderInBD);

        }).map(orderMapper::toDto);
    }

}
