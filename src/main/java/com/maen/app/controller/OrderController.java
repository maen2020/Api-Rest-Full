package com.maen.app.controller;

import com.maen.app.entity.OrderEntity;
import com.maen.app.exceptions.RequestUpdateException;
import com.maen.app.exceptions.ResponseDeleteIdException;
import com.maen.app.exceptions.ResponseGetByIdException;
import com.maen.app.service.OrderService;
import com.maen.app.service.dto.OrderInDto;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    public List<OrderEntity> getAllOrders(){
        return this.orderService.getAllOrder();
    }

    @GetMapping("/{id}")
    public Optional<OrderEntity> getByIdOrder(@PathVariable Integer id) throws ResponseGetByIdException {
        return this.orderService.getByIdOrder(id);
    }

    @PostMapping
    public ResponseEntity<OrderEntity> saveOrder(@RequestBody OrderInDto orderInDto){
         return ResponseEntity.status(HttpStatus.CREATED)
                 .body(orderService.saveOrder(orderInDto));
    }

    @PutMapping("/{id}")
    public OrderEntity updateOrder(@PathVariable Integer id, @RequestBody OrderEntity orderEntity) throws RequestUpdateException {
        return this.orderService.updateOrder(id, orderEntity);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Integer id) throws ResponseDeleteIdException {
        this.orderService.deleteOrder(id);
    }
}
