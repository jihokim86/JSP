package memberController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import memberDAO.MemberDAO;

/* 1단계
 * doHandle()함수를 만들어서~ doget / dopost 어떤 방식으로 접근하든 동작하게 만든다.
 * 1. forword방식으로 보내야하므로 dispatcher가 필요하다.
 * 2. 어디로 포워딩할지 dispatcher에 기록해야하므로 url주소가 필요하다.
 * 3. 무엇을 포워딩할껀데? DAO에서 리스트를 저장한 함수를 호출하여 setAttri를 통해 저장한다.
 * 4. DAO에 접근하기 위해 객체를 생성해야겠지!!
 * 
 * */

/* 2단계
 * command패턴?의 활용
 * controller(servlet) 1개만으로 다양한 jsp로 이동시키기 위한 방법
 * 어떻게 해야할까? 회원리스트창에서 회원가입 버튼을 누렀을 경우 해당 url로 이동하게 만든다.
 * url중에서 servlet 접근 명령어?(xx.do)만을 추출하여 포워딩 시킨다.
 * 추출하는 함수는 getPathInfo()
 * */
@WebServlet("/mem.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String url = "/listMember.jsp";
		MemberDAO memberDAO = new MemberDAO();
		request.setAttribute("memberslist", memberDAO.listMember());
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
