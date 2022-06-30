

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%@page import = "java.sql.Connection" %> 
    <%@page import = "javax.sql.DataSource" %>
    <%@page import="javax.naming.InitialContext"%>
    <%@page import="javax.naming.Context"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h4>디비 연동</h4>

   //<%@page import = "java.sql.Connection" %> // Connection 데이터베이스 연결과 관련된 인터페이스 
   // <%@page import = "javax.sql.DataSource" %>
   // <%@page import="javax.naming.InitialContext"%>
   // <%@page import="javax.naming.Context"%>
<%
	Context initContext = new InitialContext();								// Context 어떤 객체를 핸들링하기 위한 접근 수단 정도로만 알아두자.
	//웹 어플리케이션이 처음 배치될때 설정되고, 모든 설정된 엔트리와자원은 JNDI namespace의 java:comp/env부분에 놓이게 됨.
	//JNDI:Java Naming and Directory Interface)는 네이밍 서비스로 부터 제공하는 자원(데이터 및 객체)를 찾아 참고(lookup)하기 위한 자바 API입니다.
	Context envContext = (Context)initContext.lookup("java:/comp/env");
	//자바 웹 응용프로그램에서는 JDNI의 "lookup()"를 통해 리소스에 접근하고 데이터베이스 커넥션을 가져와 이용합니다.
	//lookup()을 통해 "java:/comp/0env"에 해당하는 객체를 찾아서 enContext에 저장
	DataSource ds = (DataSource)envContext.lookup("jdbc/oracle");
	//lookup()을 통해 "jdbc/oracle"에 해당하는 객체를 찾아서 ds에 저장
	Connection conn = ds.getConnection();
	//getConnection메서드를 이용해서 커넥션 풀로 부터 커넥션 객체를 얻어내어 conn변수에 저장
	out.println("DBCP 연동 성공");
	
	/*
     * 위의 코드를 아래와 같이 줄여서 작성 가능하다.
     Context context = new InitialContext();
     DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
     Connection conn = dataSource.getConnection(); 
     
     */
%>
</body>
</html>