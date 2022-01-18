import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Create {

	public static void main(String[] args) {
		String dbURL = "jdbc:mysql://localhost:3306/prac";
		String username = "root";
		String password = "aman";
		
		try (Connection conn = DriverManager.getConnection(dbURL, username, password)) {
			
			String sql = "INSERT INTO STUDENT( STUDENT_NO, STUDENT_NAME ,STUDENT_DOB ,STUDENT_DOJ) VALUES (?, ?, ?, ?)";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, 101);
			statement.setString(2, "Aman");
			statement.setString(3, "2000-06-07");
			statement.setString(4, "2021-06-08");
			
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("A new data was inserted successfully!");
			}

			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}		
	}
}