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