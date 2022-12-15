package com.amandla.genericutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.Driver;
/**
 * this class is used to perform all the database operations and it contains all the reusable Actions of database
 * @author VANNUR
 *
 */
public class DatabaseUtility {
	private Connection connection;
	private ResultSet result;
	private Statement statement = null;
	/**
	 * this method is used to get connection with mysql database server
	 * @param dbURL
	 * @param dbUserName
	 * @param dbPassword
	 */
	public void openDBConnection(String dbURL,String dbUserName, String dbPassword) {
		Driver dbdriver = null;
		try {
			dbdriver=new Driver();
			DriverManager.registerDriver(dbdriver);
			connection=DriverManager.getConnection(dbURL,dbUserName,dbPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * this method is used to retrieve data from database (result table)
	 * @param query
	 * @param columnName
	 * @return
	 */
	public List<String> getDataFromDatabase(String query,String columnName) {
		List<String> list = null;
		try {
			statement = connection.createStatement();
			result= statement.executeQuery(query);
			list = new ArrayList<String>();
			while (result.next()) {
				list.add(result.getString(columnName));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * this method is used to modify the data in database
	 * @param query
	 */
	public void modifyDataIntoDB(String query) {
		try {
			statement = connection.createStatement();
			 statement.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * this method is used to verify the data in Database
	 * @param query
	 * @param columnName
	 * @param expectedData
	 * @return
	 */
	public boolean verifyDataInDataBase(String query,String columnName,String expectedData) {
		List<String> list = getDataFromDatabase(query, columnName);
		boolean data=false;
		if (list.contains(expectedData)) {
			data=true;
		}
		return data;
	}
	/**
	 * this method is used to close database connection
	 */
	public void closeDB() {
		try {
			connection.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
