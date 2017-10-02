
package com.studentprofilemanagement.AcademicManagement;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import com.studentprofilemanagement.AcademicManagement.DisplayFrame;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class AcademicFocusListener implements MouseListener 
{
    public String Grade;
    public String Intern;
    public String Pro1;
    public String Pro2;
    public String Pro3;
     public String Pro4;
     public String Work1;
     public String Work2;
     AcademicGUI agui;
        
     public AcademicFocusListener(AcademicGUI au)
     {
         agui=au;
     }
    
    
    

	@Override
	public void mouseClicked(MouseEvent e) {                                //Action Event Mouse Clicked
		
		
		
		PanelAcademicRecord selectedRecord = (PanelAcademicRecord) e.getSource();
		
		System.out.println("Selected Id: " + selectedRecord.getRoll());
		
		AcademicGUI AcademicForm = (AcademicGUI) SwingUtilities.getRoot(selectedRecord);
		
          
            
            Grade=selectedRecord.getGradeF();
            Intern=selectedRecord.getInternshipF();
            Pro1=selectedRecord.getpro1F();
            Pro2=selectedRecord.getpro2F();
            Pro3=selectedRecord.getpro3F();
            Pro4=selectedRecord.getpro4F();
            Work1=selectedRecord.getwork1F();
             Work2=selectedRecord.getwork2F();
            
            
	}
            
        
        //Overriding several functions
	@Override
	public void mousePressed(MouseEvent e) {
            PanelAcademicRecord selectedRecord = (PanelAcademicRecord) e.getSource();
		
		System.out.println("Selected Id: " + selectedRecord.getRoll());
		
		AcademicGUI AcademicForm = (AcademicGUI) SwingUtilities.getRoot(selectedRecord);
		System.out.println("Mouse Pressed: " );
                DisplayFrame d=new DisplayFrame(agui);
                d.Roll.setText((selectedRecord.getRoll()));
                d.Grade.setText((selectedRecord.getGrade()));
                d.Intern.setText((selectedRecord.getInternship()));
                d.Pro1.setText((selectedRecord.getpro1()));
                d.Pro2.setText((selectedRecord.getpro2()));
                d.Pro3.setText((selectedRecord.getpro3()));
                d.Pro4.setText((selectedRecord.getpro4()));
                d.Work1.setText((selectedRecord.getwork1()));
                d.Work2.setText((selectedRecord.getwork2()));
                d.Semf.setText((selectedRecord.getSemF()));
                d.Rollf.setText((selectedRecord.getRollF()));
                d.Gradef.setText((selectedRecord.getGradeF()));
                d.Internf.setText((selectedRecord.getInternshipF()));
                d.Pro1f.setText((selectedRecord.getpro1F()));
                d.Pro2f.setText((selectedRecord.getpro2F()));
                d.Pro3f.setText((selectedRecord.getpro3F()));
                d.Pro4f.setText((selectedRecord.getpro4F()));
                d.Work1f.setText((selectedRecord.getwork1F()));
                d.Work2f.setText((selectedRecord.getwork2F()));
                d.Semff.setText((selectedRecord.getSemF()));
                
                
                        
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
		
	}
        
 }
