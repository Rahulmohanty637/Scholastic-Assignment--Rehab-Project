package Login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.Result;
import com.mysql.cj.xdevapi.Statement;

import Model.CounselorModel;
import Model.PatientModel;

public class LoginDao {
	private String url = "jdbc:mysql://localhost:3306/rehab";
	private String userName = "root";
	private String password = "JSR#3306monty";
	Connection con = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	public void loadDriver() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		try {
			con = DriverManager.getConnection(url, userName, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public boolean isValidUser(String username2, String password2, String role2) {
		// TODO Auto-generated method stub
		try {
			loadDriver();
			Connection con = getConnection();
			String sqlQuery = "SELECT role FROM Users WHERE username = ? AND password = ?";
			preparedStatement = con.prepareStatement(sqlQuery);

			// Set the parameters (username and password)
			preparedStatement.setString(1, username2);
			preparedStatement.setString(2, password2);

			// Execute the query
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				// Retrieve and print the role
				String role = resultSet.getString("role");
				System.out.println("Role: " + role);
				if (role.length() == role2.length()) {
					return true;
				}
			} else {
				System.out.println("User not found or invalid credentials.");
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} 
		return false;
	}

	public PatientModel getPatientData(String username2) {
		// TODO Auto-generated method stub
		
		try {
			loadDriver();
			Connection con = getConnection();
			
			
			String sqlQuery = "SELECT * FROM Users WHERE username = ?";
			preparedStatement = con.prepareStatement(sqlQuery);
			preparedStatement.setString(1, username2);
			ResultSet Set1 = preparedStatement.executeQuery();
			
			String id = null;	
			String fname = null;
			String lname = null;
			String email = null;
			
			while (Set1.next()) {
		       
				id = Set1.getString("user_id");
				fname = Set1.getString("first_name");
				lname = Set1.getString("last_name");
				email = Set1.getString("email");
		        
		    }
			System.out.println(fname);
			System.out.println(lname);
			System.out.println(email);
			
			
			String sqlQuery1 = "SELECT medical_history FROM Patients WHERE user_id = ?";
			preparedStatement = con.prepareStatement(sqlQuery1);
			preparedStatement.setString(1, id);
			ResultSet Set2 = preparedStatement.executeQuery();
			String medichistory = null;
			if(Set2.next()) {
			medichistory = Set2.getString("medical_history");
			}
			
			PatientModel patient = new PatientModel(fname, email, medichistory);
			
			return patient;
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	public CounselorModel getCounselorData(String username2) {
		// TODO Auto-generated method stub
		
		try {
			loadDriver();
			Connection con = getConnection();
			
			String sqlQuery = "SELECT email FROM users WHERE username = ?";
			preparedStatement = con.prepareStatement(sqlQuery);
			preparedStatement.setString(1, username2);
			ResultSet sett = preparedStatement.executeQuery();
			
			String email = null;
			if(sett.next()) {
				email = sett.getString("email");
			}
			
			String sqlQuery1 = "SELECT * FROM counselors WHERE email = ?";
			preparedStatement = con.prepareStatement(sqlQuery1);
			preparedStatement.setString(1, email);
			ResultSet sett1 = preparedStatement.executeQuery();

			String fname = null;
			String qualifications = null;
			String specializations = null;
			
			if(sett1.next()) {
				fname = sett1.getString("first_name");
				qualifications = sett1.getString("qualifications");
				specializations = sett1.getString("specializations"); 
			}
			
			CounselorModel counselor = new CounselorModel(fname, email, qualifications, specializations);
			
			return counselor;
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return null;
	}
}
