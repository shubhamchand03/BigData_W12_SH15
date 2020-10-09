package general;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class ques3 {
	
	private static String driverClass = "org.apache.hive.jdbc.HiveDriver";

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		try {
			Class.forName(driverClass);
		} catch (ClassNotFoundException exception) {
			System.out.println(exception.toString());
			System.exit(1);
		}

		Connection con = DriverManager.getConnection(
				"jdbc:hive2://localhost:10000/default", "hive", "");

		Statement statement = con.createStatement();

		String query = "select e.first_name, e.last_name, s.start_date"
				+ " from W12emp e inner join W12emp_salary s on (e.emp_id = s.emp_id)"
				+ " order by s.start_date asc limit 10";

		ResultSet res = null;
		try {
			res = statement.executeQuery(query);
			ResultSetMetaData meta = res.getMetaData();

			int numCols = meta.getColumnCount();

			System.out.println("Top 10 oldest employees:");
			System.out.println("First Name, Last Name, Starting Date");
			while (res.next()) {
				for (int i = 1; i <= numCols; i++) {
					if (i != numCols)
						System.out.print(res.getString(i) + ", ");
					else
						System.out.print(res.getString(i) + "\n");
				}
			}

		} catch (SQLException ex) {
			System.out.println(ex.toString());
		}

		res.close();
		statement.close();
		con.close();
		
	}

}
