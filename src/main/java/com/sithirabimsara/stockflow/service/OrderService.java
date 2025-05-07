package com.sithirabimsara.stockflow.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sithirabimsara.stockflow.dto.OrderRequestDTO;
import com.sithirabimsara.stockflow.dto.OrderResponseDTO;
import com.sithirabimsara.stockflow.entity.Order;
import com.sithirabimsara.stockflow.repo.OrderRepo;

@Service
public class OrderService {

    @Autowired
    private OrderRepo orderRepo;


    public List<OrderResponseDTO> findAllOrders(){
        List<Order> ordersList = orderRepo.findAll();
        return ordersList.stream().map(this::mapOrderToOrderResponseDTO).toList();
    }

    public OrderResponseDTO getOrderById(Long id){
        Order existingOrder = orderRepo.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
        return mapOrderToOrderResponseDTO(existingOrder);
    }

    public OrderResponseDTO saveOrder(OrderRequestDTO orderRequestDTO){
        Order newOrder = mapOrderRequestDTOTOOrder(orderRequestDTO);
        newOrder.setOrderDate(LocalDate.now());
        Order savedOrder = orderRepo.save(newOrder);
        return mapOrderToOrderResponseDTO(savedOrder);
    }



    private Order mapOrderRequestDTOTOOrder(OrderRequestDTO orderRequestDTO) {
        return Order.builder()
            .deliveryDate(orderRequestDTO.getDeliveryDate())
            .totalAmount(orderRequestDTO.getTotalAmount())
            .products(orderRequestDTO.getProducts())
            .build();
    }

    private OrderResponseDTO mapOrderToOrderResponseDTO(Order order) {
        return OrderResponseDTO.builder()
            .id(order.getId())
            .orderDate(order.getOrderDate())
            .deliveryDate(order.getDeliveryDate())
            .totalAmount(order.getTotalAmount())
            .products(order.getProducts())
            .build();
    }
}
