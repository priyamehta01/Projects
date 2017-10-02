/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.studentprofilemanagement.StudentDetailsManagement;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelStudentRecord extends JPanel {
	
	private JLabel lblRollNo = new JLabel();                           //Objects of various labels
	private JLabel lblName = new JLabel();
        static JLabel Roll=new JLabel();
        static JLabel Name=new JLabel();
        static JLabel Gender=new JLabel();
	private JLabel lblGender = new JLabel();
        static JLabel Branch = new JLabel();
        static JLabel BatchYear = new JLabel();
        static JLabel EmailID = new JLabel();
        static JLabel Password = new JLabel();
        static JLabel ContactNum = new JLabel();
        static JLabel BirthYear = new JLabel();
        static JLabel BirthMonth = new JLabel();
        static JLabel BirthDate = new JLabel();
        private JLabel lblBranch = new JLabel();
        private JLabel lblBatchYear = new JLabel();
        private JLabel lblEmailID = new JLabel();
        private JLabel lblPassword = new JLabel();
        private JLabel lblContactNum = new JLabel();
        private JLabel lblBirthYear = new JLabel();
        private JLabel lblBirthMonth = new JLabel();
        private JLabel lblBirthDate = new JLabel();
        FormFrame3 f;
	
	public PanelStudentRecord(String roll, String name, String gender, String branch, String batchyr, String email, String pass, String cont, String byear, String bmonth, String bdate)       //Patameterised constructor
	{
           // System.out.println("ROLLNO"+roll);
               
                {
                    
                
		lblRollNo.setText("Roll Number : "+ roll);                  //Label characteristics
		lblName.setText("Name : "+name);
		lblGender.setText("Gender : "+gender);
                lblBranch.setText("Branch : "+branch);
                lblBatchYear.setText("Batch Year : "+batchyr);
                lblEmailID.setText("Email ID : "+email);
                lblPassword.setText("Password : "+pass);
                lblContactNum.setText("Contact Number : "+cont);
                lblBirthYear.setText("Birth Year : "+byear);
                lblBirthMonth.setText("Birth Month : "+bmonth);
                lblBirthDate.setText("Birth Date : "+bdate);
                
                Roll.setText(roll);                  //Label characteristics
		Name.setText(name);
		Gender.setText(gender);
                Branch.setText(branch);
                BatchYear.setText(batchyr);
                EmailID.setText(email);
                Password.setText(pass);
                ContactNum.setText(cont);
                BirthYear.setText(byear);
                BirthMonth.setText(bmonth);
                BirthDate.setText(bdate);
                
		this.setLayout(new GridLayout(10,10,2,2));
		
		this.add(lblRollNo);                       //Adding labels to frame
		this.add(lblName);
		this.add(lblGender);
                this.add(lblBranch);
		this.add(lblBatchYear);
                this.add(lblEmailID);
                this.add(lblPassword);
                this.add(lblContactNum);
                this.add(lblBirthYear);
                this.add(lblBirthMonth);
                this.add(lblBirthDate);
               // this.setVisible(true);
		
		//this.addMouseListener(new StudentFocusListner(agu));
		          
                }
                
              
               
	}
        
        //Various Getters and Setters
	
	public String getRoll()
	{
		return lblRollNo.getText();
	}
	
	public String getName()
	{
		return lblName.getText();
	}
	
	public String getGender()
	{
		return lblGender.getText();
	}
        
        public String getBranch()
	{
		return lblBranch.getText();
	}
        
        public String getBatchYear()
	{
		return lblBatchYear.getText();
	}
         public String Email()
	{
		return lblEmailID.getText();
	}
         
          public String getPass()
	{
		return lblPassword.getText();
	}
          
           public String getContactNum()
	{
		return lblContactNum.getText();
	}
           
            public String getBirthYear()
	{
		return lblBirthYear.getText();
	}
            
             public String getBirthMonth()
	{
		return lblBirthMonth.getText();
	}
             
              public String getBirthDate()
	{
		return lblBirthDate.getText();
	}
              
        
       public String getRollF()
	{
		return Roll.getText();
	}
	
	public String getNameF()
	{
		return Name.getText();
	}
	
	public String getGenderF()
	{
		return Gender.getText();
	}
        
        public String getBranchF()
	{
		return Branch.getText();
	}
        
        public String getBatchYearF()
	{
		return BatchYear.getText();
	}
         public String EmailF()
	{
		return EmailID.getText();
	}
         
          public String getPassF()
	{
		return Password.getText();
	}
          
           public String getContactNumF()
	{
		return ContactNum.getText();
	}
           
            public String getBirthYearF()
	{
		return BirthYear.getText();
	}
            
             public String getBirthMonthF()
	{
		return BirthMonth.getText();
	}
             
              public String getBirthDateF()
	{
		return BirthDate.getText();
	}
             
            
             
             
}


