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
import com.Model.Course;

@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public AdminServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		PrintWriter pw=response.getWriter();
		CourseCatalog search= new CourseCatalog();
		List<Course> list3=search.showCourses();
		request.setAttribute("courses3", list3);
        RequestDispatcher rd =request.getServletContext().getRequestDispatcher("/AdminLogin.jsp");
     	rd.forward(request, response);
	
     	
		
      	int id=Integer.parseInt(request.getParameter("id"));
		Course c1=new Course();
		c1.setCourseID(id);
		String s1=search.deleteCourse(c1);
		pw.println(s1);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
