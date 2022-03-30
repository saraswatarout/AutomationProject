package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleNonSelectSqlqurey {
	public static void main(String[] args) throws Throwable {
		Connection conn=null;
		int result=0;
		try {
			
			Driver driverRef = new Driver();
			DriverManager.registerDriver(driverRef);
			
			conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/testyantra","root","root");
			System.out.println("connection is done");
			
			Statement stat= conn.createStatement();
			String query="insert into students_info values('7','deepak','rout','h')"; 
			
			result = stat.executeUpdate(query); 
		}catch (Exception e) {
		}finally {
			if(result==1) {
				System.out.println("Data inserted succesfully");
			}else { 
	         System.err.println("Data is not inserted--");
			}
	        	  conn.close();
	        	 System.out.println("===============lose db connection========");
	         }
	}

}
