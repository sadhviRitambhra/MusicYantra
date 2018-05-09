package com.niit.service;

import java.util.List;

import com.niit.model.Product;

public interface ProductService {
	List<Product> getAllProducts();

	Product getProductById(int productId);

	boolean addProduct(Product product);

	boolean deleteProduct(Product product);

	void saveProduct(Product product);

	void updateProduct(Product product);

}
