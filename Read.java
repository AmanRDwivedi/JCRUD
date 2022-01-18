import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Read {

	public static void main(String[] args) {
		String dbURL = "jdbc:mysql://localhost:3306/prac";
		String username = "root";
		String password = "aman";
		try (Connection conn = DriverManager.getConnection(dbURL, username, password)) {
			
			String sql = "SELECT * FROM STUDENT";
			
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			
			int count = 0;
			
			while (result.next()){
				String ST_NO = result.getString("STUDENT_NO");
				String ST_NAME = result.getString("STUDENT_NAME");
				String ST_DOB = result.getString("STUDENT_DOB");
				String ST_DOJ = result.getString("STUDENT_DOJ");
				
				String output = "Students Data #%s: %s - %s - %s - %s";
				System.out.println(String.format(output, ++count, ST_NO, ST_NAME ,ST_DOB ,ST_DOJ));
			}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}		
	}
}