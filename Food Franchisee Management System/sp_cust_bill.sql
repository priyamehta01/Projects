delimiter $$ ;

create procedure Customer_Bill(IN ContactNo varchar(10))
begin
select customer_details.Customer_ID, customer_details.FirstName, customer_details.LastName, sum(Quantity*(Food_Price - Food_Actual_Price)) as Bill from customer_details, customer_record, food_items where ContactNo = customer_details.ContactNumber and DateOfBilling = curdate() and customer_details.Customer_ID = customer_record.Customer_ID and customer_record.Food_ID = food_items.Food_ID group by customer_record.Customer_ID;
end
$$ ;

call Customer_Bill('1211121111');