REM   Script: Activity9.sql
REM   FST SQL Acitvity9

create table orders ( 
    order_no int primary key,  
    purchase_amount float, 
    order_date date, 
    customer_id int, 
    salesman_id int 
);

Insert All 
    into orders values(70001, 150.5, TO_DATE('2012/10/05', 'YYYY/MM/DD'), 3005, 5002) 
    INTO orders VALUES(70009, 270.65, TO_DATE('2012/09/10', 'YYYY/MM/DD'), 3001, 5005) 
    INTO orders VALUES(70002, 65.26, TO_DATE('2012/10/05', 'YYYY/MM/DD'), 3002, 5001) 
    INTO orders VALUES(70004, 110.5, TO_DATE('2012/08/17', 'YYYY/MM/DD'), 3009, 5003) 
    INTO orders VALUES(70007, 948.5, TO_DATE('2012/09/10', 'YYYY/MM/DD'), 3005, 5002) 
    INTO orders VALUES(70005, 2400.6, TO_DATE('2012/07/27', 'YYYY/MM/DD'), 3007, 5001) 
    INTO orders VALUES(70008, 5760, TO_DATE('2012/08/15', 'YYYY/MM/DD'), 3002, 5001) 
    INTO orders VALUES(70010, 1983.43, TO_DATE('2012/10/10', 'YYYY/MM/DD'), 3004, 5006) 
    INTO orders VALUES(70003, 2480.4, TO_DATE('2012/10/10', 'YYYY/MM/DD'), 3009, 5003) 
    INTO orders VALUES(70012, 250.45, TO_DATE('2012/06/27', 'YYYY/MM/DD'), 3008, 5002) 
    INTO orders VALUES(70011, 75.29, TO_DATE('2012/08/17', 'YYYY/MM/DD'), 3003, 5007) 
    INTO orders VALUES(70013, 3045.6, TO_DATE('2012/04/25', 'YYYY/MM/DD'), 3002, 5001) 
select 1 from dual;

CREATE TABLE salesman ( 
    salesman_id int, 
    salesman_name varchar2(32), 
    salesman_city varchar2(32), 
    commission int 
);

DESCRIBE salesman


INSERT INTO salesman VALUES(5002, 'Nail Knite', 'Paris', 13);

INSERT ALL  
    INTO salesman VALUES(5001, 'James Hoog', 'New York', 15)  
    INTO salesman VALUES(5005, 'Pit Alex', 'London', 11)  
    INTO salesman VALUES(5006, 'McLyon', 'Paris', 14)  
    INTO salesman VALUES(5007, 'Paul Adam', 'Rome', 13)  
    INTO salesman VALUES(5003, 'Lauson Hen', 'San Jose', 12)  
SELECT 1 FROM DUAL;

SELECT * FROM salesman;

SELECT salesman_id, commission FROM salesman WHERE salesman_name='Paul Adam';

ALTER TABLE salesman ADD grade int;

UPDATE salesman SET grade=100;

SELECT * FROM salesman;

UPDATE salesman SET grade=200 WHERE salesman_city='Rome';

UPDATE salesman SET grade=300 WHERE salesman_name='James Hoog';

UPDATE salesman SET salesman_name='Pierre' WHERE salesman_name='McLyon';

SELECT * FROM salesman;

select * from salesman;

select * from orders;

create table customers ( 
    customer_id int primary key, customer_name varchar(32), 
    city varchar(20), grade int, salesman_id int);

INSERT ALL  
    into customers values (3002, 'Nick Rimando', 'New York', 100, 5001)  
    into customers values (3007, 'Brad Davis', 'New York', 200, 5001) 
    into customers values (3005, 'Graham Zusi', 'California', 200, 5002) 
    into customers values (3008, 'Julian Green', 'London', 300, 5002) 
    into customers values (3004, 'Fabian Johnson', 'Paris', 300, 5006)  
    into customers values (3009, 'Geoff Cameron', 'Berlin', 100, 5003) 
    into customers values (3003, 'Jozy Altidor', 'Moscow', 200, 5007)  
    into customers values (3001, 'Brad Guzan', 'London', 300, 5005) 
SELECT 1 FROM DUAL;

select * from customers;

select c.customer_id, c.customer_name, s.salesman_id, s.SALESMAN_NAME from customers c 
inner join salesman s 
on c.salesman_id = s.salesman_id;

select c.customer_id, c.grade, c.salesman_id, s.SALESMAN_NAME from  customers c 
left outer join salesman s 
on c.salesman_id = s.salesman_id;

select  c.customer_id,c.customer_name, s.salesman_id, s.SALESMAN_NAME, s.COMMISSION 
from customers c 
inner join salesman s 
on c.salesman_id = s.salesman_id 
where s.COMMISSION >12;

SELECT o.order_no, o.order_date, o.purchase_amount, c.customer_name, c.grade, s.SALESMAN_NAME, s.commission  
FROM orders o 
INNER JOIN customers c ON c.customer_id=o.customer_id  
INNER JOIN salesman s ON s.salesman_id=c.salesman_id;

