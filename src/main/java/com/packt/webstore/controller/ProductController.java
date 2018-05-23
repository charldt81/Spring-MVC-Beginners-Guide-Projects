package com.packt.webstore.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.packt.webstore.service.ProductService;


// to put the product information in a model, we needed to create this controller class ProductController{}... step3

// we added this relative request mapping annotation at the class level... now we access the products at '/market/products'
@RequestMapping("market")
@Controller
public class ProductController {
	
	
	@Autowired
	private ProductService productService;

	
	// we just have a single method called list whose responsibility it is to create a product domain object to hold the information about
	// Apple's iPhone 5s and add that object to the model.
	@RequestMapping("/products")
	public String list(Model model) {
		model.addAttribute("products", productService.getAllProducts());
		return "products";
		// and finally we return the view name as 'products'
	}
	
	
	
	// added from Chapter_3
	// By enclosing a portion of a request path within curly braces, we are indicating to Spring MVC that it is a URI template variable.
	// According to the Spring MVC documentation, a URI template is a URI-like string containing one or more variable names.
	// When you substitute values for these variables, the template becomes a URI. (http://localhost:8080/webstore/market/products/Laptop)
	// In Spring MVC, we can use the @PathVariable annotation to read a URI template variable.
	// A request mapping method can have any number of @PathVariable annotations.
	// It will be written like this: (@PathVariable("manufacturerId") String manufacturer, @PathVariable("productId") String product)
	@RequestMapping("/products/{category}")
	public String getProductsByCategory(Model model, @PathVariable("category") String productCategory) {
		model.addAttribute("products",productService.getProductsByCategory(productCategory));
		return "products";
	}
	
	
	
	// added from Chapter_3
	// A URL can have multiple matrix variables, and each matrix variable must be separated with a “;” (semicolon).
	// To assign multiple values to a single variable, each value must be “,” (comma) separated or we can repeat the variable name.
	// @MatrixVariable is very similar to the @PathVariable annotation.
	// The filterParams map will have each matrix variable name as the key and the corresponding list will contain multiple 
	// values assigned for the matrix variable.
	// The 'pathVar' attribute from @MatrixVariable is used to identify the matrix variable segment in the URL,
	// that's why it has the value params, which is nothing but the URI template value we used in our request mapping URL.
	// A URL can have multiple matrix variable segments, eg.:
	//	 /products/filter/params;brands=Google,Dell;categories=Tablet,Laptop/specification;dimention=10,20,15;color=red,green,blue
	// It contains two matrix variable segments each identified by the prefix params and specification respectively.
	@RequestMapping("/products/filter/{params}")
	public String getProductsByFilter(@MatrixVariable(pathVar="params") Map<String,List<String>> filterParams, Model model) {
		model.addAttribute("products", productService.getProductsByFilter(filterParams));
		return "products";
	}
	
	
	
	// added from Chapter_3
	// The @RequestParam annotation also follows the same convention as other binding annotations; that is, if the name of the 
	// GET request parameter and the name of the variable it is annotating are the same, then there is no need to specify the 
	// value attribute in the @RequestParam annotation. - (value = "")
	// Since we annotated the parameter productId with @RequestParam("id") annotation, Spring MVC will try to read a GET request
	// parameter with the name 'id' from the URL and will assign that to the getProductById method's parameter productId, eg.:
	//   /market/product?id=P1234
	@RequestMapping("/product")
	public String getProductById(@RequestParam("id") String productId, Model model) {
		model.addAttribute("product", productService.getProductById(productId));
		return "product";
	}
	
	
	
	// these request mappings are on the controllers method level - "/products" and "/update/stock"
	@RequestMapping("/update/stock")
	public String updateStock(Model model) {
		productService.updateAllStock();
		return "redirect:/market/products";
	}
	
	
}






