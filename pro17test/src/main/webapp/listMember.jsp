<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% request.setCharacterEncoding("UTF-8"); %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"  />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보출력창</title>
</head>
<body>
	<h1>회원 정보</h1>
	<form method="post" action="mem.do">
		<table border=1>
			<tr>
				<td>아이디</td>
				<td>비밀번호</td>
				<td>이름</td>
				<td>이메일</td>
				<td>가입일</td>
			</tr>
			<c:choose>
			
				<c:when test="${memberslist == null }" >
					<tr>
						<td colspan="5">등록된 회원이 없습니다.</td>
					</tr>
				</c:when>
				
				<c:when test="${memberslist != null}">
					<c:forEach var="mem" items="${memberslist }">
						<tr>
							<td>${mem.id}</td>
							<td>${mem.pwd}</td>
							<td>${mem.name}</td>
							<td>${mem.email}</td>
							<td>${mem.joinDate}</td>
						</tr>
					</c:forEach>
				</c:when>
				
			</c:choose>
			<tr>
				<td align="center" colspan="5">
					<input type="submit" value="회원가입하기" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>