package br.com.maven.systemlabs.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.maven.systemlabs.model.Paciente;
import br.com.maven.systemlabs.service.PacienteServices;

 

 
@WebServlet(urlPatterns = {  "/acessoCadastroPaciente", "/NewPaciente" })
public class PacienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public PacienteController() {
        super();
     }

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String address = request.getServletPath();

		switch (address) {
		
		case "/AcessoCadastroPaciente":
			AcessoCadastroPaciente(request, response);
			break;
		
		case "/NewPaciente":
			insertPaciente(request, response);
			break;
	
		}

 

	}
	
	public void AcessoCadastroPaciente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 response.sendRedirect("cadastroPaciente.html");
		 
	}
	
 
	
	
	public void insertPaciente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		  // Tratamento da data		 
		  String dataOriginal = request.getParameter("inputNascimento"); //Recebe o parâmetro 	
		  LocalDate data = LocalDate.parse(dataOriginal, DateTimeFormatter.ofPattern("dd/MM/yyyy")); // Converte ele no formato de data que o Db entende (0000-00-00)
		
		  Paciente paciente = new Paciente(
				  							request.getParameter("inputNome"),
				  							request.getParameter("inputCpf"),
				  							data,
				  							request.getParameter("inputGenero"),
				  							request.getParameter("inputEmail"),
				  							request.getParameter("inputEndereco"),
				  							request.getParameter("inputTelefone")
				  						  );
				  
		 if(PacienteServices.insertPaciente(paciente)){
			 response.getWriter().append("Cadastrado com sucesso");
				System.out.println("Cadastrado");

		 }else {
			 response.getWriter().append("Falha no cadastro");
				System.out.println("Cadastrado");

		 }
		  
	}
	
	 

	
	
	
}
