package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ticketdao;
import model.Ticket;

/**
 * Servlet implementation class enattente
 */
@WebServlet("/enattente")
public class enattente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sid = request.getParameter("id");
		
		if(sid!= null && sid.matches("[0-9]+")) {
			int id = Integer.parseInt(sid);
			Ticket ticket = ticketdao.getbyid(id);
			
			if(ticket != null) {
				 ticketdao.attente(id);

				response.sendRedirect("Support");
				return;
			}
		}
		response.sendRedirect("Support");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
