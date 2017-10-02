/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.studentprofilemanagement.StudentCategory;

import Threading.DialogBox;
import Threading.MyThread;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import com.studentprofilemanagement.AcademicManagement.AcademicGUI;
import com.studentprofilemanagement.NonAcademicManagement.NonAcademicGUI;
import com.studentprofilemanagement.StudentMenu.MenuFrame5;

public class Category extends JFrame
{   
    JLabel Title = new JLabel("Categories");
    JLabel emp = new JLabel("");
    JLabel emp1 = new JLabel("");
    CheckboxGroup Categories = new CheckboxGroup();
    Checkbox Aca = new Checkbox("Academics",Categories,false);
    Checkbox NonAca = new Checkbox("Non Academic",Categories,false);
    
    JButton Submit = new JButton("Submit");
    JButton back = new JButton("Back");
    public int n;
    
    public Category(int num)
    {
        //System.out.println(""+num);
        n=num;
        this.setTitle("Categories");
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.setSize(800,800);
        this.setBackground(Color.ORANGE);
        this.getContentPane().setBackground(Color.ORANGE);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel P = new JPanel();
        P.setSize(400, 400);
        P.setLayout(new GridLayout(7,1));
        P.setBackground(Color.ORANGE);
        
        Title.setPreferredSize(new Dimension(30,15));
        Title.setFont(new Font("Comic Sans MS", Font.PLAIN,30));
        Aca.setFont(new Font("Tempus Sans ITC", Font.PLAIN,25));
        Aca.setBackground(Color.ORANGE);
        NonAca.setFont(new Font("Tempus Sans ITC", Font.PLAIN,25));
        NonAca.setBackground(Color.ORANGE);
        
        CategoryActionListener listener=new CategoryActionListener(this, n);      //Action Listener object
        Submit.addActionListener(listener);
        back.addActionListener(listener);
        P.add(Title);
        P.add(new JLabel(""));
        
        P.add(Aca);
        P.add(NonAca);
        
        P.add(new JLabel(""));
        P.add(Submit);
        P.add(back);
        this.add(P);
        this.setVisible(true);        
    }
}

class CategoryActionListener implements ActionListener
{
    private Category myCategory;
    int numb;
    public CategoryActionListener(Category catGUI, int nu)
    {
        myCategory=catGUI;
        numb=nu;
    }
      public void actionPerformed(ActionEvent e) 
      {
           if(e.getActionCommand()==myCategory.Submit.getText())
           {
               System.out.println("category : "+numb);
               if(myCategory.Aca.getState())
               {
                   myCategory.setVisible(false);
                   MyThread t1 = new MyThread(numb);
                   
               }
               else if(myCategory.NonAca.getState())
               {
                   myCategory.setVisible(false);
                   NonAcademicGUI n=new NonAcademicGUI(numb);
               }
           }
           if(e.getActionCommand()==myCategory.back.getText())
           {
               myCategory.setVisible(false);
               MenuFrame5 M =new MenuFrame5(numb);
           }
           
           
           
      }
}