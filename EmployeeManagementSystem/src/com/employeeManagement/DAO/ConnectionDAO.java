package com.employeeManagement.DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.spi.RootLogger;



public class ConnectionDAO {
	static Connection con;
	static Logger logger=RootLogger.getLogger(ConnectionDAO.class.getName());
	static Connection connection; 
	public static Connection openConnection() {
		final String driverName = "oracle.jdbc.driver.OracleDriver";
		final String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String username = "system";
		String password = "system";
		PropertyConfigurator.configure("log4j.properties");
		try {
			Class.forName(driverName);
			con = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		return con;
	}

	public static void closeConnection() {

		try {
			if (con != null)
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
	}
}
