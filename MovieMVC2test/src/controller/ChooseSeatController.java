package controller;

import java.io.IOException;
import java.rmi.ServerException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MovieDAO;
import vo.TicketVO;

public class ChooseSeatController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServerException, IOException, ServletException {
		int schNo = 0;
		
		if (req.getParameter("schNo") != null) {
			schNo = Integer.parseInt(req.getParameter("schNo"));
			
			MovieDAO instance = MovieDAO.getInstance();
			ArrayList<TicketVO> ticketList = instance.ticketList(schNo);

			req.setAttribute("ticketList", ticketList);
			req.setAttribute("schNo", schNo);
			req.getRequestDispatcher("/view/chooseSeat.jsp").forward(req, resp);
		} else {
			String referer = req.getHeader("Referer");
			resp.sendRedirect(referer);
		}
	}

}
