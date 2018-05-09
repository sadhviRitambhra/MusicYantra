package com.niit.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.CustomerDao;
import com.niit.model.Authorization;
import com.niit.model.Cart;
import com.niit.model.Customer;
import com.niit.model.Product;
import com.niit.model.User;

@Transactional
@Repository
public class CustomerDaoImpl implements CustomerDao {

	@Autowired 
	SessionFactory sessionFactory;

	public boolean registerCustomer(Customer customer) {
        try {
        	Session session=sessionFactory.openSession();
        	customer.getBillingAddress().setCustomer(customer);
        	customer.getShippingAddress().setCustomer(customer);
        	session.saveOrUpdate(customer);
        	session.saveOrUpdate(customer.getBillingAddress());
        	session.saveOrUpdate(customer.getShippingAddress());
        	User user=new User();
        	user.setUsername(customer.getUsername());
        	user.setPassWord(customer.getPassword());
        	user.setEnabled(true);
        	Authorization newAathorities=new Authorization();
        	newAathorities.setRoleName("ROLE_USER");
        	newAathorities.setUsername(customer.getUsername());
            session.saveOrUpdate(newAathorities);
            session.saveOrUpdate(user);
            
            Cart newCart = new Cart();
            newCart.setCustomer(customer);
            customer.setCart(newCart);
            
            session.saveOrUpdate(newCart);
            
            session.flush();
            session.close();
            return true;
        }catch(Exception ex)
        {
            ex.printStackTrace();
            return false;
        }
    }

	public Customer getCustomerById(int customerId) {
		 Session session = sessionFactory.openSession();
	        return (Customer) session.get(Customer.class, customerId);
	}

	public List<Customer> getAllCustomers() {
		Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Customer");
        List<Customer> customerList = query.list();

        return customerList;
	}

	public Customer getCustomerByUsername(String username) {
		try{
		 Session session = sessionFactory.openSession();
	        Query query = session.createQuery("from Customer where username = :uname");
	        query.setString("uname", username);


	        return (Customer) query.uniqueResult();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
	}  
}
