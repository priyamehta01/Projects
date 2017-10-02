CREATE SCHEMA franchisee_management;

use franchisee_management;

CREATE TABLE franchisee_management.employee_personal_details(
  Employee_ID VARCHAR(10) NOT NULL,
  FirstName VARCHAR(45) NOT NULL,
  MiddleName VARCHAR(45) NULL,
  LastName VARCHAR(45) NOT NULL,
  DateOfBirth DATE NOT NULL,
  DateOfJoining DATE NOT NULL,
  ContactNumber INT(10) NOT NULL,
  Address VARCHAR(45) NOT NULL,
  BloodGroup VARCHAR(4) NOT NULL,
  EmergencyContact INT(10) NOT NULL,
  Photo BLOB NOT NULL,
  Gender VARCHAR(1) NOT NULL,
  Document BLOB NOT NULL,
  EmailID VARCHAR(45) NOT NULL,
  AdhaarNumber VARCHAR(45) NOT NULL,
  PRIMARY KEY (Employee_ID));
  
  
CREATE TABLE franchisee_management.franchisee(
  Franchisee_ID VARCHAR(10) NOT NULL,
  Franchisee_Area_Name VARCHAR(45) NOT NULL,
  PRIMARY KEY (Franchisee_ID));

CREATE TABLE franchisee_management.franchisee_details (
  Franchisee_ID VARCHAR(10) NOT NULL,
  LandmarkI VARCHAR(45) NOT NULL,
  LandmarkII VARCHAR(45) NOT NULL,
  Area VARCHAR(45) NOT NULL,
  City VARCHAR(45) NOT NULL,
  State VARCHAR(45) NOT NULL,
  PinNumber VARCHAR(45) NOT NULL,
  ContactNumber VARCHAR(45) NOT NULL,
  OpeningTime TIME(2) NOT NULL,
  franchisee_detailscol VARCHAR(45) NOT NULL,
  INDEX `Franchisee_ID_idx` (`Franchisee_ID` ASC),
  PRIMARY KEY (Franchisee_ID),
  CONSTRAINT Franchisee_ID
    FOREIGN KEY (Franchisee_ID)
    REFERENCES franchisee_management.franchisee (Franchisee_ID)
    ON DELETE CASCADE
    ON UPDATE CASCADE);
    
    
    
CREATE TABLE `franchisee_management`.`post_salary_details` (
  `PostID` VARCHAR(10) NOT NULL,
  `SalaryPerHour` INT NOT NULL,
  `Category` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`PostID`));


  
