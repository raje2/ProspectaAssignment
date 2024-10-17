package com.prospecta.service;

//Author: Rajesh Pradhan

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.prospecta.model.Product;

@Service
public class ProductService {
	
	@Autowired
    private RestTemplate restTemplate;

	// Fetch products by category from fakestoreapi.com
    public List<Product> getProductsByCategory(String category) {
        String url = "https://fakestoreapi.com/products/category/" + category;
        try {
            ResponseEntity<Product[]> response = restTemplate.getForEntity(url, Product[].class);
            if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
                return Arrays.asList(response.getBody());
            } else {
                throw new RuntimeException("Failed to fetch products: " + response.getStatusCode());
            }
        } catch (HttpClientErrorException e) {
            // Handle 4xx errors (client-side errors)
            throw new RuntimeException("Client error while fetching products: " + e.getStatusCode() + " - " + e.getResponseBodyAsString());
        } catch (Exception e) {
            // Handle other exceptions
            throw new RuntimeException("An error occurred while fetching products: " + e.getMessage());
        }
    }

    // Add new product to fakestoreapi.com
    public String addProduct(Product product) {
        String url = "https://fakestoreapi.com/products";
        try {
            ResponseEntity<String> response = restTemplate.postForEntity(url, product, String.class);
            if (response.getStatusCode().is2xxSuccessful()) {
                return response.getBody();
            } else {
                throw new RuntimeException("Failed to add product: " + response.getStatusCode());
            }
        } catch (HttpClientErrorException e) {
            // Handle 4xx errors (client-side errors)
            throw new RuntimeException("Client error while adding product: " + e.getStatusCode() + " - " + e.getResponseBodyAsString());
        } catch (Exception e) {
            // Handle other exceptions
            throw new RuntimeException("An error occurred while adding the product: " + e.getMessage());
        }
    }

}
