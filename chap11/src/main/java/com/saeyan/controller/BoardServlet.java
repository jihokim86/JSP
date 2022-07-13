package com.saeyan.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BoardServlet")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command");
		System.out.println("BoardServlet에서 요청 받음을 확인 : " + command);
		//이번 장에 controller는 "요청 파라미터"로 원하는 작업을 위한 명령을 전달하는 방식을 택함
		//ex) BoardServlet?command=board_list
		//퀘리 스트링 방식 , 커맨드패턴 = 특정 이름(command)에 명령어 정보를 담아서 전달하여 각 명령어에 따른 로직을 처리하는 코드를 별로의 클래스로 작성하는 것
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
