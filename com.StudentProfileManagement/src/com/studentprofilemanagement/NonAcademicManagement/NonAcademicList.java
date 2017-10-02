/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.studentprofilemanagement.NonAcademicManagement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import static com.studentprofilemanagement.NonAcademicManagement.DisplayFrame1.actif;
import static com.studentprofilemanagement.NonAcademicManagement.DisplayFrame1.certif;
import static com.studentprofilemanagement.NonAcademicManagement.DisplayFrame1.actifmore;
import static com.studentprofilemanagement.NonAcademicManagement.DisplayFrame1.hostacaf;
import static com.studentprofilemanagement.NonAcademicManagement.DisplayFrame1.Rollf;
import com.studentprofilemanagement.StudentConnection;



/**
 *
 * @author admin
 */
public class NonAcademicList extends NonAcademic {
    
    int i=0;
    int g=0;
    //public String gpa;
    //double total, avg;
    String sem;
    //int pro1=0;
    Scanner input=new Scanner(System.in);
    public DisplayFrame1 d;
    NonAcademicGUI ngu;
    
    public NonAcademicList(DisplayFrame1 d1, NonAcademicGUI nu)
    {
        d=d1;
        ngu=nu;
    }
    
	
	
	public ArrayList<NonAcademic> fetchRecords() throws SQLException, Exception
	{
		ArrayList<NonAcademic> list1 = new ArrayList<NonAcademic>();                   //Array of Employee Data
		
                               
	   System.out.println("Creating statement...");                          //Fetch Records from Database
	   Connection conn = StudentConnection.getConnection();
	   Statement stmt = conn.createStatement();
	   String sql;
	   sql = "SELECT * FROM NonAcademic";
	   ResultSet rs1 = stmt.executeQuery(sql);
	   while(rs1.next())                                                         //Retrieve by column name
	   {
               
	      
	      int rollNo  = rs1.getInt("rollno");
	      String Hostaca = rs1.getString("host_acad");
	      String Certi = rs1.getString("certi");
              String Activ = rs1.getString("activity");
              String Activmore = rs1.getString("activity_more");
                          
               
              
             //  System.out.println("Intern"+Interns);
              
	      list1.add(new NonAcademic(rollNo, Hostaca, Certi, Activ, Activmore));
              // System.out.println(""+Grade);
            
      
	   }
	   return list1;
           
           
           
 
	}
	
	public void addRecord(NonAcademic newNonAcademic) throws SQLException, IllegalArgumentException, Exception            //Executing a query
	{
	
		   System.out.println("Creating statement...");
		   Connection conn = StudentConnection.getConnection();
		   Statement stmt = conn.createStatement();
		   String sql;
                   sql = "INSERT INTO NonAcademic VALUES('" + newNonAcademic.getRoll()+ "', '" + newNonAcademic.getHA() + "', '" + newNonAcademic.getCerti() + "', '" + newNonAcademic.getActivity()+"', '" + newNonAcademic.getActivitymore()+"')";

                   //sql = "INSERT INTO employeedetails1 VALUES(" + newEmployee.getId() + ", '" + newEmployee.getName() + "', '" + newEmployee.getPhone()+"','" +newEmployee.getDate() +"','" +newEmployee.getGen()+"')";
                   stmt.execute(sql);
                   //System.out.println("sql barabar!");
                   
	}
        
        public void updateRecord(NonAcademic modAca) throws SQLException, Exception   
        {
            // Executing update query
            System.out.println("IN UPDATE!");
            
          //  System.out.println("update pachi");
          //  NonAcademicFocusListener nfa=new NonAcademicFocusListener(ngu);
            
          //  System.out.println("old : "+.getText());
	    Connection conn = StudentConnection.getConnection();
            Statement stmt = conn.createStatement();
            String sql;
           System.out.println("new : "+modAca.getCerti());
            System.out.println("old : "+certif.getText());
            sql="UPDATE student.NonAcademic \n SET host_acad='"+ modAca.getHA()+"',certi= '"+modAca.getCerti()+"',activity='"+modAca.getActivity()+"',activity_more='"+modAca.getActivitymore()+"'\nWHERE rollno ='"+Rollf.getText()+"' AND host_acad='"+hostacaf.getText()+"' AND certi= '"+certif.getText()+"' AND activity='"+actif.getText()+"' AND activity_more='"+actifmore.getText()+"';";  
            System.out.println("sql!!");
            stmt.execute(sql);
            System.out.println("UPDATE EXECUTED!");
	           //System.out.println("query fired");
	}
        
         public void deleteRecord(DisplayFrame1 disp1) throws SQLException, Exception  
        {
             DisplayFrame1 di1;
             di1=disp1;
             Connection conn = StudentConnection.getConnection();
            Statement dstmt = conn.createStatement();
            String dsql;
          //  System.out.println("before : "+di.Sem.getText());
           dsql="DELETE FROM student.NonAcademic WHERE rollno='"+(di1.Rollf.getText())+"' AND host_acad ='"+di1.hostacaf.getText()+"' AND certi='"+ di1.certif.getText()+"'AND activity= '"+di1.actif.getText()+"'AND activity_more='"+di1.actifmore.getText()+"';";
          //System.out.println("after : "+di.Sem.getText());
            dstmt.execute(dsql);
            System.out.println("EXECUTED!");
        }
        
        
    
    
}
