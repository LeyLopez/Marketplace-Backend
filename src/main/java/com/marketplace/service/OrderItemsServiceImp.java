package com.marketplace.service;

import com.marketplace.dto.OrderItemsDTO;
import com.marketplace.dto.OrderItemsMapper;
import com.marketplace.entity.OrderItems;
import com.marketplace.repository.OrderItemsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderItemsServiceImp implements OrderItemsService {

    private final OrderItemsRepository orderItemsRepository;
    private final OrderItemsMapper orderItemsMapper;

    public OrderItemsServiceImp(OrderItemsRepository orderItemsRepository, OrderItemsMapper orderItemsMapper) {
        this.orderItemsRepository = orderItemsRepository;
        this.orderItemsMapper = orderItemsMapper;
    }


    @Override
    public Optional<OrderItemsDTO> findById(Long id) {
        return orderItemsRepository.findById(id).map(orderItemsMapper::toDto);
    }

    @Override
    public List<OrderItemsDTO> findAll() {
        return orderItemsRepository.findAll().stream()
                .map(dto->orderItemsMapper.toDto(dto))
                .collect(Collectors.toList());
    }

    @Override
    public OrderItemsDTO save(OrderItemsDTO orderItemsDTO) {
        OrderItems orderItems = orderItemsRepository.save(orderItemsMapper.toEntity(orderItemsDTO));
        return orderItemsMapper.toDto(orderItemsRepository.save(orderItems));
    }

    @Override
    public void delete(Long id) {
        orderItemsRepository.deleteById(id);
    }

    @Override
    public Optional<OrderItemsDTO> update(Long id, OrderItemsDTO orderItemsDTO) {
        return orderItemsRepository.findById(id)
                .map(orderItemsInBD->{
                    orderItemsInBD.setOrder(orderItemsDTO.order());
                    orderItemsInBD.setProduct(orderItemsDTO.product());
                    orderItemsInBD.setQuantity(orderItemsDTO.quantity());

                    return orderItemsRepository.save(orderItemsInBD);

        }).map(orderItemsMapper::toDto);
    }
}
