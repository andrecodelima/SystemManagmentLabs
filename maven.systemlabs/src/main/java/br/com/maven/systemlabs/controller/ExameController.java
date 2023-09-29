package br.com.maven.systemlabs.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.maven.systemlabs.model.Exame;
import br.com.maven.systemlabs.service.ExameServices;

 
@WebServlet(urlPatterns = {"/acessoCadastroExame", "/newExame"})
public class ExameController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
     
    public ExameController() {
        super();
         
    }

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String address = request.getServletPath();
		
		switch (address) {
		case "/acessoCadastroExame":
			acessoCadastroExame(request, response);
			break;
			
		case "/newExame":
			insertExame(request, response);
			break;
			

		default:
			break;
		
		}
		
	}
	
	
	public void acessoCadastroExame(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 response.sendRedirect("cadastroExame.jsp");
		 
	}
	
	
	public void insertExame(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		  String dataOriginal = request.getParameter("inputData"); //Recebe o parâmetro 	
		  LocalDate data = LocalDate.parse(dataOriginal,DateTimeFormatter.ofPattern("dd/MM/yyyy")); // Converte ele no formato de data que o Db entende (0000-00-00)

		  Exame exame = new Exame(
				  	
				  	request.getParameter("inputNome"),
				  	data,
				  	Integer.parseInt(request.getParameter("inputPaciente")),
				  	Integer.parseInt(request.getParameter("inputMedico"))
				  
				  );  
		  
		  if(ExameServices.insertExame(exame)) {
			  response.getWriter().append("Exame cadastrado com sucesso");
				System.out.println("Cadastrado");
		  }else {
			  response.getWriter().append("Falha no cadastro do exame");
				System.out.println("Falha no cadastro");
		  }
			  
		  
		 
	}
	
	 
}
