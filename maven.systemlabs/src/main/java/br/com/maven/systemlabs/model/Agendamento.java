package br.com.maven.systemlabs.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table (name = "agendamentos")
public class Agendamento {
	
	@Column
	private int id;
	
	@Column
	private LocalDateTime dataHora;
	
	@Column
	private int id_paciente;
	
	@Column
	private int id_medico;
	
	@Column
	private int id_exame;
	
	public Agendamento() {}

	public Agendamento(int id, LocalDateTime dataHora, int id_paciente, int id_medico, int id_exame) {
		super();
		this.id = id;
		this.dataHora = dataHora;
		this.id_paciente = id_paciente;
		this.id_medico = id_medico;
		this.id_exame = id_exame;
	}

	public Agendamento(LocalDateTime dataHora, int id_paciente, int id_medico, int id_exame) {
		super();
		this.dataHora = dataHora;
		this.id_paciente = id_paciente;
		this.id_medico = id_medico;
		this.id_exame = id_exame;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public void setData(LocalDateTime dataHora) {
		this.dataHora = dataHora;
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

	public int getId_exame() {
		return id_exame;
	}

	public void setId_exame(int id_exame) {
		this.id_exame = id_exame;
	}

	
	
}
