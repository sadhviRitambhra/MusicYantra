package com.niit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.dao.CustomerDao;
import com.niit.dao.ProductDao;
import com.niit.dao.impl.CustomerDaoImpl;
import com.niit.model.Customer;
import com.niit.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
@Autowired  
CustomerDao customerDao;

public boolean registerCustomer(Customer customer) {
	// TODO Auto-generated method stub
	return customerDao.registerCustomer(customer);
}

public Customer getCustomerById(int customerId) {
	// TODO Auto-generated method stub
	return customerDao.getCustomerById(customerId);
}

public List<Customer> getAllCustomers() {
	return customerDao.getAllCustomers();

}

public Customer getCustomerByUsername(String username) {
	  return customerDao.getCustomerByUsername(username);

}
}
