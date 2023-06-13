package com.ded.view;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.IOException;
import java.util.function.BiPredicate;

import com.ded.controller.EmployeeController;

import com.ded.controller.EmployeeInterface;

import com.ded.Exception.UserNotFoundException;



public class MainClass {

	public static void main(String[] args) {
		System.out.println("Welcome to EMS :)");
		EmployeeController ec = new EmployeeController();
		Scanner sc = new Scanner(System.in);
		String ch=null;
		
		try {
			String un = null;
			String pwd = null;

			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			System.out.println("Enter Username");
			un = br.readLine();
			System.out.println("Enter Password");
			pwd = br.readLine();
			BiPredicate<String, String> res = (u, p) -> u.equals(p);
			if (res.test(pwd, un)) {
				System.out.println("Welcome " + un);
				System.out.println("Please wait.....loading");
				Thread.sleep(5000);
			
		do {
		System.out.println("Enter your choice");
		System.out.println("1. Add Employee");
		System.out.println("2. View Employee");
		System.out.println("3. Serialize");
		System.out.println("4. DeSerialize");
		System.out.println("5. Update Employee");
		System.out.println("6. Delete Employee");
		System.out.println("7. Sort Employee");
		int choice = sc.nextInt();
		switch (choice) {
		case 1: {
			ec.addEmployee();
			break;
		}

		case 2: {
			ec.viewEmployee();
			break; 
		}
		
		case 3: { 
			ec.SerialEg();
			break;
		}
		
		case 4:{
			ec.DeSerialEg();
			break;
		}
		
		case 5:{
			ec.updateEmployee();
			break;
		}
			
		case 6:{
			ec.deleteEmployee();
//			ec.viewEmployee();
			break;
		}
		case 7:{
			ec.sortEmployee();
//			ec.viewEmployee();
			break; 
		}
		
		default: {
			System.out.println("Enter a valid number");
			break;
		}
		}
		
		System.out.println("Do u want to continue Y | y");
		ch=sc.next();
		
		}while(ch.equals("Y") || ch.equals("y"));
		System.out.println("Thanks for using our system.");
		System.exit(0);
			}
			else {
				throw new UserNotFoundException();
			}

		}

		catch (UserNotFoundException unf) {
			//System.out.println("From catch unf");
			//System.out.println(unf);
			unf.printStackTrace();
		}

		catch (Exception ae) {
			System.out.println("IO");
		} finally {
			System.out.println("Finally .....");
		}
		System.out.println("Main Ends");
	}

}
