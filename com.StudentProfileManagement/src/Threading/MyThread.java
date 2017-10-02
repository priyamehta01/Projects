/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Threading;

import com.studentprofilemanagement.AcademicManagement.AcademicGUI;

public class MyThread implements Runnable{
    Thread t;
    int roll;
    public MyThread(int n){
        roll=n;
        t = new Thread(this,"NotifBox");
        t.start();
        
    }
    
    public void run()
    {
        try{
            DialogBox box = new DialogBox();
            box.setVisible(true);
            t.sleep(4000);
            box.dispose();
            AcademicGUI a=new AcademicGUI(roll);
        }
        catch(InterruptedException err){
            err.printStackTrace();
        }
    }        
    
}
