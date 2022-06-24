<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table{
 width:100%;
 border : 1px solid black;
 border-collapse : collapse;
}

th,td{
border : 1px solid black;
text-align : center;
}


</style>
</head>
<body>
<c:forEach var="cnt" begin="1" end="10" varStatus="status">
	${cnt} 
	<c:if test="${ not status.last }">,</c:if>
</c:forEach>
<br><br>

<table class="table">
	<tr>
		<th>index</th><th>count</th><th>cnt</th>
	</tr>
	<c:forEach var="cnt" begin="7" end="10" varStatus="status">
		<tr>
		<td>${status.index}</td> <!-- 현재 반복중인 항목 -->
		<td>${status.count}</td> <!-- 몇번째 반복인지 알려주는 -->
		<td>${cnt}</td>
		</tr>
	</c:forEach>
</table>
<br><br>
<table class="table">
	<tr>
		<th>index</th><th>count</th><th>cnt</th>
	</tr>
	<c:forEach var="cnt" begin="1" end="10" step="2" varStatus="status">
		<tr> 
		<td>${status.index}</td> <!-- 현재 반복중인 항목 -->
		<td>${status.count}</td> <!-- 몇번째 반복인지 알려주는 -->
		<td>${cnt}</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>