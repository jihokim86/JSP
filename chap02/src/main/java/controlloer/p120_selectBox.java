package controlloer;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class p120_selectBox
 */
@WebServlet("/p120_selectBox")
public class p120_selectBox extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String job = request.getParameter("job");
		String[] interests = request.getParameterValues("interest");
		
		out.print("<html><body>");
		out.print("����� ������ ���� : ");
		out.print(job);
		out.print("<hr>����� ������ ���� �о� :");
		if(interests == null) {
			out.print("������ �׸��� �����ϴ�.");
		}else {
			for(String interest : interests) {
				out.print(interest);
				out.print(" ");
			}
		}
		out.print("</body></html>");
		
		out.close();
	
	}

}
