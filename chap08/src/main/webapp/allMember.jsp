<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import = "java.sql.DriverManager" %>
<%@page import = "java.sql.ResultSet" %>
<%@page import = "java.sql.Statement" %>
<%@page import = "java.sql.Connection" %>

<%
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	String url="jdbc:oracle:thin:@localhost:1521:XE";
	String uid="bg";
	String pass = "bg";
	String sql = "select * from member";
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table{
width : 100%;
border : 1px solid black
}
tr,th,td{
border : 1px solid black
}
</style>
</head>
<body>
<table>
<tr>
	<th>이름</th><th>아이디</th><th>암호</th><th>이메일</th>
	<th>전화번호</th><th>권한(1:관리자,0:일반회원)</th>
</tr>
<%
 try{
	 Class.forName("oracle.jdbc.driver.OracleDriver");
	 conn = DriverManager.getConnection(url,uid,pass);
	 stmt = conn.createStatement();
	 rs=stmt.executeQuery(sql);
	 
	 while(rs.next()){
		 out.println("<tr>");
		 out.println("<td>"+rs.getString("name")+"</td>");
		 out.println("<td>"+rs.getString("userid")+"</td>");
		 out.println("<td>"+rs.getString("pwd")+"</td>");
		 out.println("<td>"+rs.getString("email")+"</td>");
		 out.println("<td>"+rs.getString("phone")+"</td>");
		 out.println("<td>"+rs.getString("admin")+"</td>");
		 out.println("</tr>");
	  	 } 
	 }catch(Exception e){
		 e.printStackTrace();
	 }finally{
		 try{
			 if(rs != null) rs.close();
			 if(stmt != null) stmt.close();
			 if(conn != null) conn.close();
		 }catch(Exception e){
			 e.printStackTrace();
		 }
}


%>
</table>

</body>
</html>