<%@page import="br.com.maven.systemlabs.service.MedicoServices"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@ page import= "java.text.DateFormat" %>
<%@ page import= "java.time.LocalDate" %>

<%@ page import= "java.util.ArrayList" %>

<%@ page import="br.com.maven.systemlabs.model.Medico"%>
<%@ page import="br.com.maven.systemlabs.service.MedicoServices"%>

<%
	  Medico medico = MedicoServices.getId(Integer.parseInt(request.getParameter("id")));

%>

<!DOCTYPE html>
<html lang="pt-Br">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Medico</title>
   
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
      width: 60vw;
      margin-left: -56px;
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
      <h4 class="mb-3">Médico</h4>

      <!-- Formulário de Cadastro -->
      <form class="needs-validation" id="form" name="formCadastro" novalidate action="updateMedico">
        <div class="row g-3">
          <div class="col-sm-10">
            <label for="firstName" class="form-label">Nome Completo</label>
            <input type="text" class="form-control" id="nome" name="inputNome" placeholder="Nome Completo" value="<%=medico.getNome()%>" required>
            <div class="invalid-feedback">
              Por favor insira o nome completo
            </div>
          </div>

          <div class="col-5">
            <label for="username" class="form-label">CPF</label>
            <div class="input-group has-validation">
              <input type="text" class="form-control" id="cpf" name="inputCpf" placeholder="999.999.999-99" value="<%=medico.getCpf()%>" required>
              <div class="invalid-feedback">
                Por favor informe o CPF
              </div>
            </div>
          </div>

          <div class="col-5">
            <label for="username" class="form-label">Data de nascimento</label>
            <div class="input-group has-validation">
              <input type="text" class="form-control" id="data" name="inputNascimento"  value="<%=medico.getNascimento()%>" required>
              <div class="invalid-feedback">
                Por favor informe sua data de nascimento
              </div>
            </div>
          </div>

          <div class="col-md-5">
            <label for="state" class="form-label">Gênero</label>
            <select class="form-select" id="genero" name="inputGenero" value="<%=medico.getGenero()%>" required>
              <option disabled>Escolha...</option>
               <option value="feminino">Feminino</option>
              <option value="masculino">Masculino</option>
            </select>
            <div class="invalid-feedback">
              Por favor selecione um gênero
            </div>
          </div>

          <div class="col-5">
            <label for="username" class="form-label">Telefone</label>
            <div class="input-group has-validation">
              <input type="text" class="form-control" id="telefone" name="inputTelefone" value="<%=medico.getTelefone()%>" required>
              <div class="invalid-feedback">
                Por favor informe o telefone
              </div>
            </div>
          </div>

          <div class="col-10">
            <label for="address" class="form-label">Endereço</label>
            <input type="text" class="form-control" id="endereco" name="inputEndereco" placeholder="" value="<%=medico.getEndereco()%>" required>
            <div class="invalid-feedback">
              Por favor insira seu endereço
            </div>
          </div>

          <div class="col-10">
            <label for="email" class="form-label">CRM <span class="text-body-secondary"></span></label>
            <input type="text" class="form-control" id="cpf" name="inputCrm" placeholder="999.999.999-99" value="<%=medico.getCrm()%>" required>
            <div class="invalid-feedback">
              Por favor insira seu CRM
            </div>
          </div>

          <div class="col-10">
            <label for="email" class="form-label">Email <span class="text-body-secondary"></span></label>
            <input type="email" class="form-control" id="email" name="inputEmail" placeholder="nomedoemail@example.com" value="<%=medico.getEmail()%>">
            <div class="invalid-feedback">
              Por favor insira seu email
            </div>
          </div>

          <div class="col-10">
            <label for="address" class="form-label">Especialidade</label>
            <input type="text" class="form-control" id="endereco" name="inputEspecialidade" placeholder="" value="<%=medico.getEspecialidade()%>" required>
            <div class="invalid-feedback">
              Por favor insira sua especialidade
            </div>
          </div>

          <input type="hidden" name="id" value="<%=medico.getId()%>">
        </div>

        <hr class="my-4">
        <button class="w-30 btn btn-primary btn-lg" type="submit">Salvar</button>

      </form>
      <!-- Fim Formulário cadastro -->
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

	// Calendar
	$("#data").datepicker({
		dateFormat: "dd/mm/yy"
	});

  
</script>

</body>
</html>