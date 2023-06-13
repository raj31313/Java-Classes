package com.ded.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ded.model.Employee;
import com.ded.util.MyDbConnection;

public class EmployeeDao {
	
	Connection con;
	Statement stmt;
	PreparedStatement ps;
	ResultSet rs;
	
	public void insertEmployee(Employee emp) {
		
		con =MyDbConnection.getMyConnection();
		try {
			ps =con.prepareStatement("insert into DEDEMP values(?,?)");
			ps.setInt(1, emp.getEno());
			ps.setString(2, emp.getEname());
			int noofrows =ps.executeUpdate();
			System.out.println(noofrows + " got inserted into DB successfully!");
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
	}
	
	public void showEmployee() {
		con =MyDbConnection.getMyConnection();
		try {
			stmt =con.createStatement();
			rs =stmt.executeQuery("select * from dedemp");
			while(rs.next()) {
				System.out.println(rs.getInt(1) + " -- " + rs.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void updateEmployee(int eno, String ename) {
		con = MyDbConnection.getMyConnection();
		
		try {
			stmt = con.createStatement();
			stmt.executeUpdate("update dedemp set ename='"+ename+"' where eno= "+eno);
			System.out.println("employee got updated successfully!!");
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public void deleteEmployee(int eno) {
		con = MyDbConnection.getMyConnection();
		
		try {
			stmt = con.createStatement();
			stmt.executeUpdate("delete from dedemp where eno = "+eno);
			System.out.println("Employee number '"+eno+"' deleted successfully!!");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}