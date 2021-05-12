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
import com.Model.Employee;


@WebServlet("/MyCourseServlet")
public class MyCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public MyCourseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw=response.getWriter();
		EmployeeCatalog search= new EmployeeCatalog();
		
	
		int n1=(int) request.getSession().getAttribute("id");
		
		List<Course> list4=search.showMyCourses(n1);
		request.setAttribute("courses4", list4);
		 RequestDispatcher rd1 =request.getServletContext().getRequestDispatcher("/MyCoursePage.jsp");
	      	rd1.forward(request, response);
	      	
	      	int id=Integer.parseInt(request.getParameter("id"));
			Course c1=new Course();
			c1.setCourseID(id);
			String s1=search.removeCourse(n1, c1);
			pw.println(s1);
			
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
