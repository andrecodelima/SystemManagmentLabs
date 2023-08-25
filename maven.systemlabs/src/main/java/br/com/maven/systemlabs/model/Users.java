package br.com.maven.systemlabs.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class Users {

	@Id
	@GeneratedValue
	private int id;
	
	@Column(length = 50)
 	private String tipo;
	
	
	private boolean status;
	
	private int idcliente;
	
	@Column(length = 100)
	private String usuario;
	
	@Column(length = 100)
	private String senha;
	
}
