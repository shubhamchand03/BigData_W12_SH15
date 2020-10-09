package general;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ques1 {
	
	private static String driverClass = "org.apache.hive.jdbc.HiveDriver";

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		try {
			Class.forName(driverClass);
		} catch (ClassNotFoundException e) {
			System.out.println(e.toString());
			System.exit(1);
		}
		
		Connection con = DriverManager.getConnection(
				"jdbc:hive2://localhost:10000/default", "hive", "");
		Statement statement = con.createStatement();

		String createEmp = "create table W12emp ("
				+ "emp_id int, birthday string, first_name string, last_name string, gender string, work_day string"
				+ ")" + " row format delimited" + " fields terminated by ','";

		try {
			statement.execute(createEmp);
			System.out.println("Employee Table is created successfully");
		} catch (SQLException ex) {
			System.out.println(ex.toString());
		}

		String createSalary = "create table W12emp_salary ("
				+ "emp_id int, salary string, start_date string, end_date string"
				+ ")" + " row format delimited" + " fields terminated by ','";

		try {
			statement.execute(createSalary);
			System.out.println("Employee_Salary Table is created successfully");
		} catch (SQLException ex) {
			System.out.println(ex.toString());
		}

		statement.close();
		con.close();

	}

}
