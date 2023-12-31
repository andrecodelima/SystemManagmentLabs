<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@ page import= "java.text.DateFormat" %>
<%@ page import= "java.time.LocalDate" %>

<%@ page import= "java.util.ArrayList" %>

<%@ page import="br.com.maven.systemlabs.model.Medico"%>
<%@ page import="br.com.maven.systemlabs.service.MedicoServices"%>
<%@ page import="br.com.maven.systemlabs.model.Paciente"%>
<%@ page import="br.com.maven.systemlabs.service.PacienteServices"%>
<%@ page import="br.com.maven.systemlabs.model.Exame"%>
<%@ page import="br.com.maven.systemlabs.service.ExameServices"%>

<%
	ArrayList<Exame> 		lista 			= ExameServices.getAllExames();
	ArrayList<Paciente>		listaPaciente	= PacienteServices.getAllPacientes();
	ArrayList<Medico>		listaMedico		= MedicoServices.getAllMedicos();

	String nomePaciente = "";
	String nomeMedico	= "";

	String line = "";
	
	if(lista.isEmpty()){
		line = "<tr><th colspan='8'> Lista vazia </tr></th>";

	}else{
		
		for(Exame exame : lista){
			
			 int id					= exame.getId();
			 String nome			= exame.getNome();
			 LocalDate data			= exame.getData();
			 int id_paciente		= exame.getId_paciente();
			 int id_medico			= exame.getId_medico();
			 
			 for(Paciente paciente : listaPaciente){
				 
				 int idTabelaPaciente = paciente.getId();
				 
				 if(idTabelaPaciente == id_paciente){
					 
					 nomePaciente = paciente.getNome();
					 System.out.print(nomePaciente);
					 
					 for(Medico medico : listaMedico ){
						 
						 int idTabelaMedico = medico.getId();
						 
						 if(idTabelaMedico == id_medico){
							 
							 nomeMedico = medico.getNome();
							 System.out.print(nomePaciente);
						 }
						 
					 }
				 }
				 
				 
			 }
			  
		
		line += "<tr>"					+
		
				"<td>"					+ id				+ "</td>"		+
				"<td>"					+ nome				+ "</td>"		+
				"<td>"					+ data				+ "</td>"		+
				"<td>"					+ nomePaciente		+ "</td>"		+
				"<td>"					+ nomeMedico		+ "</td>"		+


				
				"<td><a class='btn btn-warning' href='editMedico.jsp?id="		 + id + "'>Editar</a></td>"  	+
				"<td><a class='btn btn-danger'  href='deleteMedico?id="		 	 + id + "'>Excluir</a></td>"  	+
				
				"</tr>";
		}
		
		
	}

%>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Exames</title>
   
   <!-- Style - BS -->
   <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
   <link rel="stylesheet" href="./static/css/style.css">
   
    <!-- Style - jquery -->
 	<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
   
   <style type="text/css">
   	.lable{
    	margin-left: 40%;
    	font-weight: 700;
   	  }
    
     .main{
        display:flex;
        justify-content: center;
        margin-top:40px;
        
    }
    
    .container {
        max-width: 960px;
      }

    
    .mb-3{
      margin-left: -56px;

    }

    .box-register{
    border-radius: 23px;
    padding-top: 25px;
    padding-bottom: 40px;
    width: 80%;
    box-shadow: 4px -1px 8px 2px #0f0e0e99;

    display: flex;
    justify-content: space-evenly;

    .mb-3{
      background-color: #dcdcdd;
      padding: 11px;
      width: 100%;
    }
}

   </style>
</head>
<body>
  <!-- Header -->
 <header>

 </header>
 <nav>
<nav class="navbar navbar-expand-md bg-dark sticky-top border-bottom" data-bs-theme="dark">
  <div class="container">
    <a class="navbar-brand d-md-none" href="#">
      <svg class="bi" width="24" height="24"><use xlink:href="#aperture"/></svg>
      Aperture
    </a>
    <button class="navbar-toggler" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvas" aria-controls="#offcanvas" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="offcanvas offcanvas-end" tabindex="-1" id="#offcanvas" aria-labelledby="#offcanvasLabel">
      <div class="offcanvas-header">
        <h5 class="offcanvas-title" id="#offcanvasLabel">Aperture</h5>
        <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
      </div>
      <div class="offcanvas-body">
        <ul class="navbar-nav flex-grow-1 justify-content-between">
          <li class="nav-item"><a class="nav-link" href="#">
            <svg class="bi" width="24" height="24"><use xlink:href="#aperture"/></svg>
          </a></li>
          <li class="nav-item"><a class="nav-link" href="#">Tour</a></li>
          <li class="nav-item"><a class="nav-link" href="#">Product</a></li>
          <li class="nav-item"><a class="nav-link" href="#">Features</a></li>
          <li class="nav-item"><a class="nav-link" href="#">Enterprise</a></li>
          <li class="nav-item"><a class="nav-link" href="#">Support</a></li>
          <li class="nav-item"><a class="nav-link" href="#">Pricing</a></li>
          <li class="nav-item"><a class="nav-link" href="#">
            <svg class="bi" width="24" height="24"><use xlink:href="#cart"/></svg>
          </a></li>
        </ul>
      </div>
    </div>
  </div>
</nav>
 </nav>
<!-- Header -->

<main class="main">
  <section class="box-register">
    <div class="col-md-7 col-lg-8">
     <h4 class="mb-3">Exames</h4>
  

      <table class="table-responsive-lg">
        <thead>
          <tr>
            <th scope="col">Nº</th>
            <th scope="col">Exame</th>
            <th scope="col">Data</th>
            <th scope="col">Paciente</th>
			<th scope="col">Medico</th>
              
            
          </tr>
        </thead>
        
        <tbody class="table-group-divider">
          <tr>
            <th><%=line %></th>     
          </tr>
        </tbody>
        
        <tfoot>
        	<tr>
        		<th colspan=10>Fim da lista</th>
        	</tr>
        </tfoot>
        
      </table>

    </div>
  </section>
</main>

<!-- Footer -->
<footer>
   <nav>

   </nav>
</footer>
<!-- Footer -->

<!-- SCRIPTS -->

<!-- Js - BS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>

<!-- JS Local --> 
<!-- Para as mascaras funcionarem Ã© preciso que as chamadas fiquem nessa ordem -->
<script src="./static/js/jquery.js"></script>
<script src="./static/js/scripts.js"></script>
<script src="./static/js/jquery.maskedinput.min.js"></script> 


<!-- Jquery UI - Componentes para UI -->
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>

<!-- <script src="./static/js/checkout.js"></script> -->

</body>

<script>
  
</script>

</body>
</html>