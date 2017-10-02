delimiter $$ ;

create procedure New_Customer_Records(IN  cust_id varchar(10), firstname varchar(45), middlename varchar(45), lastname varchar(45), dob DATE, email varchar(45), contactnumber varchar(10), address varchar(90))
begin
Insert Into customer_details values (cust_id, firstname, middlename, lastname, dob, email, contactnumber, address);
end
$$ ;

call New_Customer_Records('CS_010', 'Jay', 'Jeet', 'Jivrajani', '2012-04-02', 'jjj@gmail.com', '9033870911', 'vapi');