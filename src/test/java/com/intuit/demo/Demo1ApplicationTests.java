package com.intuit.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.intuit.demo.model.Product;
import com.intuit.demo.repository.ProductRepository;
import com.intuit.demo.service.impl.ProductServiceImpl;

@SpringBootTest
class Demo1ApplicationTests {

	@Autowired
	ProductServiceImpl productServiceImpl;

	@MockBean
	ProductRepository productRepository;

	@Test
	void addition() {

		Product product = new Product();
		product.setId(1);
		product.setName("IPhone");
		Optional<Product> productvalue = Optional.of(product);

		when(productRepository.findById((long) 1)).thenReturn(productvalue);
		Optional<Product> productvalueAfterExecution = productServiceImpl.getProduct(1);
		assertEquals(1, productvalueAfterExecution.get().getId());
	}
}
