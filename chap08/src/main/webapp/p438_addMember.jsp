<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import = "java.sql.DriverManager" %>
<%@page import = "java.sql.ResultSet" %>
<%@page import = "java.sql.Statement" %>
<%@page import = "java.sql.Connection" %>
<%@page import = "java.sql.PreparedStatement" %>

<%!
	Connection conn = null;
	PreparedStatement pstmt = null;

	
	String url="jdbc:oracle:thin:@localhost:1521:XE";
	String uid="bg";
	String pass = "bg";
	
	
	String sql = "insert into member values(?,?,?,?,?,?)";

%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");

	String name = request.getParameter("name");
	String userid = request.getParameter("userid");
	String pwd = request.getParameter("pwd");
	String email = request.getParameter("email");
	String phone = request.getParameter("phone");
	String admin = request.getParameter("admin");

	try{
		Class.forName("oracle.jdbc.driver.OracleDriver"); 	//드라이버 로드
		
		conn = DriverManager.getConnection(url,uid,pass); 	//connection 연결 객체 생성
		
		pstmt = conn.prepareStatement(sql);					//prepareStatement 객체 생성
		
		pstmt.setString(1,name);
		pstmt.setString(2,userid);
		pstmt.setString(3,pwd);
		pstmt.setString(4,email);
		pstmt.setString(5,phone);
		pstmt.setInt(6,Integer.parseInt(admin));			//바인딩 변수를 채운다.
		
		pstmt.executeUpdate();								//SQL문을 실행하여 결과 처리
		
		
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		try{
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		}catch(Exception e){
			e.printStackTrace();	
		}
		
	}


%>
<h3>회원가입 성공</h3>
<a href="allMember.jsp">회원 전체 목록 보기</a>

</body>
</html>