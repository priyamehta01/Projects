/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.studentprofilemanagement.NonAcademicManagement;

import com.studentprofilemanagement.StudentCategory.Category;
import com.studentprofilemanagement.StudentMenu.MenuFrame5;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

class NonAcademicActionListener implements ActionListener
{
    private NonAcademicGUI gui;
    DisplayFrame1 g;
    String HA, Activity, details, Certi;
    int n;
    int i=0;
    public NonAcademicActionListener(NonAcademicGUI mygui, int num)
    {
        gui = mygui;
        n=num;
    }
    
    public void displayNonAcademicRecords()
{
	ArrayList<PanelNonAcademicRecord> NonAcademicRecords = new ArrayList();
	//NonAcademicRecords.add(new PanelNonAcademicRecord("num","RollNum", "Semester", "Grade", "Internship", "Project1", "Project2", "Project3", "Project4", "Workshop1", "Workshop2"));

	try{
	NonAcademicList list = new NonAcademicList(g, gui);                         //EmployeeList object created
	
	ArrayList<NonAcademic> records = list.fetchRecords();
	
            for (NonAcademic naca : records) 
            {
                if(naca.getRoll()==n)
                {
                    //NonAcademicRecords.add(new PanelNonAcademicRecord("num","RollNum", "Semester", "Grade", "Internship", "Project1", "Project2", "Project3", "Project4", "Workshop1", "Workshop2"));
                NonAcademicRecords.add(new PanelNonAcademicRecord(Integer.toString(n),Integer.toString(naca.getRoll()), naca.getHA(), naca.getCerti(), naca.getActivity(),naca.getActivitymore(), gui));
                }
                }  
                
		//gui.D.removeAll();
                
		
		for(PanelNonAcademicRecord r: NonAcademicRecords)
                {
			gui.D.add(r);
                }
		gui.validate();
		//this.gui.repaint();
	
	
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


  /*   void update(DisplayFrame d)
     {
         DisplayFrame dis;
         dis=d;
         
         gui.txtGrade.setText(d.Grade.getText());
         gui.txtintern.setText(d.Intern.getText());
         gui.txtpro1.setText(d.Pro1.getText());
         gui.txtpro2.setText(d.Pro2.getText());
         gui.txtpro3.setText(d.Pro3.getText());
         gui.txtpro4.setText(d.Pro4.getText());
         gui.txtWS1.setText(d.Work1.getText());
         gui.txtWS2.setText(d.Work2.getText());
         
         
     }*/
  
 @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getActionCommand()==gui.submit.getText())
        {
            try
            {
            if(gui.txtHa.getText().isEmpty() || gui.txtdetails.getText().equals("") || gui.txtCerti.getText().equals(""))
            {            
            throw new NullPointerException("");    
            }
            
            else
            {
                NonAcademic newNonAcademic = new NonAcademic(gui.n, gui.getHa(), gui.getCerti(), gui.getAct(),gui.getActmore());
		try{
			gui.submit.setVisible(true);
                    NonAcademicList list = new NonAcademicList(g, gui);
			
			list.addRecord(newNonAcademic);
                        gui.submit.setVisible(false);
                        gui.setVisible(false);
                        MenuFrame5 M = new MenuFrame5(n);
			
		}
                
		catch(SQLException err)                                             //Exception Handling
		{
                       
			err.printStackTrace();
		}
		catch(Exception err)
		{
			err.printStackTrace();
		}
                
                finally
                {
                    gui.txtHa.setText("");
                    gui.txtCerti.setText("");
                    gui.txtact.setText("");
                    gui.txtdetails.setText("");
                    
                }
            }
            HA = gui.getHa();
            Activity = gui.getAct();
            details = gui.getActmore();
            Certi = gui.getCerti();
            gui.err.setText("");
            System.out.println(HA + "" + Activity + "" + details + "" + Certi);
            }
            catch(NullPointerException er)
            {
                gui.err.setText("*Empty Field");
            }
            
            
            
                
            /*    try
            {
            if(gui.txtHa.getText().isEmpty() || gui.txtdetails.getText().equals("") || gui.txtCerti.getText().equals(""))
            {            
            throw new NullPointerException("");    
            }
            HA = gui.getHa();
            Activity = gui.getAct();
            details = gui.getActmore();
            Certi = gui.getCerti();
            gui.err.setText("");
            System.out.println(HA + "" + Activity + "" + details + "" + Certi);
            }
            catch(NullPointerException er)
            {
                gui.err.setText("*Empty Field");
            }*/
                
                
		
        }
        
      else if(e.getActionCommand()==gui.Display.getText())
        {
            //NonAcademicListener ac=new NonAcademicListener(gui);
            do
            {
            this.displayNonAcademicRecords();
            i++;
            }while(i==0);
        }
        
         else if(e.getActionCommand()==gui.Update.getText())
         {
             NonAcademicList a = new NonAcademicList(g, gui);
             NonAcademic modNonAcademic = new NonAcademic(gui.n, gui.getHa(), gui.getCerti(), gui.getAct(),gui.getActmore());
             try
             {
             if(gui.txtHa.getText().isEmpty() || gui.txtdetails.getText().equals("") || gui.txtCerti.getText().equals(""))
            {            
            throw new NullPointerException("");    
            }
             a.updateRecord(modNonAcademic);
             gui.setVisible(false);
             MenuFrame5 M = new MenuFrame5(n);
            }
             
             catch(SQLException s)
             {
                 
             }
             
             
            catch(NullPointerException er)
            {
                gui.err.setText("*Empty Field");
            }
             catch(Exception er)
            {
                
            }
             
            // this.displayNonAcademicRecords();
         }
        
         else if(e.getActionCommand()==gui.back.getText())
         {
             gui.setVisible(false);
             Category Cat = new Category(n);
         }
        
      
    }
    
    
        
        

    
 /*   
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getActionCommand().equals(gui.submit.getText()))
        {
            try
            {
            if(gui.txtHa.getText().isEmpty() || gui.txtdetails.getText().equals("") || gui.txtCerti.getText().equals(""))
            {            
            throw new NullPointerException("");    
            }
            HA = gui.getHa();
            Activity = gui.getAct();
            details = gui.getdetails();
            Certi = gui.getCerti();
            gui.err.setText("");
            System.out.println(HA + "" + Activity + "" + details + "" + Certi);
            }
            catch(NullPointerException er)
            {
                gui.err.setText("*Empty Field");
            }
        }
    }
*/
    
}

