
package com.studentprofilemanagement.AcademicManagement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import static com.studentprofilemanagement.AcademicManagement.DisplayFrame.Semf;
import com.studentprofilemanagement.StudentConnection;

public class AcademicList extends Academic
{
    int i=0;
    int g=0;
    public String gpa;
    double total, avg;
    String sem;
    int pro1=0;
    Scanner input=new Scanner(System.in);
    
	
	
	public ArrayList<Academic> fetchRecords() throws SQLException, Exception
	{
		ArrayList<Academic> list = new ArrayList<Academic>();                   //Array of Employee Data
		
                               
	   System.out.println("Creating statement...");                          //Fetch Records from Database
	   Connection conn = StudentConnection.getConnection();
	   Statement stmt = conn.createStatement();
	   String sql;
	   sql = "SELECT * FROM academic4";
	   ResultSet rs = stmt.executeQuery(sql);
	   while(rs.next())                                                         //Retrieve by column name
	   {
               
	      
	      int rollNo  = rs.getInt("rollno");
	      String Sem = rs.getString("sem");
	      String Grade = rs.getString("grade");
              String Interns = rs.getString("internship");
              String Proj1 = rs.getString("project1");
              String Proj2 = rs.getString("project2");
              String Proj3 = rs.getString("project3");
              String Proj4 = rs.getString("project4");
              String Work1 = rs.getString("workshop1");
              String Work2 = rs.getString("workshop2");
              
               
     
              
	      list.add(new Academic(rollNo, Sem, Grade, Interns, Proj1, Proj2, Proj3, Proj4, Work1, Work2));
           
            
      
	   }
	   return list;
           
           
           
 
	}
	
	public void addRecord(Academic newAcademic) throws SQLException, IllegalArgumentException, Exception            //Executing a query
	{
	
		   System.out.println("Creating statement...");
		   Connection conn = StudentConnection.getConnection();
		   Statement stmt = conn.createStatement();
		   String sql;
                   sql = "INSERT INTO academic4 VALUES('" + newAcademic.getRoll()+ "', '" + newAcademic.getSem() + "', '" + newAcademic.getGrade() + "', '" + newAcademic.getIntern()+"', '" + newAcademic.getPro1()+"', '" + newAcademic.getPro2()+"', '" + newAcademic.getPro3()+"', '" + newAcademic.getPro4()+"', '" + newAcademic.getWork1()+"','" +newAcademic.getWork2()+"')";
                   stmt.execute(sql);
        
                   
	}
        
        public void updateRecord(Academic modAca) throws SQLException, Exception   
        {
            // Executing update query
	    Connection conn = StudentConnection.getConnection();
            Statement stmt = conn.createStatement();
            String sql;
            sql="UPDATE student.academic4 \n SET grade='"+ modAca.getGrade()+"',internship= '"+modAca.getIntern()+"',project1='"+modAca.getPro1()+"',project2='"+modAca.getPro2()+"',project3='"+modAca.getPro3()+"',project4='"+modAca.getPro4()+"',workshop1='"+modAca.getWork1()+"',workshop2='"+modAca.getWork2()+"'\nWHERE rollno ="+modAca.getRoll()+" AND sem='"+Semf.getText()+"';";  
            System.out.println("ROLL "+modAca.getRoll());
            System.out.println("SEM : "+modAca.getSem());
            System.out.println("PRO 1 : "+modAca.getPro1());
            stmt.execute(sql);
	       
	}
   
        
        
        public void deleteRecord(DisplayFrame disp) throws SQLException, Exception  
        {
             DisplayFrame di;
             di=disp;
             Connection conn = StudentConnection.getConnection();
            Statement dstmt = conn.createStatement();
            String dsql;
           dsql="DELETE FROM student.academic4 WHERE sem='"+(di.Semf.getText())+"' and rollno='"+(di.Rollf.getText())+"';";
          System.out.println("after : "+di.Sem.getText());
            dstmt.execute(dsql);
            System.out.println("EXECUTED!");
        }
        
}