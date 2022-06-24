<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:choose>
	<c:when test="${param.fruit ==1 }">사과</c:when>
	<c:when test="${param.fruit ==2 }">메론</c:when>
	<c:when test="${param.fruit ==3 }">딸기</c:when>
	</c:choose>
</body>
</html>