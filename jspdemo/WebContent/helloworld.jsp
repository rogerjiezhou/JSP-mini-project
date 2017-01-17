<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hello world of Java!</title>

The time on the server is <%= new java.util.Date() %>

String convert <%= new String("haha").toUpperCase() %>
<% 
	for(int i = 0; i <= 5; i++) {
		out.println("<br>Print " + i +"</br>");
	}
%>

<%!
	String lower(String data) {
		return data.toLowerCase();
	}
%>
<h3><%= lower("Smile") %></h3>

</head>
<body>

</body>
</html>