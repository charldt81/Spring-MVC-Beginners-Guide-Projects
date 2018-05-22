package com.packt.webstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.packt.webstore.domain.repository.ProductRepository;
import com.packt.webstore.service.ProductService;


//to put the product information in a model, we needed to create this controller class ProductController{}... step3

@Controller
public class ProductController {
	
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductService productService;

	
	// we just have a single method called list whose responsibility it is to create a product domain object to hold the information about
	// Apple's iPhone 5s and add that object to the model.
	@RequestMapping("/products")
	public String list(Model model) {
		model.addAttribute("products", productRepository.getAllProducts());
		return "products";
		// and finally we return the view name as 'products'
	}
	
	
	@RequestMapping("/update/stock")
	public String updateStock(Model model) {
		productService.updateAllStock();
		return "redirect:/products";
	}
	
	
}
