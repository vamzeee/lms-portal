package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DaoImp.CourseCatalog;
import com.Model.Course;


@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public AddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		PrintWriter pw=response.getWriter();
		String s1=request.getParameter("id");
		int id=Integer.parseInt(s1);
		String s2=request.getParameter("name");
		String s3=request.getParameter("trainer");
		int train=Integer.parseInt(s3);
		String s4=request.getParameter("pr");
		int pre=Integer.parseInt(s4);
		String s5=request.getParameter("dur");
		int dur=Integer.parseInt(s5);
		String s6=request.getParameter("sd");
		String s7=request.getParameter("ed");
		String s8=request.getParameter("time");
		String s9=request.getParameter("url");
		
		Course e= new Course();
		e.setCourseID(id);
		e.setCourseName(s2);
		e.setCourseTrainer(train);
		e.setPreRequisite(pre);
		e.setDuration(dur);
		e.setStartDate(LocalDate.parse(s6));
		e.setEndDate(LocalDate.parse(s7));
		e.setTimings(s8);
		e.setUrl(s9);
		CourseCatalog c1=new CourseCatalog();
		  String str= c1.addCourse(e);
		
		  pw.println(str);
		  RequestDispatcher rd =request.getServletContext().getRequestDispatcher("/AdminServlet");
			rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
