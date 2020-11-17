<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add User</title>
</head>
<body onload="saveOrNotData();">

	<h2>User CRUD operation</h2>
	<a href="">Show All User</a>
	<hr>
	
	<h3>Add New Student</h3>
	<form:form method="POST" action="../SaveOrUpdate" modelAttribute="user">
		<form:hidden path="id" id="id"/>
		<table>
			<tr>
				<td>First Name</td>
				<td><form:input type="text" path="firstName" id="firstName" /></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><form:input type="text" path="lastName" id="lastName"/></td>
			</tr>
			<tr>
				<td>Email.</td>
				<td><form:input type="email" path="Email" id="Email" /></td>
			</tr>
			<tr>
				<td>D.O.B.</td>
				<td><form:input type="date" path="DOB" id="DOB" value=""/></td>
			</tr>
			<tr>
				<td>User Name</td>
				<td><form:input type="text" path="UserName" id="UserName" value=""/></td>
			</tr>
			<tr>
				<td>
					<form:button type="submit" id="submitBtn" onclick="return checkBlank();">Submit</form:button>
				</td>
			</tr>
		</table>
	</form:form>
	<hr>
	
<script type="text/javascript">

	function checkBlank(){
		var check = true;
		if(document.getElementById("firstName").value == '')
			check = false;
		else if(document.getElementById("lastName").value == '')
			check = false;
		else if(document.getElementById("Email").value == '')
			check = false;
		else if(document.getElementById("DOB").value == '')
			check = false;
		else if(document.getElementById("UserName").value == '')
			check = false;
		
		if(check){
			return true;
		} else {
			alert("Please Fill All the Field.");
			return false;
		}
	}

</script>	
	
</body>
</html>