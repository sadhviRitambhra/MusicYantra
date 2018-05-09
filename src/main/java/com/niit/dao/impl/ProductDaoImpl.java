package com.niit.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale.Category;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.ProductDao;
import com.niit.model.Product;

@Transactional
@Repository

public class ProductDaoImpl implements ProductDao {

    @Autowired
    SessionFactory sessionfactory;
    public List<Product> getAllProducts() {
        // TODO Auto-generated method stub
        List<Product> allProducts = new ArrayList<Product>();
        try {
            Session session = sessionfactory.openSession();
            Query q = session.createQuery("from Product");
            allProducts=q.list();
            session.close();
            return allProducts;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            return null;
        }
    }
    public Product getProductById(int productId) {
        
        try {
            Session session = sessionfactory.openSession();
            Product product = (Product) session.get(Product.class, productId);
            session.close();
            return product;
            
        }catch(Exception ex)
        {
            ex.printStackTrace();
            return null;
        }
    }
	
	public boolean addProduct(Product product) {
        try {
            Session session = sessionfactory.openSession();
            session.save(product);
            session.close();
            return true;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            return false;
        }
    }
	public boolean deleteProduct(Product product) {
		try {
            Session session = sessionfactory.openSession();
            Query q = session.createQuery("delete from Product where id=?");
            q.setInteger(0, product.getProductId());
            q.executeUpdate();
            session.close();
            return true;
		}
	 catch(Exception ex)
     {
		ex.printStackTrace();
	}
		return false;
	}
	public void saveOrUpdate(Product product) {
		try {
			Session session= sessionfactory.openSession();
			session.saveOrUpdate(product);
			session.flush();
		
		}
			catch(Exception ex) {
			ex.printStackTrace();
			
			}
		
		/*try {
            Session session = sessionfactory.openSession();
            session.saveOrUpdate(product);
            session.flush();
		
	}  
		 catch(Exception ex)
	     {
			ex.printStackTrace();
		}*/
	}
	}
