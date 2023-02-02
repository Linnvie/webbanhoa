 <%@ page language="java" contentType="text/html; charset=UTF-8" 
   pageEncoding="UTF-8"%> 
     <%@ include file="/WEB-INF/views/common/taglib.jsp" %> 
<!-- <!DOCTYPE html> -->
<!-- <html> -->
<!-- <head> -->
<!-- <meta charset="UTF-8"> -->
<%-- <title><dec:title default="Trang chủ" /></title> --%>
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"> -->
<!-- </head> -->
<!-- <body> -->
<!-- <h1>trang chủ admin</h1> -->

<%@include file = "/WEB-INF/views/tagLib/tagLib.jsp"%>
<!DOCTYPE html>
<html>
  <head>
  <base href="${pageContext.servletContext.contextPath}">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title><dec:title default="Quản lí" /></title>
  
    <!-- Google Font: Source Sans Pro -->
    <link rel="stylesheet"
      href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
    <!-- Font Awesome Icons -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="<c:url value="/resources/admin/plugins/fontawesome-free/css/all.min.css"/>">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
    <!-- IonIcons -->
    <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
    <!-- DataTables -->
    <link rel="stylesheet" href="<c:url value="/resources/admin/plugins/datatables-bs4/css/dataTables.bootstrap4.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/admin/plugins/datatables-responsive/css/responsive.bootstrap4.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/admin/plugins/datatables-buttons/css/buttons.bootstrap4.min.css"/>">
    <!-- ekko-lightbox show img -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ekko-lightbox/5.3.0/ekko-lightbox.css"
      integrity="sha512-Velp0ebMKjcd9RiCoaHhLXkR1sFoCCWXNp6w4zj1hfMifYB5441C+sKeBl/T/Ka6NjBiRfBBQRaQq65ekYz3UQ=="
      crossorigin="anonymous" referrerpolicy="no-referrer" />
    <!-- Theme style -->
    <link rel="stylesheet" href="<c:url value="/resources/admin/dist/css/custom-1.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/admin/dist/css/adminlte.min.css"/>">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"
	integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ=="
	crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.8.0/chart.min.js"
	integrity="sha512-sW/w8s4RWTdFFSduOTGtk4isV1+190E/GghVffMA9XczdJ2MDzSzLEubKAs5h0wzgSJOQTRYyaz73L3d6RtJSg=="
	crossorigin="anonymous" referrerpolicy="no-referrer"></script>
	<style type="text/css">
	*[id$=.errors]{
		color:red; font-style: italic;
		}
	</style>
  </head>

<body class="hold-transition sidebar-mini">
  <div class="wrapper"> 
    <%@include file="/WEB-INF/views/admin/include/header.jsp"%> 
 	<dec:body/> 
 	<footer class="main-footer">
      <div class="float-right d-none d-sm-block">
        <b>Version</b> 1.0.0
      </div>
      <strong>Copyright &copy; 2014-2022 <a href="https://adminlte.io">AdminLTE.io</a>.</strong> All rights reserved.
    </footer>
   </div> 
  <!-- ./wrapper -->
   <%@include file="/WEB-INF/views/admin/include/jsLib.jsp"%>	
</body>
</html>