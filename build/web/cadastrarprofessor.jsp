<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>RedaTec</title>
        
                     <!-- Favicons -->
  <link href="assets/img/logosite.png" rel="icon">
  <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Google Fonts -->
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

  <!-- Vendor CSS Files -->
  <link href="assets/vendor/aos/aos.css" rel="stylesheet">
  <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
  <link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
  <link href="assets/vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
  <link href="assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">

  <!-- Template Main CSS File -->
  <link href="assets/css/style.css" rel="stylesheet">
        
    </head>
    <body>
        
          <section class="vh-95" style="background-color: #499ead;">
  <div class="container py-5 h-100">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col-12 col-md-8 col-lg-6 col-xl-5">
        <div class="card shadow-2-strong" style="border-radius: 1rem;">
          <div class="card-body p-5 text-center">

        
         <h3 class="mb-5">Cadastrar Professor</h3>
            
            <form name="cadastrarprofessor" action="CadastrarProfessor" method="POST">
                
                    <div classs="text-center"> ${mensagem} </div>
                
            <div class="form-outline mb-4">
              <input type="text" id="typeTextX-2" name="nomeUsuario" for="nomeUsuario" class="form-control form-control-lg" />
              <label class="form-label" for="typeTextX-2">Nome</label>
            </div>
            
              <div class="form-outline mb-4">
              <input type="email" id="typeEmailX-2" name="emailUsuario" for="emailUsuario" class="form-control form-control-lg" />
              <label class="form-label" for="typeEmailX-2">Email</label>
            </div>
                
                
             <div class="form-outline mb-4">
              <input type="text" id="typeTextX-2" name="telefoneUsuario" for="telefoneUsuario" class="form-control form-control-lg" />
              <label class="form-label" for="typeTextX-2">Telefone</label>
            </div>
                
                 <div class="form-outline mb-4">
              <input type="text" id="typeTextX-2" name="rmProfessor" for="rmProfessor" class="form-control form-control-lg" />
              <label class="form-label" for="typeTextX-2">Rm do professor</label>
            </div>
            
               <div class="form-outline mb-4">
              <input type="text" id="typeTextX-2" name="loginUsuario" class="form-control form-control-lg" />
              <label class="form-label" for="typeTextX-2">Login</label>
            </div>


            <div class="form-outline mb-4">
              <input type="password" id="typePasswordX-2" name="senhaUsuario" class="form-control form-control-lg" />
              <label class="form-label" for="typePasswordX-2">Senha</label>
            </div>

           <div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
                    <button type="submit"  class="btn btn-primary btn-lg">Registrar</button>
                  </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>             
        
        
             
                       <!-- ======= EXPORTAÇÕEs ======= -->
  <!-- Vendor JS Files -->
  <script src="assets/vendor/purecounter/purecounter_vanilla.js"></script>
  <script src="assets/vendor/aos/aos.js"></script>
  <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="assets/vendor/glightbox/js/glightbox.min.js"></script>
  <script src="assets/vendor/isotope-layout/isotope.pkgd.min.js"></script>
  <script src="assets/vendor/swiper/swiper-bundle.min.js"></script>
  <script src="assets/vendor/typed.js/typed.min.js"></script>
  <script src="assets/vendor/waypoints/noframework.waypoints.js"></script>
  <script src="assets/vendor/php-email-form/validate.js"></script>

  <!-- Template Main JS File -->
  <script src="assets/js/main.js"></script>
    </body>
</html>
