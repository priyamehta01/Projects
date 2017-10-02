/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.studentprofilemanagement.StudentDetailsManagement;

import java.sql.SQLException;
import java.util.ArrayList;

public class displayStudentRecords
{
public displayStudentRecords(int roll)
{
   int rol;
   rol=roll;
	ArrayList<PanelStudentRecord> StudentRecords = new ArrayList();
	//AcademicRecords.add(new PanelAcademicRecord("num","RollNum", "Semester", "Grade", "Internship", "Project1", "Project2", "Project3", "Project4", "Workshop1", "Workshop2"));

	try{
	StudentList list = new StudentList(); 
        //EmployeeList object created
        FormDisplay form=new FormDisplay(rol);
	
	ArrayList<Student> records = list.fetchRecords();
	
            for (Student stu : records) 
            {
                if(stu.getRoll()==rol)
                {
                    //AcademicRecords.add(new PanelAcademicRecord("num","RollNum", "Semester", "Grade", "Internship", "Project1", "Project2", "Project3", "Project4", "Workshop1", "Workshop2"));
                StudentRecords.add(new PanelStudentRecord(Integer.toString(stu.getRoll()), stu.getStuName(), stu.getGen(),stu.getBranch(), stu.getBatchyr(),stu.getEmail(),stu.getPassword(),stu.getConNum(), stu.getByear(),stu.getBMonth(),stu.getBDate()));
                }
                }  
                
		//frame.D.removeAll();
                
		
		for(PanelStudentRecord r: StudentRecords)
                {
			form.Disp.add(r);
                }
		form.validate();
		//this.frame.repaint();
	
	
	}
	catch(SQLException err)                                         //Exception Handling
	{
		err.printStackTrace();
	}
	catch(Exception err)
	{
		err.printStackTrace();
	}
	
        }

   
}
