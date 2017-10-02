select count(Customer_ID), Franchisee_ID from customer_record group by Franchisee_ID;
select max (customer_record.num) from (select count (Customer_ID) as num from customer_record where Franchisee_ID = 'FR_002');

select count(Customer_ID), Customer_ID from customer_record group by Customer_ID;
select max(y.num), y.Customer_ID from (select count(Customer_ID) as num, Customer_ID from customer_record group by Customer_ID) y;

select Customer_ID from customer_record where count(Customer_ID) = (select max(y.num), y.Customer_ID from (select count(Customer_ID) as num, Customer_ID from customer_record group by Customer_ID) y);

select Customer_ID from customer_record where (select count(Customer_ID) from customer_record group by Customer_ID) = (select max(y.num) from (select count(Customer_ID) as num, Customer_ID from customer_record group by Customer_ID) y);

select Customer_ID from customer_record where count(Customer_ID) = (select max(y.num) from (select count(Customer_ID) as num from customer_record group by Customer_ID) y);

select Customer_ID from customer_record where (select count(Customer_ID) from customer_record group by Customer_ID) in (select max(y.num) from (select count(Customer_ID) as num, Customer_ID from customer_record group by Customer_ID) y);
