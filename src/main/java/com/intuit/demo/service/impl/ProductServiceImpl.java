package com.intuit.demo.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intuit.demo.model.Product;
import com.intuit.demo.repository.ProductRepository;
import com.intuit.demo.service.ProductService;

import lombok.Data;

@Data
@Service
public class ProductServiceImpl implements ProductService {
	@Autowired ProductRepository productRepository;

	@Override
	public Iterable<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public Optional<Product> getProduct(long id) {
		return productRepository.findById(id);
	}

	@Override
	public void save(Product product) {
		//  orderRepository.saveAll(product);
	}
	
}
