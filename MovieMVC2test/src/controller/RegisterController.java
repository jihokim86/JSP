package controller;

import java.io.IOException;
import java.rmi.ServerException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import vo.MemberVO;

public class RegisterController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp)
			throws ServerException, IOException, ServletException {
		// 파라미터 추출
		String userId = req.getParameter("userId");
		String userPW = req.getParameter("userPW");
		String userRePW = req.getParameter("userRePW");
		String userEmail = req.getParameter("userEmail");
		String userPhone = req.getParameter("userPhone");
		Date userBirth = Date.valueOf(req.getParameter("userBirth"));
		
		//관리자 아이디인 admin 으로 회원가입 제한하기
		if(userId == "admin") {
			req.setAttribute("error", "관리자 아이디인 admin으로는 가입하실 수 없습니다.");
			req.getRequestDispatcher("/view/register.jsp").forward(req, resp);
			return;
		}

		// 유효성 체크
		if (userId.isEmpty() || userPW.isEmpty() || userRePW.isEmpty() || userEmail.isEmpty() || userPhone.isEmpty() || userBirth == null) {
			req.setAttribute("error", "모든 항목을 빠짐없이 입력해주시기 바랍니다.");
			req.getRequestDispatcher("/view/register.jsp").forward(req, resp);
			return;
		}

		// VO객체에 데이터 바인딩
		MemberVO vo = new MemberVO();
		vo.setId(userId);
		vo.setPw(userPW);
		vo.setEmail(userEmail);
		vo.setTel(userPhone);
		vo.setBirth(userBirth);
		
		//DB 연동
		MemberDAO instance = MemberDAO.getInstance();
		int n = instance.memberRegister(vo);
		
		if(n > 0) {
			req.setAttribute("regID", userId);
			req.getRequestDispatcher("/view/register.jsp").forward(req, resp);
		}else {
			req.setAttribute("error", "회원정보 수정 오류입니다. 중복된 회원입니다.");
			req.getRequestDispatcher("/view/register.jsp").forward(req, resp);
		}
	}

}
