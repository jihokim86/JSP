<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Addition</title>
</head>
<body>
 <%
 	int a =20;
 	int b =10;
 	String str = "20";
 	int c = Integer.parseInt(str);
 	int add = a+b;
 %>
 
 <%=a+b+c%>+<%=b%>=<%=add%><br>
 <%=add=c %><br> 
 <%=add %><br>
 ++++ ---- === 오류는 있는데 실행에 문제는 없네?
 
</body>
</html>