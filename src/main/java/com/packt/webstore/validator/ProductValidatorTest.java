
// Added this 'ProductValidatorTest.java' class from Chapter_12

package com.packt.webstore.validator;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.validation.BindException;
import org.springframework.validation.ValidationUtils;

import com.packt.webstore.config.WebApplicationContextConfig;
import com.packt.webstore.domain.Product;




@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = WebApplicationContextConfig.class)
@WebAppConfiguration
public class ProductValidatorTest {
	
	
	// We used a Spring standard @Autowired annotation to get the instance of ProductValidator.
	@Autowired
	private ProductValidator productValidator;
	
	
	
	@Test
	public void product_without_UnitPrice_should_be_invalid() {
		// Arrange: here we instantiated and instrumented the required objects for testing.
		//			here we just instantiated a bare minimum 'Product' domain object.
		//			we have not set any values for the productId, unitPrice, and category fields.
		//	        We purposely set up such a bare minimum domain object in the Arrange part to check whether our ProductValidator class is 
		//			working properly in the Act part.
		Product product = new Product();
		BindException bindException = new BindException(product, " product");
		
		// Act: here we invoked the actual functionality that needs to be tested.
		//		here we invoked the productValidator method using the ValidationUtils class to check whether the validation works or not.
		//		During validation, productValidator will store the errors in a BindException object.
		//		We simply check whether the bindException object contains one error using the JUnit Assert APIs
		ValidationUtils.invokeValidator(productValidator, product, bindException);
		
		// Assert: here we compared the expected result and the actual result that is an output of the invoked functionality.
		Assert.assertEquals(1, bindException.getErrorCount());
		Assert.assertTrue(bindException.getLocalizedMessage().contains("Unit price is Invalid. It cannot be empty."));
	}																   // this message is from 'messages.properties' file
	
	
	
	@Test
	public void
	product_with_existing_productId_invalid() {
		//Arrange
		Product product = new Product("P1234","iPhone5s", new BigDecimal(500));
		product.setCategory("Tablet");
		BindException bindException = new BindException(product, " product");
		
		//Act
		ValidationUtils.invokeValidator(productValidator, product, bindException);
		
		//Assert
		Assert.assertEquals(1, bindException.getErrorCount());
		Assert.assertTrue(bindException.getLocalizedMessage().contains("A product already exists with this product ID.")); 
	}																   // this message is from 'messages.properties' file
	
	
	
	@Test
	public void a_valid_product_should_not_get_any_error_during_validation() {
		//Arrange
		Product product = new Product("P9876","iPhone5s", new BigDecimal(500));
		product.setCategory("Tablet");
		BindException bindException = new BindException(product, " product");
		
		//Act
		ValidationUtils.invokeValidator(productValidator, product, bindException);
		
		//Assert
		Assert.assertEquals(0, bindException.getErrorCount());
	}

}













