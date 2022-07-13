<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@page import = "java.sql.Connection" %>
    <%@page import = "com.saeyan.dao.ProductDAO" %>
    <%@page import = "util.DBManager" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
/* ProductDAO proDao = ProductDAO.getInstance();
Connection conn = proDao.getConnection(); */

Connection conn = DBManager.getConnection();
out.println("DBCP 연동 성공");
%>
</body>
</html>