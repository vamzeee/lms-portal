<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">
	<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
	<script src="https://code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
	<script>
$( function() {
$( "#datepicker" ).datepicker({ changeMonth: true, changeYear: true });
$( "#datepicker" ).datepicker( "option", "dateFormat", "yy-mm-dd" );
} );
	</script>
	<script>
$( function() {
$( "#datepicker1" ).datepicker({ changeMonth: true, changeYear: true });
$( "#datepicker1" ).datepicker( "option", "dateFormat", "yy-mm-dd" );
} );
	</script>
    </head> 	
    <body>  
   <h1 align="center">Hi I Am Admin  <%=session.getAttribute("name") %></h1> 
        <h1>Course Information </h1>
        <form name="searchCourse" action="SearchServlet" method="post">
            <div>
                <table border="1">
                    <thead>
                        <tr>
                        	<th style="alignment-adjust: auto">Course Name </th>
                        	<td><input type="text" name="courseN"  size="20" /></td>
                        </tr>
                        <tr>
                        	<th>Trainer Name :</th>
                        	<td><input type="text" name="trainerN" size="20" /></td>
                        </tr>
                        <tr>
                        	<th>Start Date :</th>
                        	<td><input type="text" name="start" id="datepicker" size="20" /></td>
                        </tr>
          				<tr>
                        	<th>End Date :</th>
                        	<td><input type="text" name="end" id="datepicker1" size="20" /></td>
                        </tr>
                        <tr>
                       		<td colspan="3" >
                    		<center> <input type="submit" value="GetData" /> </center>
                        </td>
                        </tr>
                    </thead>
                </table>
        	</div>
    	</form>
 <form action="AdminServlet" method="post">
 

 <input type="submit" value="Show All Courses" />
 
 
 </form>
</body>
</html>