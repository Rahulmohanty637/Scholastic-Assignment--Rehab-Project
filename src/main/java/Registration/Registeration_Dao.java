package Registration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Model.Model;

public class Registeration_Dao {

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

	public String insert(Model model) throws ClassNotFoundException, SQLException{
		// TODO Auto-generated method stub
		loadDriver();
		Connection con = getConnection();
		
		String res = "Schema Updated Successfully";
		String role = model.getRole();
		System.out.print(role);
		if (role.length() > 7) {
			try {
				String q1 = "INSERT INTO counselors (first_name, last_name, email, phone_number, qualifications, specializations) values(?, ?, ?, ?, ?, ?)";
				PreparedStatement pstmt = con.prepareStatement(q1);
				pstmt.setString(1, model.getFirst_name());
				pstmt.setString(2, model.getLast_name());
				pstmt.setString(3, model.getMail());
				pstmt.setString(4, model.getPhone());
				pstmt.setString(5, model.getQualification());
				pstmt.setString(6, model.getSpecialization());
				pstmt.executeUpdate();
				
				String q2 = "INSERT INTO users (username, password, email, first_name, last_name, role) values(?, ?, ?, ?, ?, ?)";
				PreparedStatement pstmt1 = con.prepareStatement(q2);
				pstmt1.setString(1, model.getU_name());
				pstmt1.setString(2, model.getPassword());
				pstmt1.setString(3, model.getMail());
				pstmt1.setString(4, model.getFirst_name());
				pstmt1.setString(5, model.getLast_name());
				pstmt1.setString(6, model.getRole());
				pstmt1.executeUpdate();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		} else {
			try {
				String q = "INSERT INTO users (username, password, email, first_name, last_name, role) values(?, ?, ?, ?, ?, ?)";
				PreparedStatement pstmt1 = con.prepareStatement(q);
				pstmt1.setString(1, model.getU_name());
				pstmt1.setString(2, model.getPassword());
				pstmt1.setString(3, model.getMail());
				pstmt1.setString(4, model.getFirst_name());
				pstmt1.setString(5, model.getLast_name());
				pstmt1.setString(6, model.getRole());
				pstmt1.executeUpdate();
				
				String q1 = "select user_id from users WHERE username = ?";
				PreparedStatement pstmt2 = con.prepareStatement(q1);
				pstmt2.setString(1, model.getU_name());
				ResultSet set = pstmt2.executeQuery();
				int num = 0;
				while (set.next()) {
		            num = set.getInt("user_id");
		            System.out.print(num);
		           
		        }
				
				String q2 = "INSERT INTO Patients (user_id, medical_history) values(?, ?)";
				PreparedStatement pstmt3 = con.prepareStatement(q2);
				pstmt3.setLong(1, num);
				pstmt3.setString(2, model.getMedichistory());
				pstmt3.executeUpdate();
				
				String q3 = "INSERT INTO Documents (user_id, document_name, document_type) values(?, ?, ?)";
				PreparedStatement pstmt4 = con.prepareStatement(q3);
				String type = "pdf";
				pstmt4.setLong(1, num);
				pstmt4.setString(2, model.getFilename());
				pstmt4.setString(3, type);
				pstmt4.executeUpdate();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}

		return res;
}
}
