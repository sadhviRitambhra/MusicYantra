package com.niit.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.niit.model.Cart;
import com.niit.model.CartItem;
import com.niit.model.Customer;
import com.niit.model.Product;
import com.niit.model.User;
import com.niit.service.CartItemService;
import com.niit.service.CartService;
import com.niit.service.CustomerService;
import com.niit.service.ProductService;

@Controller
@RequestMapping("/rest/cart")
public class CartResourcesController {
	@Autowired
	private CartService cartService;

	@Autowired
	private CartItemService cartItemService;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private ProductService productService;

	@RequestMapping("/{cartId}")
	public ResponseEntity<Cart> getCartById(@PathVariable(value = "cartId") int cartId) {
		Cart cart=cartService.getCartById(cartId);
		return new ResponseEntity<Cart>(cart,HttpStatus.OK);
	}

	@RequestMapping(value = "/add/{productId}", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void addItem(@PathVariable(value = "productId") int productId, Principal activeUser) {

		Customer customer = customerService.getCustomerByUsername(activeUser.getName());

		Cart cart = customer.getCart();
		Product product = productService.getProductById(productId);
		try {
			List<CartItem> cartItems = cart.getCartItems();
			System.out.println("after cartitems");
			for (int i = 0; i < cartItems.size(); i++) {
				if (product.getProductId() == cartItems.get(i).getProduct().getProductId()) {
					CartItem cartItem = cartItems.get(i);
					cartItem.setQuantity(cartItem.getQuantity() + 1);
					cartItem.setTotalPrice(product.getPrice() * cartItem.getQuantity());
					cartItemService.addCartItem(cartItem);

					return;
				}
			}

			CartItem cartItem = new CartItem();
			cartItem.setProduct(product);
			cartItem.setQuantity(1);
			cartItem.setTotalPrice(product.getPrice() * cartItem.getQuantity());
			cartItem.setCart(cart);
			cartItemService.addCartItem(cartItem);
		} 
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@RequestMapping(value = "/remove/{productId}", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void removeItem(@PathVariable(value = "productId") int productId) {
		CartItem cartItem = cartItemService.getCartItemByProductId(productId);
		cartItemService.removeCartItem(cartItem);

	}

	@RequestMapping(value = "/{cartId}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void clearCart(@PathVariable(value = "cartId") int cartId) {
		Cart cart = cartService.getCartById(cartId);
		cartItemService.removeAllCartItems(cart);
	}

	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Illegal request, please verify your payload")
	public void handleClientErrors(Exception ex) {

	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Internal Server Error")
	public void handleServerErrors(Exception ex) {

	}

}
