delimiter $$ ;

create procedure EmployeeRating(IN Emp_ID varchar(10))
begin
update employee_working_detail set Rating = (CASE  WHEN Rating < 5 THEN Rating+1 WHEN Rating = 5 THEN 5 END) where employee_working_detail.Employee_ID = Emp_ID and NumberOfDaysOnLeave < 5 and NumberOfDaysPresent >15;
end
$$ ;

call EmployeeRating('EM_002');