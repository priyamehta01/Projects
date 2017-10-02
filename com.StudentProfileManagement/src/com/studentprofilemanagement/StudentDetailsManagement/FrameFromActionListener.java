/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.studentprofilemanagement.StudentDetailsManagement;

import static com.studentprofilemanagement.StudentDetailsManagement.PanelStudentRecord.BirthDate;
import static com.studentprofilemanagement.StudentDetailsManagement.PanelStudentRecord.BirthMonth;
import static com.studentprofilemanagement.StudentDetailsManagement.PanelStudentRecord.BirthYear;
import static com.studentprofilemanagement.StudentDetailsManagement.PanelStudentRecord.BatchYear;
import static com.studentprofilemanagement.StudentDetailsManagement.PanelStudentRecord.ContactNum;
import static com.studentprofilemanagement.StudentDetailsManagement.PanelStudentRecord.EmailID;
import static com.studentprofilemanagement.StudentDetailsManagement.PanelStudentRecord.Gender;
import static com.studentprofilemanagement.StudentDetailsManagement.PanelStudentRecord.Name;
import static com.studentprofilemanagement.StudentDetailsManagement.PanelStudentRecord.Password;
import static com.studentprofilemanagement.StudentDetailsManagement.PanelStudentRecord.Roll;
import com.studentprofilemanagement.StudentLogin.LoginFrame_4;
import com.studentprofilemanagement.StudentMenu.MenuFrame5;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author admin
 */
class FrameFormActionListener implements ActionListener
{
        private FormFrame3 myFrame3GUI;
    int y=0;
    int rol;
    public FrameFormActionListener(FormFrame3 FormGUI, int num)
    {
        myFrame3GUI=FormGUI;
        rol=num;
     
    }
    
    public void actionPerformed(ActionEvent e) 
    {
        int x=0;
                double cnt;
            if(e.getActionCommand()==myFrame3GUI.Submit.getText())
            { 
                
                if(Integer.parseInt((String)myFrame3GUI.year.getSelectedItem())%4!=0 && ((String)myFrame3GUI.month.getSelectedItem()).equals("February") && ((String)myFrame3GUI.date.getSelectedItem()).equals("29"))
                        {
                            myFrame3GUI.lblexp.setText("Invalid Date Entry!");
                        }
                
                else if(myFrame3GUI.txtCntNum.getText().length()!=10)
                {
                     myFrame3GUI.lblexp.setText("Invalid Contact Number Entry!");
                }
                        
                else
                    {
                
                try
                    {                               
                        cnt = Double.parseDouble(myFrame3GUI.txtCntNum.getText());
                        if(myFrame3GUI.txtrollno.getText().isEmpty() || myFrame3GUI.txtname.getText().equals("") || myFrame3GUI.txtemail.getText().equals("") || 
                        myFrame3GUI.txtCntNum.getText().equals("") || myFrame3GUI.txtpassword.getText().equals("") || myFrame3GUI.Gender.getSelectedCheckbox().equals("")
                        || myFrame3GUI.branch.getSelectedCheckbox().equals(""))
                        {            
                        throw new NullPointerException("");    
                        }
                        Student newStudent = new Student(Integer.parseInt(myFrame3GUI.txtrollno.getText()), myFrame3GUI.getName(), myFrame3GUI.getGender(), myFrame3GUI.getStream(), myFrame3GUI.getBatchYear(), myFrame3GUI.getEmail(), myFrame3GUI.getPassword(), myFrame3GUI.getContact(), myFrame3GUI.getYear(), myFrame3GUI.getMonth(), myFrame3GUI.getDate());
                        StudentList list = new StudentList();
                        
                        
                        //System.out.println(""+myFrame3GUI.mon);
                        list.addRecord(newStudent);
                        myFrame3GUI.setVisible(false);
                        LoginFrame_4 l=new LoginFrame_4();
                        }
                        catch(NullPointerException er)
                        {
                            myFrame3GUI.lblexp.setText("*Empty Field");
                        }

                        catch(NumberFormatException er)
                        {
                            myFrame3GUI.lblexp.setText("*Enter in numbers");
                        }

                        catch(SQLException err)                                             //Exception Handling
                        {
                         myFrame3GUI.lblexp.setVisible(true);
                        myFrame3GUI.lblexp.setText("Roll Number already exists!!");
                //err.printStackTrace();
                        myFrame3GUI.txtname.setText("");
                        myFrame3GUI.txtemail.setText("");
                        myFrame3GUI.txtpassword.setText("");
                        myFrame3GUI.txtCntNum.setText("");
                        myFrame3GUI.txtrollno.setText("");
                        myFrame3GUI.male.setState(false);
                        myFrame3GUI.female.setState(false);
                        myFrame3GUI.ICT.setState(false);
                        myFrame3GUI.chem.setState(false);
                        myFrame3GUI.mech.setState(false);
                        }
                        catch(InputMismatchException err)
                        {
                            myFrame3GUI.lblexp.setVisible(true);
                                myFrame3GUI.lblexp.setText("Roll Number bruh!!");
                        }

                        catch(Exception err)
                        {

                                err.printStackTrace();
                        }

            
            }
            }
            else if(e.getActionCommand()==myFrame3GUI.Update.getText())
            {
                
                Student modStudent = new Student(Integer.parseInt(myFrame3GUI.txtrollno.getText()), myFrame3GUI.getName(), myFrame3GUI.getGender(), myFrame3GUI.getStream(), myFrame3GUI.getBatchYear(), myFrame3GUI.getEmail(), myFrame3GUI.getPassword(), myFrame3GUI.getContact(), myFrame3GUI.getYear(), myFrame3GUI.getMonth(), myFrame3GUI.getDate());
                StudentList list = new StudentList();
                
                try
                {
                    list.updateRecord(modStudent);
                }
                
                catch(SQLException err)
                {
                    
                }
                
                catch(Exception err)
                {
                    
                }
                       
            }
            else if(e.getActionCommand()==myFrame3GUI.back.getText())
            {
                myFrame3GUI.setVisible(false);
                LoginFrame_4 l=new LoginFrame_4();
            }
    }
}
    



class FormDisplay extends JFrame
{
    JPanel Disp=new JPanel();
    JButton update=new JButton("Update");
    JButton back=new JButton("Back");
    int roll;
    
    public FormDisplay(int r)
    {
        roll=r;
        Disp.add(update);
        Disp.add(back);
        this.add(Disp);
        
        FormDisplayActionListener disp=new FormDisplayActionListener(this, roll);
        update.addActionListener(disp);
        back.addActionListener(disp);
        
        this.setVisible(true);
    }
            
}


class FormDisplayActionListener implements ActionListener
{
    FormDisplay f;
    int rolln;
    public FormDisplayActionListener(FormDisplay fo, int num)
    {
        f=fo;
        rolln=num;
    }
 
    public void actionPerformed(ActionEvent e) 
    {
       if(e.getActionCommand()==f.update.getText())
       {
           f.setVisible(false);
           FormFrame3 f3=new FormFrame3(rolln);
           f3.txtrollno.setText(Roll.getText());
           f3.txtrollno.setEditable(false);
           f3.txtname.setText(Name.getText());
           f3.txtpassword.setText(Password.getText());
           f3.year.setSelectedItem(BirthYear.getText());
           f3.month.setSelectedItem(BirthMonth.getText());
           f3.date.setSelectedItem(BirthDate.getText());
           f3.Batchyear.setSelectedItem(BatchYear.getText());
           f3.txtemail.setText(EmailID.getText());
           f3.txtCntNum.setText(ContactNum.getText());
           
           
       }
       if(e.getActionCommand()==f.back.getText())
       {
           f.setVisible(false);
           MenuFrame5 M = new MenuFrame5(rolln);
       }
       
    }
    
}
            

