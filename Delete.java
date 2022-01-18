
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Delete {

	public static void main(String[] args) {
		String dbURL = "jdbc:mysql://localhost:3306/prac";
		String username = "root";
		String password = "aman";
		
		try (Connection conn = DriverManager.getConnection(dbURL, username, password)) {
			
			String sql = "DELETE FROM STUDENT WHERE STUDENT_NO =?";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, "101");
			
			int rowsDeleted = statement.executeUpdate();
			if (rowsDeleted > 0) {
				System.out.println("A Student Data was deleted successfully!");
			}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}		
	}
}
