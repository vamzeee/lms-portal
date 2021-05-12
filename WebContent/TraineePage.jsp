
<%@ page import="java.io.*,java.util.*"%>
 <%@ page import="com.Model.Course"%>
<%@ page isELIgnored="false"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
            
            
            
            <h1>All Courses </h1>
            <div>
				<table border="1">
                    <thead>
                        <tr>
                        	<th>Course ID</th>
                            <th>Course Name</th>
                            <th>Course Trainer</th>
                            <th>Course Pre-Requisite</th>
                            <th>Course Duration</th>
                            <th>Start Date</th>
                            <th>End Date</th>
                            <th>Timing</th>
                            <th>Course Link</th>
                             
                        </tr>
                    </thead>
              		
              		<tbody>
              		
              	
              	<% 
              		List<Course> list = (List)request.getAttribute("courses4"); 
              		for (Course u : list) { 
                    %>                  
					<tr>
      					<td><%=u.getCourseID()%></td>
   						<td><%=u.getCourseName()%></td>
   						<td><%=u.getCourseTrainer()%></td>
   						<td><%=u.getPreRequisite()%></td>
   						<td><%=u.getDuration()%></td>
				    	<td><%=u.getStartDate()%></td>
   						<td><%=u.getEndDate()%></td>
   						<td><%=u.getTimings()%></td>
				    	<td><%=u.getUrl()%></td>
				    <td><a href="CourseServlet?id=<%=u.getCourseID()%>">Enroll</a></td>
					</tr>		                 
				<% 
				} 
			%> 
			</tbody>
                </table>
            </div>   
          
</body>
</html>