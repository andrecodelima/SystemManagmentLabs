package br.com.maven.systemlabs.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import br.com.maven.systemlabs.model.Users;

public class AcessoServices {
	
	public static boolean insertUser(Users user) {
		
		Connection conn = Db.conect();
		
		try {
			
			String sql = "INSERT INTO users (usuario, senha) VALUES(?, ?)";
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setString(1, user.getUsuario());
			st.setString(2, user.getSenha());
			
			st.execute();
//     		System.out.println("Cadastro realizado");
     		
     		st.close();
			Db.Disconnect(conn);
			
			return true;
			
		}catch (Exception e) {
			System.out.println("Falha no cadastro" + e);
 
		}
		
		
		return false;
	}
	
	 
	 public static ArrayList<Users> getAllUsers(){
		 
		 Connection conn = Db.conect();
		 
		 try {
			 
			 String sql = "SELECT * FROM users";
			 
			 Statement st = conn.createStatement();
			 ResultSet result = st.executeQuery(sql);
			 
			 ArrayList<Users> lista = new ArrayList<Users>();
			 
			 while(result.next()) {
				 lista.add(new Users(result.getInt("id"),
						 			result.getString("usuario"),
						 			result.getString("senha")
						 			)
						 );
			 }
			 
			 st.close();
			 Db.Disconnect(conn);
			 return lista;
			 
		 }catch (Exception e) { 
				System.err.println("Erro na conexão");

 		}
		 
		 return null;
	 }
	 
	 
	 public static Users getUsuario(String user) {
		 
		 Connection conn = Db.conect();
		 Users users = new Users();
		 
		 try {
			 
			 String sql = "SELECT * FROM users WHERE usuario = \"" + user + "\"";
			 
			 Statement st 		= conn.createStatement();
			 ResultSet result  = st.executeQuery(sql);
			 
			 
			 while(result.next()) {
				 
				 users = new Users (
						 			result.getInt("id"),
						 			result.getString("usuario"),
						 			result.getString("senha")
						 		);
			 }
			 			 
		 }catch (Exception e) {
				System.err.println(e);

		}
		 
		return users;
		 
	 }
}

