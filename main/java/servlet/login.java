package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import dao.userdao;

@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		boolean check = true;
		try {

			String login = request.getParameter("login");
			String motdepasse = request.getParameter("password");
			
			if(login.length()< 8) {
				check = false;
			}
			if(motdepasse.length()<8) {
				check = false;
			}
			if(check == false) {
				String statusMessage ="echec";
				request.setAttribute("statusMessage", statusMessage);
				request.setAttribute("login", login);
				request.setAttribute("ConnexionFailed", true);

				getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request,response);
			} else {

				HttpSession session = request.getSession();
				User user = userdao.getMedecinBylogin(login, motdepasse);
				
				if(user != null ) {
					session.setMaxInactiveInterval(3000);
	                session.setAttribute("user", login);
	                
	                if(user.getRole().equals("ADMIN")) {
	                	response.sendRedirect("Admin");
	                } else if (user.getRole().equals("SUPPORT")) {
						response.sendRedirect("Support");
	                } else if(user.getRole().equals("USER")) {
	                	response.sendRedirect("User");
	                }
				}
				
			}	
			
	 }catch(Exception e) {
		 
	 }
	}

}
