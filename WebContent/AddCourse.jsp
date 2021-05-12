<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
<div class="main">

		<form action="AddServlet" method="post" name="myform">
	
			<center>
				<h1>Add Course</h1>
			</center>
		
		
			
			<table>	
		       <tr>
					<td>CourseID</td>
					<td><input type="text" name="id"></td>
				</tr>
		
				<tr>
					<td>CourseName</td>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<td>CourseTrainer</td>
					<td><input type="text" name="trainer"></td>
				</tr>	
				<tr>
					<td>Pre-Requisite</td>
					<td><input type="text" name="pr"></td>
				</tr>
				<tr>
					<td>Duration</td>
					<td><input type="text" name="dur"></td>
				</tr>		
				<tr>
					<td>StartDate</td>
					<td><input type="text" name="sd" id="datepicker"></td>
				</tr>
				<tr>
					<td>EndDate</td>
					<td><input type="text" name="ed" id="datepicker1"></td>
				</tr>
				<tr>
					<td>Timing</td>
					<td><input type="text" name="time"></td>
				</tr>
				<tr>
					<td>URL</td>
					<td><input type="text" name="url"></td>
				</tr>				
				<tr>
					<td><input type="submit"  value="Add"></td>	
				</tr>
				
			</table>
			
				
				
		</form>
		
		</div>


</body>
</html>