<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>설문조사결과</h2>
	<%
	request.setCharacterEncoding("UTF-8");
	
	String name = request.getParameter("name");
	String gender = request.getParameter("gender");
	
	out.println("이름:<b>"+name+"</b><br>");
	out.println("성별 :");
	
	if(gender.equals("남자")){
		out.println("남자");
	}else{
		out.println("여자");
	}
	%>
</body>
</html>