REM   Script: Activity10.sql
REM   FST SQL Acitvity10

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

select sum(purchase_amount) as "total" from orders;

select avg(purchase_amount) as "Average" from orders;

select max(purchase_amount) as "Maximun" from orders;

select min(purchase_amount) as "Minimum" from orders;

select count(distinct salesman_id) as "Total salesman" from orders;

select * from orders;

select customer_id, purchase_amount from orders 
group by customer_id 
order by purchase_amount desc;

select customer_id, purchase_amount from orders 
group by customer_id 
order by purchase_amount desc;

select customer_id, max(purchase_amount) from orders 
group by customer_id 
order by purchase_amount desc;

select customer_id, max(purchase_amount) from orders 
group by customer_id;

select customer_id, max(purchase_amount) from orders 
group by customer_id 
order by purchase_amount desc;

select customer_id, max(purchase_amount) from orders 
group by customer_id 
order by max(purchase_amount) desc;

select salesman_id, max(purchase_amount) from orders 
group by salesman_id 
having order_date ='2012-08-17';

select salesman_id, max(purchase_amount) from orders 
group by salesman_id, purchase_amount 
having order_date ='2012-08-17';

select salesman_id, max(purchase_amount) from orders 
group by salesman_id, purchase_amount, order_date 
having order_date ='2012-08-17';

select salesman_id, max(purchase_amount), order_date from orders 
group by salesman_id, purchase_amount, order_date 
having order_date ='2012-08-17';

select salesman_id, max(purchase_amount), order_date from orders 
group by salesman_id, purchase_amount, order_date 
having order_date =To_DATE('2012/08/17', 'YYYY/MM/DD');

select salesman_id, max(purchase_amount), order_date from orders 
group by salesman_id 
having order_date =To_DATE('2012/08/17', 'YYYY/MM/DD');

select salesman_id, max(purchase_amount), order_date from orders 
group by salesman_id, purchase_amount 
having order_date =To_DATE('2012/08/17', 'YYYY/MM/DD');

select salesman_id,  order_date, max(purchase_amount) from orders 
group by salesman_id, order_date 
having order_date =To_DATE('2012/08/17', 'YYYY/MM/DD');

select customer_id,  order_date, max(purchase_amount) from orders 
group by customer_id, order_date 
having max(purchase_amount) in [2030, 3450, 5760, 6000];

select customer_id,  order_date, max(purchase_amount) from orders 
group by customer_id, order_date 
having max(purchase_amount) in (2030, 3450, 5760, 6000);

select * from salesman;

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

SELECT salesman_id, salesman_city FROM salesman;

SELECT * FROM salesman WHERE salesman_city='Paris';

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

insert into customers values  
(3002, 'Nick Rimando', 'New York', 100, 5001), (3007, 'Brad Davis', 'New York', 200, 5001), 
(3005, 'Graham Zusi', 'California', 200, 5002), (3008, 'Julian Green', 'London', 300, 5002), 
(3004, 'Fabian Johnson', 'Paris', 300, 5006), (3009, 'Geoff Cameron', 'Berlin', 100, 5003), 
(3003, 'Jozy Altidor', 'Moscow', 200, 5007), (3001, 'Brad Guzan', 'London', 300, 5005);

INSERT ALL  
    into customers values (3002, 'Nick Rimando', 'New York', 100, 5001), (3007, 'Brad Davis', 'New York', 200, 5001), 
    into customers values (3005, 'Graham Zusi', 'California', 200, 5002), (3008, 'Julian Green', 'London', 300, 5002), 
    into customers values (3004, 'Fabian Johnson', 'Paris', 300, 5006), (3009, 'Geoff Cameron', 'Berlin', 100, 5003), 
    into customers values (3003, 'Jozy Altidor', 'Moscow', 200, 5007), (3001, 'Brad Guzan', 'London', 300, 5005) 
SELECT 1 FROM DUAL;

INSERT ALL  
    into customers values (3002, 'Nick Rimando', 'New York', 100, 5001),  
    into customers values (3007, 'Brad Davis', 'New York', 200, 5001), 
    into customers values (3005, 'Graham Zusi', 'California', 200, 5002), 
    into customers values (3008, 'Julian Green', 'London', 300, 5002), 
    into customers values (3004, 'Fabian Johnson', 'Paris', 300, 5006),  
    into customers values (3009, 'Geoff Cameron', 'Berlin', 100, 5003), 
    into customers values (3003, 'Jozy Altidor', 'Moscow', 200, 5007),  
    into customers values (3001, 'Brad Guzan', 'London', 300, 5005) 
SELECT 1 FROM DUAL;

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

select c.customer_id, c.customer_name, s.salesman_id, s.name from customers c 
inner join salesman s 
on c.salesman_id = s.salesman_id 
;

select * from salesman;

select c.customer_id, c.customer_name, s.salesman_id, s.SALESMAN_NAME from customers c 
inner join salesman s 
on c.salesman_id = s.salesman_id;

select c.customer_id, c.customer_name, s.salesman_id, s.SALESMAN_NAME from customers c 
inner join salesman s 
on c.salesman_id = s.salesman_id;

select c.customer_id, c.grade, c.salesman_id, s.SALESMAN_NAME from  customers c 
left outer join salesman s 
on c.salesman_id = s.salesman_id;

where c.grade < 300 


order by  c.customer_id asc 


select * from salesman;

select  c.customer_id,c.customer_name, s.salesman_id, s.SALESMAN_NAME, s.COMMISSION 
from customers c 
inner join salesman s 
on c.salesman_id = s.salesman_id 
where s.COMMISSION >12;

SELECT o.order_no, o.order_date, o.purchase_amount, c.customer_name, c.grade, s.SALESMAN_NAME, s.commission  
FROM orders o 
INNER JOIN customers c ON c.customer_id=o.customer_id  
INNER JOIN salesman s ON s.salesman_id=c.salesman_id;

select * from orders o;

select * from orders  
where salesman_id in (select distinct salesman_id from orders where customer_id=3007);

select * from orders  
where salesman_id = (select distinct salesman_id from orders where customer_id=3007);

select * from orders  
where salesman_id = (select  salesman_id from orders where customer_id=3007);

select  salesman_id from orders where customer_id=3007;

select * from orders  where salesman_id = 5001;

select * from salesman;

select * from salesman 
 
select * from orders 
where salesman_id = (select salesman_id from salesman where SALESMAN_CITY = 'New York');

select * from orders 
where salesman_id = (select salesman_id from salesman where SALESMAN_CITY = 'New York');

select * from orders 
where salesman_id = (select salesman_id from salesman where SALESMAN_CITY = 'New York');

select o.ORDER_NO,o.PURCHASE_AMOUNT, o.ORDER_DATE, o.CUSTOMER_ID,o.SALESMAN_ID, s.SALESMAN_CITY from ordres o 
inner join salesman s 
on o.salesman_id = s.salesman_id 
where s.SALESMAN_CITY = 'New York';

select * from orders 
where salesman_id = (select salesman_id from salesman where SALESMAN_CITY = 'New York');

select o.ORDER_NO,o.PURCHASE_AMOUNT, o.ORDER_DATE, o.CUSTOMER_ID,o.SALESMAN_ID, s.SALESMAN_CITY from orders o 
inner join salesman s 
on o.salesman_id = s.salesman_id 
where s.SALESMAN_CITY = 'New York';

SELECT grade, COUNT(*) FROM customers 
where grade>(SELECT AVG(grade) FROM customers WHERE city='New York');

SELECT grade, COUNT(*) FROM customers 
GROUP BY grade HAVING grade>(SELECT AVG(grade) FROM customers WHERE city='New York');

select salesman_id from salesman where commission = max(commission);

select salesman_id from salesman  
group by salesman_id having commission = max(commission);

select salesman_id from salesman  
group by salesman_id having max(commission);

select salesman_id,  max(commission) from salesman  
group by salesman_id having commission = max(commission);

select salesman_id,  max(commission) from salesman  
where commission = max(commission) 
group by salesman_id ;

SELECT order_no, purchase_amount, order_date, salesman_id FROM orders 
WHERE salesman_id IN( SELECT salesman_id FROM salesman 
WHERE commission=( SELECT MAX(commission) FROM salesman));

