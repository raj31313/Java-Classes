CREATE TABLE Orders(orderNumber number(5) NOT NULL,paymentState VARCHAR(12),creationTime DATE,totalAmount number(5),PRIMARY KEY (orderNumber)
);
CREATE TABLE Customers(custId number(5)NOT NULL,cname VARCHAR(20),phone VARCHAR(20),PRIMARY KEY(custId));


CREATE TABLE Products(prodId number(5) NOT NULL,pname VARCHAR(20),price number(5),PRIMARY KEY(prodId));


CREATE TABLE OrderDetail(orderNumber number(5) NOT NULL,prodId number(5) NOT NULL,
			FOREIGN KEY(orderNumber) REFERENCES Orders(orderNumber),
			FOREIGN KEY(prodId) REFERENCES Products(prodId));
            
insert into Products values(101,'Watch',2000);
insert into Products values(102,'Laptop',40000);
insert into Products values(103,'Mobile',8000);
insert into Products values(104,'Teddy',1000);
insert into Products values(105,'Dress',1500);

select * from Products;

insert into Customers values(11,'Priya',9876543210);
insert into Customers values(12,'Shiva',8765432109);
insert into Customers values(13,'Lalitha',7654321098);
insert into Customers values(14,'Prem',9874563210);
insert into Customers values(15,'Vivek',98765432211);
select * from Customer;

insert into Orders values(1,'Success','2022-05-15',2000);
insert into Orders values(2,'Success','2023-01-15',40000);
insert into Orders values(3,'Failed','2022-07-11',5000);
insert into Orders values(4,'Failed','2022-09-07',6000);
insert into Orders values(5,'Success','2021-03-21',4000);
select * from Orders;



alter table Orders add custId number(5) NOT NULL;


alter table Orders add constraint fk_cust_orders FOREIGN KEY(custId) REFERENCES Customer(custId);
desc Orders;
alter table Orders drop column custId;
truncate table Orders;
drop table OrderDetail;

alter table Orders add custId number(5) NOT NULL;
alter table Orders add constraint fk_cust_orders FOREIGN KEY(custId) REFERENCES Customer(custId);
/*insert into orders table now*/
insert into Orders values(1,'Success','2022-05-15',2000,11);
insert into Orders values(2,'Success','2023-01-15',40000,11);
insert into Orders values(3,'Failed','2022-07-11',5000,12);
insert into Orders values(4,'Failed','2022-09-07',6000,14);
insert into Orders values(5,'Success','2021-03-21',4000,15);

select * from Orders;

/*Create Order Details table*/
drop table OrderDetail;
CREATE TABLE OrderDetail(orderNumber number(5) NOT NULL,prodId number(5) NOT NULL,
			FOREIGN KEY(orderNumber) REFERENCES Orders(orderNumber),
			FOREIGN KEY(prodId) REFERENCES Products(prodId));
insert into OrderDetails values(1,101);
insert into OrderDetails values(1,102);
insert into OrderDetails values(2,101);
insert into OrderDetails values(3,102);
insert into OrderDetails values(4,104);
insert into OrderDetails values(5,105);

select * from OrderDetails;

ALTER TABLE `table_name`
	DROP FOREIGN KEY `id_name_fk`;
-- -------
-- Natural Join
SELECT * FROM Orders NATURAL JOIN Products NATURAL JOIN Customer;
SELECT custId, orderNumber FROM Customer INNER JOIN Orders USING (custID);
SELECT c.custId,cname, orderNumber FROM Customer c INNER JOIN Orders o ON c.custId = o.custId;
SELECT c.custId,cname, orderNumber,paymentState FROM Customer c LEFT OUTER JOIN Orders o 
   ON c.custId = o.custId where c.custId=13;
  -- where paymentState='Success';
  
  /*Evaluation order
Multiple joins in a query are evaluated left-to-right in the order that you write them, 
unless you use parentheses to force a different evaluation order. */
SELECT c.custId,cname, orderNumber,paymentState FROM Customer c CROSS JOIN Orders o ;

use training2;
select m.ename "Manager" , e.ename 
from emp e join emp m
on e.mgr =m.empno;

use mydb;

-- Return a list of all orders and their associated product items.
SELECT Orders.*, Products.*
FROM Orders 
JOIN OrderDetail
ON Orders.orderNumber = OrderDetail.orderNumber
JOIN Products
ON OrderDetail.prodId = Products.prodId;

-- Return the orderid of any order that includes Laptop.
SELECT o.orderNumber,p.pname
FROM Orders AS o JOIN OrderDetail AS od
ON o.orderNumber = od.orderNumber
JOIN Products AS p
ON od.prodId = p.prodId
WHERE p.pname = 'Laptop';

-- Write a query to return the name of every product included in an order alongside the number of times 
-- it has been ordered.  Sort the results by product name, ascending.

SELECT p.pname AS pn , COUNT(od.prodId)
FROM Products  p JOIN OrderDetail  od
ON p.prodId = od.prodId
GROUP BY p.pname
ORDER BY pn ASC;

/*to return the name of any customer who ordered fries. Return this in a column called 
'Customers who like Laptop'. 
Don't repeat the same customer name more than once in the results.
*/

SELECT DISTINCT c.cname AS "Customers who like Laptop"
FROM Customer AS c JOIN Orders as o
ON c.custId = o.custId
JOIN OrderDetail AS od
ON o.orderNumber = od.orderNumber
JOIN Products AS p
ON od.prodId = p.prodId
WHERE p.pname = 'Laptop';
/*
To get the names of the customers who have ordered the same products as a given customer,
 you can use a self-join on the orders table and join it with the products and customers tables 
SELECT DISTINCT c.cname,p.pname
FROM OrderDetail o1
JOIN OrderDetail o2 ON o1.orderNumber = o2.orderNumber AND o1.prodId<> o2.prodId
JOIN Orders o ON o.custId=c.custId
JOIN Products p ON p.prodId=o2.prodId
JOIN customer c ON c.custId = o.custId
WHERE o.custId = 12;
*/
