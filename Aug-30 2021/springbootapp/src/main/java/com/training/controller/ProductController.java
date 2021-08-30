package com.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.model.Product;
import com.training.repository.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductRepository repository;
	
	// /products/hello?msg=abc
	
	@GetMapping("/hello")
	//@RequestMapping(value = "/hello", method = {RequestMethod.GET})
	public String sayHello(@RequestParam(value = "msg", required = true) String msg) {
		
		System.out.println("ProductController.sayHello()");
		return "Hello " + msg;
	}
	
	// products
	@GetMapping
	public ResponseEntity<List<Product>> getAll(){
		
		try {
			
			List<Product> products = repository.fetchAll();
			return ResponseEntity.ok(products);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			return ResponseEntity.internalServerError().build();
		}
	}
	
	// products/3
	@GetMapping("{id}")
	public ResponseEntity<Product> getById(@PathVariable("id") int id){
		
		try {
			
			Product product = repository.fetchByID(id);
			return ResponseEntity.ok(product);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			return ResponseEntity.internalServerError().build();
		}
	}
}
























