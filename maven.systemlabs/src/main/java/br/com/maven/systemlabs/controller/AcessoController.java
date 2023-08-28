package br.com.maven.systemlabs.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.maven.systemlabs.model.Users;
import br.com.maven.systemlabs.service.AcessoServices;

 

 
@WebServlet(urlPatterns = {  "/acessoCadastro", "/newUser", "/login" })
public class AcessoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public AcessoController() {
        super();
     }

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String address = request.getServletPath();

		switch (address) {
		
		case "/acessoCadastro":
			Acesso(request, response);
			break;
		
		
		
		case "/newUser":
			NewUser(request, response);
			break;
		
		
		
		case "/login":
			Login(request, response);
			break;
	
		}

 

	}
	
	public void Acesso(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 response.sendRedirect("cadastroUser.html");
		 
		  
	}
	
	
	public void NewUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		 Users user = new Users (request.getParameter("inputUser"), 
				 				 request.getParameter("inputPassword")
				 				);
		 
		 if (AcessoServices.insertUser(user)) {
				response.getWriter().append("Cadastro realizado");

		 } else {
				response.getWriter().append("Falha no cadastro");

		 }
	}
	
	public void Login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		String user = request.getParameter("inputUser");
		String pass = request.getParameter("inputPassword");
		
		Users users = AcessoServices.getAllUser(user);
		
		if(users.getUsuario() == null || users.getSenha() == null) {
			response.getWriter().append("Usuario ou senha inválido");

		}else{
			 if((users.getUsuario().equals(user)) && (users.getSenha().equals(pass))) {}
				response.getWriter().append("Acesso permitido");

		}
		
 	}
	

}
