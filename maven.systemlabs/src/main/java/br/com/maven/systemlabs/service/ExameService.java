package br.com.maven.systemlabs.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;

import br.com.maven.systemlabs.model.Exame;

public class ExameService {

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
	
}
