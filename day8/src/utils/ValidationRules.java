package utils;

import exception.CustomerHandlingException;

import com.app.core.Customer;

import com.app.core.CustomerType;

import java.text.ParseException;

import static com.app.core.Customer.sdf;

import java.util.Date;

import static com.app.core.CustomerType.valueOf;

public class ValidationRules{
	
	public static String validateEmail(String email,Customer customer[]) throws CustomerHandlingException {
		Customer cus = new Customer(email);
		if(email.contains("@")&&email.contains(".com")) {
			for(Customer c : customer) {
				if(c != null) {
				if(!(c.equals(cus)))
					return email;
				   throw new CustomerHandlingException("duplicate customers are not allowed");
				}
				else
					return email;
			}
			
		}
		throw new CustomerHandlingException("Email must include @ and .com domain name");
	}
   
	public static String validatePass(String password) throws CustomerHandlingException {
		if(password.length()>=4 && password.length()<=10) 
		  return password;
	    throw new CustomerHandlingException("Password must be min 4 max 10 chars long");
	}
	
	public static double validateReg(double amt) throws CustomerHandlingException {
		if(amt%500 == 0)
			return amt;
		throw new CustomerHandlingException("Amount must be multiples of 500");
	}

	public static Date convertDate(String date) throws ParseException,CustomerHandlingException {
		if((sdf.parse(date)).before(sdf.parse("01-01-1995")))
		  return sdf.parse(date);
	    throw new CustomerHandlingException("Date must before 1st jan 1995");
	}
	
	public static CustomerType validateCustType(String ctype) throws CustomerHandlingException {
	   try {
		return valueOf(ctype);
	   }catch(Exception e) {
		throw new CustomerHandlingException("Invalid customer type");
	   }
	}

}