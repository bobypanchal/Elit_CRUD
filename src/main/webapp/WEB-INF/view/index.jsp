<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<script>
	function saveOrNotData(){
		if(${SaveOrNot eq 'Save'})
			alert('User Data is successfully Added.');
		else if(${SaveOrNot eq 'Delete'})
			alert('User Data is successfully Delete.');
		else if(${SaveOrNot eq 'No'})
			alert('Something Went Wrong.');
	}
	
	function deleteStudent(id){
		if(confirm("Are you sure ?")){
			document.getElementById('hideUserId').value = id;
			document.userList.action = 'Delete';
			document.getElementById("userList").submit();
		}
	}
	
	function editStudent(id){
		document.getElementById('hideUserId').value = id;
		document.userList.action = 'Edit';
		document.getElementById("userList").submit();
	}
	
</script>
</head>
<body onload="saveOrNotData();">

	<h2>User CRUD operation</h2>
	<a href="AddUser">Add New User</a>
	<hr>
	
	<table border="1">
		<tr>
			<th>id</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>userName</th>
			<th>DOB</th>
			<th>Email</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<c:forEach var="user" items="${allUser }">
			<tr>
				<td>${user.getId() }</td>
				<td>${user.getFirstName() }</td>
				<td>${user.getLastName() }</td>
				<td>${user.getUserName() }</td>
				<td>
					<fmt:parseDate pattern="yyyy-MM-dd" value="${user.getDOB() }" var="dob" />
					<fmt:formatDate pattern="dd/MM/yyyy" value = "${dob }" />
				</td>
				<td>${user.getEmail() }</td>
				<td>
					<button onclick="editStudent(${user.getId()});">Edit</button>
				</td>
				<td>
					<button onclick="deleteStudent(${user.getId()});">Delete</button>
				</td>
			</tr>
		</c:forEach>
	</table>
	<form name="userList" method="POST" action="" id="userList">	
		<input type="hidden" name="userId" id="hideUserId" />
	</form>
	
</body>
</html>