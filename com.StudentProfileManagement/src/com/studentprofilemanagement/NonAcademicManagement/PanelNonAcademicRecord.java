/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.studentprofilemanagement.NonAcademicManagement;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author admin
 */
public class PanelNonAcademicRecord extends JPanel {
	
	private JLabel lblRollNo = new JLabel();                           //Objects of various labels
	private JLabel lblHa = new JLabel();
        private JLabel lblCerti=new JLabel();
        private JLabel lblActiv=new JLabel();
        private JLabel lblActivmore=new JLabel();
	
        private JLabel RollNo = new JLabel();
        private JLabel Ha = new JLabel();
        private JLabel Certi = new JLabel();
        private JLabel Activ = new JLabel();
        private JLabel Activmore = new JLabel();
        
        NonAcademicGUI na;
	
	public PanelNonAcademicRecord(String ro, String roll, String ha, String cert, String act, String actmore, NonAcademicGUI ng)       //Patameterised constructor
	{
           // System.out.println("ROLLNO"+roll);
               
                {
                    na=ng;
                
		lblRollNo.setText("Roll Number : "+ roll);                  //Label characteristics
		lblHa.setText("Hosting Academy : "+ha);
		lblCerti.setText("Certification : "+cert);
                lblActiv.setText("Activity : "+act);
                lblActivmore.setText("Activity details : "+actmore);
                
                RollNo.setText(roll);
                Ha.setText(ha);
		Certi.setText(cert);
                Activ.setText(act);
                Activmore.setText(actmore);
                
		this.setLayout(new GridLayout(10,10,2,2));
		
		this.add(lblRollNo);                       //Adding labels to frame
		this.add(lblHa);
		this.add(lblCerti);
                this.add(lblActiv);
		this.add(lblActivmore);
                
               // this.setVisible(true);
		
		this.addMouseListener(new NonAcademicFocusListener(ng));
		          }
                
              
               
	}
        
        //Various Getters and Setters
	
	public String getRoll()
	{
		return lblRollNo.getText();
	}
	
	public String getact()
	{
		return lblActiv.getText();
	}
	
	public String getHa()
	{
		return lblHa.getText();
	}
        
        public String getcert()
	{
		return lblCerti.getText();
	}
        
        public String getactmore()
	{
		return lblActivmore.getText();
	}
             public String getRollF()
             {
                 return RollNo.getText();
             }
             
             public String gethaF()
             {
                 return Ha.getText();
             }
             
             public String getcertF()
             {
                 return Certi.getText();
             }
             
             public String getActivF()
	{
		return Activ.getText();
	}
        
        public String ActivmoreF()
	{
		return Activmore.getText();
	}
             
}

