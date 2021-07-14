package br.fucturaJdbc.JDBCUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConecxaoJDBC {
	
	public static Connection getConexao() {
		Connection conexao = null;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "ganyu";
		String password = "ganyu";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conexao = DriverManager.getConnection(url, user, password);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conexao;
	}
}
