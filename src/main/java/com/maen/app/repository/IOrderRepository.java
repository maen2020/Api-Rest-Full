package com.maen.app.repository;

import com.maen.app.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderRepository extends JpaRepository<OrderEntity, Integer> {
}
