package com.saeyan.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.saeyan.dao.MemberDAO;
import com.saeyan.dto.MemberVO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      String url = "member/login.jsp";
      
      HttpSession session = request.getSession();
      
      if(session.getAttribute("loginUser")!= null) {
         url = "main.jsp";
      }
      
      RequestDispatcher dispatcher = request.getRequestDispatcher(url);
      dispatcher.forward(request, response);
   }
   

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      String url = "member/login.jsp";
      
      String userid = request.getParameter("userid");
      String pwd = request.getParameter("pwd");
      
      MemberDAO mDao = MemberDAO.getInstance();
      int result = mDao.userCheck(userid, pwd);
      
      if(result == 1) {
         MemberVO mVo = mDao.getMember(userid);
         HttpSession session = request.getSession();
         session.setAttribute("loginUser", mVo);
         request.setAttribute("message", "ȸ�����Կ� �����߽��ϴ�.");
         url="main.jsp";
      }else if(result == 0) {
         request.setAttribute("message", "��й�ȣ�� ���� �ʽ��ϴ�.");
      }else if(result == -1) {
         request.setAttribute("message", "�������� �ʴ� ȸ���Դϴ�.");
      }
      
      RequestDispatcher dispatcher = request.getRequestDispatcher(url);
      dispatcher.forward(request, response);
   }
}