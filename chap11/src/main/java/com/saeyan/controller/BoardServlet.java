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
		System.out.println("BoardServlet���� ��û ������ Ȯ�� : " + command);
		//�̹� �忡 controller�� "��û �Ķ����"�� ���ϴ� �۾��� ���� ����� �����ϴ� ����� ����
		//ex) BoardServlet?command=board_list
		//���� ��Ʈ�� ��� , Ŀ�ǵ����� = Ư�� �̸�(command)�� ��ɾ� ������ ��Ƽ� �����Ͽ� �� ��ɾ ���� ������ ó���ϴ� �ڵ带 ������ Ŭ������ �ۼ��ϴ� ��
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
