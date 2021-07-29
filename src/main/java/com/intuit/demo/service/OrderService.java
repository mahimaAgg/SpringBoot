package com.intuit.demo.service;

import com.intuit.demo.exception.CustomException;
import com.intuit.demo.model.Order;

public interface OrderService {

	Iterable<Order> getAllOrders();

	Order create(Order order) throws CustomException;

	void update(Order order);

}