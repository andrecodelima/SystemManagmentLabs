package br.com.maven.systemlabs.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.maven.systemlabs.model.Medico;
import br.com.maven.systemlabs.service.MedicoServices;

 

 
@WebServlet(urlPatterns = {  "/acessoCadastroMedico", "/NewMedico" })
public class MedicoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public MedicoController() {
        super();
     }

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String address = request.getServletPath();

		switch (address) {
		
		case "/acessoCadastroMedico":
			AcessoCadastroMedico(request, response);
			break;
		
		case "/NewMedico":
			insertMedico(request, response);
			break;
	
		}

 

	}
	
	public void AcessoCadastroMedico(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 response.sendRedirect("cadastroMedico.html");
		 
	}
	
	
	public void insertMedico(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		  // Tratamento da data. Convertendo em String	 
		  String dataOriginal = request.getParameter("inputNascimento"); //Recebe o parâmetro 	
		  LocalDate data = LocalDate.parse(dataOriginal,DateTimeFormatter.ofPattern("dd/MM/yyyy")); // Converte ele no formato de data que o Db entende (0000-00-00)
		  
		  // Tratamento da campo ativo que é booleano. Convertendo em String
		  boolean ativo = Boolean.parseBoolean(request.getParameter("inputAtivo"));
		  
		  Medico medico = new Medico(
				  							request.getParameter("inputNome"),
				  							data,
				  							request.getParameter("inputGenero"),
				  							request.getParameter("inputCpf"),
				  							request.getParameter("inputTelefone"),
				  							request.getParameter("inputEmail"),
				  							request.getParameter("inputEndereco"),
				  							request.getParameter("inputCrm"),
				  							request.getParameter("inputEspecialidade"),
				  							ativo
				  						  );
				  
		 if(MedicoServices.insertMedico(medico)){
			 response.getWriter().append("Médico cadastrado com sucesso");
				System.out.println("Cadastrado");

		 }else {
			 response.getWriter().append("Falha no cadastro");
				System.out.println("Cadastrado");

		 }
		  
	}
	
	 

	
	
	
}
