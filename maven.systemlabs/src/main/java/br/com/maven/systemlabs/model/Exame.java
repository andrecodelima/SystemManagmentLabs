package br.com.maven.systemlabs.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table (name = "exames")
public class Exame {

	@Column
	private int id;
	
	@Column
	private String nome;
	
	@Column
	private LocalDate data;
	
	@Column
	private int id_paciente;
	
	@Column
	private int id_medico;
	
	
	public Exame() {}

	public Exame(int id, String nome, LocalDate data) {
		super();
		this.id = id;
		this.nome = nome;
		this.data = data;
	}
	

	public Exame(int id, String nome, LocalDate data, int id_paciente, int id_medico) {
		super();
		this.id = id;
		this.nome = nome;
		this.data = data;
		this.id_paciente = id_paciente;
		this.id_medico = id_medico;
	}

	
	public Exame(String nome, LocalDate data, int id_paciente, int id_medico) {
		super();
		this.nome = nome;
		this.data = data;
		this.id_paciente = id_paciente;
		this.id_medico = id_medico;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public int getId_paciente() {
		return id_paciente;
	}

	public void setId_paciente(int id_paciente) {
		this.id_paciente = id_paciente;
	}

	public int getId_medico() {
		return id_medico;
	}

	public void setId_medico(int id_medico) {
		this.id_medico = id_medico;
	}
	
	
}
