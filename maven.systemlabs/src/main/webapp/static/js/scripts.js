/**
 * 
 */

 function validaLogin(){
	 
	 let user = document.getElementById('inputUser').value;
	 let pass = document.getElementById('inputPassword').value;
 	
 	if(user == ""){
		alert("O campo Usuário não pode ficar em branco.");

	 }else if(pass == ""){
		 alert("O campo Senha não pode ficar em branco.");

	 }else{
		 formLogin.submit();
	 }
 }