package Reset_Password;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Servlet implementation class PasswordResetServlet
 */
public class PasswordResetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final SecureRandom secureRandom = new SecureRandom();
	

	private String url = "jdbc:mysql://localhost:3306/rehab";
	private String userName = "root";
	private String password = "JSR#3306monty";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PasswordResetServlet() {
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
        String resetToken = generateResetToken();
        
        String userEmail = getUserEmail(usernameOrEmail); 
        if (userEmail != null) {
        	// Redirect to a confirmation page
            response.sendRedirect("Login.jsp");
        }else {
        	PrintWriter out = response.getWriter();
    		out.print("User not found");
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

	private String getUserEmail(String usernameOrEmail) {
		// TODO Auto-generated method stub
		loadDriver();
		Connection con = getConnection();
		
		String found = "yes";
		
		try {
			String q2 = "select password from users WHERE email = ?";
			PreparedStatement pstmt3 = con.prepareStatement(q2);
			pstmt3.setString(1, usernameOrEmail);
			ResultSet set2 = pstmt3.executeQuery();
			
		    if (set2.next()) {
				return found;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return null;
	}

	public static String generateResetToken() {
        byte[] tokenBytes = new byte[32]; // 256 bits
        secureRandom.nextBytes(tokenBytes);

        // Convert the random bytes to a hexadecimal string
        String token = new BigInteger(1, tokenBytes).toString(16);

        return token;
    }

}
