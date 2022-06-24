<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="now" class="java.util.Date"></jsp:useBean>

<pre>
default : <c:out value="${now}"></c:out>
Korea KST : <fmt:formatDate value="${now}" type="both"
			dateStyle="full" timeStyle="full"/>	

<fmt:timeZone value="GMT">
Swiss GMT : <fmt:formatDate value="${now}" type="both"
			dateStyle="full" timeStyle="full"/>	
</fmt:timeZone>

<fmt:timeZone value="GMT-8">
NewYork GMT-8 : <fmt:formatDate value="${now}" type="both"
			dateStyle="full" timeStyle="full"/>	
</fmt:timeZone>
</pre>
</body>
</html>