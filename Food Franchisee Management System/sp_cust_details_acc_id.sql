delimiter $$ ;

create procedure CustomerDetails(IN Cust_ID varchar(10))
begin
select * from customer_details where Cust_ID = customer_details.Customer_ID;
end
$$ ;

call CustomerDetails('CS_003');