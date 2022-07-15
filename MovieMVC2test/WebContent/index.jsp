<%@page import="vo.MemberVO"%>
<%@page import="vo.MovieVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%@ include file="/header.jsp" %>

<%
	MemberVO id = (MemberVO) request.getAttribute("Auser");

	if (id != null) {
		out.print("<script>swal('Success', '" + id.getId() + "님 로그인 되었습니다.', 'success').then((val) => {location.href = '/movieList.do';});</script>");
		session.setAttribute("user", id);
	}else {
		response.sendRedirect("/movieList.do");
	}
%>