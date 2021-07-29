package com.intuit.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.intuit.demo.model.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {
}