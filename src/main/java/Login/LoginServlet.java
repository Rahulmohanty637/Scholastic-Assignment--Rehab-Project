package Login;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import Model.CounselorModel;
import Model.PatientModel;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        LoginDao dao = new LoginDao();
        if (dao.isValidUser(username, password, role)) {
            
            if(role.length() < 9) {
            	
            	PatientModel patient = dao.getPatientData(username);
        		HttpSession session = request.getSession();
                session.setAttribute("patientName", patient.getName());
                session.setAttribute("patientEmail", patient.getEmail());
                session.setAttribute("medicalHistory", patient.getMedicalHistory());
                 
            	response.sendRedirect("Patient.jsp");
            }else {
            	
            	CounselorModel counselor = dao.getCounselorData(username);
            	 HttpSession session = request.getSession();
                 session.setAttribute("counselorName", counselor.getName());
                 session.setAttribute("counselorEmail", counselor.getEmail());
                 session.setAttribute("qualifications", counselor.getQualifications());
                 session.setAttribute("specializations", counselor.getSpecializations());

                 response.sendRedirect("CounselorDashboard.jsp");
            }

        } else {
            
            response.sendRedirect("Login.jsp");
        }
	}

	

}
