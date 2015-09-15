package Dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Exceptions.AppException;
import model.Employee;
import utils.DBConnector;

public class EmpDao {
	 public List<Employee>  getAllEmployee() throws AppException{
		 List<Employee> empList = new ArrayList<Employee>(); 
		 
		 Connection con = DBConnector.connect();
		 
		 PreparedStatement ps = null;
		 ResultSet rs = null;
		 try {
			ps = con.prepareStatement("SELECT * FROM mydata.people;");
			rs = ps.executeQuery();
			
			while(rs.next()){
				
				Employee emp = new Employee();
				emp.setId(rs.getInt("ID"));
				emp.setFirstName(rs.getString("FIRST_NAME"));
				emp.setLastName(rs.getString("LAST_NAME"));
				emp.setEmail(rs.getString("EMAIL"));
				emp.setAddress1(rs.getString("ADDRESS1"));
				emp.setAddress2(rs.getString("ADDRESS2"));
				emp.setCity(rs.getString("CITY"));
				emp.setZip(rs.getInt("ZIP"));
				emp.setCity(rs.getString("PHONE"));
				emp.setCity(rs.getString("STATE"));
				empList.add(emp);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AppException("Error :" +e.getMessage(),e.getCause());
		}
		 
		 finally{
			 
			 
			 DBConnector.closeResources(ps, rs, con); 
			 }
	 
		return empList; 
	 }

	 public Employee  getEmployee(int empId) throws AppException{
		Employee emp = null;
		 
		 Connection con = DBConnector.connect();
		 
		 PreparedStatement ps = null;
		 ResultSet rs = null;
		 try {
			ps = con.prepareStatement("SELECT * FROM mydata.people where id =?");
			ps.setInt(1,empId);
			rs = ps.executeQuery();
			
			if(rs.next()){
				
				emp = new Employee();
				emp.setId(rs.getInt("ID"));
				emp.setFirstName(rs.getString("FIRST_NAME"));
				emp.setLastName(rs.getString("LAST_NAME"));
				emp.setEmail(rs.getString("EMAIL"));
				emp.setAddress1(rs.getString("ADDRESS1"));
				emp.setAddress2(rs.getString("ADDRESS2"));
				emp.setCity(rs.getString("CITY"));
				emp.setZip(rs.getInt("ZIP"));
				emp.setPhone(rs.getString("PHONE"));
				
			
				
			}
			else{
				throw new AppException("Employee with id" +empId  +"is not available");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AppException("Error :" +e.getMessage(),e.getCause());
		}
		 
		 finally{
			 
			 
			 DBConnector.closeResources(ps, rs, con); 
			 }
	 
		return emp; 
	 }
	 
	 public Employee  addEmployee(Employee emp) throws AppException{
			
			 
			 Connection con = DBConnector.connect();
			 
			 PreparedStatement ps = null;
			 ResultSet rs = null;
			 try {
				ps = con.prepareStatement("INSERT INTO mydata.people (FIRST_NAME, LAST_NAME, EMAIL, ADDRESS1, ADDRESS2, PHONE,CITY, ZIP ) VALUES(?,?,?,?,?,?,?,?) ", PreparedStatement.RETURN_GENERATED_KEYS);
				ps.setString(1, emp.getFirstName());
				ps.setString(2, emp.getLastName());
				ps.setString(3, emp.getEmail());
				ps.setString(4, emp.getAddress1());
				ps.setString(5, emp.getAddress2());
				ps.setString(6, emp.getPhone());
				ps.setString(7, emp.getCity());
				ps.setInt(8, emp.getZip());
				
				ps.executeUpdate();
				rs = ps.getGeneratedKeys();
				
				if(rs.next()){
					emp.setId(rs.getInt(1));
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new AppException("Error :" +e.getMessage(),e.getCause());
			}
			 
			 finally{
				 
				 
				 DBConnector.closeResources(ps, rs, con); 
				 }
		 
			return emp; 
		 }
}
