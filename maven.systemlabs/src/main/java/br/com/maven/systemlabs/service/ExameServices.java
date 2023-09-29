package br.com.maven.systemlabs.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import br.com.maven.systemlabs.model.Exame;

public class ExameServices {

	public static boolean insertExame(Exame exame) {
		
		Connection conn = Db.conect();
		LocalDate data = exame.getData();
		
		try {
			
			String sql = "INSERT INTO exames(nome, data, id_paciente, id_medico) VALUES(?,?,?,?)"; 
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setString(1, exame.getNome());
			st.setObject(2, data);
			st.setInt(3, exame.getId_paciente());
			st.setInt(4, exame.getId_medico());
			
			st.execute();
			System.out.println("Cadastro Realizado");

			st.close();
			Db.Disconnect(conn);
			
			return true;
			
		}catch (Exception e) {
			System.out.print("Falha no cadastro " + e);
		}
		
		return false;
	}
	
	
	public static ArrayList<Exame> getAllExames(){
		
		Connection conn = Db.conect();
		
		try {
			
			String sql = "SELECT * FROM exames";
			
			Statement st = conn.createStatement();
			ResultSet result = st.executeQuery(sql);
			
			ArrayList<Exame> lista = new ArrayList<Exame>();
			
			while(result.next()) {
				
				lista.add(new Exame(
					
						result.getInt("id"),
						result.getString("nome"),
						result.getDate("data").toLocalDate(),
						result.getInt("id_paciente"),
						result.getInt("id_medico")
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
	
}
