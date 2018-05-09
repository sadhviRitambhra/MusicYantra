package com.niit.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.dao.CartDao;
import com.niit.model.Cart;
import com.niit.service.CartService;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartDao cartDao;
	
	public Cart getCartById(int cartId) {
		// TODO Auto-generated method stub
		return cartDao.getCartById(cartId);
	}

	public void update(Cart cart) {
		// TODO Auto-generated method stub
		cartDao.getCartById(cart.getCartId());
		
	}

	
}
