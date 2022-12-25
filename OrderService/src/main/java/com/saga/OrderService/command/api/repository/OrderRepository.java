package com.saga.OrderService.command.api.repository;

import com.saga.OrderService.command.api.data.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,String > {
}
