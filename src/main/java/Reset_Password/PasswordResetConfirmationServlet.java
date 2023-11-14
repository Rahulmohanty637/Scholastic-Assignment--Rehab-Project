package Reset_Password;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Servlet implementation class PasswordResetConfirmationServlet
 */
public class PasswordResetConfirmationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String url = "jdbc:mysql://localhost:3306/rehab";
	private String userName = "root";
	private String password = "JSR#3306monty";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PasswordResetConfirmationServlet() {
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
		 String usernameOrEmail = request.getParameter("usernameOrEmail");
		 String newPassword = request.getParameter("newPassword");
	              
	     String done = resetUserPassword(usernameOrEmail, newPassword);
	            
	     // Redirect to a success page
	     if(done != null) {
	    	 response.sendRedirect("Login.jsp");
	     }else {
	    	 response.sendRedirect("ResetPasswordRequest.jsp");
	     }
	           
	}
	
	public void loadDriver() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, userName, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	private String resetUserPassword(String usernameOrEmail, String newPassword) {
		// TODO Auto-generated method stub
		loadDriver();
		Connection con = getConnection();
		
		String found = "yes";
		
		try {
			String q2 = "UPDATE users SET password= ? WHERE email= ?";
			PreparedStatement pstmt3 = con.prepareStatement(q2);
			pstmt3.setString(1, newPassword);
			pstmt3.setString(2, usernameOrEmail);
			pstmt3.executeUpdate();
			return found;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}


}
