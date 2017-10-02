
package com.studentprofilemanagement.NonAcademicManagement;

public class NonAcademic {
 
        private int roll;
	private String HostAcademy;
	private String Certification;
        private String Activity;
        private String Activitymore;
       
        String Roll;
	
	NonAcademic()                                              //Default Constructor
	{}
	
	public NonAcademic(int roll, String HostAcademy, String Certification, String Activity, String Activitymore)       //Constructor
	{
           
		this.setRoll(roll);
		this.setHA(HostAcademy);
                this.setCerti(Certification);
                this.setActivity(Activity);
                this.setActivitymore(Activitymore);
                
	}
        
       public NonAcademic(String roll, String HostAcademy, String Certification, String Activity, String Activitymore)       //Constructor
	{
   
		Roll=roll;
		this.setHA(HostAcademy);
                this.setCerti(Certification);
                this.setActivity(Activity);
                this.setActivitymore(Activitymore);
                
	}

        //Getters and Setters
         
	public int getRoll() {
		return roll;
	}

	public void setRoll(int roll) {
		this.roll = roll;
	}
        
       

	public String getHA() {
		return HostAcademy;
	}

	public void setHA(String HostAcademy) {
		this.HostAcademy = HostAcademy;
	}
        
        
        
          public String getCerti() {
		return Certification;
	}

	public void setCerti(String Certification) {
		this.Certification = Certification;
	}
        
        public String getActivity() {
		return Activity;
	}

	public void setActivity(String Activity) {
		this.Activity = Activity;
	}
        
         public String getActivitymore() {
		return Activitymore;
	}

	public void setActivitymore(String Activitymore) {
		this.Activitymore = Activitymore;
	}
        
       
}
