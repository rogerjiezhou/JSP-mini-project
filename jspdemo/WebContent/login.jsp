<head>
<%!
	String str = "Good Morning";
%>
</head>
<body>
<h2>This is my JSP <%= str.toUpperCase() %></h2>


<%
	
	out.println("Hello world! " + str);
%>
</body>