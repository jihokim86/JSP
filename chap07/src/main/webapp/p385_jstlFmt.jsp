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
<pre>
<c:set var="now" value="<%=new java.util.Date() %>"></c:set>
\${now} : ${now}
date : <fmt:formatDate value="${now}" type="date"/>
time : <fmt:formatDate value="${now}" type="time"/>
both : <fmt:formatDate value="${now}" type="both"/>

default : <fmt:formatDate value="${now}" type="both"
			dateStyle="default" timeStyle="default"/>
			
short : <fmt:formatDate value="${now}" type="both"
			dateStyle="short" timeStyle="short"/>
			
medium : <fmt:formatDate value="${now}" type="both"
			dateStyle="medium" timeStyle="medium"/>
			
long : <fmt:formatDate value="${now}" type="both"
			dateStyle="long" timeStyle="long"/>	
			
full : <fmt:formatDate value="${now}" type="both"
			dateStyle="full" timeStyle="full"/>	
			
pattern="yyyy년 MM월 dd일 hh시 mm분 ss초" :
		<fmt:formatDate value="${now}" type="both"
			pattern="yyyy년 MM월 dd일 hh시 mm분 ss초"/>	
</pre>

</body>
</html>