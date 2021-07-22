CREATE TABLE Customers (
  customerid INTEGER PRIMARY KEY,
  customername VARCHAR(64) NOT NULL,
  country   VARCHAR(64) NOT NULL);

CREATE TABLE Orders (
  orderid INTEGER PRIMARY KEY,
  customer_id INTEGER NOT NULL,
  description VARCHAR(64) NOT NULL
  );

 ALTER TABLE Orders
    ADD FOREIGN KEY (customer_id)
    REFERENCES Customers(customerid)