<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
 
<html>
<head>
   <title>Acesso</title>
   
   <!-- Style - BS -->
   <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
   <link rel="stylesheet" href="./static/css/style.css">
   
   <style type="text/css">
   	.lable{
    	margin-left: 40%;
    	font-weight: 700;
   	}
   </style>
</head>
<body>
 
<!-- Header -->
 <header>

 </header>
 <nav>
   <nav class="navbar navbar-expand-lg navbar-dark bg-dark" aria-label="Offcanvas navbar large">
      <div class="container-fluid">
        <a class="navbar-brand" href="#">Responsive offcanvas navbar</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasNavbar2" aria-controls="offcanvasNavbar2" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="offcanvas offcanvas-end text-bg-dark" tabindex="-1" id="offcanvasNavbar2" aria-labelledby="offcanvasNavbar2Label">
          <div class="offcanvas-header">
            <h5 class="offcanvas-title" id="offcanvasNavbar2Label">Offcanvas</h5>
            <button type="button" class="btn-close btn-close-white" data-bs-dismiss="offcanvas" aria-label="Close"></button>
          </div>
          <div class="offcanvas-body">
            <ul class="navbar-nav justify-content-end flex-grow-1 pe-3">
              <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="#">Home</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="#">Link</a>
              </li>
              <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                  Dropdown
                </a>
                <ul class="dropdown-menu">
                  <li><a class="dropdown-item" href="#">Action</a></li>
                  <li><a class="dropdown-item" href="#">Another action</a></li>
                  <li>
                    <hr class="dropdown-divider">
                  </li>
                  <li><a class="dropdown-item" href="#">Something else here</a></li>
                </ul>
              </li>
            </ul>
 
          </div>
        </div>
      </div>
    </nav>
 </nav>
<!-- Header -->

<main class="main">
   <section class="box-form">
      <form>
         <h1 class="h3 mb-3 fw-normal">Log in</h1>
   
         <div class="form-floating">
         <input type="email" class="form-control" id="floatingInput" placeholder="name@example.com">
         <label for="floatingInput">Email address</label>
         </div>
         <div class="form-floating">
         <input type="password" class="form-control" id="floatingPassword" placeholder="Password">
         <label for="floatingPassword">Password</label>
         </div>
   
         <div class="form-check text-start my-3">
         <input class="form-check-input" type="checkbox" value="remember-me" id="flexCheckDefault">
         
         <label class="form-check-label" for="flexCheckDefault">
            Remember me
         </label>
         <a href="#"><label for="" class="lable">Cadastre-se</label></a>
         </div>
         <button class="btn btn-primary w-100 py-2" type="submit">Sign in</button>
         <p class="mt-5 mb-3 text-body-secondary">&copy; 2017–2023</p>
      </form>
   </section>
</main>


<!-- Footer -->
<footer>
   <nav>

   </nav>
</footer>
<!-- Footer -->


<!-- Js - BS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
<script src=""></script>
<script>
</script>

</body>
</html>
