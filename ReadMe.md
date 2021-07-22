This is the Spring boot application with in memory database H2.
There are two db tables Customers and Orders. 
The database can be accessed from **_http:localhost:8080_**.
put jdbc url as _**jdbc:h2:mem:memDb**_
username as **_test_** and **_blank_** password
Customer can have many orders.

application exposes two REST endpoints:
1) **GET http:localhost:8080/customers**
   
   -  To get all the customers and their orders from in memory database.

2) **GET http:localhost:8080/customer/{customerid}**
    
    - To get a particular customer with an id and its corresponding orders.

To run the application simply run the command **_mvn spring-boot:run_** in parent directory of the project.
