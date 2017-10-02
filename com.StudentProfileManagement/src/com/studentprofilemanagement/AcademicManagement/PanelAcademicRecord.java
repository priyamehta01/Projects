
package com.studentprofilemanagement.AcademicManagement;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelAcademicRecord extends JPanel 
{
	
	private JLabel lblRollNo = new JLabel();                           //Objects of various labels
	private JLabel lblSem = new JLabel();
        private JLabel Roll=new JLabel();
        private JLabel Sem=new JLabel();
        private JLabel Grade=new JLabel();
	private JLabel lblGrade = new JLabel();
         private JLabel Intern = new JLabel();
        private JLabel Pro1 = new JLabel();
        private JLabel Pro2 = new JLabel();
        private JLabel Pro3 = new JLabel();
        private JLabel Pro4 = new JLabel();
        private JLabel Work1 = new JLabel();
        private JLabel Work2 = new JLabel();
        private JLabel lblIntern = new JLabel();
        private JLabel lblPro1 = new JLabel();
        private JLabel lblPro2 = new JLabel();
        private JLabel lblPro3 = new JLabel();
        private JLabel lblPro4 = new JLabel();
        private JLabel lblWork1 = new JLabel();
        private JLabel lblWork2 = new JLabel();
        AcademicGUI a;
	
	public PanelAcademicRecord(String ro, String roll, String sem, String grade, String intern, String pro1, String pro2, String pro3, String pro4, String work1, String work2, AcademicGUI agu)       //Patameterised constructor
	{
          
               
                {
                    a=agu;
                
		lblRollNo.setText("Roll Number : "+ roll);                  //Label characteristics
		lblSem.setText("Semester : "+sem);
		lblGrade.setText("Grade : "+grade);
                lblIntern.setText("Internship : "+intern);
                lblPro1.setText("Project 1 : "+pro1);
                lblPro2.setText("Project 2 : "+pro2);
                lblPro3.setText("Project 3 : "+pro3);
                lblPro4.setText("Project 4 : "+pro4);
                lblWork1.setText("WorkShop 1 : "+work1);
                lblWork2.setText("WorkShop 2 : "+work2);
                Roll.setText(roll);
                Sem.setText(sem);
		Grade.setText(grade);
                Intern.setText(intern);
                Pro1.setText(pro1);
                Pro2.setText(pro2);
                Pro3.setText(pro3);
                Pro4.setText(pro4);
                Work1.setText(work1);
                Work2.setText(work2);
                
		this.setLayout(new GridLayout(10,10,2,2));
		
		this.add(lblRollNo);                       //Adding labels to frame
		this.add(lblSem);
		this.add(lblGrade);
                this.add(lblIntern);
		this.add(lblPro1);
                this.add(lblPro2);
                this.add(lblPro3);
                this.add(lblPro4);
                this.add(lblWork1);
                this.add(lblWork2);
           
		
		this.addMouseListener(new AcademicFocusListener(agu));
		          System.out.println("sem"+lblSem.getText());
                          System.out.println("WORK2"+lblWork2.getText());
                }
                
              
               
	}
        
        //Various Getters and Setters
	
	public String getRoll()
	{
		return lblRollNo.getText();
	}
	
	public String getSem()
	{
		return lblSem.getText();
	}
	
	public String getGrade()
	{
		return lblGrade.getText();
	}
        
        public String getInternship()
	{
		return lblIntern.getText();
	}
        
        public String getpro1()
	{
		return lblPro1.getText();
	}
         public String getpro2()
	{
		return lblPro2.getText();
	}
         
          public String getpro3()
	{
		return lblPro3.getText();
	}
          
           public String getpro4()
	{
		return lblPro4.getText();
	}
           
            public String getwork1()
	{
		return lblWork1.getText();
	}
            
             public String getwork2()
	{
		return lblWork2.getText();
	}
             
             public String getRollF()
             {
                 return Roll.getText();
             }
             
             public String getSemF()
             {
                 return Sem.getText();
             }
             
             public String getGradeF()
             {
                 return Grade.getText();
             }
             
             public String getInternshipF()
	{
		return Intern.getText();
	}
        
        public String getpro1F()
	{
		return Pro1.getText();
	}
         public String getpro2F()
	{
		return Pro2.getText();
	}
         
          public String getpro3F()
	{
		return Pro3.getText();
	}
          
           public String getpro4F()
	{
		return Pro4.getText();
	}
           
            public String getwork1F()
	{
		return Work1.getText();
	}
            
             public String getwork2F()
	{
		return Work2.getText();
	}
             
             
}


