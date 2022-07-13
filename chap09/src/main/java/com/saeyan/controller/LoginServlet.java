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
      
      if(session.getAttribute("loginUser")!= null) { //로그인 후 홈페이지(index)에서 링크타고 다시 접속하면 main 폼으로 이동됨
         url = "main.jsp";
      }
      
      RequestDispatcher dispatcher = request.getRequestDispatcher(url); //("이동할 페이지 지정")
      dispatcher.forward(request, response); // p196확인 forward를 사용하려면 RequestDispatcher로 접근해야함.
   }
   

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
	   //아이디 비번 입력하고 확인누르면 이쪽으로 이동되어 옴~~
      String url = "member/login.jsp";					//이동페이지 기본값 저장해 놓음~ 아래 if 조건에 따라 이동페이지가 결정됨
      													//로그인 성공시 main으로 이동하고 로그인 실패시 로그인창으로 이동
      String userid = request.getParameter("userid");	//아이디 text창에 입력값(파라미터)를 get해서 userid에 저장
      String pwd = request.getParameter("pwd");			//암호 text창에 입력값(파라미터)를 get해서 pwd에 저장
      
      MemberDAO mDao = MemberDAO.getInstance();			//MemberDAO(싱글톤)에 접근하기 위해 객체를 생성함
      //new연산자를 사용하지 못하는 이유는 싱글톤이기 때문에~
      //getInstance()에서 미리 생성해놓은 MemberDAO의 참조객체명 getInstance를 리턴하도록 되어 있음~
      //MemberDAO mDao = getInstance(참조변수) = new MemberDao() 
      //결국 new연사자를 미리 사용해놓고(싱글톤) getInstance()로 접근해서 객체를 생성하여 
      //MemberDAO 클래스에 접근하고 함~
      //MemberDAO 클래스에 접근하려고하는 이유는 userCheck()함수를 사용하기 위해서이다
      //MemberDAO는 삽입 수정 삭제 등 DB와 연관된 함수들과 VO와 연관되어 있는 클래스이다.
      
      int result = mDao.userCheck(userid, pwd);	//MemberDAO클래스 내의 userCheck(매개변수,매개변수)함수를 호출하여~
      											//result 변수에 저장한다.
      //userCheck(userid, pwd) 함수는 int 형으로 result 값을 1 , 0 ,-1를 반환하게 된다
      //1일 경우 회원인증 성공 , 0일 경우 비밀번호 오류 , -1일 경우 아이디가 없는 경우를 말함.
      if(result == 1) {
         MemberVO mVo = mDao.getMember(userid);
         //MemberDAO의 getMember()함수를 호출하였다! 이유는 뭘까? 로그인에 성공했을시 필요한 옵션이 무엇일까?
         //getMember()는 "select * from member where userid =?"에 따라 userid를 가진 속성을 나열하고
         //그 값들을 mVo.setName(rs.getString("name"));을 이용해 속성값들을 mVo에 다 저장한다.
         //return은 MemberDAO타입의 mVo로 반환하므로  MemberVO mVo = MemberDAO instence가 된다.
         //참조변수가 같아도 괜찮은걸까?? 타입이 달라서 괜찮나?? 물어보자!!
         //MemberVO타입의 참조변수 mVo에는 MemberVO의 속성과 MemberDAO의 속성을 가지게 된다.
         //처음으로 돌아와서~ userid에 대한 속성값들을 왜 저장한 것일까?
         //왜 저장한것이지??
         //session에 값을 저장히기 위해서이다!
         //이는 로그인후에 홈페이지에 다시 접속해도 로그인을 유지하기 위함이다.
         
         HttpSession session = request.getSession();
         //세션 객체를 생성함!!
         session.setAttribute("loginUser", mVo);
         //세션에 값을 저장한다!
         //forward로 페이지를 이동하 것이므로~ setAttribute를 사용한다!
         //setAttribute(속성이름, 속성값);
         //loginUser속성이름을 갖는데 속성값이 mVo이다...
         //속성값은 배열이라고 생각하면되려나?
         //String[] loginUser ={name,userid,pwd,email,phone,admin}; 
         //그런데 모든 속성값을 다 저장해야되나??? 이건 문의를 해봐야겠다.
         //main문에 안녕하세요. ${loginUser.name}(${loginUser.userid})님 이 있는거보니~ 일단 다 넘겨놓고 
         //필요한것을 가져다 사용할수있나봄~ EL문자는 왜 쓴거지?
         //리다이렉트 방식으로 전송하려면~ response.sendRedirect("이동페이지 loginUser="+mvo)이런방식으로 후단에 코딩해야한다.
         request.setAttribute("message", "로그인에 성공했습니다.");
         //message 속성 이름에  회원가입에 성공했다는 값을 저장.
         //main페이지로 이동하게 되면 form하단에 message출력될 예정
         url="main.jsp"; //회원인증에 성공했을경우 url이 변경됨!
      }else if(result == 0) {
         request.setAttribute("message", "비밀번호가 맞지 않습니다.");
      }else if(result == -1) {
         request.setAttribute("message", "존재하지 않는 회원입니다.");
      }
      //forward로 전송하기 위해 RequestDispatcher 클래스가 필요함~~~
      //해당 url로 페이지 이동함!
      RequestDispatcher dispatcher = request.getRequestDispatcher(url);
      dispatcher.forward(request, response);
   }
}