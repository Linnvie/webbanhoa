<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- Header start  -->
<%@include file="/WEB-INF/views/web/include/header.jsp"%>
<!-- Header End -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng kí tài khoản</title>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<style type="text/css">
	body#LoginForm {
	background-image:
		url("https://hdwallsource.com/img/2014/9/blur-26347-27038-hd-wallpapers.jpg");
	background-repeat: no-repeat;
	background-position: center;
	background-size: cover;
	padding: 10px;
}
.form-heading {
	color: #fff;
	font-size: 23px;
}
.panel h2 {
	color: #444444;
	font-size: 18px;
	margin: 0 0 8px 0;
}
.panel p {
	color: #777777;
	font-size: 14px;
	margin-bottom: 30px;
	line-height: 24px;
}
.login-form .form-control {
	background: #f7f7f7 none repeat scroll 0 0;
	border: 1px solid #d4d4d4;
	border-radius: 4px;
	font-size: 14px;
	height: 50px;
	line-height: 50px;
}
.main-div {
	background: #ffffff none repeat scroll 0 0;
	border-radius: 2px;
	margin: 10px auto 30px;
	max-width: 38%;
	padding: 50px 70px 70px 71px;
}
.login-form .form-group {
	margin-bottom: 10px;
}
.login-form {
	text-align: center;
}
.forgot a {
	color: #777777;
	font-size: 14px;
	text-decoration: underline;
}
*[id$=.errors]{
color:red; font-style: italic;
}
.login-form  .btn.btn-primary {
	background: #f0ad4e none repeat scroll 0 0;
	border-color: #f0ad4e;
	color: #ffffff;
	font-size: 14px;
	width: 100%;
	height: 50px;
	line-height: 50px;
	padding: 0;
}
.forgot {
	text-align: left;
	margin-bottom: 30px;
}
.botto-text {
	color: #ffffff;
	font-size: 14px;
	margin: auto;
}
.login-form .btn.btn-primary.reset {
	background: #ff9900 none repeat scroll 0 0;
}
.back {
	text-align: left;
	margin-top: 10px;
}
.back a {
	color: #444444;
	font-size: 13px;
	text-decoration: none;
}
</style>
</head>
<body id="LoginForm">
${message}
	<div class="container">
		<!-- <h1 class="form-heading">login Form</h1> -->
		<div class="login-form">
			<div class="main-div">
				<form:form action="dang-ki" id="formLogin" method="post" modelAttribute="taiKhoanDangKi">
					<div class="form-group">
						<form:input path="email" type="text" class="form-control" id="userName" placeholder="Email"/>
						<form:errors path="email" cssClass="text-danger"/>
						<p class="text-danger" id="email.errors"></p>
					</div>

					<div class="form-group">
						<form:input path="matKhau" type="password" class="form-control" id="password" placeholder="Mật khẩu"/>
						<form:errors path="matKhau" cssClass="text-danger"/>
						<p class="text-danger" id="matKhau.errors"></p>
					</div>
					
					<div class="form-group">
						<input name="matKhauXacNhan" type="password" class="form-control" id="password" placeholder="Xác nhận mật khẩu"/>
						
					</div>
					
					<div class="form-group">
						<form:input path="khachHang.ho" type="text" class="form-control" id="password" placeholder="Họ"/>
						<form:errors path="khachHang.ho" cssClass="text-danger"/>
						<p class="text-danger" id="matKhau.errors"></p>
					</div>
					
					<div class="form-group">
						<form:input path="khachHang.ten" type="text" class="form-control" id="password" placeholder="Tên"/>
						<form:errors path="khachHang.ten" cssClass="text-danger"/>
						<p class="text-danger" id="matKhau.errors"></p>
					</div>
					
					<div class="form-group">
						<form:input path="khachHang.diaChi" type="text" class="form-control" id="password" placeholder="Địa chỉ"/>
						<form:errors path="khachHang.diaChi" cssClass="text-danger"/>
						<p class="text-danger" id="matKhau.errors"></p>
					</div>
					
					<div class="form-group">
						<form:input path="khachHang.sdt" type="text" class="form-control" id="password" placeholder="Số điện thoại"/>
						<form:errors path="khachHang.sdt" cssClass="text-danger"/>
						<p class="text-danger" id="matKhau.errors"></p>
					</div>
					<%-- <div class="form-group">
						 <form:input path="khachHang.ngaySinh" class="form-control" type="date" id="datepicker" placeholder="Ngày sinh"/>
					</div> --%>
					
					<div class="form_group">
						<label>Giới tính </label>
						<form:radiobutton path="khachHang.gioiTinh" value="true" label="Nam" />
						<form:radiobutton path="khachHang.gioiTinh" value="false" label="Nữ"/>
					</div>
					<button type="submit" class="btn btn-primary" >Đăng kí</button>
				</form:form>
			</div>
		</div>
	</div>
	 <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
  <script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
	    $("#datepicker").datepicker();
	  });
</script>
  <!-- Footer -->
<%@include file="/WEB-INF/views/web/include/footer.jsp"%>
<!-- Footer End -->


<!-- JS Lib -->
<%@include file="/WEB-INF/views/web/include/jsLib.jsp"%>
<!-- JS Lib End -->
</body>
</html>