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
	<%
		String[] movieList ={"타이타닉","시네마천국","혹성탈출","킹콩"};
		pageContext.setAttribute("movieList", movieList);
	%>
	
	
	<table border="1" style="width :100%; text-align=center">
		<tr>
			<th>인덱스</th><th>count</th><th>title</th>
		</tr>
		
		<c:forEach var="movie" items="${movieList}" varStatus="status">
		<tr>
			<td>${status.index}</td>
			<td>${status.count}</td>
			<td>${movie}</td>
		</tr>
		</c:forEach>	
	</table>
</body>
</html>