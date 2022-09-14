package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc {

	public static void main(String[] args) throws SQLException {
		Connection con = null;

		try {
			// connect to database
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eebookshop", "root", "Behappy@1325");

			System.out.println(" dataBASE conneted ");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select *from books");
			while (rs.next()) {
				System.out.println("Id:" + rs.getString(1) + "   Tittle :" + rs.getString(2) + "   Author: "
						+ rs.getString(3) + "   Price: " + rs.getString(4) + " Qty: " + rs.getString(5));
			}

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error Connecting database");
		} finally {
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}

	}

}
