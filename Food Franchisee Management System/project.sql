CREATE SCHEMA franchisee_management_system;

USE franchisee_management_system;

CREATE TABLE franchisee_management_system.employee_personal_details (
  Employee_ID VARCHAR(10) NOT NULL,
  FirstName VARCHAR(45) NOT NULL,
  MiddleName VARCHAR(45) NOT NULL,
  LastName VARCHAR(45) NOT NULL,
  ContactNumber INT(10) NOT NULL,
  BloodGroup VARCHAR(3) NOT NULL,
  Gender VARCHAR(1) NOT NULL,
  DateOfBirth DATE NOT NULL,
  DateOfJoining DATE NOT NULL,
  Address VARCHAR(90) NOT NULL,
  EmergencyContactNumber VARCHAR(45) NOT NULL,
  Photo BLOB NOT NULL,
  Document BLOB NOT NULL,
  EmailID VARCHAR(45) NOT NULL,
  AdharNumber VARCHAR(45) NOT NULL,
  PRIMARY KEY (Employee_ID)
);

CREATE TABLE franchisee_management_system.employee_work_experience (
  Employee_ID VARCHAR(10) NOT NULL,
  LastJob VARCHAR(60) NOT NULL,
  YearsOfExperience INT NOT NULL,
  Place VARCHAR(45) NOT NULL,
  PRIMARY KEY (Employee_ID),
  CONSTRAINT EmployeeID
    FOREIGN KEY (Employee_ID)
    REFERENCES franchisee_management_system.employee_basic_details (Employee_ID)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

CREATE TABLE franchisee_management_system.franchisee_details (
  Franchisee_ID VARCHAR(10) NOT NULL,
  Landmark_I VARCHAR(45) NOT NULL,
  Landmark_II VARCHAR(45) NOT NULL,
  Area VARCHAR(45) NOT NULL,
  City VARCHAR(45) NOT NULL,
  State VARCHAR(45) NOT NULL,
  Pin_Number VARCHAR(45) NOT NULL,
  ContactNumber INT(10) NOT NULL,
  OpeningTime VARCHAR(10) NOT NULL,
  ClosingTime VARCHAR(45) NOT NULL,
  PRIMARY KEY (Franchisee_ID));
  
  
CREATE TABLE franchisee_management_system.post_salary_details (
  Post_ID VARCHAR(10) NOT NULL,
  SalaryPerHour INT NOT NULL,
  Category VARCHAR(45) NOT NULL,
  PRIMARY KEY (Post_ID));
  
  
CREATE TABLE franchisee_management_system.employee_working_detail (
  Employee_ID VARCHAR(10) NOT NULL,
  WorkingHours INT NOT NULL,
  NumberOfDaysPresent INT NOT NULL,
  NumberOfDaysOnLeave VARCHAR(10) NOT NULL,
  Manager_ID VARCHAR(10) NOT NULL,
  Rating INT NOT NULL,
  Post_ID VARCHAR(10) NOT NULL,
  Franchisee_ID VARCHAR(10) NOT NULL,
  PRIMARY KEY (Employee_ID),
  INDEX PostID_idx (Post_ID ASC),
  INDEX FranchiseeID_idx (Franchisee_ID ASC),
  CONSTRAINT EmpID
    FOREIGN KEY (Employee_ID)
    REFERENCES franchisee_management_system.employee_basic_details (Employee_ID)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT PostID
    FOREIGN KEY (Post_ID)
    REFERENCES franchisee_management_system.post_salary_details (Post_ID)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT FranchiseeID
    FOREIGN KEY (Franchisee_ID)
    REFERENCES franchisee_management_system.franchisee (Franchisee_ID)
    ON DELETE CASCADE
    ON UPDATE CASCADE);
    
    
CREATE TABLE franchisee_management_system.owner_details (
  Owner_ID VARCHAR(10) NOT NULL,
  FirstName VARCHAR(45) NOT NULL,
  MiddleName VARCHAR(45) NOT NULL,
  LastName VARCHAR(45) NOT NULL,
  ContactNumber INT(10) NOT NULL,
  EmailID VARCHAR(45) NOT NULL,
  PRIMARY KEY (Owner_ID));


CREATE TABLE franchisee_management_system.franchisee (
  Franchisee_ID VARCHAR(10) NOT NULL,
  Owner_ID VARCHAR(10) NOT NULL,
  Franchisee_Area_Name VARCHAR(45) NOT NULL,
  PRIMARY KEY (Franchisee_ID, Owner_ID),
  INDEX O_ID_idx (Owner_ID ASC),
  CONSTRAINT Fran_ID
    FOREIGN KEY (Franchisee_ID)
    REFERENCES franchisee_management_system.franchisee_details (Franchisee_ID)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT O_ID
    FOREIGN KEY (Owner_ID)
    REFERENCES franchisee_management_system.owner_details (Owner_ID)
    ON DELETE CASCADE
    ON UPDATE CASCADE);
    

CREATE TABLE franchisee_management_system.food_items (
  Food_ID VARCHAR(10) NOT NULL,
  Food_Name VARCHAR(45) NOT NULL,
  Food_Price INT NOT NULL,
  Food_Actual_Price INT NOT NULL,
  Spec_1_Jain_NonJain VARCHAR(10) NULL,
  Spec_2_Butter_Cheese_Oil VARCHAR(10) NULL,
  Spec_3_Any_Special VARCHAR(45) NULL,
  PRIMARY KEY (Food_ID));


CREATE TABLE franchisee_management_system.raw_materials (
  RawMaterial_ID VARCHAR(10) NOT NULL,
  Raw_Material_Name VARCHAR(45) NOT NULL,
  Quantity INT NOT NULL,
  Date DATE NOT NULL,
  Price VARCHAR(45) NOT NULL,
  Food_ID VARCHAR(45) NOT NULL,
  PRIMARY KEY (RawMaterial_ID, Date, Food_ID),
  INDEX FoodID_idx (Food_ID ASC),
  CONSTRAINT FoodID
    FOREIGN KEY (Food_ID)
    REFERENCES franchisee_management_system.food_items (Food_ID)
    ON DELETE CASCADE
    ON UPDATE CASCADE);


CREATE TABLE franchisee_management_system.customer_details (
  Customer_ID VARCHAR(10) NOT NULL,
  FirstName VARCHAR(45) NOT NULL,
  MiddleName VARCHAR(45) NOT NULL,
  LastName VARCHAR(45) NOT NULL,
  DateOfBirth DATE NOT NULL,
  EmailID VARCHAR(45) NOT NULL,
  ContactNumber INT(10) NOT NULL,
  Address VARCHAR(90) NOT NULL,
  PRIMARY KEY (Customer_ID));
  
  
  
  CREATE TABLE franchisee_management_system.customer_record (
  Customer_ID VARCHAR(10) NOT NULL,
  DateOfBilling DATE NOT NULL,
  Time TIME(2) NOT NULL,
  Food_ID VARCHAR(10) NOT NULL,
  Quantity INT NOT NULL,
  PRIMARY KEY (Customer_ID, DateOfBilling, Time, Food_ID),
  INDEX FoodID_idx (Food_ID ASC),
  CONSTRAINT CustID
    FOREIGN KEY (Customer_ID)
    REFERENCES franchisee_management_system.customer_details (Customer_ID)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT ID_Food
    FOREIGN KEY (Food_ID)
    REFERENCES franchisee_management_syste.food_items (Food_ID)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    CONSTRAINT ID_Franchisee
    FOREIGN KEY (Franchisee_ID)
    REFERENCES franchisee_management_syste.franchisee (Franchisee_ID)
    ON DELETE CASCADE
    ON UPDATE CASCADE
    );
