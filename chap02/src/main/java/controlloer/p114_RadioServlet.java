package controlloer;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class p114_RadioServlet
 */
@WebServlet("/p114_RadioServlet")
public class p114_RadioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html ; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String gender = request.getParameter("gender");
		String chk_mail= request.getParameter("chk_mail");
		String content = request.getParameter("content");
		
		out.print("<html><body>");
		out.print("당신이 입력한 정보입니다<br>");
		out.print("--------------------------<br>");
		out.print("성별 : "); out.print(gender);
		out.print("<br>메일정보 수신 여부 : "); out.print(chk_mail);
		out.print("<br>가입인사 :"); out.print(content);
		out.print("<br><a href='javascript:history.go(-1)'>다시</a>");
		out.print("</body></html>");
		out.close();
	}

}
