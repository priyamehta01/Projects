/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.studentprofilemanagement.StudentLogin;


import com.studentprofilemanagement.StudentConnection;
import com.studentprofilemanagement.StudentDetailsManagement.FormFrame3;
import com.studentprofilemanagement.StudentMenu.MenuFrame5;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.JPanel;


public class LoginFrame_4  extends JFrame 
{
    public JFrame frame4;
    ImageIcon i1= null;
    ImageIcon i2= null;
    //ImageIcon i3 = null;
    JLabel lblRollNum = new JLabel("Roll Number");
    JButton btnSubmit = new JButton("Login");
    JLabel lblPwd = new JLabel("Password ");
    JButton btnNew = new JButton("New User");
    public JLabel err = new JLabel("");
    JPasswordField txtPwd = new JPasswordField();
    public  JTextField txtRollNum = new JTextField(10);
    public int rollnumber;
    int i=0;
    
    public LoginFrame_4()
    {
                frame4 = new JFrame();
                frame4.setLayout(new FlowLayout(FlowLayout.CENTER));
		frame4.setSize(600, 600);
		frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame4.setForeground(Color.GREEN);
		frame4.setLocationRelativeTo(null);
                frame4.getContentPane().setBackground(Color.ORANGE);
                 i1 = new ImageIcon("loginIcon2.png");
		 i2 = new ImageIcon(getClass().getResource("img2.jpg"));
                 //i3 = new ImageIcon("backgrnd.png");
                JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(8,4 ));   //setting layout
		panel1.setSize(400, 600);
		//panel1.setBackground(Color.CYAN);
                frame4.setForeground(Color.CYAN);
		panel1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
                panel1.setBackground(Color.ORANGE);
                JLabel lblImage1 = new JLabel(i1);                
                
                
                lblRollNum.setFont(new Font("Comic Sans MS",Font.PLAIN,30));
                lblRollNum.setForeground(Color.BLUE);                
                lblPwd.setFont(new Font("Comic Sans MS",Font.PLAIN,30));
                lblPwd.setForeground(Color.blue);
                btnNew.setBackground(Color.PINK);
                txtRollNum.setFont(new Font("Tempus Sans ITC",Font.PLAIN,25));
                txtRollNum.setBackground(Color.CYAN);
                
                btnNew.setFont(new Font("Tempus Sans ITC",Font.PLAIN,25));
                btnSubmit.setBackground(Color.YELLOW);
                btnSubmit.setFont(new Font("Tempus Sans ITC",Font.PLAIN,25));
                txtPwd.setBackground(Color.cyan);
                txtRollNum.setSize(10, 20);
                err.setFont(new Font("Comic Sans MS",Font.PLAIN,15));
                err.setForeground(Color.RED);  
                
                txtPwd.setSize(10, 20);
              
                setLayout(new BorderLayout());
	        JLabel background=new JLabel(new ImageIcon("backgrnd.png"));
	        frame4.add(background);
	        background.setLayout(new FlowLayout());
                
                
                
                //btnSubmit.setFont(new Font("Microsoft Sans Serif",Font.BOLD,18));
                btnSubmit.setSize(20, 30);
                LoginActionListener listener = new LoginActionListener(this);
                btnSubmit.addActionListener(listener);
                 btnNew.addActionListener(listener);
                 panel1.setAutoscrolls(rootPaneCheckingEnabled);
             //    frame4.add(but2);
                frame4.add(lblImage1);
               
                panel1.add(lblRollNum);
             
                panel1.add(txtRollNum);
              //  panel1.add(lbl3);
             //   panel1.add(lbl1);
                  panel1.add(new JLabel(""));
                    panel1.add(new JLabel(""));
                panel1.add(lblPwd);
              
                panel1.add(txtPwd);
                 
                panel1.add(new JLabel(""));
                panel1.add(new JLabel(""));
                panel1.add(new JLabel(""));
                panel1.add(new JLabel(""));
                panel1.add(btnSubmit);
                panel1.add(btnNew);
                panel1.add(new JLabel(""));
                panel1.add(err);
                frame4.setVisible(true);
                frame4.add(panel1);
               
                
    }
    
    

    
    }
                
             
              

class LoginActionListener implements ActionListener
{
    private LoginFrame_4 myFrame4GUI;
    //int y=0;
    int Roll;
    int i;
    public LoginActionListener(LoginFrame_4 LoginGUI)
    {
        myFrame4GUI=LoginGUI;
     
    }
     public void actionPerformed(ActionEvent e)
     {
         
         if(e.getActionCommand()==myFrame4GUI.btnSubmit.getText())
         {
             try
            {
            if(myFrame4GUI.txtRollNum.getText().isEmpty())
            {
                throw new NullPointerException("");
            }     
            Roll=Integer.parseInt(myFrame4GUI.txtRollNum.getText());
            Connection conn = StudentConnection.getConnection();
            Statement stmt = conn.createStatement();
	    String sql;
            sql = "SELECT * FROM student.studentdetails WHERE RollNo='"+Roll+"';";
            stmt.execute(sql);
                
            ResultSet rs = stmt.executeQuery(sql);
             i=0;   
            while(rs.next())
            {
                
               
                if(rs.getString("RollNo").equals(myFrame4GUI.txtRollNum.getText()))
                {
                    i++;
                    
                    if(rs.getString("Password").equals(myFrame4GUI.txtPwd.getText()))
                    {
                        myFrame4GUI.frame4.setVisible(false);    
                        MenuFrame5 menu=new MenuFrame5(Integer.parseInt(myFrame4GUI.txtRollNum.getText()));
                        // myFrame4GUI.err.setText((""));
                    }
                    
                    
                    else
                    {
                        myFrame4GUI.err.setText("Invalid Password!");
                    }
                }
                
                
               
                
                
            }
            
            if(i==0)
            {
                 myFrame4GUI.err.setText("Invalid User!");
            }
             
            }
             
            catch(SQLException err)
            {
                  err.printStackTrace();
            }
            catch(NumberFormatException er)
            {
                myFrame4GUI.err.setText("*Roll Number not Valid!");
            }
             
            catch(NullPointerException er)
            {
                myFrame4GUI.err.setText("*Empty Field");
            } 
            catch(Exception err)
            {
                    err.printStackTrace();
            }
             
             /* try
            {
            if(myFrame4GUI.txtRollNum.getText().isEmpty())
            {
                throw new NullPointerException("");
            }
            myFrame4GUI.rollnumber=Integer.parseInt(myFrame4GUI.txtRollNum.getText());
            MenuFrame5 menu=new MenuFrame5(myFrame4GUI.rollnumber);
            
            }
            catch(NullPointerException er)
            {
                myFrame4GUI.err.setText("*Empty Field");
            }
            
             //System.out.println("ROLL NO"+myFrame4GUI.rollnumber);*/
         }
         
          if(e.getActionCommand()==myFrame4GUI.btnNew.getText())
         {
             myFrame4GUI.frame4.setVisible(false);
             FormFrame3 form=new FormFrame3(myFrame4GUI.rollnumber);
             
         }
     }
}