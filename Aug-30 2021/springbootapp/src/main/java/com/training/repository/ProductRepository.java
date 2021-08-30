package com.training.repository;

import java.util.List;

import com.training.model.Product;

public interface ProductRepository {

	List<Product> fetchAll();

	Product fetchByID(int id);

}