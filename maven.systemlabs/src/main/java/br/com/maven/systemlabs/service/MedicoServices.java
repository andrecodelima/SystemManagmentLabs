package br.com.maven.systemlabs.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;

import br.com.maven.systemlabs.model.Medico;

public class MedicoServices {

	public static boolean insertMedico(Medico medico) {
		
		Connection conn 		= Db.conect();
		LocalDate nascimento	= medico.getNascimento();
		                            
		try {
			
			String sql = "INSERT INTO medicos(nome, nascimento, genero, cpf, telefone, email, endereco, crm, especialidade, ativo) VALUES(?,?,?,?,?,?,?,?,?,?)";
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
			st.setBoolean(10, medico.isAtivo());


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
