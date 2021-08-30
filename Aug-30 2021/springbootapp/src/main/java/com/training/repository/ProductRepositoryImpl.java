package com.training.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.training.model.Product;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	@Override
	public List<Product> fetchAll(){
		
		
		return jdbcTemplate.query("select * from products", new RowMapper<Product>() {
			
			@Override
			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				return new Product(rs.getInt("ID"), rs.getString("NAME"), rs.getDouble("PRICE"));
			}
		});
	}
	
	
	@Override
	public Product fetchByID(int id){
		
		
		return jdbcTemplate.queryForObject("select * from products where ID= ?", new RowMapper<Product>() {
			
			@Override
			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				return new Product(rs.getInt("ID"), rs.getString("NAME"), rs.getDouble("PRICE"));
			}
		}, id);
	}
	
	
}














