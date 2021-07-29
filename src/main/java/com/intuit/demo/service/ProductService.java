package com.intuit.demo.service;

import java.util.Optional;

import com.intuit.demo.model.Product;

public interface ProductService {

	Iterable<Product> getAllProducts();

	Optional<Product> getProduct(long id);

	void save(Product product);

	
}
