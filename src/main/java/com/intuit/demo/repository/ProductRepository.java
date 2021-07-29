package com.intuit.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.intuit.demo.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {


}
