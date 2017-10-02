/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.studentprofilemanagement.StudentMenu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import com.studentprofilemanagement.StudentMenu.FrameCompare;
import com.studentprofilemanagement.StudentDetailsManagement.displayStudentRecords;
import com.studentprofilemanagement.StudentCategory.Category;
import com.studentprofilemanagement.StudentLogin.LoginFrame_4;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
public class MenuFrame5 extends JFrame
{
 
    public int rolln;
    JPanel btnPan=new JPanel();
    JLabel title = new JLabel("   MENU");
     
    JButton btnView = new JButton("View Profile");
    JButton btnCompare = new JButton("Compare");
    JButton btnEdit = new JButton("Edit");
    JButton back = new JButton("Back");
    public MenuFrame5(int rn)
    {
       // System.out.println("rn : "+rn);
        // this.setTitle("Queue Operations");
        rolln=rn;
        this.setSize(800, 500);
        
        this.setBackground(Color.BLACK);
        this.getContentPane().setBackground(Color.ORANGE);
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        //btnPan.setPreferredSize(new Dimension(400,200));
        title.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        title.setFont(new Font("Comic Sans MS", Font.PLAIN,30));
        btnPan.setSize(500, 400);
        FrameMenuActionListener listener=new FrameMenuActionListener(this, rolln);      //Action Listener object
        btnEdit.addActionListener(listener);
        btnCompare.addActionListener(listener);
        btnView.addActionListener(listener);
        back.addActionListener(listener);
        btnView.setBackground(Color.CYAN);
        btnCompare.setBackground(Color.CYAN);
        btnEdit.setBackground(Color.CYAN);
        btnPan.setBackground(Color.ORANGE);
        back.setBackground(Color.GRAY);
        btnPan.setLayout(new GridLayout(9,1));  
        btnCompare.setFont(new Font("Comic Sans MS", Font.PLAIN,25));
        btnEdit.setFont(new Font("Comic Sans MS", Font.PLAIN,25));
        btnView.setFont(new Font("Comic Sans MS", Font.PLAIN,25));
        back.setFont(new Font("Comic Sans MS", Font.PLAIN,25));
        btnPan.add(title);
        title.setSize(50, 50);
        btnPan.add(new JLabel(""));
        btnPan.add(btnView);
        btnPan.add(new JLabel(""));
        btnPan.add(btnCompare);
        btnPan.add(new JLabel(""));
        btnPan.add(btnEdit);
        btnPan.add(new JLabel(""));
        btnPan.add(back);
                
        this.add(btnPan);    
        this.setVisible(true);
        
        
    }
}

class FrameMenuActionListener implements ActionListener
{
    private MenuFrame5 myFrame5GUI;
    int rollnumb;
    public FrameMenuActionListener(MenuFrame5 MenuGUI, int r)
    {
        myFrame5GUI=MenuGUI;
        rollnumb=r;
    }
    
    public void actionPerformed(ActionEvent e)
    {
        
            if(e.getActionCommand()==myFrame5GUI.btnEdit.getText())
            {
                myFrame5GUI.setVisible(false);
                Category cat=new Category(rollnumb);
            }
            
            
            
            else if(e.getActionCommand()==myFrame5GUI.btnCompare.getText())
            {
                myFrame5GUI.setVisible(false);
                FrameCompare f=new FrameCompare(rollnumb);
               
                
                
            }
            
              else if(e.getActionCommand()==myFrame5GUI.btnView.getText())
            {
                myFrame5GUI.setVisible(false);
               displayStudentRecords d=new displayStudentRecords(rollnumb);
               
                
            }
              else if(e.getActionCommand()==myFrame5GUI.back.getText())
              {
                  myFrame5GUI.setVisible(false);
                  LoginFrame_4 l = new LoginFrame_4();
              }
            
            
            
          
    }
      
        
        
       
}