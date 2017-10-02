/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.studentprofilemanagement.StudentDetailsManagement;

public class Student {

	private int roll;
	private String stuname;
	private String byear;
        private String bmonth;
        private String bdate;
        private String gen;
        private String branch;
        private String batchyr;
        private String email;
        private String pwd;
        private String connum;
        public String Roll;
	
	Student()                                              //Default Constructor
	{}
	
	public Student(int roll, String stuname, String gen, String branch, String batchyr, String email, String pwd, String connum, String byear, String bmonth, String bdate )        //Constructor
	{
		this.setRoll(roll);
		this.setStuName(stuname);
                this.setBYear(byear);
                this.setBMonth(bmonth);
                this.setBDate(bdate);
		this.setGen(gen);
                this.setBranch(branch);
                this.setBatchyr(batchyr);
                this.setEmail(email);
                this.setPassword(pwd);
                this.setConNum(connum);
                
	}
        
       public Student(String roll, String stuname, String gen, String branch, String batchyr, String email, String pwd, String connum, String byear, String bmonth, String bdate)        //Constructor
	{
		Roll=roll;
		this.setStuName(stuname);
                this.setBYear(byear);
                this.setBMonth(bmonth);
                this.setBDate(bdate);
		this.setGen(gen);
                this.setBranch(branch);
                this.setBatchyr(batchyr);
                this.setEmail(email);
                this.setPassword(pwd);
                this.setConNum(connum);
                
	}

        //Getters and Setters
         
	public int getRoll() {
		return roll;
	}

	public void setRoll(int roll) {
		this.roll = roll;
	}
        
       

	public String getStuName() {
		return stuname;
	}

	public void setStuName(String name) {
		this.stuname = name;
	}
        
        public String getByear() {
		return byear;
	}

	public void setBYear(String byear) {
		this.byear = byear;
	}
        
          public String getBMonth() {
		return bmonth;
	}

	public void setBMonth(String bmonth) {
		this.bmonth = bmonth;
	}
        
          public String getBDate() {
		return bdate;
	}

	public void setBDate(String bdate) {
		this.bdate = bdate;
	}
        
        public String getGen() {
		return gen;
	}

	public void setGen(String gen) {
		this.gen = gen;
	}
        
        public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}
        
        public String getBatchyr() {
		return batchyr;
	}

	public void setBatchyr(String batchyr) {
		this.batchyr = batchyr;
	}
        
        public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
        
        public String getPassword() {
		return pwd;
	}

	public void setPassword(String pwd) {
		this.pwd = pwd;
	}
        
        public String getConNum() {
		return connum;
	}

	public void setConNum(String connum) {
		this.connum = connum;
	}



	
	
}
