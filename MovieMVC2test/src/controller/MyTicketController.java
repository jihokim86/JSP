package controller;

import java.io.IOException;
import java.rmi.ServerException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MovieDAO;
import vo.TicketVO;

public class MyTicketController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServerException, IOException, ServletException {

		String id = req.getParameter("user");
		
		if (id != null) {
			MovieDAO instance = MovieDAO.getInstance();
			ArrayList<TicketVO> myTicket = new ArrayList<TicketVO>();
			
			if(id.equals("admin")) {
				myTicket = instance.ticketAllList();
			}else {
				myTicket = instance.ticketMyList(id);
			}
			
			req.setAttribute("myTicket", myTicket);
			req.getRequestDispatcher("/view/myTickets.jsp").forward(req, resp);	
		}	
		
	}

}
