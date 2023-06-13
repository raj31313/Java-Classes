package com.ded.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;

import com.ded.model.Employee;
import com.ded.dao.EmployeeDao;

public class EmployeeController implements EmployeeInterface {
	
	Scanner sc = new Scanner(System.in);

	Employee emp;
	
	List<Employee> emplist = new ArrayList<>();
	EmployeeDao empdao = new EmployeeDao();
	
	public void addEmployee()
	{
		emp = new Employee();
		System.out.println("Enter Eno");
		int eno = sc.nextInt();
		emp.setEno(eno);
		System.out.println(emp.getEno());
		System.out.println("Enter Ename");
		String ename = sc.next();
		emp.setEname(ename);
		System.out.println(emp.getEname());
		
		emplist.add(emp);
		
		empdao.insertEmployee(emp);
	}
	
	public void viewEmployee() {
//		System.out.println(emp.getEmpno());
//		System.out.println(emp.getEname());
		
		System.out.println(emplist);
		
		Iterator<Employee> i = emplist.iterator();
		while(i.hasNext()) {
			System.out.println(i.next());
		}
		
		System.out.println("Datas from DB:");
		empdao.showEmployee();
	}
	
	public void SerialEg() {
		try{
			//Employee emp = new Employee();
		
			FileOutputStream fos = new FileOutputStream("dedalus.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(emplist);
			System.out.println("Serilized to file dedalus.txt");
			oos.close();
			fos.close();
			}
			catch(FileNotFoundException fnf)
			{
				System.out.println("No file");
			}
			catch(IOException ae)
			{
				System.out.println("No file");
			}
			
	}
	
	public void DeSerialEg() {
		try{
			
			
			FileInputStream fis = new FileInputStream("dedalus.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			emplist = (ArrayList<Employee>) ois.readObject();
			System.out.println("DeSerilized from file dedalus.txt");
			
			emplist.forEach(emp -> {
				System.out.println("Employee No : " + emp.getEno()+ " " +"Employee Name : "+ emp.getEname());
			});
			
//			for(Employee emp : emplist) {
//				System.out.println(emp.getEno() + " " + emp.getEname());
//			}
			ois.close();
			fis.close();
			
			}
			catch(FileNotFoundException fnf)
			{
				System.out.println("No file");
			}
			catch(ClassNotFoundException cnf)
			{
				System.out.println("No Emp class");
			}
			catch(IOException ae)
			{
				System.out.println("No file");
			}

	}
	
	public void updateEmployee() {
		System.out.println("Enter the employee number to update: ");
		int eno = sc.nextInt();
		
		System.out.println("Enter new employee name to update");
		String ename = sc.next();
		empdao.updateEmployee(eno, ename);
	}
	
	public void deleteEmployee() {
		System.out.println("Enter the employee number to delete: ");
		int eno = sc.nextInt();
		
		empdao.deleteEmployee(eno);
	}
	
	public List<Employee> getEmplist() {
		// TODO Auto-generated method stub
		return emplist;
	}
	
	public void sortEmployee() {
		System.out.println("Sort by name(1) or sort by Eno(2)?");
		int ch = sc.nextInt();
		
		if(ch == 1) {
			Collections.sort(getEmplist(),Employee.nameComparator);
			empdao.sortEmployee(ch);
		}
		else {
			Collections.sort(getEmplist());
			empdao.sortEmployee(ch);
		}
		
	}


}
