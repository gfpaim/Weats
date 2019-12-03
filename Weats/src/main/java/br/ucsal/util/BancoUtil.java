package br.ucsal.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class BancoUtil {
	
	private static Connection connection;
	
	static {
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/weats", "postgres", "postegresql");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		return connection;
	}

}