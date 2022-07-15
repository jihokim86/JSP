<%@page import="vo.MovieVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%@ include file="../header.jsp" %>

<%
	ArrayList<MovieVO> list = new ArrayList<MovieVO>();

	if(request.getAttribute("movieList") == null) {
		response.sendRedirect("movieList.do");
	}else {
		list = (ArrayList) request.getAttribute("movieList");
	}
%>

<div class="ui container">
    <div class="visual">
        <img src="./images/logo.jpg" alt="visualImg">
    </div>

    <div class="main">
        <h2>전체 영화 목록</h2>

        <div class="MovieList">
            <div class="ui link cards unit">
            <%
				for (MovieVO vo : list) {
					String cat = "";
					
					switch (vo.getCategory()) {
						case 1 :
							cat = "액션";
							break;
						case 2 :
							cat = "로맨스";
							break;
						case 3 :
							cat = "코미디";
							break;
						case 4 :
							cat = "스릴러";
							break;
						case 5 :
							cat = "애니메이션";
							break;
					}
			%>
                <div class="card" onclick="location.href = '/movieInfo.do?movieNo=<%=vo.getMovieNo()%>';">
                    <div class="image">
                        <img src="/images/<%=vo.getImg()%>">
                    </div>

                    <div class="content">
                        <div class="header"><%=vo.getMovieName() %></div>

                        <div class="meta">
                            <span class="date"><%=cat %></span>
                        </div>

                        <div class="description">
                        	<%=vo.getInfo() %>
                        </div>
                    </div>

                    <div class="extra content">
                        <span class="right floated">
                       	<%=vo.getRuntime() %>분
                        </span>

                        <span>
                            <i class="user icon"></i>
                            No: <%=vo.getMovieNo() %>
                        </span>
                    </div>
                </div>
            <% } %>
            </div>
        </div>
    </div>
</div>

<%@ include file="../footer.jsp" %>