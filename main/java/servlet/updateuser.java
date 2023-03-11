package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.userdao;
import model.User;

/**
 * Servlet implementation class updateuser
 */
@WebServlet("/updateuser")
public class updateuser extends HttpServlet {
	private static final long serialVersionUID = 1L;
     

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sid = request.getParameter("id");
		
		if(sid != null && sid.matches("[0-9]+")) {
			int id = Integer.parseInt(sid);
			User user = userdao.getbyid(id);
			
			if(user != null) {
				 request.setAttribute("user", user);
				 getServletContext().getRequestDispatcher("/WEB-INF/admin/update.jsp").forward(request,response);
				return;
			}
		}
		response.sendRedirect("Admin");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);
		String email =request.getParameter("email");
		String motdepasse = request.getParameter("motdepasse");
		String role = request.getParameter("role");
		
		User user = new User();
		user.setIduser(id);
		user.setEmail(email);
		user.setPassword(motdepasse);
		user.setRole(role);
		
		userdao.updateUser(user);
		response.sendRedirect("Admin");
	}

}
