package com.DaoImp;

import com.Model.*;
import com.DAO.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class EmployeeCatalog implements EmployeeInterface{
	DBConnector db = new DBConnector();
	
	private boolean isPresent(int id, Course c) {
		int temp = 0;
		try {
			PreparedStatement ps = db.getConnection().prepareStatement("Select * from Enrollment where EmployeeID = ? and CourseID = ?");
			ps.setInt(1, id);
			ps.setInt(2, c.getCourseID());
			ResultSet rs = ps.executeQuery();
			if(rs.next())
				temp++;
		}catch(SQLException ex) {ex.printStackTrace();}
		if(temp == 0)
			return false;
		else
			return true;
	}

	@Override
	public String addCourse(int id, Course c) {
		int rows = 0;
		if(!isPresent(id,c)) {
			try {
				PreparedStatement ps = db.getConnection().prepareStatement("Insert into Enrollment values (?,?)");
				ps.setInt(2, id);
				ps.setInt(1, c.getCourseID());
				rows = ps.executeUpdate();
			}catch(SQLException ex) {ex.printStackTrace();}
			return "Course added";
		}
		else
			return "You've already registered for this course";
	}

	@Override
	public String removeCourse(int id, Course c) {
		int rows = 0;
		if(isPresent(id,c)) {
			try {
				PreparedStatement ps = db.getConnection().prepareStatement("Delete from Enrollment where EmployeeID = ? and CourseID = ?");
				ps.setInt(1, id);
				ps.setInt(2, c.getCourseID());
				rows = ps.executeUpdate();
			}catch(SQLException ex) {ex.printStackTrace();}
			return "Course deleted";
		}
		else
			return "You've never registered for this course";
	}

	@Override
	public List<Course> showMyCourses(int id) {
		int rows = 0;
		List<Course> list = new ArrayList<>();
		try {PreparedStatement ps = db.getConnection().prepareStatement("Select * from coursecatalog where courseID IN(select courseID from Enrollment where employeeID=?)");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Course c = new Course();
			c.setCourseID(rs.getInt(1));
			c.setCourseName(rs.getString(2));
			c.setCourseTrainer(rs.getInt(3));
			c.setPreRequisite(rs.getInt(4));
			c.setDuration(rs.getInt(5));
			c.setStartDate(LocalDate.parse(rs.getString(6)));
			c.setEndDate(LocalDate.parse(rs.getString(7)));
			c.setTimings(rs.getString(8));
			c.setUrl(rs.getString(9));
			list.add(c);
		}
	}catch(SQLException ex) {ex.printStackTrace();}
		return list;
	}
}
