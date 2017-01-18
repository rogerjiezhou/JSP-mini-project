<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JSP Mini project</title>


</head>
<body>
<jsp:useBean id="obj" class="com.demo.dao.UserDAO" />
<table class="table table-bordered table-striped table-hover" id="userTable">
<tr class="warning">
	<th>Username</th>
	<th>Password</th>
</tr>
<%
	out.print(obj.listUser());
%>

<tr>
	<td>
		<img src="images/add.png" onclick="addUser()"/>
	</td>
</tr>
</table>
<script data-require="jquery@*" data-semver="3.1.1" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.js"></script>
<script src="script/viewScript.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</body>
</html>