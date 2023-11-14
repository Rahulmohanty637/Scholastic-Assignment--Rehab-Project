package Counselling;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BookingDao {

		private String url = "jdbc:mysql://localhost:3306/rehab";
		private String userName = "root";
		private String password = "JSR#3306monty";
		ResultSet resultSet = null;

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

	public boolean bookSeesion(String sessionDate, String sessionTime, String sessionDuration,
			String selectedCounselor, String patientId) {
		// TODO Auto-generated method stub
		
		loadDriver();
		Connection con = getConnection();
		
		boolean ans = true;
		try {
			String q = "SELECT counselor_id FROM counselors WHERE first_name = ?";
			PreparedStatement pstmt = con.prepareStatement(q);
			pstmt.setString(1, selectedCounselor);
			resultSet = pstmt.executeQuery();
			
			String counselorId = "null";
			if (resultSet.next()) {
				// Retrieve and print the role
				counselorId = resultSet.getString("counselor_id");
			}
			
			
			String q1 = "INSERT INTO Appointments (counselor_id, patient_id, date, time, duration, status) values(?, ?, ?, ?, ?, ?)";
			PreparedStatement pstmt1 = con.prepareStatement(q1);
			pstmt1.setString(1, counselorId);
			pstmt1.setString(2, patientId);
			pstmt1.setString(3, sessionDate);
			pstmt1.setString(4, sessionTime);
			pstmt1.setString(5, sessionDuration);
			pstmt1.setString(6, "Pending");
			pstmt1.executeUpdate();
			
			
			return ans;
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		return false;
	}

}
