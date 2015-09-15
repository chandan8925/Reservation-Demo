package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnector {
	private final static String DB_URL="jdbc:mysql://localhost:3306/mydata";
	private final static String DB_USER="root";
	private final static String DB_PASSOWRD="tiger";
 static{
	 try {
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("driver loaded");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		System.err.println("error loading driver" +e.getMessage());
		e.printStackTrace();
	}
 }
 public static Connection connect() {
	 Connection con=null;
	  try {
		con= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSOWRD);
		System.out.println("Connection Established");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		System.err.println("error in connection" +e.getMessage());
		e.printStackTrace();
	}
	 return con;
 }
public static void closeResources(PreparedStatement ps, ResultSet rs, Connection con){
	 try{
		  if(ps!= null)
		  {
			ps.close();
		  } 
		  if(rs!= null){
			  rs.close();
		  }
		  if(con!=null){
			  con.close();
		  }
	  }  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
}
