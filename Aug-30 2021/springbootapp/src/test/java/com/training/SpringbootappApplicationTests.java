package com.training;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.util.ArrayList;

import org.assertj.core.api.Assertions;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.web.servlet.MockMvc;

import com.training.controller.HomeController;
import com.training.model.Product;
import com.training.repository.ProductRepository;

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
class SpringbootappApplicationTests {

	@Autowired
	private HomeController homeController;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@MockBean
	private ProductRepository productRepository;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	void contextLoads() {
		
		Assertions.assertThat(homeController).isNotNull();
	}
	
	@Test
	void testHomeRequest() {
		Assertions.assertThat(restTemplate.getForObject("http://localhost:9010/home", String.class)).contains("Welcome");
	}
	
	@Test
	void testProductsRequest() throws Exception{
		
		Product product = new Product(1, "abc", 3000);
		Mockito.when(productRepository.fetchByID(1)).thenReturn(product);
		
	//	mockMvc.perform(get("/products/1")).andExpect(status().isOk()).andExpect(jsonPath("$.id", Matchers.is(1)));
		
		Assertions.assertThat(restTemplate.getForObject("http://localhost:9010/products/1", Product.class)).hasFieldOrPropertyWithValue("id", 1);
	}
	
	

}
