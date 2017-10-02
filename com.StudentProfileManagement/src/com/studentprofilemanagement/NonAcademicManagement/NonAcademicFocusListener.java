
package com.studentprofilemanagement.NonAcademicManagement;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.SwingUtilities;

public class NonAcademicFocusListener implements MouseListener {
    
    public String ha;
    public String act;
    public String actmore;
    public String cert;
    
     NonAcademicGUI ng;
        
     public NonAcademicFocusListener(NonAcademicGUI au)
     {
         ng=au;
     }
    
    
    

	@Override
	public void mouseClicked(MouseEvent e) {                                //Action Event Mouse Clicked
		
		
		
		PanelNonAcademicRecord selectedRecord = (PanelNonAcademicRecord) e.getSource();
		
		System.out.println("Selected Id: " + selectedRecord.getRoll());
		
		NonAcademicGUI NonAcademicForm = (NonAcademicGUI) SwingUtilities.getRoot(selectedRecord);
		
         
            
            ha=selectedRecord.gethaF();
            cert=selectedRecord.getcertF();
            act=selectedRecord.getActivF();
            actmore=selectedRecord.ActivmoreF();
           
            
	}
            
        
        //Overriding several functions
	@Override
	public void mousePressed(MouseEvent e) {
            PanelNonAcademicRecord selectedRecord = (PanelNonAcademicRecord) e.getSource();
		
		System.out.println("Selected Id: " + selectedRecord.getRoll());
		
		NonAcademicGUI NonAcademicForm = (NonAcademicGUI) SwingUtilities.getRoot(selectedRecord);
		System.out.println("Mouse Pressed: " );
                DisplayFrame1 d=new DisplayFrame1(ng);
               
                d.hostaca.setText((selectedRecord.getHa()));
                d.certi.setText((selectedRecord.getcert()));
                d.acti.setText((selectedRecord.getact()));
                d.actim.setText((selectedRecord.getactmore()));
                
                d.hostacaf.setText((selectedRecord.gethaF()));
                d.Rollf.setText((selectedRecord.getRollF()));
                d.actif.setText((selectedRecord.getActivF()));
                d.actifmore.setText((selectedRecord.ActivmoreF()));
                d.certif.setText((selectedRecord.getcertF()));
                
                        
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
		
	}
        
        
        

	
}