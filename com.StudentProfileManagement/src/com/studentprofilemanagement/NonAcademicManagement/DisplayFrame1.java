
package com.studentprofilemanagement.NonAcademicManagement;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class DisplayFrame1ActionListener implements ActionListener
{
    private DisplayFrame1 display;
    private NonAcademicGUI nai;
    
    public DisplayFrame1ActionListener(DisplayFrame1 d, NonAcademicGUI nac)
    {
        display=d;
        nai=nac;
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getActionCommand()==display.delete.getText())
        {
            NonAcademicList an=new NonAcademicList(display, nai);
            try
            {
            an.deleteRecord(display);
            display.setVisible(false);
            }
            
            catch(SQLException er)
            {
                
            }
            
            catch(Exception er)
            {
                
            }
            
        }
        
        //rollNo, Hostaca, Certi, Activ, Activmore
        
        if(e.getActionCommand()==display.update.getText())
        {
            

            nai.txtHa.setText(display.hostacaf.getText());
           nai.txtCerti.setText(display.certif.getText());
           nai.txtact.setText(display.actif.getText());
           nai.txtdetails.setText(display.actifmore.getText());
           
           
             nai.submit.setVisible(false);
             nai.Update.setVisible(true);
             display.setVisible(false);
           
            
        }
        
    }
    
      
}


public class DisplayFrame1 extends JFrame
{
    JPanel Pan;
    public static JLabel hostaca,Roll,certi,acti,actim,hostacaf,Rollf,certif,actif,actifmore;
    
    JButton delete=new JButton("Delete");
    JButton update=new JButton("Update");

    
    
    public DisplayFrame1(NonAcademicGUI na)
            
    {
        Pan=new JPanel();
        hostaca= new JLabel();
        Roll= new JLabel();
        certi= new JLabel();
        acti= new JLabel();
        actim= new JLabel();
        hostacaf= new JLabel();
        Rollf= new JLabel();
        certif= new JLabel();
        actif= new JLabel();
        actifmore= new JLabel();
        
        this.setSize(500,500);
        Pan.add(Roll);
        Pan.add(new JLabel(""));
        Pan.add(hostaca);
        Pan.add(new JLabel(""));
        Pan.add(acti);
        Pan.add(new JLabel(""));
        Pan.add(actim);
         Pan.add(new JLabel(""));
        
        Pan.add(delete);
        Pan.add(update);
        DisplayFrame1ActionListener disp=new DisplayFrame1ActionListener(this, na);
        delete.addActionListener(disp);
        update.addActionListener(disp);
        this.add(Pan);
        this.setVisible(true);
    
   }
    
   
}


