package tester;

import static utils.ValidationRules.*;

import java.util.Scanner;

import com.app.core.Customer;

import exception.CustomerHandlingException;

import java.text.ParseException;
import java.util.*;

public class Test {
	
	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in);){
			System.out.println("Enter number of customers");
			Customer cust[] = new Customer[sc.nextInt()];
			int counter=0;
			boolean exit = false;
			while(!exit) {
			System.out.println("1.Prompt for customer details, 2.Display details of all registered customers, 3.Exit");
			System.out.println("Enter your choice");
			switch(sc.nextInt()) {
			case 1:System.out.println("Prompt for customer details name,email,password,registrationAmount,dob,type (CustomerType");
			       System.out.println("Enter name of customer");
			       String name = sc.next();
			       System.out.println("Enter email of customer");
			       String email = validateEmail(sc.next(),cust);
			       System.out.println("Enter password of customer");
			       String password = validatePass(sc.next());
			       System.out.println("Enter registration amount of customer");
			       double registrationAmount = validateReg(sc.nextDouble());
			       System.out.println("Enter date of birth");
			       Date d = convertDate(sc.next());
			       System.out.println("Enter Customer Type");
			       cust[counter++] = new Customer(name,email,password,registrationAmount,d,validateCustType(sc.next()));
			       break;
			       
			case 2: System.out.println("Display details of all registered customers");
			        for(Customer c : cust) {
			        	System.out.println(c);
			        }
			        break;
			        
			case 3: exit = true;
			}
		}
		}catch(ParseException | CustomerHandlingException e) {
			e.printStackTrace();
		}
	}

}
