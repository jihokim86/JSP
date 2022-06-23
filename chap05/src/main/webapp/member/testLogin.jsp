<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>testLogin</title>
</head>
<body>
	<%
		String id ="cadiablue";
		String pwd = "1234";
		String name = "김씨아저씨";
		
		if(id.equals(request.getParameter("id")) && pwd.equals(request.getParameter("pwd"))){
			session.setAttribute("loginUser", name);
			response.sendRedirect("main.jsp");
		}else{
			response.sendRedirect("loginForm.jsp");
		}
	%>
</body>
</html>