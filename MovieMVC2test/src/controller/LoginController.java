package controller;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDAO;
import vo.MemberVO;

public class LoginController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp)
			throws ServerException, IOException, ServletException {
		// 파라미터 추출
		String userId = req.getParameter("userId");
		String userPW = req.getParameter("userPW");

		// 유효성 체크
		if (userId.isEmpty() || userPW.isEmpty()) {
			req.setAttribute("error", "모든 항목을 빠짐없이 입력해주시기 바랍니다.");
			req.getRequestDispatcher("/view/login.jsp").forward(req, resp);
			return;
		}
		
		//DB 연동
		MemberDAO instance = MemberDAO.getInstance();
		MemberVO vo = instance.memberLogin(userId, userPW);
		
		if(vo.getId() != null) {
			req.setAttribute("Auser", vo);
			req.getRequestDispatcher("/").forward(req, resp);
		}else {
			req.setAttribute("error", "아이디 또는 비밀번호가 올바르지 않습니다.");
			req.getRequestDispatcher("/view/login.jsp").forward(req, resp);
		}
	}

}
