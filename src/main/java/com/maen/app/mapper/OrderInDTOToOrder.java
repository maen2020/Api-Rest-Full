package com.maen.app.mapper;

import com.maen.app.entity.OrderEntity;
import com.maen.app.service.dto.OrderInDto;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class OrderInDTOToOrder implements IOrderMapper<OrderInDto, OrderEntity>{


    @Override
    public OrderEntity map(OrderInDto in) {

        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setProduct(in.getProduct());
        orderEntity.setPrice(in.getPrice());
        orderEntity.setCustomerId(in.getCustomerId());

        orderEntity.setCreationDate(LocalDate.now());
        return orderEntity;
    }
}
