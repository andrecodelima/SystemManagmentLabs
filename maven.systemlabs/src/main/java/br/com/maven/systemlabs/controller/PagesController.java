package br.com.maven.systemlabs.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 

 
@WebServlet(urlPatterns = { })
public class PagesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public PagesController() {
        super();
     }

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String address = request.getServletPath();

		switch (address) {
		
		}

 

	}
	 
	public void NewUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 

	}
	

}
