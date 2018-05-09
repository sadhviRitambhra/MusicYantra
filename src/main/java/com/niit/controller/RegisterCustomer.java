package com.niit.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.model.BillingAddress;
import com.niit.model.Customer;
import com.niit.model.Product;
import com.niit.model.ShippingAddress;
import com.niit.service.CustomerService;

@Controller
public class RegisterCustomer {
	@Autowired
	CustomerService customerService;

	@RequestMapping("/registerCustomer")
	public String viewAddProductPage(Model model) {
		Customer customer = new Customer();
		BillingAddress billingAddress = new BillingAddress();
		ShippingAddress shippingAddress = new ShippingAddress();
		customer.setBillingAddress(billingAddress);
		customer.setShippingAddress(shippingAddress);
		model.addAttribute("customer", customer);
		return "registerCustomer";
	}

	@RequestMapping(value = "/registerCustomer", method = RequestMethod.POST)
	public String registerCustomer(@Valid @ModelAttribute("customer") Customer customer, BindingResult result) {
		/*
		 * if(result.hasErrors()) { return "registerCustomer"; } boolean
		 * res=customerService.registerCustomer(customer); if(res) { return
		 * "login"; } else { return "registerCustomer"; } }
		 */
		boolean flag = customerService.registerCustomer(customer);
		if (flag == true) {
			customer.setEnabled(true);
			return "index";
		} else {
			return "registerCustomer";
		}
	}
}
