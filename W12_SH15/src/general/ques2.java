package general;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ques2 {
	
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

		// Loading data from CSV file into table
		String loadEmp = "load data local inpath '/home/cloudera/Downloads/W12employee.csv' overwrite into table W12emp";
		try {
			statement.execute(loadEmp);
			System.out.println("Data is loaded into Employee Table");
		} catch (SQLException e) {
			System.out.println(e.toString());
		}

		String loadSalary = "load data local inpath '/home/cloudera/Downloads/W12salary.csv' overwrite into table W12emp_salary";
		try {
			statement.execute(loadSalary);
			System.out.println("Data is loaded into Employee_Salary Table");
		} catch (SQLException e) {
			System.out.println(e.toString());
		}

		statement.close();
		con.close();

	}

}
