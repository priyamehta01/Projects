/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.studentprofilemanagement.StudentDetailsManagement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.studentprofilemanagement.StudentConnection;

public class StudentList extends Student
{

	
	
	public ArrayList<Student> fetchRecords() throws SQLException, Exception
	{
		ArrayList<Student> list = new ArrayList<Student>();                   //Array of Employee Data
		
                               
	   System.out.println("Creating statement...");                          //Fetch Records from Database
	   Connection conn = StudentConnection.getConnection();
	   Statement stmt = conn.createStatement();
	   String sql;
	   sql = "SELECT * FROM studentdetails";
	   ResultSet rs = stmt.executeQuery(sql);
	   while(rs.next())                                                         //Retrieve by column name
	   {
	      
	      int rollNo  = rs.getInt("RollNo");
	      String Name = rs.getString("Name");
	      String DYear = rs.getString("BirthYear");
              String DMonth = rs.getString("BirthMonth");
              String DDate = rs.getString("BirthDate");
              String gender = rs.getString("Gender");
              String branch = rs.getString("Branch");
              String batchyr = rs.getString("BatchYear");
              String emailid = rs.getString("EmailID");
              String password = rs.getString("Password");
	      String cntnum = rs.getString("ContactNum");
	      list.add(new Student(rollNo, Name, gender, branch, batchyr, emailid, password, cntnum, DYear, DMonth, DDate));
      
	   }
	   return list;
 
	}
	
	public void addRecord(Student newStudent) throws SQLException, IllegalArgumentException, Exception            //Executing a query
	{
	
		   System.out.println("Creating statement...");
		   Connection conn = StudentConnection.getConnection();
		   Statement stmt = conn.createStatement();
		   String sql;
                   sql = "INSERT INTO studentdetails VALUES('" + newStudent.getRoll()+ "', '" + newStudent.getStuName() + "', '" + newStudent.getGen() + "','" +newStudent.getBranch()+ "','" + newStudent.getBatchyr() + "','" + newStudent.getEmail()+ "','" + newStudent.getPassword()+ "','" + newStudent.getConNum()+ "','" + newStudent.getByear()+ "','" +newStudent.getBMonth()+ "','" +newStudent.getBDate()+"')";

                   //sql = "INSERT INTO employeedetails1 VALUES(" + newEmployee.getId() + ", '" + newEmployee.getName() + "', '" + newEmployee.getPhone()+"','" +newEmployee.getDate() +"','" +newEmployee.getGen()+"')";
                   stmt.execute(sql);
                   //System.out.println("sql barabar!");
                   
	}
	
	public void updateRecord(Student modStu) throws SQLException, Exception        //Executing update 
	{
            System.out.println("Entered update");
	    Connection conn = StudentConnection.getConnection();
            Statement ustmt = conn.createStatement();
           String usql;
           // System.out.println("uval : "+uval);
           // System.out.println("ROLL  : "+modStu.getRoll());
            usql="UPDATE student.studentdetails \n SET Name= '" + modStu.getStuName() + "',Gender='"+ modStu.getGen()+"',Branch= '"+modStu.getBranch()+"',BatchYear='" + modStu.getBatchyr() + "' , EmailID= '"+modStu.getEmail()+"', Password= '"+modStu.getPassword()+"', ContactNum= '"+modStu.getConNum()+"', BirthYear= '"+modStu.getByear()+"' , BirthMonth= '"+modStu.getBMonth()+"', BirthDate= '"+modStu.getBDate()+"'   \nWHERE RollNo ="+modStu.getRoll()+";"; 
            System.out.println("usql ey thyu");
            ustmt.execute(usql);
            System.out.println("have?");
	    
	}
	
	/*public void deleteRecord(String dval) throws SQLException, Exception            //Executing delete 
	{
            
            String delete;
            delete=dval;
            
            
            Connection conn = EmployeeConnection.getConnection();
            Statement dstmt = conn.createStatement();
            String dsql;
            dsql="DELETE FROM employeedetails1 WHERE idEmployee='"+delete+"'";
            dstmt.execute(dsql);
		
	}*/
}

