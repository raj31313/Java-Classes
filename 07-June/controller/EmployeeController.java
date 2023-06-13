package com.ded.controller;

import java.util.ArrayList;
import java.io.Serializable;
import java.util.List;
import java.util.Scanner;
import com.dedalus.dao.EmployeeDao;
import java.util.Iterator;
import java.util.Comparator;
import java.util.Collections;

import com.dedalus.model.Employee;

public class EmployeeController implements EmployeeInterface, Serializable {

	private transient Scanner sc = new Scanner(System.in);
	Employee emp;
	List<Employee> emplist = new ArrayList<Employee>();
	EmployeeDao empdao = new EmployeeDao();

	public void addEmployee() {
		emp = new Employee();
		System.out.println("Enter Eno");
		int eno = sc.nextInt();
		emp.setEmpno(eno);

		System.out.println("Enter Ename");
		String ename = sc.next();
		emp.setEname(ename);
		emplist.add(emp);
		System.out.println("Employee Added Successfully");

	}

	public void viewEmployee() {
		// System.out.println(emp.getEmpno());
		// System.out.println(emp.getEname());

//		System.out.println(emplist);
//
//		Iterator<Employee> i = emplist.iterator();
//		while (i.hasNext()) {
//			System.out.println(i.next());

//			

	}

	public void insertEmployee() {
		System.out.println("Data from DB:");

		empdao.insertEmployee(emp);

	}

	public void showEmployee() {
		Collections.sort(emplist, Comparator.comparingInt(Employee::getEmpno));
		empdao.showEmployee();
	}

	public void updateEmployee() {
		System.out.println("Enter employee number to update:");
		int eno = sc.nextInt();

		// Check if the employee exists in the list
		boolean employeeExists = false;
		for (Employee e : emplist) {
			if (e.getEmpno() == eno) {
				employeeExists = true;
				System.out.println("Enter new employee name:");
				String newName = sc.next();
				e.setEname(newName);
				empdao.updateEmployee(e);
				break;
			}
		}

		if (!employeeExists) {
			System.out.println("Employee with number " + eno + " does not exist.");
		}
		
	}
	public void deleteEmployee() {
		System.out.println("Enter Employee Number to delete:");
		int empno = sc.nextInt();
		empdao.deleteEmployee(empno);
	}

	public void sortEmployee() {
		emplist = empdao.getAllEmployees();
		Collections.sort(emplist, Comparator.comparingInt(Employee::getEmpno));

		System.out.println("Sorted Employee List (by Employee Number):");
		for (Employee employee : emplist) {
			System.out.println("Employee Number: " + employee.getEmpno() + ", Employee Name: " + employee.getEname());
		}
	}
}