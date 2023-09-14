package br.com.maven.systemlabs.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="pacientes")
public class Paciente {

	
	@Id
	@GeneratedValue
	private int id;
	
	@Column
	private String nome;
	
	@Column
	private String cpf;
	
	@Column
    @Temporal(TemporalType.DATE)
	private LocalDate nascimento;
	
	@Column
	private String genero;
	
	@Column
	private String telefone;
	
	@Column
	private String email;
	
	@Column
	private String endereco;
	
	@Column
	private boolean ativo;

	public Paciente() {
		super();
	}

	public Paciente(int id, String nome, String cpf, LocalDate nascimento, String genero, String telefone, String email, String endereco
			) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.nascimento = nascimento;
		this.genero = genero;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
	}
	
	public Paciente(String nome, String cpf, LocalDate nascimento, String genero, String telefone, String email, String endereco
			) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.nascimento = nascimento;
		this.genero = genero;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getNascimento() {
		return nascimento;
	}

	public void setNascimento(LocalDate nascimento) {
		this.nascimento = nascimento;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	

 
	
	
	
}
