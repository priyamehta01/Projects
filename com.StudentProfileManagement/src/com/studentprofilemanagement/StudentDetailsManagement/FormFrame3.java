/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.studentprofilemanagement.StudentDetailsManagement;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.InputMismatchException;
//import javafx.scene.control.CheckBox;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class FormFrame3 extends JFrame
{
    public String mon;
    int n;
    private JLabel name = new JLabel("Name");
    private JLabel email = new JLabel("Email Address");
    public JTextField txtname = new JTextField(10);
    public JTextField txtDate = new JTextField(10);
    public JTextField txtMonth = new JTextField(10);
    public JTextField txtYear = new JTextField(10);
    public JTextField txtGender = new JTextField(10);
    public JTextField txtStream = new JTextField(10);
    public JTextField txtemail = new JTextField(10);
    public JLabel lblexp = new JLabel("");
    JLabel err = new JLabel("");
    JButton Update = new JButton("Update");
    private JLabel DOB = new JLabel("Date of Birth");
    String Date[] ={"1","2","3","4","5","6","7","8","9","10","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
    public JComboBox date= new JComboBox(Date);
    
    String Month[] = {"January","February","March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public JComboBox month= new JComboBox(Month);
    
    String Year[] = {"1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005"};
    public JComboBox year= new JComboBox(Year);
    
    private JLabel Rollno = new JLabel("Roll Number");
    public  JTextField txtrollno = new JTextField(10);
    
    private JLabel gender = new JLabel("Gender");
    public  CheckboxGroup Gender= new CheckboxGroup();
    Checkbox male = new Checkbox("Male",Gender,false);
    Checkbox female = new Checkbox("Female",Gender,false);
    
    private JLabel Branch = new JLabel("Branch");
    CheckboxGroup branch = new CheckboxGroup();
    Checkbox ICT = new Checkbox("ICT",branch,false);
    Checkbox mech = new Checkbox("Mechanical",branch,false);
    Checkbox chem = new Checkbox("Chemical",branch,false);
    
        
    private JLabel Bchyear = new JLabel("Batch Year");
    String BchYear[] = {"2011", "2012", "2013", "2014", "2015","2016"};
    public JComboBox Batchyear= new JComboBox(BchYear);
    
    private JLabel id = new JLabel("Email ID");
    public  JTextField emailid = new JTextField(20);
    
    private JLabel username = new JLabel("User Name");
    public  JTextField txtuser = new JTextField(10);
    
    private JLabel password = new JLabel("Password");
    public  JTextField txtpassword = new JTextField(10);

    private JLabel CntNum = new JLabel("Contact Number");
    public  JTextField txtCntNum = new JTextField(10);
    
    public JButton Submit = new JButton("Submit");
    public JButton back = new JButton("Back");
    public FormFrame3(int roll)
    {
        n=roll;
        this.setTitle("Profile Information");
        this.setLayout(new BorderLayout());
        this.setSize(800,800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.ORANGE);
        JPanel P1 = new JPanel();
        P1.setSize(800, 800);
        P1.setLayout(new GridLayout(26,2));
        P1.setBackground(Color.ORANGE);
    
        name.setFont(new Font("Comic Sans MS",Font.PLAIN,20));
        name.setBackground(Color.CYAN);
        name.setForeground(Color.BLUE);        
        id.setFont(new Font("Comic Sans MS",Font.PLAIN,20));
        id.setBackground(Color.CYAN);
        id.setForeground(Color.BLUE);
        DOB.setFont(new Font("Comic Sans MS",Font.PLAIN,20));
        DOB.setBackground(Color.CYAN);
        DOB.setForeground(Color.BLUE);
        Rollno.setFont(new Font("Comic Sans MS",Font.PLAIN,20));
        Rollno.setBackground(Color.CYAN);
        Rollno.setForeground(Color.BLUE);
        gender.setFont(new Font("Comic Sans MS",Font.PLAIN,20));
        gender.setBackground(Color.CYAN);
        gender.setForeground(Color.BLUE);
        male.setFont(new Font("Comic Sans MS",Font.ITALIC,20));
        male.setBackground(Color.ORANGE);
        female.setFont(new Font("Comic Sans MS",Font.ITALIC,20));
        female.setBackground(Color.ORANGE);
        ICT.setFont(new Font("Comic Sans MS",Font.ITALIC,20));
        ICT.setBackground(Color.ORANGE);
        mech.setFont(new Font("Comic Sans MS",Font.ITALIC,20));
        mech.setBackground(Color.ORANGE);
        chem.setFont(new Font("Comic Sans MS",Font.ITALIC,20));
        chem.setBackground(Color.ORANGE);
        Branch.setFont(new Font("Comic Sans MS",Font.PLAIN,20));
        Branch.setBackground(Color.CYAN);
        Branch.setForeground(Color.BLUE);
        email.setFont(new Font("Comic Sans MS",Font.PLAIN,20));
        email.setBackground(Color.CYAN);
        email.setForeground(Color.BLUE);
        Bchyear.setFont(new Font("Comic Sans MS",Font.PLAIN,20));
        Bchyear.setBackground(Color.CYAN);
        Bchyear.setForeground(Color.BLUE);
        username.setFont(new Font("Comic Sans MS",Font.PLAIN,20));
        username.setBackground(Color.CYAN);
        username.setForeground(Color.BLUE);
        password.setFont(new Font("Comic Sans MS",Font.PLAIN,20));
        password.setBackground(Color.CYAN);
        password.setForeground(Color.BLUE);
        CntNum.setFont(new Font("Comic Sans MS",Font.PLAIN,20));
        CntNum.setBackground(Color.CYAN);
        CntNum.setForeground(Color.BLUE);
        Submit.setFont(new Font("Comic Sans MS",Font.PLAIN,25));
        Submit.setBackground(Color.PINK);
        date.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 25));
        date.setBackground(Color.CYAN);
        month.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 25));
        month.setBackground(Color.CYAN);
        year.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 25));
        year.setBackground(Color.CYAN);
        Batchyear.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 25));
        Batchyear.setBackground(Color.CYAN);
        txtname.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 25));
        txtname.setBackground(Color.CYAN);
        txtrollno.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 25));
        txtrollno.setBackground(Color.CYAN);
        txtCntNum.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 25));
        txtCntNum.setBackground(Color.CYAN);
        txtuser.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 25));
        txtuser.setBackground(Color.CYAN);
        txtpassword.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 25));
        txtpassword.setBackground(Color.CYAN);
        txtemail.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 25));
        txtemail.setBackground(Color.CYAN);
        FrameFormActionListener listener=new FrameFormActionListener(this,n);      //Action Listener object
        Submit.addActionListener(listener);
        Update.addActionListener(listener);
        back.addActionListener(listener);
        P1.add(name);
        P1.add(txtname);
        
        P1.add(DOB);
        P1.add(date);
        P1.add(new JLabel(""));
        P1.add(month);
        P1.add(new JLabel(""));
        P1.add(year);
        
        P1.add(Rollno);
        P1.add(txtrollno);
        
        P1.add(gender);
        P1.add(male);
        P1.add(new JLabel(""));
        P1.add(female);
        
        P1.add(Branch);
        P1.add(ICT);
        P1.add(new JLabel(""));
        P1.add(mech);
        P1.add(new JLabel(""));
        P1.add(chem);
        P1.add(Bchyear);
        P1.add(Batchyear);
        
        P1.add(email);
        P1.add(txtemail);
        
      //  P1.add(username);
      //  P1.add(txtuser);
        P1.add(password);
        P1.add(txtpassword);
        
        P1.add(CntNum);
        P1.add(txtCntNum);
        P1.add(Update);
        P1.add(Submit);
        P1.add(back);
        P1.add(lblexp);
        //Update.setVisible(false);
       // txtname.setText(null);
        
        
        this.add(P1);
        this.setVisible(true);
    }
    
    public String getName()
    {
        return txtname.getText();
    }
	
    public void setName(String name)
    {
        txtname.setText(name);
    }
    
    public String getDate()
    {
        return (String)date.getSelectedItem();
    }
	
    public void setDate(String date)
    {
        txtDate.setText((String)date);
    }
    
     public String getMonth()
    {
       
        return (String)month.getSelectedItem();
    }
	
    public void setMonth(String month)
    {
        mon=month;
        txtMonth.setText((String)month);
        
    }
    
    public String getYear()
    {
        return (String)year.getSelectedItem();
    }
	
    public void setYear(String year)
    {
        txtYear.setText((String)year);
    }
    
    public String getRollNo()
    {
        return txtrollno.getText();
    }
	
    public void setRollNo(String rollno)
    {
        txtrollno.setText(rollno);
    }
    
    public String getGender()
    {
      if(male.getState())
      {
          return male.getLabel();
      }
      
      else
      {
          return female.getLabel();
      }
    }
	
    public void setGender(String gen)
    {
        txtGender.setText(gen);
       
        
    }
    
    public String getStream()
    {
        if(ICT.getState())
        {
            return ICT.getLabel();
        }
        
        else if(mech.getState())
        {
            return mech.getLabel();
        }
        
        else
        {
            return chem.getLabel();
        }
    }
    
    public void setStream(String stream)
    {
        txtStream.setText(stream);
    }
    
    public String getBatchYear()
    {
        return (String)Batchyear.getSelectedItem();
    }
	
    public void setBatchYear(Object bchyear)
    {
        txtYear.setText((String)bchyear);
    }
    
    /* public String getUserName()
    {
        return txtuser.getText();
    }
	
    public void setUserName(String username)
    {
        txtuser.setText(username);
    }*/
    
    public String getPassword()
    {
        return txtpassword.getText();
    }
	
    public void setPassword(String password)
    {
        txtpassword.setText(password);
    }
    
    public String getContact()
    {
        return txtCntNum.getText();
    }
	
    public void setContact(String contact)
    {
        txtCntNum.setText(contact);
    }
    
    public String getEmail()
    {
        return txtemail.getText();
    }
	
    public void setEmail(String Email)
    {
        txtemail.setText(Email);
    }
    
    
}
