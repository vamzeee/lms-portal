package com.DAO;

import java.util.List;

import com.Model.*;
public interface EmployeeInterface {
	public String addCourse(int id, Course c); //gotta check time clashes
	public String removeCourse(int id, Course c);
	public List<Course> showMyCourses(int id);
}
