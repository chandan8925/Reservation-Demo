  package rest.controller;

import java.util.List;




import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import rest.AppResponse;
import model.Employee;
import Dao.EmpDao;
import Exceptions.AppException;

  @Path("/emp")
public class EmpController {
	  @GET
	  @Path("/all")
	  @Produces(MediaType.APPLICATION_JSON)
	  
	public AppResponse getAll(){
		  
		  AppResponse res = new AppResponse();
		 
		try {
			EmpDao dao = new EmpDao();
			List<Employee> empList = dao.getAllEmployee();
			res.setPayload(empList);
			
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			res.setStatus(AppResponse.Error);
			res.setMessage(e.getMessage());
		}
		  
		  return res;
		
	}
	  @GET
	  @Path("get/{id}")
	  @Produces(MediaType.APPLICATION_JSON)
	public AppResponse getEmployee(@PathParam("id") int empId){
		  AppResponse res = new AppResponse();
			 
			try {
				EmpDao dao = new EmpDao();
				Employee emp = dao.getEmployee(empId);
				res.setPayload(emp);
				
			} catch (AppException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				res.setStatus(AppResponse.Error);
				res.setMessage(e.getMessage());
			}
			  
			  return res;
			
		  
	}
	@POST 
	 @Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public AppResponse addEmployee(Employee emp){
		AppResponse res = new AppResponse();
		try {
			EmpDao dao = new EmpDao();
			emp = dao.addEmployee(emp);
			res.setPayload(emp);
			
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			res.setStatus(AppResponse.Error);
			res.setMessage(e.getMessage());
		}
		
		  return res;
		

		
	}
	

}
