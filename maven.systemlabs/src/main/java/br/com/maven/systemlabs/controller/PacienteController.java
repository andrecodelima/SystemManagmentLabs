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

 

 
@WebServlet(urlPatterns = {  "/acessoCadastroPaciente", "/NewPaciente", "/deletePaciente", "/updatePaciente" })
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
	
		
		case "/deletePaciente":
			DelPaciente(request, response);
			break;
			
		case "/updatePaciente":
			UpdatePaciente(request, response);
			break;

	}

 

	}
	
	public void AcessoCadastroPaciente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 response.sendRedirect("cadastroPaciente.html");
		 
	}
	
	
	public void insertPaciente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		  // Tratamento da data		 
		  String dataOriginal = request.getParameter("inputNascimento"); //Recebe o parâmetro 	
		  LocalDate data = LocalDate.parse(dataOriginal,DateTimeFormatter.ofPattern("dd/MM/yyyy")); // Converte ele no formato de data que o Db entende (0000-00-00)
		
		  Paciente paciente = new Paciente(
				  							request.getParameter("inputNome"),
				  							request.getParameter("inputCpf"),
				  							data,
				  							request.getParameter("inputGenero"),
				  							request.getParameter("inputTelefone"),
				  							request.getParameter("inputEmail"),
				  							request.getParameter("inputEndereco")
				  							
				  						  );
				  
		 if(PacienteServices.insertPaciente(paciente)){
			 response.getWriter().append("Paciente CADASTRADO com sucesso");
				System.out.println("Cadastrado");

		 }else {
			 response.getWriter().append("Falha ao CADASTRAR paciente");
				System.out.println("falha no cadastro do paciente");

		 }
		  
	}
	
	public void UpdatePaciente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		  /* Instanciação do objeto paciente que receberá os parâmetros vindos do formulário pelo atributo 'name' */
		  Paciente paciente = new Paciente(
				  								Integer.parseInt(request.getParameter("id")),
				  								request.getParameter("inputNome"),
				  								request.getParameter("inputCpf"),
				  								LocalDate.parse(request.getParameter("inputNascimento")),
				  								request.getParameter("inputGenero"),
				  								request.getParameter("inputTelefone"),
				  								request.getParameter("inputEmail"),
				  								request.getParameter("inputEndereco")
				  								
				  					);
		  /*    
		    	* Chamada 	- PacienteServices 'chama' o método updatePaciente que requer um parâmetro.
		   		* Parâmetro - Como parâmetro atribuímos o objeto paciente instanciado ou criado acima. 
		   	     
		   */
		  
		  if(PacienteServices.updatePaciente(paciente)) {
				 response.getWriter().append("Paciente EDITADO com sucesso");

		  }else {
				 response.getWriter().append("Falha AO EDITAR paciente");

		  }
		 
	}
	 
	public void DelPaciente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		    /* 
		 	  # Tratamento de Dados
			  	
			  *  O Método ParseInt da classe Integer converte o parâmetro 'id' de uma String para um
			  * 	número Inteiro. Isso é necessário porque o método 'delPaciente()' espera um
			  * 	número inteiro como argumento.
			  *   
            */
		
		  if(PacienteServices.delPaciente(Integer.parseInt(request.getParameter("id")))) {
				 response.getWriter().append("Paciente DELETADO com sucesso");

		  }else {
				 response.getWriter().append("Falha AO DELETAR paciente");

		  }
		 
	}
	
	
	
	
}
