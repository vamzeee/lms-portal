package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DaoImp.CourseCatalog;
import com.DaoImp.EmployeeCatalog;
import com.Model.Course;


@WebServlet("/CourseServlet")
public class CourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
		CourseCatalog search= new CourseCatalog();
		List<Course> list4=search.showCourses();
		request.setAttribute("courses4", list4);
		 RequestDispatcher rd1 =request.getServletContext().getRequestDispatcher("/TraineePage.jsp");
	      	rd1.forward(request, response);
	      	int n1=(int) request.getSession().getAttribute("id");
			
			EmployeeCatalog search1= new EmployeeCatalog();
	      	
	      	int id=Integer.parseInt(request.getParameter("id"));
			Course c1=new Course();
			c1.setCourseID(id);
			String s1=search1.addCourse(n1, c1);
			pw.println(s1);
	      	
	      	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
