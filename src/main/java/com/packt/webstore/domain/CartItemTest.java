
// Added this 'CartItemTest.java' class from Chapter_12

package com.packt.webstore.domain;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



public class CartItemTest {

	
	private CartItem cartItem;
	
	
	@Before
	public void setup() {
		cartItem = new CartItem("1");
	}
	
	
	
	// The important method in the CartItemTest class is the @Test annotated method.
	// The @Test (org.junit.Test) annotation marks a particular method as a test method so that the JUnit framework can treat that method as a 
	// test method and execute it when we choose the Run As | JUnit Test option.
	// This method was divided into three logical parts called Arrange, Act, and Assert:
	//		Arrange all the necessary preconditions and inputs to perform a test
	//		Act on the object or method under test
	//		Assert that the expected results have occurred
	@Test
	public void cartItem_total_price_should_be_equal_to_product_unit_price_in_case_of_single_quantity() {
		
		// Arrange: here we just instantiated a product domain object (iphone) with a unit price value of 500 and added that product object to 
		// 			the 'cartItem' object by calling cartItem.setProduct(iphone).
		Product iphone = new Product("P1234","iPhone5s", new BigDecimal(500));
		cartItem.setProduct(iphone);
		
		// Act: here we just called the method under test, which is the 'getTotalPrice()' method of the cartItem object, and stored the result in a 
		// 		BigDecimal variable called 'totalPrice'.
		BigDecimal totalPrice = cartItem.getTotalPrice();
		
		// Assert: here in the Assert part, we used the JUnit API (Assert.assertEquals) to assert the equality between the unitPrice of the product 
		// 		   domain object and the calculated totalPrice of cartItem:
		Assert.assertEquals(iphone.getUnitPrice(), totalPrice);
	}
	
	
	
}
