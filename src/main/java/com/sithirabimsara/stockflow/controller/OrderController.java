package com.sithirabimsara.stockflow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sithirabimsara.stockflow.dto.OrderRequestDTO;
import com.sithirabimsara.stockflow.dto.OrderResponseDTO;
import com.sithirabimsara.stockflow.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("api/v1/order")
@CrossOrigin(origins = "*")
public class OrderController {
    
    @Autowired
    private OrderService orderService;

    
    @GetMapping("/getAll")
    public ResponseEntity<List<OrderResponseDTO>> getAllOrders(){
        List<OrderResponseDTO> orderResponseDTOList = orderService.findAllOrders();
        return new ResponseEntity<>(orderResponseDTOList, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<OrderResponseDTO> getById(@PathVariable("id") Long id){
        OrderResponseDTO orderResponseDTO = orderService.getOrderById(id);
        return new ResponseEntity<>(orderResponseDTO, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<OrderResponseDTO> saveOrder(@RequestBody OrderRequestDTO orderRequestDTO) {
        OrderResponseDTO orderResponseDTO = orderService.saveOrder(orderRequestDTO);
        return new ResponseEntity<>(orderResponseDTO, HttpStatus.CREATED);
    }
    

}
