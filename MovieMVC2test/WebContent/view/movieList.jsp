<%@page import="vo.MovieVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%@ include file="../header.jsp" %>

<div class="ui container">
    <div class="visual">
        <img src="./images/logo.jpg" alt="visualImg">
    </div>

    <div class="main">
        <h2>전체 영화 목록</h2>

        <div class="MovieList">
            <div class="ui link cards unit">
            <c:forEach var="list" items="${movieList }">
            
                <div class="card" onclick="">
                    <div class="image">
                        <img src="/images/${list.img }">
                    </div>

                    <div class="content">
                        <div class="header">${list.movieNo }</div>

                        <div class="meta">
                            <span class="date">${list.movieName }</span>
                        </div>

                        <div class="description">
                        	 x
                        </div>
                    </div>

                    <div class="extra content">
                        <span class="right floated">
                       		y
                        </span>

                        <span>
                            <i class="user icon"></i>
                            z
                        </span>
                    </div>
                </div>
                
            </c:forEach>
            
            </div>
        </div>
    </div>
</div>

<%@ include file="../footer.jsp" %>