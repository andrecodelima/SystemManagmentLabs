package br.com.maven.systemlabs.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Db {

	// Criando a conexão com o Banco
	public static Connection conect() {
		
		Connection conn = null;
		
		// Parametros para a conexão
		final String usr 	= "root";
		final String pass	= "1234567";
		final String host	= "localhost";
		
		final String url	= "jdbc:mysql://" + host + ":" + "/clinicamedica?verifyServerCertificate=false&useSSL=true"; 
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url,usr,pass);
//			System.out.print("Conectado!");
			
		}catch (Exception e) {
			System.err.print(e);
			System.err.print("Falha na conexão");
		}
		
		return conn;
	}
	
	// Desconectando
	public static void Disconnect(Connection conn) throws SQLException {
		
		conn.close();
	}
	
}
