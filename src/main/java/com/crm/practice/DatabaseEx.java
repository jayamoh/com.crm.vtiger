package com.crm.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.cj.jdbc.Driver;

public class DatabaseEx {

	public static void main(String[] args) throws SQLException {

		Driver dbdriver= new Driver();
		String mobilename="notepad 15";
		String price="250000";
		String brand="mi";
		ArrayList<String> al=new ArrayList<String>();
		DriverManager.registerDriver(dbdriver); 

		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet44","root","root");
		Statement statement=connection.createStatement();
		ResultSet result=statement.executeQuery("select * from mobile;");
		while(result.next())
		{
			al.add(result.getString("mobilename").toLowerCase()+"||"+result.getString("price").toLowerCase()+"||"+result.getString("brand").toLowerCase());
		}
		System.out.println(al);
		if (al.contains(mobilename.toLowerCase()+"||"+price.toLowerCase()+"||"+brand.toLowerCase())) {
			System.out.println("data already exist");
		}
		else {
			@SuppressWarnings("unused")
			int result1=statement.executeUpdate("insert into mobile values ('"+mobilename+"',"+price+",'"+brand+"')");
			System.out.println("data updated successfully");
		}
		statement.close();
		connection.close();
		System.out.println("connection closed successfully");

	}
}
