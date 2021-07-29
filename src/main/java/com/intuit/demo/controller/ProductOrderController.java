package com.intuit.demo.controller;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intuit.demo.exception.CustomException;
import com.intuit.demo.model.Order;
import com.intuit.demo.model.Product;
import com.intuit.demo.service.impl.OrderServiceImpl;
import com.intuit.demo.service.impl.ProductServiceImpl;

@RestController
@RequestMapping("/api/v1")
public class ProductOrderController {

	@Autowired ProductServiceImpl productService;
	@Autowired OrderServiceImpl orderService;
	
	@GetMapping(value = "/get-price/{id}")
	public Double getPriceOfProduct(@PathVariable("id") long productId) throws CustomException {
		 
		Optional<Product> product= productService.getProduct(productId);
		if(!product.isPresent()) {
			throw new CustomException("Product Not found");
		}
		return product.get().getPrice();
	}
	
	@PostMapping(value = "/save-order")
	public Order saveOrder(@RequestBody Order order) throws CustomException {
		 order.setDate(LocalDate.now());
		return orderService.create(order);
		// return "Order created successfully";
	}
	

}
