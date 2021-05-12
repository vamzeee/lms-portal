package com.DaoImp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.DAO.LoginInterface;

public class LoginImplementation implements LoginInterface {
	int r = 0;
	DBConnector db = new DBConnector();
	@Override
	public boolean validate(int empId, String pass) {
		boolean status = false;
	    ResultSet rs = null;
		try {	
				PreparedStatement cs = db.getConnection().prepareStatement
						("Select * from Employee where EmployeeId=? and EmployeePassword=?");
		       	cs.setInt(1,empId);
		    	cs.setString(2,pass);
		        rs = cs.executeQuery();
	            status = rs.next();
		    	db.closeConnection();
		    }catch(SQLException e) {System.out.println(e);}
		return status;
	}
	@Override
	public boolean isAdmin(int empId) {
		boolean status1 = false;
	    ResultSet rs = null;
		try {	
				PreparedStatement cs = db.getConnection().prepareStatement
						("Select * from Employee where EmployeeId=? and isAdmin=true");
				cs.setInt(1,empId);
		        rs = cs.executeQuery();
	            status1 = rs.next();
		    	db.closeConnection();
		    }catch(SQLException e) {System.out.println(e);}
		return status1;
	}

}
