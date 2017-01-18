<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<jsp:useBean id="obj" class="com.demo.dao.UserDAO" />

<% 
	String username = request.getParameter("username");
	String pwd = request.getParameter("password");
	int id = Integer.parseInt(request.getParameter("id"));
	
	obj.updateUser(id, username, pwd);
	response.sendRedirect("view.jsp");
%>

</body>
</html>