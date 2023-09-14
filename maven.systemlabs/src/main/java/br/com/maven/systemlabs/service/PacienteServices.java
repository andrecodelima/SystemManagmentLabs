package br.com.maven.systemlabs.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import br.com.maven.systemlabs.model.Paciente;

public class PacienteServices {

	//INSERE
	public static boolean insertPaciente(Paciente paciente) {
		
		Connection conn 		= Db.conect();
		LocalDate nascimento	= paciente.getNascimento();
		                            
		try {
			
			String sql = "INSERT INTO pacientes(nome, cpf, nascimento, genero, telefone, email, endereco) VALUES(?,?,?,?,?,?,?)";
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setString(1, paciente.getNome());
			st.setString(2, paciente.getCpf());
			st.setObject(3, nascimento);
			st.setString(4, paciente.getGenero());
			st.setString(5, paciente.getTelefone());
			st.setString(6, paciente.getEmail());
			st.setString(7, paciente.getEndereco());
			
			st.execute();
			System.out.println("Cadastro Realizado");
			
			st.close();
			Db.Disconnect(conn);

			return true;
			
		}catch (Exception e) {
			System.out.println("Falha no cadastro" + e);

		}
		return false;
	}
	
	// SELECT  ALL
	public static ArrayList<Paciente>getAllPacientes(){
		
		Connection conn = Db.conect();
		
		try {
			
			String sql = "SELECT * FROM pacientes";
			
			Statement 	st 		= conn.createStatement();
			ResultSet 	result	= st.executeQuery(sql);
			
			ArrayList<Paciente>lista = new ArrayList<Paciente>();
			
			while(result.next()) {
				
					lista.add(new Paciente(
								result.getInt("id"),
								result.getString("nome"),
								result.getString("cpf"),
								result.getDate("nascimento").toLocalDate(),
								result.getString("genero"),
								result.getString("telefone"),
								result.getString("email"),
								result.getString("endereco")
							)
						);
			}
			
			st.close();
			Db.Disconnect(conn);
			
			return lista;
			
			
		}catch (Exception e) {
			System.err.print("Erro na conexão");
				 
		}
		
		return null;
		
	}
	
	
	// DELETAR
	public static boolean delPaciente(int id) {
		
		Connection conn = Db.conect();
		
		try {
			
			String sql = "DELETE from pacientes WHERE id=?";
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setInt(1, id);
			st.execute();
			
			System.out.println("Paciente deletado");
			
			st.close();
			Db.Disconnect(conn);

			return true;
			
			
		}catch (Exception e) {
			System.out.println(e);

		}
		
		
		return false;
	}
	
	
	// UPDATE
	public static boolean updatePaciente(Paciente p) {
		
		Connection conn = Db.conect();
		LocalDate nascimento = p.getNascimento();
		
		if(conn == null) {
			System.err.println("Falha na conexão");

		}
		
		String sql = "UPDATE pacientes "						+
				
						"SET nome 		= 			?," 		+
						"cpf 			= 			?," 		+
						"nascimento 	=			?," 		+
						"genero 		=			?," 		+
						"telefone 		=			?," 		+
						"email 			=			?," 		+
						"endereco 		=			?" 			+
						
						"WHERE id 		= 			?"			;
		
		try {
			
			
			
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, p.getNome());
			st.setString(2, p.getCpf());
			st.setObject(3, nascimento);
			st.setString(4, p.getGenero());
			st.setString(5, p.getTelefone());
			st.setString(6, p.getEmail());
			st.setString(7, p.getEndereco());
			
			st.setInt(8, p.getId());

			
			st.execute();
			System.out.print("Paciente atualizado");
			
			st.close();
			Db.Disconnect(conn);
			
			return true;
			
		}catch (Exception e) {	
			System.out.print(e);
			System.err.println("Erro durante atualização");

		}
		
		//Db.Disconnect(conn);
		return false;
	}
	
	
	// RECUPERAR ID
	public static Paciente getId(int id) {
		
		Connection conn = Db.conect();
		
		try {
			
			String sql = "SELECT * FROM pacientes WHERE id=" + id;
			
			Statement 	st 		= conn.createStatement();
			ResultSet 	result	= st.executeQuery(sql);
			
			Paciente paciente = new Paciente();
			
			while(result.next()) {
				
				paciente = new Paciente(result.getInt("id"),
										result.getString("nome"),
										result.getString("cpf"),
										result.getDate("nascimento").toLocalDate(),
										result.getString("genero"),
										result.getString("telefone"),
										result.getString("email"),
										result.getString("endereco")

						);
			}
			
			st.close();
			Db.Disconnect(conn);
			
			return paciente;
			
		}catch (Exception e) {
			System.out.println(e);

		}
		
		return null;
		
	} 
	
}
