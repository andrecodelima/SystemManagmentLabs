package br.com.maven.systemlabs.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.maven.systemlabs.model.Agendamento;
import br.com.maven.systemlabs.service.AgendamentoServices;


@WebServlet(urlPatterns = {"/acessoCadastroAgendamento", "/newAgendamento"})
public class AgendamentoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AgendamentoController() {
        super();
        
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String address = request.getServletPath();
		
		switch (address) {
		case "/acessoCadastroExame":
			acessoCadastroAgendamento(request, response);
			break;
			
		case "/newAgendamento":
			insertAgendamento(request, response);
			break;
			

		default:
			break;
		
		}
		
	}

	public void acessoCadastroAgendamento(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		 response.sendRedirect("cadastroAgendamento.jsp");
		 
	}

	protected void insertAgendamento(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		 String datOriginal = request.getParameter("inputData");
		 LocalDate data = LocalDate.parse(datOriginal, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		 
		 Agendamento agendamento = new Agendamento(
				 
				 	data,
				 	Integer.parseInt(request.getParameter("inputPaciente")),
				 	Integer.parseInt(request.getParameter("inputMedico")),
				 	Integer.parseInt(request.getParameter("inputExame"))
				 	
				 );
		
		 if(AgendamentoServices.insertAgendamento(agendamento)){
			 response.getWriter().append("Agendamento cadastrado com sucesso");
				System.out.println("Cadastrado");
		 }else {
			 response.getWriter().append("Falha no cadastro do agendamento");
				System.out.println("Falha no cadastro");
		 }
		
	}

}
