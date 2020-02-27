package com.DataBase.pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class DataBaseUtil {

	Connection connection = null;
	Statement statement = null;
	ResultSet resultset = null;

	public void connectMySqlDB() {

		String userName = "root";
		String password = "rahul";
		String driver="com.mysql.jdbc.Driver";
		String url = "jdbc:mariadb://localhost:3306/rahulworld";
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, userName, password);
//			 rs = stat.executeQuery("select * from Employee");
		} catch (Exception e) {
			System.out.println("driver connection issue");
		}
	}

	public void connectMariaDB() {

		String userName = "root";
		String password = "rahul";
		String driver="org.mariadb.jdbc.Driver";
		String url = "jdbc:mariadb://localhost:3306/rahulworld";
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, userName,password);
			statement = connection.createStatement();
		} catch (Exception e) {
			System.out.println("driver connection issue");
			e.printStackTrace();
		}
	}

	
	/*
	 * This method returns a map -> only 1st row
	 * {name=C, description=this is c language, id=101}
	 */
	public HashMap<String, String> getResultSet(String query) {
		HashMap<String, String> data = new HashMap<String, String>();
		try {
			resultset = statement.executeQuery(query);
			ResultSetMetaData resultsetMetaData = resultset.getMetaData();
			int columnCount = resultsetMetaData.getColumnCount();
			resultset.next();
			for (int i = 1; i <= columnCount; i++) {
				data.put(resultsetMetaData.getColumnName(i),
						resultset.getString(resultsetMetaData.getColumnName(i)));
			}
		} catch (SQLException e) {
			System.out.println("Result set statement issue");
		}

		return data;
	}

	/*
	 * This method returns a list total number of rows based on columns
	 * like this column - 1 [101, 102, 103, 104, 105] 
	 * column -2  [C, Java, Physics, Math, Chemistry]
	 */
	public ArrayList<String> getResultList(String query) {
		ArrayList<String> data = new ArrayList<String>();

		try {
			resultset = statement.executeQuery(query);
			ResultSetMetaData resultsetMetaData = resultset.getMetaData();
			while (resultset.next()) {
				data.add(resultset.getString(resultsetMetaData.getColumnName(2)));
			}
		} catch (Exception e) {
			System.out.println("Result set statement issue");
		}
		return data;
	}

	
	/*
	 * This method returns records in map format (key , value)
	 * 1 row fix as Header and others rows store in ArrayList
	 * ex-
	 {
		name=[C, Java, Physics, Math, Chemistry],
		description=[this is c language, Test java, Concept of physics, Demo math, Demo Chemistry],
		id=[101, 102, 103, 104, 105]
	}
	* Way to call -
		HashMap<String, ArrayList<String>> dataMap = dataBaseUtil.getMultipleResultData("select * from topic");
		for( Entry<String, ArrayList<String>> set :dataMap.entrySet())
		{
			System.out.println(set.getKey());
			System.out.println(set.getValue().get(0));
		}
		
	 */
	public HashMap<String, ArrayList<String>> getMultipleResultData(String query){
		
		HashMap<String, ArrayList<String>> data = new HashMap<String, ArrayList<String>>();
		ArrayList<String> header = new ArrayList<String>();
		
		try {
			resultset = statement.executeQuery(query);
			ResultSetMetaData resultsetMetaData = resultset.getMetaData();
			int columnCount = resultsetMetaData.getColumnCount();
			ArrayList<ArrayList<String>> rowObj= new ArrayList<ArrayList<String>>();
			for(int i=1;i<=columnCount;i++) {
				header.add(resultsetMetaData.getColumnName(i));
				rowObj.add(new ArrayList<String>());
			}
			
			while(resultset.next()) {
				for(int i=1;i<=columnCount;i++) {
					rowObj.get(i-1).add(resultset.getString(i));
				}
			}
			
			for(int i=0;i< columnCount;i++) {
				data.put(header.get(i), rowObj.get(i));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return data;
	}
	
	public void closeDB() {
		try {
			statement.close();
			connection.close();
			System.out.println("connection close");
		} catch (Exception e) {
			System.out.println("close coonection issue");
		}
	}
}
