/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.studentprofilemanagement.StudentMenu;
import com.studentprofilemanagement.StudentConnection;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FrameCompare extends JFrame

{
    JLabel stugrade=new JLabel();
    JLabel avggrade=new JLabel();
    JLabel Sem=new JLabel("Semester Number");
    String s[] = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII"};
    JComboBox txtSem=new JComboBox(s);
    JPanel Pan=new JPanel();
    JButton compare=new JButton("Compare");
    JButton back=new JButton("Back");
    int rollnum;
    
    public FrameCompare(int r)
    {
        this.setSize(500, 400);
        rollnum=r;
        Pan.add(Sem);
        Pan.add(txtSem);
        
        Pan.add(compare);
        Pan.add(back);
        FrameCompareActionListener f=new FrameCompareActionListener(this, rollnum);
        compare.addActionListener(f);
        back.addActionListener(f);
        Pan.add(stugrade);
        Pan.add(avggrade);
        this.add(Pan);
        this.setVisible(true);
        
    }
    
    
    
}

class FrameCompareActionListener implements ActionListener
{
    private FrameCompare fc;
    public String gpa;
    double total=0, avg;
    String sem;
    int g;
    int roll;
    String stuGrade;
    public FrameCompareActionListener(FrameCompare comp, int ro)
    {
        fc=comp;
        roll=ro;
    }
    
    public void actionPerformed(ActionEvent e)
    {
        
        try
        {
        
        if(e.getActionCommand()==fc.compare.getText())
        {
             System.out.println("Creating statement...");                          //Fetch Records from Database
	   Connection conn = StudentConnection.getConnection();
	   Statement stmt = conn.createStatement();
	   String sql;
	   sql = "SELECT * FROM academic4";
	   ResultSet rs = stmt.executeQuery(sql);
    
         //  System.out.println("Enter the sem you want to compare : ");
            sem=(String)fc.txtSem.getSelectedItem();
            
	   while(rs.next())                                                         //Retrieve by column name
	   {  
              
               if(sem.equals(rs.getString("sem")))
               {
                   
               gpa=rs.getString("grade");
                  
               total=total+Double.parseDouble(gpa);
                  
               g++;
               
               if(String.valueOf(roll).equals(rs.getString("rollno")))
               {
                 
                   stuGrade=rs.getString("grade");
               }
               
               
               }
      
               
           }
           
           avg=total/g;
           /* System.out.println("g : "+g);
            System.out.println("Average : "+avg);*/
           
           fc.avggrade.setText("Average Grade : "+String.valueOf(avg));
           
           
           fc.stugrade.setText("Student Grade : "+stuGrade);
           
           if(avg>Double.parseDouble(stuGrade))
           {
               fc.stugrade.setForeground(Color.red);
           }
           
           else
           {
               fc.stugrade.setForeground(Color.green);
           }
                        
           
        }
        else if(e.getActionCommand()==fc.back.getActionCommand())
        {
            fc.setVisible(false);
            MenuFrame5 M = new MenuFrame5(roll);
        }
        }
        
        catch(SQLException ee)
        {
            
        }
        
        catch(Exception ee)
        {
            
        }
    
        
    }
    
        
    
}
