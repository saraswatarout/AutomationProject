package com.vtiger.Genericutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.bcel.ExceptionConstants;

import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.protocol.Resultset;

public class DatabaseUtility {
	Connection connection;
	 
	public void connectToDB()  {
		
			try {
					Driver driver = new Driver();
					DriverManager.registerDriver(driver);
					connection=DriverManager.getConnection(IPathConstants.DATABASE_URL,IPathConstants.DB_USERNAME,IPathConstants.DB_PASSWORD);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}
			
		
		
			public void closeDB() throws SQLException {
				connection.close();
			}
		
		
		public ResultSet getAllData(String querry) throws SQLException {
			ResultSet result=connection.createStatement().executeQuery(querry);
			 return  result;
		}
		
		public boolean insertData(String querry) throws SQLException {
			int result=connection.createStatement().executeUpdate(querry);
			boolean flag=false;
			if(result==1) {
				System.out.println("data is added");
				flag=true;
				return flag;
				
			}else {
				System.out.println("data is not added");
			}
			return flag;
		}

}
