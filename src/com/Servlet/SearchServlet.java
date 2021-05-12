package com.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DaoImp.CourseCatalog;
import com.Model.Course;

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
//		PrintWriter out= response.getWriter();
		
		String cname=request.getParameter("courseN");
		String tname=request.getParameter("trainerN");
		String st=request.getParameter("start");
		String en=request.getParameter("end");				

		CourseCatalog search= new CourseCatalog();
		
		List<Course> list=search.searchDateRange(st,en);
		List<Course> list1=search.searchCourseName(cname);
		List<Course> list2=search.searchTrainerName(tname);
		
		request.setAttribute("courses", list);
		request.setAttribute("courses1", list1);
		request.setAttribute("courses2", list2);
		
		RequestDispatcher rd =request.getServletContext().getRequestDispatcher("/SearchResult.jsp");
		rd.forward(request, response);
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
