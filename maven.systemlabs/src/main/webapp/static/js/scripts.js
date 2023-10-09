/**
 * 
 */

 function validaCadastroUser(){
	 
	 let user 		= document.getElementById('inputUser').value;
	 let user_conf  = document.getElementById('inputUser_confirm').value;
	 let pass 		= document.getElementById('inputPassword').value;
	
	if(user == ""){
		alert("O campo Usuário não pode ficar em branco."); // Primeira cadeia de validação - Validação do usuario (Não pode ficar vazio)

	}else{ // Segunda cadeia de validação - Validação de igualdade do usuário (Precisa ser igual ao usuario de confirmação)
		
		if(user_conf == ""){
			alert("Confirme o usuário");

		}else if(user != user_conf){
			alert("Usuário não são iguais!");
		
		}else{// Terceira cadeia de validação - Validação da senha
			
			if(pass == ""){
				alert("O campo Senha não pode ficar em branco.");
				

			}else{ // Se passar pelas 3 cadeias, o formulário pode ser submetido
				
				formLogin.submit();
			}
		} 
	}
	 
 	
 
 }
 
 function validaLogin(){
	 
	 let user 		= document.getElementById('inputUser').value;
	 let pass 		= document.getElementById('inputPassword').value;
	
	if(user == ""){
		alert("O campo Usuário não pode ficar em branco.");  
	 
	 }else if(pass == ""){
		 alert("O campo Senha não pode ficar em branco.");

	 }else{
		formLogin.submit();

	 }
	 
 }

 //Valida Form - Cadastro Cliente (ESTUDAR)
 // Example starter JavaScript for disabling form submissions if there are invalid fields
 (() => {
	'use strict'
  
	// Fetch all the forms we want to apply custom Bootstrap validation styles to
	const forms = document.querySelectorAll('.needs-validation')
  
	// Loop over them and prevent submission
	Array.from(forms).forEach(form => {
	  form.addEventListener('submit', event => {
		if (!form.checkValidity()) {
		  event.preventDefault()
		  event.stopPropagation()
		}
  
		form.classList.add('was-validated')
	  }, false)
	})
  })()



  function validaCadastro(){
	 
	 let option1 = document.getElementById('paciente').value;
	 let option2 = document.getElementById('medico').value;
	 let option3 = document.getElementById('exame').value;

	 if(option1 == 0 || option2 == 0 || option3 == 0){
		alert("Escolha uma opção válida"); 
	 }else{
		 formCadastro.submit();
	 }
	 
	 
		  
 
 }