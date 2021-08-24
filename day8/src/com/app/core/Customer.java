package com.app.core;
import java.text.SimpleDateFormat;
import java.util.*;

public class Customer {
  //name(string),email(string),password(string),registrationAmount(double),dob(Date)
	private String name,email,password;
	private double registrationAmount;
	private Date dob;
	private CustomerType ctype;
    public static SimpleDateFormat sdf;
	
	static {
		sdf = new SimpleDateFormat("dd-MM-yyyy");
	}
	public Customer(String name, String email, String password, double registrationAmount, Date dob, CustomerType ctype) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.registrationAmount = registrationAmount;
		this.dob = dob;
		this.ctype = ctype;
	}
    public Customer(String email) {
    	this.email = email;
    }
	@Override
	public String toString() {
		return "Name: "+name+", Email: "+email+", Password: "+password+", Registration Ammount: "+registrationAmount+", Date of Birth: "+sdf.format(dob)+" ,Customer Type: "+ctype;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Customer) 
		 return email.equals(((Customer)obj).email);
		 return false;
		}
	}
	

