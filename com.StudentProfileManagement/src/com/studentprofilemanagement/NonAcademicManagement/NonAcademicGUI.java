package com.studentprofilemanagement.NonAcademicManagement;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
host academy
certification name
name of activity
-music
-dance
-sports
-volunteering
Activity Details
*/

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
host academy
certification name
name of activity
-music
-dance
-sports
-volunteering
Activity Details
*/

public class NonAcademicGUI extends JFrame
{
    
    
    JLabel Title1,Title2,Ha,act,Certi,details,err;
    public JTextField txtHa = new JTextField(8);
    JTextField txtCerti,txtdetails,txtact,txtRoll;
    JPanel D=new JPanel();
    public JButton submit,Update,Display, back;
    JComboBox CBact;
    int n;
    public NonAcademicGUI(int nu)
    {
        this.setSize(400, 400);
        this.setLayout(new GridLayout(2,1,10,0));
        
        n=nu;
        Title1 = new JLabel("                                                             Non");
     Title2 = new JLabel("Academic");
    
     Ha = new JLabel("                                             Host Academy");
     
    
     Certi = new JLabel("                                             Certification");
     txtCerti = new JTextField(8);
    
     act = new JLabel("                                            Activity");
    String activity[] = {"Music", "Dance", "Sports", "Volunteering"};
     CBact = new JComboBox(activity);
    
     details = new JLabel("                                            Activity Details");
     txtdetails = new JTextField(8);
     submit = new JButton("Submit");
     Update = new JButton("Update");
     back = new JButton("Back");
     err = new JLabel("");
     txtact = new JTextField(8);
        //.setTitle("Non Academic");
     //  myFrame.setSize(400, 400);
      //  myFrame.setLayout(new GridLayout(2,1,10,0));
       // this.setBackground(Color.BLACK);
       // this.getContentPane().setBackground(Color.BLACK);
      //  myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel P = new JPanel();
        P.setSize(600, 400);
      //  D.setSize(300,300);
       // P.setBackground(Color.BLACK);
        P.setLayout(new GridLayout(12,2,5,2));
        P.setLayout(new GridLayout(12,4));
        //D.setLayout(new GridLayout(1,0,10,10));
        
        Title1.setPreferredSize(new Dimension(20,10));
        Title1.setFont(new Font("Serif", Font.PLAIN,20));
        Title2.setPreferredSize(new Dimension(20,10));
        Title2.setFont(new Font("Serif", Font.PLAIN,20));
        Title1.setForeground(Color.ORANGE);
        Title2.setForeground(Color.ORANGE);
        
        Ha.setFont(new Font("Serif",Font.PLAIN,20));
        //Ha.setBackground(Color.CYAN);
       // Ha.setForeground(Color.CYAN);
        Certi.setFont(new Font("Serif",Font.PLAIN,20));
        //Certi.setBackground(Color.CYAN);
        //Certi.setForeground(Color.CYAN);
        act.setFont(new Font("Serif",Font.PLAIN,20));
       // act.setBackground(Color.CYAN);
       /// act.setForeground(Color.CYAN);
        details.setFont(new Font("Serif",Font.PLAIN,20));
        //details.setBackground(Color.CYAN);
       // details.setForeground(Color.CYAN);
        txtHa.setFont(new Font("Serif", Font.PLAIN, 20));
        //txtHa.setBackground(Color.CYAN);
        
        txtCerti.setFont(new Font("Serif", Font.PLAIN, 20));
        //txtCerti.setBackground(Color.CYAN);
        
        CBact.setFont(new Font("Serif", Font.PLAIN, 20));
        //CBact.setBackground(Color.CYAN);
        
        txtdetails.setFont(new Font("Serif", Font.PLAIN, 20));
        //txtdetails.setBackground(Color.CYAN);
        txtdetails.setPreferredSize(new Dimension(15,10));
        Display=new JButton("Display");
        
        txtCerti.setToolTipText("Enter certificate details");
        
        
       // submit.setBackground(Color.PINK);
        submit.setFont(new Font("Serif",Font.BOLD,20));
        Update.setFont(new Font("Serif",Font.BOLD,20));
        back.setFont(new Font("Serif",Font.BOLD,20));
        Display.setFont(new Font("Serif",Font.BOLD,20));
        err.setForeground(Color.red);
        P.add(Title1);
        P.add(Title2);
        //P.add(new JLabel(""));
        //P.add(new JLabel(""));
        P.add(Ha);
        P.add(txtHa);
        P.add(new JLabel(""));
        P.add(new JLabel(""));
        P.add(Certi);
        P.add(txtCerti);
        P.add(new JLabel(""));
        P.add(new JLabel(""));
        P.add(act);
        P.add(CBact);
        P.add(new JLabel(""));
        P.add(new JLabel(""));
        P.add(details);
        P.add(txtdetails);
        P.add(new JLabel(""));
        P.add(new JLabel(""));
        P.add(submit);
      //  submit.setVisible(false);
       P.add(Display);
      // P.add(new JLabel(""));
        P.add(Update);
        P.add(back);
        P.add(err);
        
        NonAcademicActionListener listener = new NonAcademicActionListener(this,n);
        submit.addActionListener(listener);
        Display.addActionListener(listener);
        Update.addActionListener(listener);
        back.addActionListener(listener);
        this.add(P);
        
        this.add(D);
        this.setVisible(true); 
        P.setVisible(true);
    
}
    public int getRol()
    {
        return n;
    }
    
    public  void setRol(int r)
    {
        txtRoll.setText(Integer.toString(r));
    }

    
    
    public String getHa()
    {
        return txtHa.getText();
    }
    
    public void setHa(String Ha)
    {
        txtHa.setText(Ha);
    }
    public String getCerti()
    {
        return txtCerti.getText();
    }
    
    public void setCerti(String Certi)
    {
        txtCerti.setText(Certi);
    }
    public String getAct()
    {
        return (String)CBact.getSelectedItem();
    }
    public void setAct(String CBact)
    {
        txtact.setText((String)CBact);
    }
    
    public String getActmore()
    {
        return txtdetails.getText();
    }
    
    public void setActmore(String details)
    {
        txtdetails.setText(details);
    }
}




/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 
package com.studentprofilemanagement.NonAcademicManagement;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NonAcademicGUI extends JFrame
{
    
    
    JLabel Title1,Title2,Ha,act,Certi,details,err;
    public JTextField txtHa = new JTextField(15);
    JTextField txtCerti,txtdetails,txtact,txtRoll;
    JPanel D=new JPanel();
    public JButton submit,Update,Display;
    JComboBox CBact;
    int n;
    public NonAcademicGUI(int nu)
    {
        n=nu;
        Title1 = new JLabel("                              Non");
     Title2 = new JLabel("Academic");
    
     Ha = new JLabel("Host Academy");
     
    
     Certi = new JLabel("Certification");
     txtCerti = new JTextField(15);
    
     act = new JLabel("Activity");
    String activity[] = {"Music", "Dance", "Sports", "Volunteering"};
     CBact = new JComboBox(activity);
    
     details = new JLabel("Activity Details");
     txtdetails = new JTextField(20);
     submit = new JButton("Submit");
     Update = new JButton("Update");
     err = new JLabel("");
     txtact = new JTextField(15);
        this.setTitle("Non Academic");
       this.setSize(500,500);
        this.setLayout(new GridLayout(3,1, 10,10));
        this.setBackground(Color.BLACK);
        this.getContentPane().setBackground(Color.BLACK);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel P = new JPanel();
        P.setSize(300, 300);
        D.setSize(300,300);
        P.setBackground(Color.BLACK);
        P.setLayout(new GridLayout(0,2,3,3));
        D.setLayout(new GridLayout(1,0,10,10));
        
        Title1.setPreferredSize(new Dimension(30,10));
        Title1.setFont(new Font("Comic Sans MS", Font.PLAIN,40));
        Title2.setPreferredSize(new Dimension(30,10));
        Title2.setFont(new Font("Comic Sans MS", Font.PLAIN,40));
        Title1.setForeground(Color.ORANGE);
        Title2.setForeground(Color.ORANGE);
        
        Ha.setFont(new Font("Comic Sans MS",Font.PLAIN,35));
        Ha.setBackground(Color.CYAN);
        Ha.setForeground(Color.CYAN);
        Certi.setFont(new Font("Comic Sans MS",Font.PLAIN,35));
        Certi.setBackground(Color.CYAN);
        Certi.setForeground(Color.CYAN);
        act.setFont(new Font("Comic Sans MS",Font.PLAIN,35));
        act.setBackground(Color.CYAN);
        act.setForeground(Color.CYAN);
        details.setFont(new Font("Comic Sans MS",Font.PLAIN,35));
        details.setBackground(Color.CYAN);
        details.setForeground(Color.CYAN);
        txtHa.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 25));
        txtHa.setBackground(Color.CYAN);
        
        txtCerti.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 25));
        txtCerti.setBackground(Color.CYAN);
        
        CBact.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 25));
        CBact.setBackground(Color.CYAN);
        
        txtdetails.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 25));
        txtdetails.setBackground(Color.CYAN);
        
        Display=new JButton("Display");
        
        submit.setBackground(Color.PINK);
        submit.setFont(new Font("Tempus Sans ITC",Font.PLAIN,25));
        err.setForeground(Color.red);
        P.add(Title1);
        P.add(Title2);
        P.add(new JLabel(""));
        P.add(new JLabel(""));
        P.add(Ha);
        P.add(txtHa);
        P.add(new JLabel(""));
        P.add(new JLabel(""));
        P.add(Certi);
        P.add(txtCerti);
        P.add(new JLabel(""));
        P.add(new JLabel(""));
        P.add(act);
        P.add(CBact);
        P.add(new JLabel(""));
        P.add(new JLabel(""));
        P.add(details);
        P.add(txtdetails);
        P.add(new JLabel(""));
        P.add(new JLabel(""));
        P.add(submit);
        P.add(Display);
        P.add(Update);
        P.add(err);
        
        NonAcademicActionListener listener = new NonAcademicActionListener(this, n);
        submit.addActionListener(listener);
        Display.addActionListener(listener);
        Update.addActionListener(listener);
        this.add(P);
        this.add(D);
        this.setVisible(true); 
        P.setVisible(true);
    
}
    public int getRol()
    {
        return n;
    }
    
    public  void setRol(int r)
    {
        txtRoll.setText(Integer.toString(r));
    }

    
    
    public String getHa()
    {
        return txtHa.getText();
    }
    
    public void setHa(String Ha)
    {
        txtHa.setText(Ha);
    }
    public String getCerti()
    {
        return txtCerti.getText();
    }
    
    public void setCerti(String Certi)
    {
        txtCerti.setText(Certi);
    }
    public String getAct()
    {
        return (String)CBact.getSelectedItem();
    }
    public void setAct(String CBact)
    {
        txtact.setText((String)CBact);
    }
    
    public String getActmore()
    {
        return txtdetails.getText();
    }
    
    public void setActmore(String details)
    {
        txtdetails.setText(details);
    }
}
*/