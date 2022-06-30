<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
    
    <!-- LoginServlet에서 forward로 이쪽 페이지로 이동해왔다. -->
    <!-- 넘어올때 session.setAttribute("loginUser", mVo); 저장했으므로 -->
    <!-- empty loginUser는 false일 것이므로 점프하게된다! -->
    <!-- 값이 저장이 안되어 있다면~DB에 값이 없는거겠지~ 회원가입시키기위해 login창으로 이동하게 된다. -->
    <c:if test="${empty loginUser}">  
    <jsp:forward page = 'login.do'/>
    </c:if>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="member.js"></script>
</head>
<body>
<form action="logout.do">	<!-- submit(로그아웃)버튼을 누를 시 LogoutServlet으로 이동하게 된다. -->
	<table>
		<tr>
			<td>
			안녕하세요. ${loginUser.name}(${loginUser.userid})님 <!-- EL문자의 사용 이유가 뭘까? -->
			</td>		
			
			<!-- session.setAttribute("loginUser", mVo);로 저장했으면 ~ session.getAtribute로 불러와야 하지 않나??	 -->
			<!-- p247 -->
			<!-- p328~329 EL 내장객체에 접근하려면 JAVA로는 31줄처럼 코딩을 해야하지만~-->
			<!-- EL문자를 통해 간략하게 내장객체에 접근할수있다~-->
			<!-- {loginUser} EL문자내의 내용은 속성이름을 의미하게된다.-->
		</tr>
		
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="로그아웃"/>&nbsp;&nbsp;
				<input type="button" value="회원정보변경" onclick="location.href='memberUpdate.do?userid=${loginUser.userid}"/>
																<!-- 이 경로는 어떻게 된것일까? -->
			</td>
		</tr>
		<tr><td colspan="2">${message}</td></tr>
	</table>
</form>
</body>
</html>