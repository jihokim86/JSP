

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%@page import = "java.sql.Connection" %>
    <%@page import = "javax.sql.DataSource" %>
    <%@page import="javax.naming.InitialContext"%>
    <%@page import="javax.naming.Context"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h4>디비 연동</h4>
<%
	Context initContext = new InitialContext();
	Context envContext = (Context)initContext.lookup("java:/comp/env");
	DataSource ds = (DataSource)envContext.lookup("jdbc/oracle");
	Connection conn = ds.getConnection();
	out.println("DBCP 연동 성공");
%>
</body>
</html>