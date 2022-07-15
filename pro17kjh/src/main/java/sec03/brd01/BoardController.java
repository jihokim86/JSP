package sec03.brd01;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/board/*")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	/* 접근 url에서 servlet접근주소를 추출한다.(/board/* , * 부분을 추출)
	 * 추출된 경로를 null값과 비교하여 해당 블록을 실행시킨다.
	 * command 패턴??
	 */
	
	/* Service클래스가 추가되어~ 
	 * DAO에 함수를 사용하기 위해서는 Service -> DAO로 접근해야한다.
	 * */
	
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String action = request.getPathInfo(); // 경로 추출
		System.out.println("action:" + action);
		
		String nextPage;
		
		BoardService boardService = new BoardService();
		
		
		try {
			if(action == null) {
				request.setAttribute("articlesList", boardService.listArticles());
				nextPage = "/board01/listArticles.jsp";
			}else if(action.equals("/listArticles.do")) {
				request.setAttribute("articlesList", boardService.listArticles());
				nextPage = "/board01/listArticles.jsp";
			}
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(nextPage);
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}

}
