<%@page import="java.text.SimpleDateFormat"%>
<%@page import="vo.ScheduleVO"%>
<%@page import="vo.MovieVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%@ include file="../header.jsp" %>

<%
	ArrayList<MovieVO> movieGetList = new ArrayList<MovieVO>();
	ArrayList<ScheduleVO> schList = new ArrayList<ScheduleVO>();
	
	if(request.getAttribute("movieGetList") == null) {
		response.sendRedirect("/");
	}else {
		movieGetList = (ArrayList) request.getAttribute("movieGetList");
		schList = (ArrayList) request.getAttribute("scheduleAList");
	}
	
	String cat = "";
	String img = "";
%>

<div class="ui container">
    <div class="visual">
        <img src="/images/logo.jpg" alt="visualImg">
    </div>

    <div class="main">
        <h2>영화 정보</h2>

		<table class="ui inverted violet table movieInfoTable">
			<thead>
				<tr>
					<th>영화 번호</th>
					<th>카테고리</th>
					<th>제목</th>
					<th>영화 정보</th>
				</tr>
			</thead>
			<tbody>
				<%
					for (MovieVO item : movieGetList) {
					img = item.getImg();
					
					switch (item.getCategory()) {
					case 1:
						cat = "액션";
						break;
					case 2:
						cat = "로맨스";
						break;
					case 3:
						cat = "코미디";
						break;
					case 4:
						cat = "스릴러";
						break;
					case 5:
						cat = "애니메이션";
						break;
					}
				%>
				<tr>
					<td>No.<%=item.getMovieNo()%></td>
					<td><%=cat%></td>
					<td><%=item.getMovieName()%></td>
					<td><%=item.getInfo()%></td>
				</tr>
				<% } %>
			</tbody>
		</table>

		<h2>관람 시간 선택</h2>
		<p style="text-align: right;">Tip: 원하는 관람 시간대에 클릭하면 좌석 선택 페이지로 이동됩니다.</p>

		<div class="movieInfoBox">
			<div class="leftBox">
				<img src="/images/<%=img%>" alt="<%=img%>">
			</div>

			<div class="rightBox">
				<table class="ui inverted blue table">
					<thead>
						<tr>
							<th>스케줄 번호</th>
							<th>상영날짜</th>
							<th>상영 시간</th>
							<th>상영관</th>
							<th>잔여석</th>
						</tr>
					</thead>
					<tbody>
						<%
						for (ScheduleVO item : schList) {
							SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 (HH시 mm분)");
							String datetime = sdf.format(item.getRunDay());
						%>
						<tr onclick="location.href = '/chooseSeat.do?schNo=<%=item.getSchNo()%>';">
							<td>No.<%=item.getSchNo() %></td>
							<td><%=datetime %></td>
							<td><%=item.getRuntime() %>분</td>
							<td><%=item.getRoomNo() %>관</td>
							<td><%=25 - item.getSeatCnt() %>석</td>
						</tr>
						<%
							}
						%>
					</tbody>
				</table>
			</div>
		</div>
    </div>
</div>

<%@ include file="../footer.jsp" %>