
package com.studentprofilemanagement.AcademicManagement;


import com.studentprofilemanagement.StudentCategory.Category;
import com.studentprofilemanagement.StudentMenu.MenuFrame5;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JFrame;

class AcademicListener implements ActionListener {

private AcademicGUI frame;
int n;
int i=0;

public AcademicListener(AcademicGUI fram, int num)                               //Paramaterised ActionListner Constructor
{
        frame = fram;
        n=num;
}

public void displayAcademicRecords()
{
	ArrayList<PanelAcademicRecord> AcademicRecords = new ArrayList();
	

	try{
	AcademicList list = new AcademicList();                         //EmployeeList object created
	
	ArrayList<Academic> records = list.fetchRecords();
	
            for (Academic aca : records) 
            {
                if(aca.getRoll()==n)
                {
                   
                AcademicRecords.add(new PanelAcademicRecord(Integer.toString(n),Integer.toString(aca.getRoll()), aca.getSem(), aca.getGrade(), aca.getIntern(),aca.getPro1(),aca.getPro2(),aca.getPro3(), aca.getPro4(),aca.getWork1(),aca.getWork2(), frame));
                }
                }  
                
		
                
		
		for(PanelAcademicRecord r: AcademicRecords)
                {
			frame.D.add(r);
                }
		frame.validate();
		
	
	
	}
	catch(SQLException err)                                         //Exception Handling
	{
		err.printStackTrace();
	}
	catch(Exception err)
	{
		err.printStackTrace();
	}
	
        }


 
  
 @Override
    public void actionPerformed(ActionEvent e) 
    {
        double x;
        if(e.getActionCommand()==frame.submit.getText())
        {
            
            Academic newAcademic = new Academic(frame.rol, frame.getSem(), frame.getGrade(), frame.getint(),frame.getpr1(),frame.getpr2(),frame.getpr3(),frame.getpr4(),frame.getwr1(),frame.getwr2());
		try{
                    if(frame.txtGrade.getText().isEmpty() || frame.txtpro1.getText().isEmpty() || frame.sem.getSelectedItem().equals("--Not Selected--"))       
                    {            
                    throw new NullPointerException("");    
                    }
                    x = Double.parseDouble(frame.txtGrade.getText());
                    if(x<1 || x>5)
                    {
                        throw new Exception();
                    }
		    frame.submit.setVisible(true);
                    AcademicList list = new AcademicList();			
                    list.addRecord(newAcademic);
                    frame.setVisible(false);
                    frame.submit.setVisible(false);
		    MenuFrame5 M = new MenuFrame5(n);	
			
		}
		catch(SQLException err)                                             //Exception Handling
		{
                    
                    frame.exp.setText("Semester entry already made!!");
                  
                       
			
		}
                catch(NullPointerException er)
                {
                    frame.exp.setText("*Empty Field");
                }
                catch(NumberFormatException er)
                {
                    frame.exp.setText("*Enter Grade in numbers");
                }
		catch(Exception err)
		{
			frame.exp.setText("*Enter grade between 1 and 5!");
		}
                
                finally
                {
                    frame.txtGrade.setText("");
                    frame.txtpro1.setText("");
                    frame.txtpro2.setText("");
                    frame.txtpro3.setText("");
                    frame.txtpro4.setText("");
                    frame.txtWS1.setText("");
                    frame.txtWS2.setText("");
                    frame.txtsem.setText("");
                }
		
        }
        
      else if(e.getActionCommand()==frame.display.getText())
        {
            //AcademicListener ac=new AcademicListener(frame);
            do
            {
            this.displayAcademicRecords();
            i++;
            }while(i==0);
        }
        
         else if(e.getActionCommand()==frame.update.getText())
         {
            AcademicList a = new AcademicList();
            Academic modAcademic = new Academic(frame.rol, frame.getSem(), frame.getGrade(), frame.getint(),frame.getpr1(),frame.getpr2(),frame.getpr3(),frame.getpr4(),frame.getwr1(),frame.getwr2());
            try
            {
            if(frame.txtGrade.getText().isEmpty() || frame.txtpro1.getText().isEmpty() || frame.sem.getSelectedItem().equals("--Not Selected--"))       
                {            
                throw new NullPointerException("");    
                } 
            x = Double.parseDouble(frame.txtGrade.getText());
                if(x<1 || x>5)
                {
                    throw new Exception();
                }
            
            a.updateRecord(modAcademic);
            frame.setVisible(false);
            MenuFrame5 M = new MenuFrame5(n);
            }

            catch(SQLException s)
            {

            }
            catch(NullPointerException er)
            {
                frame.exp.setText("*Empty Field");
            }
            catch(NumberFormatException er)
            {
                frame.exp.setText("*Enter Grade in numbers");
            }
             catch(Exception s)
             {
                 frame.exp.setText("*Enter grade between 1 and 5!");
             }
             
            // this.displayAcademicRecords();
         }
         else if(e.getActionCommand()==frame.back.getText())
         {
             frame.setVisible(false);
             Category Cat = new Category(n);
         }
        
      
    }
    
    
        
        
    }
