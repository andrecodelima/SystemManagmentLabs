<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@ page import="java.util.ArrayList"%>

<%@ page import="br.com.maven.systemlabs.service.MedicoServices"%>
<%@ page import="br.com.maven.systemlabs.model.Medico"%>
<%@ page import="br.com.maven.systemlabs.model.Paciente"%>
<%@ page import="br.com.maven.systemlabs.service.PacienteServices"%>



<%
	ArrayList<Paciente> listaPaciente = PacienteServices.getAllPacientes();
	ArrayList<Medico>	listaMedico	  = MedicoServices.getAllMedicos();
	String linePaciente = "";
	String lineMedico = "";

	
	
	for(Paciente paciente : listaPaciente){
		
		int id = paciente.getId();
		String nome = paciente.getNome();
		
		linePaciente += "<option value=\"" + id + "\">" + nome + "</option>";
	}
	
	for(Medico medico : listaMedico ){
		
		int id = medico.getId();
		String nome = medico.getNome();
		
		lineMedico +="<option value=\"" + id + "\">" + nome + "</option>";
	}

%>

<!DOCTYPE html>
<html lang="pt-Br">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Cadastro | Exame</title>
   
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

    #form{
      width: 34vw;
      margin-left: -56px;
    }

    .mb-3{
      margin-left: -56px;

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
      <h4 class="mb-3">Cadastro</h4>

      <!-- FormulÃ¡rio de Cadastro -->
      <form class="needs-validation" id="form" name="formCadastro" novalidate action ="newExame">
        <div class="row g-3">        
          <div class="col-sm-10">
            <label for="firstName" class="form-label">Nome do Exame</label>
            <input type="text" class="form-control" id="nome" name="inputNome" placeholder="Nome do exame" value="" required>
            <div class="invalid-feedback">
              Por favor insira o nome do exame
            </div>
          </div>
         </div><br>

 		<div class="row g-3">
          <div class="col-5">
            <label for="username" class="form-label">Data</label>
            <div class="input-group has-validation">
              <input type="text" class="form-control" id="data" name="inputData" placeholder="00/00/0000" required>
            <div class="invalid-feedback">
              Por favor informe a data do exame
              </div>
            </div>
          </div>
		</div><br>
		
		<div class="row g-3">
		  <div class="col-md-5">
            <label for="state" class="form-label">Paciente</label>
            <select class="form-select" id="paciente" name="inputPaciente"  required>
              <option value=0>Escolha...</option>
              <%=linePaciente %>
            </select>
            <div class="invalid-feedback">
              Por favor selecione um paciente
            </div>
          </div>

		<div class="col-md-5">
            <label for="state" class="form-label">Medico</label>
            <select class="form-select" id="medico" name="inputMedico" required>
              <option value=0>Escolha...</option>
              <%=lineMedico %>
            </select>
            <div class="invalid-feedback">
              Por favor selecione um medico
            </div>
          </div>
          

        </div>

        <hr class="my-4">
        <button class="w-30 btn btn-primary btn-lg" type="submit" onclick="validaCadastro()">Cadastrar</button>
      </form>
      <!-- Fim formulÃ¡rio cadastro -->

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

	//mascaras
	$(document).ready(function(){
	
	 $("#telefone").mask("99 9999-9999");
	 $("#cpf").mask("999.999.999-99");
   $("#data").mask("99/99/9999");

	
	});
	// Calendar
	$("#data").datepicker({
		dateFormat: "dd/mm/yy"
	});


  
</script>

</body>
</html>