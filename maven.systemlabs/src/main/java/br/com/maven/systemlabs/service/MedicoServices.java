package br.com.maven.systemlabs.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import com.mysql.cj.protocol.Resultset;

import br.com.maven.systemlabs.model.Medico;

public class MedicoServices {

	//INSERE
	public static boolean insertMedico(Medico medico) {
		
		Connection conn 		= Db.conect();
		LocalDate nascimento	= medico.getNascimento();
		                            
		try {
			
			String sql = "INSERT INTO medicos(nome, nascimento, genero, cpf, telefone, email, endereco, crm, especialidade) "
						+ "VALUES(?,?,?,?,?,?,?,?,?)";
			
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setString(1, medico.getNome());
			st.setObject(2, nascimento);
			st.setString(3, medico.getGenero());
			st.setString(4, medico.getCpf());
			st.setString(5, medico.getTelefone());
			st.setString(6, medico.getEmail());
			st.setString(7, medico.getEndereco());
			st.setString(8, medico.getCrm());
			st.setString(9, medico.getEspecialidade());

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
	
	
	//SELECT ALL
	
	
	public static ArrayList<Medico> getAllMedicos(){
		
		Connection conn = Db.conect();
		
		try {
			String sql = "SELECT * FROM medicos";
			
			Statement st = conn.createStatement();
			ResultSet result = st.executeQuery(sql);
			
			ArrayList<Medico>lista = new ArrayList<Medico>();
			
			while (result.next()) {
				
				lista.add(new Medico(
							result.getInt("id"),
							result.getString("nome"),
							result.getString("cpf"),
							result.getDate("nascimento").toLocalDate(),
							result.getString("genero"),
							result.getString("telefone"),
							result.getString("email"),
							result.getString("endereco"),
							result.getString("crm"),
							result.getString("especialidade")
							
							)
						
						);
			}
			
			st.close();
			Db.Disconnect(conn);
			
			return lista;
			
		}catch (Exception e) {
			System.out.println(e);

		}
		
		return null;
	}
	
	
	//RECUPERAR ID
	public static Medico getId(int id) {
		
		Connection conn = Db.conect();
		
		try {
			
			String sql = "SELECT * FROM medicos "
						+ "WHERE id=" + id; 
			
			Statement st 		= conn.createStatement();
			ResultSet result 	= st.executeQuery(sql);
			
			Medico medico = new Medico();
			
			while(result.next()) {
				
				medico = new Medico(result.getInt("id"),
									result.getString("nome"),
									result.getString("cpf"),
									result.getDate("nascimento").toLocalDate(),
									result.getString("genero"),
									result.getString("telefone"),
									result.getString("email"),
									result.getString("endereco"),
									result.getString("crm"),
									result.getString("especialidade")				
									
									);
			}
			
			st.close();
			Db.Disconnect(conn);
			
		}catch (Exception e) {
			System.out.println(e);

		}
		
		return null;
	}
	
	//DELETE
	
	public static boolean delMedico(int id) {
		
		Connection conn = Db.conect();
		
		try {
			
			String sql = "DELETE FROM medicos WHERE id=?";
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setInt(1, id);
			st.execute();
			
			System.out.println("Medico deletado");
			
			st.close();
			Db.Disconnect(conn);
			
			return true;
			
		}catch (Exception e) {
			System.out.println(e);

			
		}
		
		
		
		return false;
	}
	
	
}
