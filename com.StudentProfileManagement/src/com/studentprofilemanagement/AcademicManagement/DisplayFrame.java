/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.studentprofilemanagement.AcademicManagement;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class DisplayFrameActionListener implements ActionListener
{
    private DisplayFrame display;
    private AcademicGUI ai;
    public DisplayFrameActionListener(DisplayFrame d, AcademicGUI agu)
    {
        display=d;
        ai=agu;
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getActionCommand()==display.delete.getText())
        {
            AcademicList al=new AcademicList();
            try
            {
            al.deleteRecord(display);
            display.setVisible(false);
            }
            
            catch(SQLException er)
            {
                
            }
            
            catch(Exception er)
            {
                
            }
            
        }
        
        if(e.getActionCommand()==display.update.getText())
        {
            
            ai.txtGrade.setText(display.Gradef.getText());
            ai.txtintern.setText(display.Internf.getText());
            ai.txtpro1.setText(display.Pro1f.getText());
           ai.txtpro2.setText(display.Pro2f.getText());
           ai.txtpro3.setText(display.Pro3f.getText());
           ai.txtpro4.setText(display.Pro4f.getText());
            ai.txtWS1.setText(display.Work1f.getText());
             ai.txtWS2.setText(display.Work2f.getText());
           System.out.println(""+display.Semff.getText());
           ai.sem.setEnabled(false);
          ai.sem.setSelectedItem(display.Semff.getText());
            display.setVisible(false); 
             
             ai.submit.setVisible(false);
             ai.update.setVisible(true);
             
           
            
        }
        
    }
    
      
}


public class DisplayFrame extends JFrame
{
    JPanel Pan=new JPanel();
    JLabel Sem=new JLabel();
    JLabel Roll=new JLabel();
    JLabel Grade=new JLabel();
    JLabel Intern=new JLabel();
    JLabel Pro1=new JLabel();
    JLabel Pro2=new JLabel();
    JLabel Pro3=new JLabel();
    JLabel Pro4=new JLabel();
    JLabel Work1=new JLabel();
    JLabel Work2=new JLabel();
    public static JLabel Semf=new JLabel();
    JLabel Semff=new JLabel();
    JLabel Rollf=new JLabel();
    JLabel Gradef=new JLabel();
    JLabel Internf=new JLabel();
    JLabel Pro1f=new JLabel();
    JLabel Pro2f=new JLabel();
    JLabel Pro3f=new JLabel();
    JLabel Pro4f=new JLabel();
    JLabel Work1f=new JLabel();
    JLabel Work2f=new JLabel();
   
    JButton delete=new JButton("Delete");
    JButton update=new JButton("Update");
    
    
    public DisplayFrame(AcademicGUI ag)
            
    {
        
        this.setSize(500,500);
        Pan.add(Sem);
        Pan.add(Roll);
       Pan.add(Grade);
      Pan.add(Intern);
         Pan.add(new JLabel(""));
        Pan.add(Pro1);
         Pan.add(new JLabel(""));
        Pan.add(Pro2);
         Pan.add(new JLabel(""));
        Pan.add(Pro3);
         Pan.add(new JLabel(""));
        Pan.add(Pro4);
         Pan.add(new JLabel(""));
        Pan.add(Work1);
         Pan.add(new JLabel(""));
        Pan.add(Work2);
        
        
         Pan.add(new JLabel(""));
        Pan.add(delete);
        Pan.add(update);
        DisplayFrameActionListener disp=new DisplayFrameActionListener(this, ag);
        delete.addActionListener(disp);
        update.addActionListener(disp);
        this.add(Pan);
        this.setVisible(true);
   }
    
   
}

