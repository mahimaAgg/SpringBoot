package com.intuit.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intuit.demo.exception.CustomException;
import com.intuit.demo.model.Order;
import com.intuit.demo.repository.OrderRepository;
import com.intuit.demo.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired OrderRepository orderRepository;

	@Override
    public Iterable<Order> getAllOrders() {
        return this.orderRepository.findAll();
    }
	
	
	@Override
    public Order create(Order order) throws CustomException {
        try {
			return this.orderRepository.save(order);
		} catch (Exception e) {
			throw new CustomException("Order does not saved because of some internal issue");
		}
    }

	@Override
    public void update(Order order) {
        this.orderRepository.save(order);
    }
}