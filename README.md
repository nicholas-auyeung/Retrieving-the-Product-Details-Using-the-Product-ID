# Retrieving the Product Details Using the Product ID

This program displays a basic product search form on a html page and searches a pre-loaded database of products...

## Features

	- Basic product search form
	- Searches for product by user entered product ID
	- On success displays product details
	- Handles invalid and non existing product ID inputs

## Installation

	- Clone and pull source code from provided github repository
	- Compile source code with Java Compiler
	- Run with Java Runtime Environment

## Code

	https://github.com/nicholas-auyeung/Retrieving-the-Product-Details-Using-the-Product-ID

## Flow
 
1. Start by creating a 'Dynamic Web Project' in Eclipse

2. Add H2 database .jar file into lib folder

2. Create an index html page

3. Set html form with action 'QueryServlet'

4. Create 'QueryServlet' servlet

5. Select 'post' method upon creation

6. Inside 'post' method 

7. Instantiate RequestDispatcher and PrintWriter

8. Request user input and try to convert to integer

9. If fail catch NumberFormatException and print 'invalid product id' message

10. If success try to connect to H2 database

11. If sucesss try to create ResultSet object

12. Execute query

13. If the returned query is greater than 0 then return product id, name, and 'product found' message

14. If no returned queries matches uer input product id, print 'product not found'

15. Bring up H2 database web console

16. Create 'PRODUCT' table with two columns 'productID' and 'productName'

16. Insert table with 30 rows of random standard grocery items for testing

## Usage

	Once run, the webpage will ask for a product id
![](screenshots/product.png)

User inputs valid product id
	
	User will see product id, product details, and 'product found' message
![](screenshots/productfound.png)

User inputs non-existing product id
	
	User will be prompt with 'product not found' message
![](screenshots/productnotfound.png)	

User inputs invalid product id
	
	User will be prompt with 'invalid product id' message
![](screenshots/invalidproduct.png)
