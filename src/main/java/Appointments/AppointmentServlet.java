package Appointments;

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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Appointment;
import Model.Program;

/**
 * Servlet implementation class AppointmentServlet
 */
public class AppointmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String url = "jdbc:mysql://localhost:3306/rehab";
	private String userName = "root";
	private String password = "JSR#3306monty";

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

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AppointmentServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String counselorId = request.getParameter("consumerid");
		List<Appointment> appointment = getAllAppointments(counselorId);
		request.setAttribute("appointment", appointment);
		request.getRequestDispatcher("AppointmentTable.jsp").forward(request, response);
	}

	private List<Appointment> getAllAppointments(String counselorId) {
		// TODO Auto-generated method stub
		loadDriver();
		Connection con = getConnection();
		List<Appointment> appointment = new ArrayList<>();

		try {

			String SELECT_BOOKED_APPOINTMENTS = "select * from Appointments where counselor_id = ?";
			PreparedStatement preparedStatement2 = con.prepareStatement(SELECT_BOOKED_APPOINTMENTS);
			preparedStatement2.setString(1, counselorId);
			ResultSet resultSet2 = preparedStatement2.executeQuery();
			String appointment_id = null;
			String patient_id = null;
			String date = null;
			String time = null;
			String duration = null;
			String status = null;

			while (resultSet2.next()) {
				appointment_id = resultSet2.getString("appointment_id");
				patient_id = resultSet2.getString("patient_id");
				date = resultSet2.getString("date");
				time = resultSet2.getString("time");
				duration = resultSet2.getString("duration");
				status = resultSet2.getString("status");
				System.out.println(status);
				
				
				String GET_PATIENT_ID = "select user_id from Patients where patient_id = ?";
				PreparedStatement preparedStatement = con.prepareStatement(GET_PATIENT_ID);
				preparedStatement.setString(1, patient_id);
				ResultSet resultSet = preparedStatement.executeQuery();
				String uid = null;
				if(resultSet.next()) {
				uid = resultSet.getString("user_id");
				}
				
				String GET_PATIENT_NAME = "select username from users where user_id = ?";
				PreparedStatement preparedStatement1 = con.prepareStatement(GET_PATIENT_NAME);
				preparedStatement1.setString(1, uid);
				ResultSet resultSet1 = preparedStatement1.executeQuery();
				String patient_name = null;
				if(resultSet1.next()) {
				patient_name = resultSet1.getString("username");
				}
				Appointment appointed = new Appointment(appointment_id, counselorId, patient_name, date, time, duration, status);
				appointment.add(appointed);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			// Handle the exception appropriately, e.g., logging or showing an error message
		}
		return appointment;
	}

}
