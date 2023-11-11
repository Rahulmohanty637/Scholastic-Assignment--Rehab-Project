package Registration;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import Model.Model;
/**
 * Servlet implementation class Registration_controller
 */
@MultipartConfig
public class Registration_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registration_controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String u_name = request.getParameter("username");
		String password = request.getParameter("password");
		String mail = request.getParameter("email");
		String first_name = request.getParameter("firstName");
		String last_name = request.getParameter("lastName");
		String role = request.getParameter("role");
		String qualification = request.getParameter("qualifications");
		String specialization =  request.getParameter("specializations");
		String phone = request.getParameter("pnone_no.");
		String medichistory = request.getParameter("medichistory");
		String filename = request.getParameter("document");
		
		System.out.print(filename);
		
		Model model = new Model(u_name, password, mail, first_name, last_name, role, qualification, specialization, phone, medichistory, filename);
		Registeration_Dao dao = new Registeration_Dao();
		String result ="not";
		try {
			result = dao.insert(model);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrintWriter out = response.getWriter();
		out.print(result);
		response.sendRedirect("Login.jsp");
		
	}

}
