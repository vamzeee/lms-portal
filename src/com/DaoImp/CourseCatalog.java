package com.DaoImp;

import com.Model.*;
import com.DAO.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class CourseCatalog implements CourseInterface{
	DBConnector db = new DBConnector();
	
	private boolean isPresent(Course e) {
		int temp = 0;
		try {
			PreparedStatement ps = db.getConnection().prepareStatement("Select * from CourseCatalog where CourseID = ?");
			ps.setInt(1, e.getCourseID());
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
	public String addCourse(Course e) {
		int rows = 0;
		if(!isPresent(e)) {
			try {
				PreparedStatement ps = db.getConnection().prepareStatement
						("insert into CourseCatalog values (?,?,?,?,?,?,?,?,?)");
				ps.setInt(1, e.getCourseID());
				ps.setString(2, e.getCourseName());
				ps.setInt(3, e.getCourseTrainer());
				ps.setInt(4, e.getPreRequisite());
				ps.setInt(5, e.getDuration());
				ps.setString(6, e.getStartDate().toString());
				ps.setString(7, e.getEndDate().toString());
				ps.setString(8, e.getTimings());
				ps.setString(9, e.getUrl());
				rows = ps.executeUpdate();
				db.closeConnection();
			}catch(SQLException ex) {ex.printStackTrace();}
			return ("Course added");
		}
		else
			return ("This Course already exists");
	}

	@Override
	public String deleteCourse(Course e) {
		int rows = 0;
		if(isPresent(e)) {
			try {
				PreparedStatement ps = db.getConnection().prepareStatement
						("delete from CourseCatalog where courseID = ? ");
				ps.setInt(1, e.getCourseID());
				rows = ps.executeUpdate();
				db.closeConnection();
			}catch(SQLException ex) {ex.printStackTrace();}
			return("Course removed");
		}
		else
			return ("This course doesn't exist");
	}
	
	@Override
	public String deleteCourse(int empID, Course e) {
		int rows = 0;
		if(isPresent(e)) {
			try {
				PreparedStatement ps = db.getConnection().prepareStatement
						("delete from CourseCatalog where CourseID = ? and courseTrainer = ? ");
				ps.setInt(1, e.getCourseID());
				ps.setInt(2, empID);
				rows = ps.executeUpdate();
				db.closeConnection();
			}catch(SQLException ex) {ex.printStackTrace();}
			return("Course removed");
		}
		else
			return ("This course doesn't exist/You dont have access to delete this course");
	}

	//INCOMPLETE
	@Override
	public String updateCourse(Course e) {
		if(isPresent(e)) {
			try {
				PreparedStatement ps = db.getConnection().prepareStatement
						("update CourseCatalog set courseName = ?,courseTrainer = ?,");
				//consider the null values		
			}catch(SQLException ex) {ex.printStackTrace();}
		}
		return ("Course updated");
	}
	
	@Override
	public String updateCourse(int empID, Course e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Course> showCourses() {
		List<Course> list = new ArrayList<>();
		try {
			PreparedStatement ps = db.getConnection().prepareStatement
					("select * from CourseCatalog");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Course e = new Course();
				e.setCourseID(rs.getInt(1));
				e.setCourseName(rs.getString(2));
				e.setCourseTrainer(rs.getInt(3));
				e.setPreRequisite(rs.getInt(4));
				e.setDuration(rs.getInt(5));
				e.setStartDate(LocalDate.parse(rs.getString(6)));
				e.setEndDate(LocalDate.parse(rs.getString(7)));
				e.setTimings(rs.getString(8));
				e.setUrl(rs.getString(9));
				list.add(e);
			}
		}catch(SQLException ex) {ex.printStackTrace();}
		return list;
	}

	//showCourses can be called with the employeeID of the logged in employee to access all the courses in which he is a trainer
	

	@Override
	public List<Course> searchCourseName(String courseN) {
		List<Course> list = new ArrayList<>();
		try {
			PreparedStatement ps = db.getConnection().prepareStatement
					("select * from CourseCatalog where courseName = ?");
			ps.setString(1, courseN);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Course e = new Course();
				e.setCourseID(rs.getInt(1));
				e.setCourseName(rs.getString(2));
				e.setCourseTrainer(rs.getInt(3));
				e.setPreRequisite(rs.getInt(4));
				e.setDuration(rs.getInt(5));
				e.setStartDate(LocalDate.parse(rs.getString(6)));
				e.setEndDate(LocalDate.parse(rs.getString(7)));
				e.setTimings(rs.getString(8));
				e.setUrl(rs.getString(9));
				list.add(e);
			}
		}catch(SQLException ex) {ex.printStackTrace();}
		return list;
	}
	@Override
	public List<Course> searchTrainerName(String trainerN) {
		List<Course> list = new ArrayList<>();
		try{
			PreparedStatement ps = db.getConnection().prepareStatement
					("select * from CourseCatalog cou, employee emp WHERE emp.employeeName =? AND emp.employeeId=cou.courseTrainer");
	       	ps.setString(1,trainerN);
		    ResultSet rs = ps.executeQuery();		   
			while(rs.next()) {
				
				Course e = new Course();
				e.setCourseID(rs.getInt(1));
				e.setCourseName(rs.getString(2));
				e.setCourseTrainer(rs.getInt(3));
				e.setPreRequisite(rs.getInt(4));
				e.setDuration(rs.getInt(5));
				e.setStartDate(LocalDate.parse(rs.getString(6)));
				e.setEndDate(LocalDate.parse(rs.getString(7)));
				e.setTimings(rs.getString(8));
				e.setUrl(rs.getString(9));
				list.add(e);
			}
		}catch(SQLException ex) {ex.printStackTrace();}
		return list;
	}
	@Override
	public List<Course> searchDateRange(String startD,String endD) {
		List<Course> list = new ArrayList<>();
		try{
			PreparedStatement ps = db.getConnection().prepareStatement
					("select * from CourseCatalog where startDate BETWEEN ? AND ? ORDER BY startDate");
	       	ps.setString(1,startD);
	    	ps.setString(2,endD);
		    ResultSet rs = ps.executeQuery();		   
			while(rs.next()) {
								
				Course e = new Course();
				e.setCourseID(rs.getInt(1));
				e.setCourseName(rs.getString(2));
				e.setCourseTrainer(rs.getInt(3));
				e.setPreRequisite(rs.getInt(4));
				e.setDuration(rs.getInt(5));
				e.setStartDate(LocalDate.parse(rs.getString(6)));
				e.setEndDate(LocalDate.parse(rs.getString(7)));
				e.setTimings(rs.getString(8));
				e.setUrl(rs.getString(9));
				list.add(e);
			}
		} catch(SQLException ex) {ex.printStackTrace();}
		return list;
		}

}
