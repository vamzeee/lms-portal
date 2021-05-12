package com.DAO;

import java.util.List;
import com.Model.*;

public interface CourseInterface {
	public String addCourse(Course e); //gotta check time clashes
	public String deleteCourse(Course e); 
	public String deleteCourse(int empID, Course e);
	public String updateCourse(Course e); 
	public String updateCourse(int empID, Course e);
	public List<Course> showCourses();
	public List<Course> searchCourseName(String courseName);
	public List<Course> searchTrainerName(String tname);
	public List<Course> searchDateRange(String startD,String endD);
	// to show all of the employees courses, 
}
