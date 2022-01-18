import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Update {

	public static void main(String[] args) {
		String dbURL = "jdbc:mysql://localhost:3306/prac";
		String username = "root";
		String password = "aman";
		
		try (Connection conn = DriverManager.getConnection(dbURL, username, password)) {

			String sql = "UPDATE STUDENT SET STUDENT_NAME =? ,STUDENT_DOB =?,STUDENT_DOJ =?  WHERE STUDENT_NO =?";

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, "Aman");
			statement.setString(2, "2000-08-05");
			statement.setString(3, "2021-05-08");
			statement.setString(4, "101");

			int rowsUpdated = statement.executeUpdate();
			if (rowsUpdated > 0) {
				System.out.println("Student Data was updated successfully!");
			}


		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
} 
