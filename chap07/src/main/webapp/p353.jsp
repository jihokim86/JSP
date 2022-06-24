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
<c:set var="msg" value="hello"></c:set>
\${msg}= ${msg} <br>

<c:set var="age">30</c:set>
\${age}= ${age}<hr>


<!-- 객체 생성하기 -->
<c:set var="member" value="<%=new com.saeyan.javaBeans.MemberBean() %>"></c:set>
<c:set target="${member}" property="name" value="전수빈"></c:set>
<c:set target="${member}" property="userid">pinksubin</c:set>
\${member}=${member} <hr>

<c:set var="add" value="${10+5}"></c:set>
\${add} = ${add} <br>
<c:set var="flag" value="${10>5}"></c:set>
\${flag} = ${flag}

</body>
</html>