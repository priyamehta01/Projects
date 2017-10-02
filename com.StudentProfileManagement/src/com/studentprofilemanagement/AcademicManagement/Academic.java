
package com.studentprofilemanagement.AcademicManagement;


public class Academic 
{
    private int roll;
	private String Semes;
        private String Grade;
        private String Intern;
        private String pro1;
        private String pro2;
        private String pro3;
        private String pro4;
        private String work1;
        private String work2;
        String Roll;
	
	Academic()                                              //Default Constructor
	{}
	
	public Academic(int roll, String Semes, String Grade, String Intern, String pro1, String pro2, String pro3, String pro4, String work1, String work2)       //Constructor
	{
   
		this.setRoll(roll);
		this.setSem(Semes);
                this.setGrade(Grade);
                this.setIntern(Intern);
                this.setPro1(pro1);
                this.setPro2(pro2);
                this.setPro3(pro3);
                this.setPro4(pro4);
                this.setWork1(work1);
                this.setWork2(work2);
               
                
	}
        
       public Academic(String roll, String Semes, String Grade, String Intern, String pro1, String pro2, String pro3, String pro4, String work1, String work2)       //Constructor
	{
    
		Roll=roll;
		this.setSem(Semes);
                this.setGrade(Grade);
                 this.setIntern(Intern);
                this.setPro1(pro1);
                this.setPro2(pro2);
                this.setPro3(pro3);
                this.setPro4(pro4);
                this.setWork1(work1);
                this.setWork2(work2);
               
                
	}

        //Getters and Setters
         
	public int getRoll() {
		return roll;
	}

	public void setRoll(int roll) {
		this.roll = roll;
	}
        
       

	public String getSem() {
		return Semes;
	}

	public void setSem(String Semes) {
		this.Semes = Semes;
	}
        
        
        
          public String getGrade() {
		return Grade;
	}

	public void setGrade(String Grade) {
		this.Grade = Grade;
	}
        
        public String getIntern() {
		return Intern;
	}

	public void setIntern(String Intern) {
		this.Intern = Intern;
	}
        
         public String getPro1() {
		return pro1;
	}

	public void setPro1(String pro1) {
		this.pro1 = pro1;
	}
        
        public String getPro2() {
		return pro2;
	}

	public void setPro2(String pro2) {
		this.pro2 = pro2;
	}
        
         public String getPro3() {
		return pro3;
	}

	public void setPro3(String pro3) {
		this.pro3 = pro3;
	}
        
         public String getPro4() {
		return pro4;
	}

	public void setPro4(String pro4) {
		this.pro4 = pro4;
	}
        
        public String getWork1() {
		return work1;
	}

	public void setWork1(String work1) {
		this.work1 = work1;
	}
        
         public String getWork2() {
		return work2;
	}

	public void setWork2(String work2) {
		this.work2 = work2;
	}
        
        
    
}
