<%-- this addProduct.jsp file added from Chapter_4 --%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%-- Since the special <form:form/> tag on line_31 is coming from a Spring tag library, we need to add a reference to that tag 
     library in our JSP file; which is this line below... --%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<html>

<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
		<title>Products</title>
</head>


<body>
	<section>
			<div class="jumbotron">
				<div class="container">
					<h1>Products</h1>
					<p>Add products</p>
				</div>
			</div>
	</section>
	
	<section class="container">
			<form:form method="POST" modelAttribute="newProduct" class="form-horizontal">
				<fieldset>
				
					<legend>Add new product</legend>
					
					<%-- in this "productId" label we are externalizing the message by creating a 'message.properties' file and adding this code:
						 <spring:message code="addProduct.form.productId.label"/>, instead of the text - Product Id 
						 Spring MVC has a special tag called <spring:message> to externalize texts from JSP files.
						 In order to use this tag, we need to add a reference to a Spring tag library, which is what we did on line 11.
						 At runtime Spring will try to read the corresponding value from a message source property file.
						 We just created a property file with the name 'messages.properties' under the resource directory.
						 Inside that file, we just assigned the label text value to the message tag code:
						 addProduct.form.productId.label = New Product ID
						 Here we have just externalized a single label, but a typical web application will have externalized messages for almost all tags.
						 In that case 'mssages.properties' file will have many code-value pair entries. --%>
					<div class="form-group">
						<label class="control-label col-lg-2 col-lg-2" for="productId"> <spring:message code="addProduct.form.productId.label"/> </label>
						<div class="col-lg-10">
							<form:input id="productId" path="productId" type="text" class="form:input-large" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-lg-2 col-lg-2" for="name">Name</label>
						<div class="col-lg-10">
							<form:input id="name" path="name" type="text" class="form:input-large" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-lg-2 col-lg-2" for="unitPrice">Unit Price</label>
						<div class="col-lg-10">
							<form:input id="unitPrice" path="unitPrice" type="text" class="form:input-large" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-lg-2 col-lg-2" for="manufacturer">Manufacturer</label>
						<div class="col-lg-10">
							<form:input id="manufacturer" path="manufacturer" type="text" class="form:input-large" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-lg-2 col-lg-2" for="category">Category</label>
						<div class="col-lg-10">
							<form:input id="category" path="category" type="text" class="form:input-large" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-lg-2 col-lg-2" for="unitsInStock">Units in Stock</label>
						<div class="col-lg-10">
							<form:input id="unitsInStock" path="unitsInStock" type="text" class="form:input-large" />
						</div>
					</div>
					
					
				<%-- 
					<div class="form-group">
						<label class="control-label col-lg-2 col-lg-2" for="unitsInOrder">Units in Order</label>
						<div class="col-lg-10">
							<form:input id="unitsInOrder" path="unitsInOrder" type="text" class="form:input-large" />
						</div>
					</div>
				--%>
					
					
					<div class="form-group">
						<label class="control-label col-lg-2" for="description">Description</label>
						<div class="col-lg-10">
							<form:textarea id="description" path="description" rows="3" />
						</div>
					</div>
					
					
				<%--	
					<div class="form-group">
						<label class="control-label col-lg-2" for="discontinued">Discontinued</label>
						<div class="col-lg-10">
							<form:checkbox id="discontinued" path="discontinued" />
						</div>
					</div>
				--%>	
				
				
					<div class="form-group">
						<label class="control-label col-lg-2" for="condition">Condition</label>
						<div class="col-lg-10">
							<form:radiobutton path="condition" value="New" />
							New
							<form:radiobutton path="condition" value="Old" />
							Old
							<form:radiobutton path="condition" value="Refurbished" />
							Refurbished
						</div>
					</div>
					
					<div class="form-group">
						<div class="col-lg-offset-2 col-lg-10">
							<input type="submit" id="btnAdd" class="btnbtn-primary" value="Add" />
						</div>
					</div>
					
				</fieldset>
			</form:form>
	</section>
</body>


</html>


