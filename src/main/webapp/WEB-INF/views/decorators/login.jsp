<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- Header start  -->
<%@include file="/WEB-INF/views/web/include/header.jsp"%>
<!-- Header End -->
<!-- Section: Design Block -->
<section class="">
  <!-- Jumbotron -->
  <div class="px-4 py-5 px-md-5 text-lg-start" style="background-image: url(https://images.unsplash.com/photo-1554494583-c4e1649bfe71?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80); background-size: contain;">
    <div class="container">
      <div class="row gx-lg-5 align-items-start">
        <div class="col-lg-7 mb-5 mb-lg-0">
          <h4 class="my-5 display-3 fw-bold ls-tight text-white">
            Fresh flowers <br />
            <span class="">for any special occasion</span>
          </h4>
          
        </div>

        <div class="col-lg-5 mb-5 mb-lg-0">
          <div class="card">
            <div class="card-body py-5 px-md-5">
              <h2 class="mb-5 text-center">Welcome back!</h2>
              ${message}
              <form:form action="dang-nhap" id="formLogin" method="post" modelAttribute="taiKhoanLogin">
                
                
                <!-- Email input -->
                <div class="form-outline mb-4">
                  <form:input path="email" type="email" class="form-control" id="form3Example3" placeholder="Email"/>
						</br>
						<form:errors path="email" cssClass="text-danger"/>
						<p class="text-danger" id="email.errors"></p>
                </div>

                <!-- Password input -->
                <div class="form-outline mb-4">
                  <form:input path="matKhau" type="password" class="form-control" id="form3Example4" placeholder="Mật khẩu"/>
						</br>
						<form:errors path="matKhau" cssClass="text-danger"/>
						<p class="text-danger" id="matKhau.errors"></p>
                </div>

                <!-- Checkbox -->
                <div class="form-check d-flex justify-content-around mb-4" style="font-size:15px;">
                  <div>
                    <input class="form-check-input me-2" type="checkbox" value="" id="form2Example33"/>
                  <label class="form-check-label" for="form2Example33">
                    Remember me
                  </label>
                  </div>
                  
                  <div style="color: #144B3C;"><a href="/webbanhoa/quen-mat-khau">Forget password?</a></div>
                </div>

                <!-- Submit button -->
                <button type="submit" class="btn btn-block mb-4 text-white" style="background-color:#144B3C">
                  Sign in
                </button>

                <!-- Register buttons -->
                <div class="text-center">
                  <small>or sign in with:</small><br>
                  <button type="button" class="btn btn-floating mx-1">
                    <i class="fab fa-facebook-f"></i>
                  </button>

                  <button type="button" class="btn btn-floating mx-1">
                    <i class="fab fa-google"></i>
                  </button>

                  <button type="button" class="btn btn-floating mx-1">
                    <i class="fab fa-twitter"></i>
                  </button>

                  
                </div>
                <p class="mt-4 text-center">Don't have an account? <a href="/webbanhoa/dang-ki" class="link-info" style="color:#86A48E">Signup</a></p>
              </form:form>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <!-- Jumbotron -->
</section>
<!-- Section: Design Block -->

  <!-- end login section -->

  <!-- Footer -->
<%@include file="/WEB-INF/views/web/include/footer.jsp"%>
<!-- Footer End -->


<!-- JS Lib -->
<%@include file="/WEB-INF/views/web/include/jsLib.jsp"%>
<!-- JS Lib End -->
</body>

</html>

















    
<!-- <!DOCTYPE html> -->
<!-- <html> -->
<!-- <head> -->
<!-- <meta charset="UTF-8"> -->
<!-- <title>Đăng nhập</title> -->
<!-- <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css"> -->
<!-- 	<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script> -->
<!-- 	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script> -->
<!-- <style type="text/css"> -->

<!-- /* 	body#LoginForm { */ -->
<!-- /* 	background-image: */ -->
<!-- /* 		url("https://hdwallsource.com/img/2014/9/blur-26347-27038-hd-wallpapers.jpg"); */ -->
<!-- /* 	background-repeat: no-repeat; */ -->
<!-- /* 	background-position: center; */ -->
<!-- /* 	background-size: cover; */ -->
<!-- /* 	padding: 10px; */ -->
<!-- /* } */ -->

<!-- /* .form-heading { */ -->
<!-- /* 	color: #fff; */ -->
<!-- /* 	font-size: 23px; */ -->
<!-- /* } */ -->

<!-- /* .panel h2 { */ -->
<!-- /* 	color: #444444; */ -->
<!-- /* 	font-size: 18px; */ -->
<!-- /* 	margin: 0 0 8px 0; */ -->
<!-- /* } */ -->

<!-- /* .panel p { */ -->
<!-- /* 	color: #777777; */ -->
<!-- /* 	font-size: 14px; */ -->
<!-- /* 	margin-bottom: 30px; */ -->
<!-- /* 	line-height: 24px; */ -->
<!-- /* } */ -->

<!-- /* .login-form .form-control { */ -->
<!-- /* 	background: #f7f7f7 none repeat scroll 0 0; */ -->
<!-- /* 	border: 1px solid #d4d4d4; */ -->
<!-- /* 	border-radius: 4px; */ -->
<!-- /* 	font-size: 14px; */ -->
<!-- /* 	height: 50px; */ -->
<!-- /* 	line-height: 50px; */ -->
<!-- /* } */ -->

<!-- /* .main-div { */ -->
<!-- /* 	background: #ffffff none repeat scroll 0 0; */ -->
<!-- /* 	border-radius: 2px; */ -->
<!-- /* 	margin: 10px auto 30px; */ -->
<!-- /* 	max-width: 38%; */ -->
<!-- /* 	padding: 50px 70px 70px 71px; */ -->
<!-- /* } */ -->

<!-- /* .login-form .form-group { */ -->
<!-- /* 	margin-bottom: 10px; */ -->
<!-- /* } */ -->

<!-- /* .login-form { */ -->
<!-- /* 	text-align: center; */ -->
<!-- /* } */ -->

<!-- /* .forgot a { */ -->
<!-- /* 	color: #777777; */ -->
<!-- /* 	font-size: 14px; */ -->
<!-- /* 	text-decoration: underline; */ -->
<!-- /* } */ -->
<!-- /* *[id$=.errors]{ */ -->
<!-- /* color:red; font-style: italic; */ -->
<!-- /* } */ -->

<!-- /* .login-form  .btn.btn-primary { */ -->
<!-- /* 	background: #f0ad4e none repeat scroll 0 0; */ -->
<!-- /* 	border-color: #f0ad4e; */ -->
<!-- /* 	color: #ffffff; */ -->
<!-- /* 	font-size: 14px; */ -->
<!-- /* 	width: 100%; */ -->
<!-- /* 	height: 50px; */ -->
<!-- /* 	line-height: 50px; */ -->
<!-- /* 	padding: 0; */ -->
<!-- /* } */ -->

<!-- /* .forgot { */ -->
<!-- /* 	text-align: left; */ -->
<!-- /* 	margin-bottom: 30px; */ -->
<!-- /* } */ -->

<!-- /* .botto-text { */ -->
<!-- /* 	color: #ffffff; */ -->
<!-- /* 	font-size: 14px; */ -->
<!-- /* 	margin: auto; */ -->
<!-- /* } */ -->

<!-- /* .login-form .btn.btn-primary.reset { */ -->
<!-- /* 	background: #ff9900 none repeat scroll 0 0; */ -->
<!-- /* } */ -->

<!-- /* .back { */ -->
<!-- /* 	text-align: left; */ -->
<!-- /* 	margin-top: 10px; */ -->
<!-- /* } */ -->

<!-- /* .back a { */ -->
<!-- /* 	color: #444444; */ -->
<!-- /* 	font-size: 13px; */ -->
<!-- /* 	text-decoration: none; */ -->
<!-- /* } */ -->
<!-- </style> -->
<!-- </head> -->
<!-- <body id="LoginForm"> -->
<%-- ${message} --%>
<!-- 	<div class="container"> -->
<!-- 		<!-- <h1 class="form-heading">login Form</h1> --> -->
<!-- 		<div class="login-form"> -->
<!-- 			<div class="main-div"> -->
<%-- 				<c:if test="${param.incorrectAccount != null}"> --%>
<!-- 					<div class="alert alert-danger">	 -->
<!-- 						 Sai tên đăng nhập hoặc mật khẩu! -->
<!-- 					</div> -->
<%-- 				</c:if> --%>
<%-- 				<c:if test="${param.accessDenied != null}"> --%>
<!-- 					<div class="alert alert-danger">	 -->
<!-- 						Bạn không có quyền Admin -->
<!-- 					</div> -->
<%-- 				</c:if> --%>
<%-- 				<form:form action="dang-nhap" id="formLogin" method="post" modelAttribute="taiKhoanLogin"> --%>
<!-- 					<div class="form-group"> -->
<%-- 						<form:input path="email" type="text" class="form-control" id="userName" placeholder="Email"/> --%>
<%-- 						<form:errors path="email" cssClass="text-danger"/> --%>
<!-- 						<p class="text-danger" id="email.errors"></p> -->
<!-- 					</div> -->

<!-- 					<div class="form-group"> -->
<%-- 						<form:input path="matKhau" type="password" class="form-control" id="password" placeholder="Mật khẩu"/> --%>
<%-- 						<form:errors path="matKhau" cssClass="text-danger"/> --%>
<!-- 						<p class="text-danger" id="matKhau.errors"></p> -->
<!-- 					</div> -->
<!-- 					<button type="submit" class="btn btn-primary" >Đăng nhập</button> -->
<%-- 				</form:form> --%>
<!-- 			</div> -->
<!-- 		</div> -->
<!-- 	</div> -->
	
<!-- </body> -->
<!-- </html> -->