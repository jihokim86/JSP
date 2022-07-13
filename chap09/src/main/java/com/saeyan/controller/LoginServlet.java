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
      
      if(session.getAttribute("loginUser")!= null) { //�α��� �� Ȩ������(index)���� ��ũŸ�� �ٽ� �����ϸ� main ������ �̵���
         url = "main.jsp";
      }
      
      RequestDispatcher dispatcher = request.getRequestDispatcher(url); //("�̵��� ������ ����")
      dispatcher.forward(request, response); // p196Ȯ�� forward�� ����Ϸ��� RequestDispatcher�� �����ؾ���.
   }
   

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
	   //���̵� ��� �Է��ϰ� Ȯ�δ����� �������� �̵��Ǿ� ��~~
      String url = "member/login.jsp";					//�̵������� �⺻�� ������ ����~ �Ʒ� if ���ǿ� ���� �̵��������� ������
      													//�α��� ������ main���� �̵��ϰ� �α��� ���н� �α���â���� �̵�
      String userid = request.getParameter("userid");	//���̵� textâ�� �Է°�(�Ķ����)�� get�ؼ� userid�� ����
      String pwd = request.getParameter("pwd");			//��ȣ textâ�� �Է°�(�Ķ����)�� get�ؼ� pwd�� ����
      
      MemberDAO mDao = MemberDAO.getInstance();			//MemberDAO(�̱���)�� �����ϱ� ���� ��ü�� ������
      //new�����ڸ� ������� ���ϴ� ������ �̱����̱� ������~
      //getInstance()���� �̸� �����س��� MemberDAO�� ������ü�� getInstance�� �����ϵ��� �Ǿ� ����~
      //MemberDAO mDao = getInstance(��������) = new MemberDao() 
      //�ᱹ new�����ڸ� �̸� ����س���(�̱���) getInstance()�� �����ؼ� ��ü�� �����Ͽ� 
      //MemberDAO Ŭ������ �����ϰ� ��~
      //MemberDAO Ŭ������ �����Ϸ����ϴ� ������ userCheck()�Լ��� ����ϱ� ���ؼ��̴�
      //MemberDAO�� ���� ���� ���� �� DB�� ������ �Լ���� VO�� �����Ǿ� �ִ� Ŭ�����̴�.
      
      int result = mDao.userCheck(userid, pwd);	//MemberDAOŬ���� ���� userCheck(�Ű�����,�Ű�����)�Լ��� ȣ���Ͽ�~
      											//result ������ �����Ѵ�.
      //userCheck(userid, pwd) �Լ��� int ������ result ���� 1 , 0 ,-1�� ��ȯ�ϰ� �ȴ�
      //1�� ��� ȸ������ ���� , 0�� ��� ��й�ȣ ���� , -1�� ��� ���̵� ���� ��츦 ����.
      if(result == 1) {
         MemberVO mVo = mDao.getMember(userid);
         //MemberDAO�� getMember()�Լ��� ȣ���Ͽ���! ������ ����? �α��ο� ���������� �ʿ��� �ɼ��� �����ϱ�?
         //getMember()�� "select * from member where userid =?"�� ���� userid�� ���� �Ӽ��� �����ϰ�
         //�� ������ mVo.setName(rs.getString("name"));�� �̿��� �Ӽ������� mVo�� �� �����Ѵ�.
         //return�� MemberDAOŸ���� mVo�� ��ȯ�ϹǷ�  MemberVO mVo = MemberDAO instence�� �ȴ�.
         //���������� ���Ƶ� �������ɱ�?? Ÿ���� �޶� ������?? �����!!
         //MemberVOŸ���� �������� mVo���� MemberVO�� �Ӽ��� MemberDAO�� �Ӽ��� ������ �ȴ�.
         //ó������ ���ƿͼ�~ userid�� ���� �Ӽ������� �� ������ ���ϱ�?
         //�� �����Ѱ�����??
         //session�� ���� �������� ���ؼ��̴�!
         //�̴� �α����Ŀ� Ȩ�������� �ٽ� �����ص� �α����� �����ϱ� �����̴�.
         
         HttpSession session = request.getSession();
         //���� ��ü�� ������!!
         session.setAttribute("loginUser", mVo);
         //���ǿ� ���� �����Ѵ�!
         //forward�� �������� �̵��� ���̹Ƿ�~ setAttribute�� ����Ѵ�!
         //setAttribute(�Ӽ��̸�, �Ӽ���);
         //loginUser�Ӽ��̸��� ���µ� �Ӽ����� mVo�̴�...
         //�Ӽ����� �迭�̶�� �����ϸ�Ƿ���?
         //String[] loginUser ={name,userid,pwd,email,phone,admin}; 
         //�׷��� ��� �Ӽ����� �� �����ؾߵǳ�??? �̰� ���Ǹ� �غ��߰ڴ�.
         //main���� �ȳ��ϼ���. ${loginUser.name}(${loginUser.userid})�� �� �ִ°ź���~ �ϴ� �� �Ѱܳ��� 
         //�ʿ��Ѱ��� ������ ����Ҽ��ֳ���~ EL���ڴ� �� ������?
         //�����̷�Ʈ ������� �����Ϸ���~ response.sendRedirect("�̵������� loginUser="+mvo)�̷�������� �Ĵܿ� �ڵ��ؾ��Ѵ�.
         request.setAttribute("message", "�α��ο� �����߽��ϴ�.");
         //message �Ӽ� �̸���  ȸ�����Կ� �����ߴٴ� ���� ����.
         //main�������� �̵��ϰ� �Ǹ� form�ϴܿ� message��µ� ����
         url="main.jsp"; //ȸ�������� ����������� url�� �����!
      }else if(result == 0) {
         request.setAttribute("message", "��й�ȣ�� ���� �ʽ��ϴ�.");
      }else if(result == -1) {
         request.setAttribute("message", "�������� �ʴ� ȸ���Դϴ�.");
      }
      //forward�� �����ϱ� ���� RequestDispatcher Ŭ������ �ʿ���~~~
      //�ش� url�� ������ �̵���!
      RequestDispatcher dispatcher = request.getRequestDispatcher(url);
      dispatcher.forward(request, response);
   }
}