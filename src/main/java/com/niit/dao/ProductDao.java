
package com.niit.dao;
import java.util.List;

import com.niit.model.Product;
public interface ProductDao {
	
	public List<Product> getAllProducts();
	Product getProductById(int productId);
	public boolean addProduct(Product product);
	boolean deleteProduct(Product product);
	void saveOrUpdate(Product product);
}
	