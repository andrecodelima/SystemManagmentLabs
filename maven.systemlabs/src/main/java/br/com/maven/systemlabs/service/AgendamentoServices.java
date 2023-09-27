package br.com.maven.systemlabs.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;

import br.com.maven.systemlabs.model.Agendamento;

public class AgendamentoServices {

	public static boolean insertAgendamento(Agendamento agendamento) {
		
		Connection conn = Db.conect();
		LocalDate data = agendamento.getData();
		
		try {
			
			String sql = "INSERT INTO agendamentos(data, id_paciente, id_medico, id_exame) VALUES(?,?,?,?)";
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setObject(1, data);
			st.setInt(2, agendamento.getId_paciente());
			st.setInt(3, agendamento.getId_medico());
			st.setInt(4, agendamento.getId_exame());
			
			st.execute();
			System.out.println("Cadastro Realizado");
			
			st.close();
			Db.Disconnect(conn);
			
			return true;
			
		}catch (Exception e) {
			System.out.print("Falha no cadastro" + e);
		}
		
		return false;
	}
}
