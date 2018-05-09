package com.niit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.dao.ProductDao;
import com.niit.model.Product;
import com.niit.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDao productDao;

	public List<Product> getAllProducts() {
		return productDao.getAllProducts();
	}

	public Product getProductById(int productId) {

		return productDao.getProductById(productId);

	}

	public boolean addProduct(Product product) {
		// TODO Auto-generated method stub
		return productDao.addProduct(product);
	}

	public boolean deleteProduct(Product product) {
		// TODO Auto-generated method stub
		return productDao.deleteProduct(product);
	}

	public void saveProduct(Product product) {
		// TODO Auto-generated method stub
		productDao.saveOrUpdate(product);
	}

	public void updateProduct(Product product) {
		// TODO Auto-generated method stub
		productDao.saveOrUpdate(product);
	}

}