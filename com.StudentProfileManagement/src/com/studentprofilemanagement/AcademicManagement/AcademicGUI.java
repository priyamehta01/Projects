/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.studentprofilemanagement.AcademicManagement;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class AcademicGUI extends JFrame 
{
   int rol;
    JLabel lblGrade;
    JLabel exp = new JLabel();

    private JLabel Title2 = new JLabel("                                         A C A D");

    private JLabel Title = new JLabel("E M I C S");
    JLabel comp = new JLabel("* Indicates Compulsory Fields.");

    private JLabel Sem = new JLabel("                           SEMESTER(*)");
    String semno[] = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII"};
    JComboBox sem = new JComboBox(semno);
    JLabel pro1 = new JLabel("                           PROJECT 1");

    private JLabel pro2 = new JLabel("                           PROJECT 2");
    private JLabel pro3 = new JLabel("                           PROJECT 3");
    private JLabel pro4 = new JLabel("                           PROJECT 4");
    private JLabel intern = new JLabel("                           INTERNSHIP");
    JTextField txtsem = new JTextField(5);
    JTextField txtRoll = new JTextField(5);
    JTextField txtpro1 = new JTextField(5);
    JTextField txtpro2 = new JTextField(5);
    JTextField txtpro3 = new JTextField(5);
    JTextField txtpro4 = new JTextField(5);
    JTextField txtintern = new JTextField(5);
    private JLabel WS1 = new JLabel("                           WORKSHOP 1");
    private JLabel WS2 = new JLabel("                           WORKSHOP 2");
  //  JButton display = new JButton("                          Display");
    JTextField txtWS1 = new JTextField(5);
    JTextField txtWS2 = new JTextField(5);
    JButton submit = new JButton("   SUBMIT  ");
    JButton update = new JButton("UPDATE");
    JButton display = new JButton("DISPLAY");
    JButton back = new JButton("BACK");
    JTextField txtGrade;
    JPanel P = new JPanel();
    JPanel D = new JPanel();
    JPanel b = new JPanel();
        public AcademicGUI(int n) {
        rol = n;
        JFrame.setDefaultLookAndFeelDecorated(true);

        this.setTitle("        Academic");
        this.setSize(400, 400);
        //this.setLayout(new FlowLayout());
        this.setLayout(new GridLayout(2,1,10,0));
//this.setLayout(new GridLayout(5,1, 10,10));        
        this.setBackground(Color.CYAN);
       
        this.getContentPane().setBackground(Color.GRAY);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        P.setLayout(new GridLayout(13,2,5,2));
        P.setSize(600, 400);
        D.setLayout(new GridLayout(1,8));

        
        
        intern.setToolTipText("Enter Organization Name");

        pro1.setToolTipText("Enter short description for the project");
        pro2.setToolTipText("Enter short description for the project");
        pro3.setToolTipText("Enter short description for the project");
        pro4.setToolTipText("Enter short description for the project");
        WS1.setToolTipText("Enter short description for the workshop");
        WS2.setToolTipText("Enter short description for the workshop");
        update.setToolTipText("click to update data");
        back.setToolTipText("click to go back to the main page");
        display.setToolTipText("click to display data entered");
        
      txtpro1.setPreferredSize(new Dimension(20,10));
        pro1.setFont(new Font("Serif", Font.BOLD, 15));
        pro2.setFont(new Font("Serif", Font.BOLD, 15));
        pro3.setFont(new Font("Serif", Font.BOLD, 15));
        pro4.setFont(new Font("Serif", Font.BOLD, 15));
        intern.setFont(new Font("Serif", Font.BOLD, 15));
        WS1.setFont(new Font("Serif", Font.BOLD, 15));
        WS2.setFont(new Font("Serif", Font.BOLD, 15));
       
        Title.setPreferredSize(new Dimension(30, 10));
        Title.setFont(new Font("Serif", Font.BOLD, 25));
        Title2.setPreferredSize(new Dimension(20, 10));
        Title2.setFont(new Font("Serif", Font.BOLD, 25));
        Title.setForeground(Color.RED);
        Title2.setForeground(Color.RED);
        Sem.setFont(new Font("Serif", Font.BOLD, 15));
        //Sem.setFont(new Font("Comic Sans MS",Font.PLAIN,15));
        Sem.setBackground(Color.BLUE);
       
        Sem.setForeground(Color.BLUE);
       
        sem.setFont(new Font("Serif", Font.PLAIN, 15));
        sem.setBackground(Color.CYAN);
        sem.setEnabled(true);
        submit.setBounds(500, 500, 10, 10);

        
        submit.setFont(new Font("Serif", Font.PLAIN, 15));
        submit.setHorizontalAlignment(SwingConstants.CENTER);

       
        update.setFont(new Font("Serif", Font.PLAIN, 15));
        update.setHorizontalAlignment(SwingConstants.CENTER);
        
        back.setFont(new Font("Serif", Font.PLAIN, 15));
        back.setHorizontalAlignment(SwingConstants.CENTER);
        
         display.setFont(new Font("Serif", Font.PLAIN, 15));
         display.setHorizontalAlignment(SwingConstants.CENTER);
        
        lblGrade = new JLabel("                           GRADE(*)");
        lblGrade.setFont(new Font("Serif", Font.BOLD, 15));
        txtGrade = new JTextField();
        //txtGrade.setSize(5, 5);
        submit.setToolTipText("Press to submit");
     //   AcademicListener elist=new AcademicListener(this);
        // submit.addActionListener(elist);
        //display.addActionListener(elist);
        AcademicListener listener = new AcademicListener(this, rol);
        submit.addActionListener(listener);
        display.addActionListener(listener);
        update.addActionListener(listener);
        back.addActionListener(listener);
        P.add(Title2);
        P.add(Title);
        P.add(new JLabel(""));
        P.add(new JLabel(""));
       // P.add(new JLabel(""));
       // P.add(new JLabel(""));
        P.add(Sem);
        P.add(sem);
        P.add(new JLabel(""));
        P.add(new JLabel(""));
       // P.add(new JLabel(""));
        //P.add(new JLabel(""));
        P.add(lblGrade);
        P.add(txtGrade);
        P.add(new JLabel(""));
        P.add(new JLabel(""));
        //P.add(new JLabel(""));
        //P.add(new JLabel(""));
        P.add(intern);
        P.add(txtintern);
        P.add(new JLabel(""));
        P.add(new JLabel(""));
       //  P.add(new JLabel(""));
       // P.add(new JLabel(""));
        P.add(pro1);
        P.add(txtpro1);
        P.add(new JLabel(""));
        P.add(new JLabel(""));
        // P.add(new JLabel(""));
        //P.add(new JLabel(""));
        P.add(pro2);
        P.add(txtpro2);
        P.add(new JLabel(""));
        P.add(new JLabel(""));
         //P.add(new JLabel(""));
       // P.add(new JLabel(""));
        P.add(pro3);
        P.add(txtpro3);
        P.add(new JLabel(""));
        P.add(new JLabel(""));
        // P.add(new JLabel(""));
        //P.add(new JLabel(""));
        P.add(pro4);
        P.add(txtpro4);
        P.add(new JLabel(""));
        P.add(new JLabel(""));
       //  P.add(new JLabel(""));
        //P.add(new JLabel(""));
        P.add(WS1);
        P.add(txtWS1);
        P.add(new JLabel(""));
        P.add(new JLabel(""));
        P.add(WS2);
        P.add(txtWS2);

        P.add(new JLabel(""));
        P.add(new JLabel(""));
        P.add(comp);
        P.add(new JLabel(""));
        P.add(new JLabel(""));
        P.add(new JLabel(""));
        submit.setBounds(500, 500, 10, 10);
        P.add(submit);
        P.add(display);
        P.add(update);
        P.add(back);
        P.add(exp);
        // P.add(display);
        this.setBounds(5, 5, 700, 700);
        this.setVisible(true);
        this.add(P);
        //this.add(b);
        this.add(D);
        D.setVisible(true);
    }

    public int getRoll() {
        return rol;
    }

    public void setRoll(int r) {
        txtRoll.setText(Integer.toString(r));
    }

    public String getGrade() {
        return txtGrade.getText();
    }

    public void setGrade(String grade) {
        txtGrade.setText(grade);
    }

    public String getSem() {

        return (String) sem.getSelectedItem();
    }

    public void setSem(String sem) {
        txtsem.setText((String) sem);

    }

    public String getint() {
        return txtintern.getText();
    }

    public void setint(String intern) {
        txtintern.setText(intern);
    }

    public String getpr1() {
        return txtpro1.getText();
    }

    public void setpr1(String pr1) {
        txtpro1.setText(pr1);
    }

    public String getpr2() {
        return txtpro2.getText();
    }

    public void setpr2(String pr2) {
        txtpro2.setText(pr2);
    }

    public String getpr3() {
        return txtpro3.getText();
    }

    public void setpr3(String pr3) {
        txtpro3.setText(pr3);
    }

    public String getpr4() {
        return txtpro4.getText();
    }

    public void setpr4(String pr4) {
        txtpro4.setText(pr4);
    }

    public String getwr1() {
        return txtWS1.getText();
    }

    public void setwr1(String wr1) {
        txtWS1.setText(wr1);
    }

    public String getwr2() {
        return txtWS2.getText();
    }

    public void setWR2(String wr2) {
        txtWS2.setText(wr2);
    }
}

