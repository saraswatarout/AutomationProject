package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleSelectSqlquery {
	public static void main(String[] args) throws Throwable  {
		
		Connection conn=null;
		try {
			
			Driver driverRef = new Driver();
			DriverManager.registerDriver(driverRef);
			
			conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/testyantra","root","root");
			System.out.println("connection is done");
			
			Statement stat= conn.createStatement();
			String query="select * from students_info"; 
			
			ResultSet resultset = stat.executeQuery(query);
			while(resultset.next()) {
				System.out.println(resultset.getInt(1) +"\t"+resultset.getString(2)+"\t"
			                            +resultset.getString(3)+"\t"+resultset.getString(4));
				}
			}catch(Exception e) { 
	         }finally {
	        	 
	        	 conn.close();
	        	 System.out.println("===============lose db connection========");
	         }
	}
	 }
