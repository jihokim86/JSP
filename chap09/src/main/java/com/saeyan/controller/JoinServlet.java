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
 * Servlet implementation class JoinServlet
 */
@WebServlet("/join.do")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("member/join.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("utf-8");
		
		String name = request.getParameter("name");
		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String admin = request.getParameter("admin");
		
		 MemberVO mVo = new MemberVO();
         mVo.setName(name);
         mVo.setUserid(userid);
         mVo.setPwd(pwd);
         mVo.setEmail(email);
         mVo.setPhone(phone);
         mVo.setAdmin(Integer.parseInt(admin));
         
         MemberDAO mDao = MemberDAO.getInstance();
         int result = mDao.insertMember(mVo);
         
         HttpSession session = request.getSession();
         
         if(result ==1) {
        	 session.setAttribute("userid", mVo.getUserid());
        	 request.setAttribute("message", "ȸ�����Կ� �����߽��ϴ�.");
         }else {
        	 request.setAttribute("message", "ȸ�����Կ� �����߽��ϴ�.");
         }
         
         RequestDispatcher dispatcher = request.getRequestDispatcher("member/login.jsp");
         dispatcher.forward(request, response);
	}
}
