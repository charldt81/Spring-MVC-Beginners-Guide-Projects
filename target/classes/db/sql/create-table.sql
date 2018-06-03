-- Following two lines added from Chapter_9
DROP TABLE CART_ITEM IF EXISTS;
DROP TABLE CART IF EXISTS;



-- This DROP TABLE and CREATE TABLE added from Chapter_?
DROP TABLE PRODUCTS IF EXISTS;
CREATE TABLE PRODUCTS (
	ID VARCHAR(25) PRIMARY KEY,
	NAME VARCHAR(50),
	DESCRIPTION VARCHAR(250),
	UNIT_PRICE DECIMAL,
	MANUFACTURER VARCHAR(50),
	CATEGORY VARCHAR(50),
	CONDITION VARCHAR(50),
	UNITS_IN_STOCK BIGINT,
	UNITS_IN_ORDER BIGINT,
	DISCONTINUED BOOLEAN
);



-- Following two tables added from Chapter_9
CREATE TABLE CART (
	ID VARCHAR(50) PRIMARY KEY
);

CREATE TABLE CART_ITEM (
	ID VARCHAR(75),
	PRODUCT_ID VARCHAR(25) FOREIGN KEY REFERENCES
	PRODUCTS(ID),
    CART_ID varchar(50) FOREIGN KEY REFERENCES
    CART(ID),
	QUANTITY BIGINT,
    CONSTRAINT CART_ITEM_PK PRIMARY KEY (ID,CART_ID)
);