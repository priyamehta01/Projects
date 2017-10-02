delimiter $$ ;

create procedure Owner_Report(IN  owner_id varchar(10))
begin
select franchisee.Owner_ID, franchisee.Franchisee_ID, sum(Quantity*(Food_Price - Food_Actual_Price)) as Profit from franchisee, customer_record, food_items where franchisee.Franchisee_ID = customer_record.Franchisee_ID AND food_items.Food_ID = customer_record.Food_ID AND franchisee.Owner_ID = owner_id group by customer_record.Food_ID; 
end
$$ ;

call Owner_Report('Own_002');