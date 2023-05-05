package com.maen.app.service;

import com.maen.app.entity.OrderEntity;
import com.maen.app.exceptions.RequestUpdateException;
import com.maen.app.exceptions.ResponseDeleteIdException;
import com.maen.app.exceptions.ResponseGetByIdException;
import com.maen.app.mapper.OrderInDTOToOrder;
import com.maen.app.repository.IOrderRepository;
import com.maen.app.service.dto.OrderInDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OrderService {

    private final IOrderRepository orderRepository;

    private final OrderInDTOToOrder mapper;

    public List<OrderEntity> getAllOrder(){
        return this.orderRepository.findAll();
    }

    public Optional<OrderEntity> getByIdOrder(Integer id) throws ResponseGetByIdException{
        Optional<OrderEntity> optionalOrder = orderRepository.findById(id);
        if (!optionalOrder.isPresent()){
            throw new ResponseGetByIdException("Id not found");
        }
        return optionalOrder;
    }

    public OrderEntity saveOrder(OrderInDto orderInDto){
        OrderEntity orderEntity = mapper.map(orderInDto);
        return this.orderRepository.save(orderEntity);
    }

    public OrderEntity updateOrder(Integer id, OrderEntity orderEntity) throws RequestUpdateException {
        Optional<OrderEntity> order = orderRepository.findById(id);
        if (!order.isPresent()){
            throw new RequestUpdateException("The Id you are trying to update does not exist.");
        }
        OrderEntity updateOrder = orderRepository.findById(id).get();
        updateOrder.setProduct(orderEntity.getProduct());
        updateOrder.setPrice(orderEntity.getPrice());
        orderRepository.save(updateOrder);
        return updateOrder;
    }

    public void deleteOrder(Integer id) throws ResponseDeleteIdException{
        Optional<OrderEntity> deleteCustomer = orderRepository.findById(id);
        if (!deleteCustomer.isPresent()){
            throw new ResponseDeleteIdException("Error when trying to delete a non-existing Id.");
        }
        this.orderRepository.deleteById(id);
    }
}
