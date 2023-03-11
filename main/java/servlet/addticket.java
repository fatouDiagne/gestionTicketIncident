package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ticketdao;
import model.Ticket;

/**
 * Servlet implementation class addticket
 */
@WebServlet("/addticket")
public class addticket extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/user/addticket.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String titre = request.getParameter("titre");
		String description = request.getParameter("description");
		String departement = request.getParameter("departement");
		
			Ticket ticket = null;
			ticket = new Ticket(titre,description,departement);
			ticketdao.insertticket(ticket);
			String statusMessage ="OK";
			request.setAttribute("statusMessage", statusMessage);

			response.sendRedirect("User");

		}


}
