package br.com.maven.systemlabs.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;

import br.com.maven.systemlabs.model.Paciente;

public class PacienteServices {

	public static boolean insertPaciente(Paciente paciente) {
		
		Connection conn 		= Db.conect();
		LocalDate nascimento	= paciente.getNascimento();
		                            
		try {
			
			String sql = "INSERT INTO pacientes(nome, cpf, nascimento, genero, email, endereco, telefone) VALUES(?,?,?,?,?,?,?)";
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setString(1, paciente.getNome());
			st.setString(2, paciente.getCpf());
			st.setObject(3, nascimento);
			st.setString(4, paciente.getGenero());
			st.setString(5, paciente.getEmail());
			st.setString(6, paciente.getEndereco());
			st.setString(7, paciente.getNome());
			
			st.execute();
			System.out.println("Cadastro Realizado");
			
			st.close();
			
			return true;
			
		}catch (Exception e) {
			System.out.println("Falha no cadastro" + e);

		}
		return false;
	}
	
	
	
}
