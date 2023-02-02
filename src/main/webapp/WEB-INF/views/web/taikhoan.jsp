<!-- Header start  -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<style>
<%@include file="/resources/user/css/style_acc.css"%>
</style>

<!-- Header End -->

<!-- breadcrums section start -->
  <section class="breadcrumb_section container">
    <nav aria-label="breadcrumb">
        <ol class="breadcrumb">
          <li class="breadcrumb-item"><a href="#">Home</a></li>
          <li class="breadcrumb-item active" aria-current="page">Account Settings</li>
        </ol>
      </nav>
  </section>
  <!-- breadcrums section end -->

  <!-- start account section -->

  <section class="container">

    <div class="row">

      <div class="col-md-8 col-xl-8 col-sm-12 wrapper bg-white">
        <h4 class="pb-4 border-bottom"><b>Account settings</b></h4>
        <div class="mb-3 mt-3"><h5>Personal information</h5></div>
        <div class="d-flex align-items-start py-3 border-bottom">
            <img src="https://images.pexels.com/photos/1037995/pexels-photo-1037995.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500"
                class="img" alt="">
            <div class="pl-sm-4 pl-2" id="img-section">
                <b>Profile Photo</b>
                <p>Accepted file type .png. Less than 1MB</p>
                <button class="btn" style="border: solid #085B45 1px; color: #085B45;"><b>Upload</b></button>
            </div>
        </div>
        <form:form action="/webbanhoa/tai-khoan" method="post" modelAttribute="khachhang" class="py-2">

            <div class="row py-2">
                <div class="col-md-6">
                    <label for="firstname">First Name</label>
                    <form:input path="ten" type="text" class="bg-light form-control" placeholder="Steve"  value="${user.khachHang.ten}"/>
                </div>
                <div class="col-md-6 pt-md-0 pt-3">
                    <label for="lastname">Last Name</label>
                    <form:input path="ho" type="text" class="bg-light form-control" placeholder="Smith" value="${user.khachHang.ho}"/>
                </div>
            </div>
            <div class="row py-2">
                <div class="col-md-6">
                    <label for="email">Gender</label>
                    <form:input path="gioiTinh" type="text" class="bg-light form-control" placeholder="Nam" value=" ${user.khachHang.gioiTinh == false ? 'Female' : 'Male' }"/>
                    
                </div>
                <div class="col-md-6 pt-md-0 pt-3">
                    <label for="phone">Phone Number</label>
                    <form:input path="sdt" type="tel" class="bg-light form-control" placeholder="+1 213-548-6015" value="${user.khachHang.sdt}"/>
                </div>
            </div>
            
            <div class="row py-2">
                <div class="col-md">
                    <label for="country">Address</label>
                    <form:input path="diaChi" type="text" class="bg-light form-control" placeholder="97 Man Thien, phuong Hiep Phu, Tp Thu Duc" value="${user.khachHang.diaChi}"/>
                </div>
            </div>
            <hr>
            
            <div class="py-2">
              

            <div class="pt-3 d-flex justify-content-between">
                <button type="submit" class="btn mr-3 text-white" style="background-color: #085B45; color: white;">Save Changes</button>
                <!-- <button class="btn" style="border: solid #085B45 1px; color: #085B45;">Cancel</button> -->
            </div>
        </form:form>
       
        
      </div>
    </div>

    <div class=" container col-md-4 col-xl-4 col-sm-12 px-4 mb-4" style="background-color: #EAEFE0;">
      <div class="mb-3 pt-5"><h5><b>My Orders</b></h5></div>
      <hr>
      <!-- <div class="mb-2">Current Order: </div>
      
      <div class="card">
        <div class="card-header">
          Order ID <span style="color:#085B45">#23455678</span>
        </div>
        <div class="card-body">
          
          <div class="row align-items-center" style="clear: both;">
            <div class="col-3"><img class="img-fluid" src="https://i.pinimg.com/564x/38/6d/b4/386db4e109b97982550308463300a403.jpg"></div>
            <div class="col-3">
                <small class="row ">The Scorpio</small>
                <small class="row text-muted">Size: Original</small>
            </div>
            <div class="col-3 justify-content-center">
                <a href="#" class="text-muted text-right"><small class="">1</small></a>
            </div>
            <small class="col-3">44.00$</small>
          </div>
          <hr>
          <small class="float-left mt-2"><b>Estimated Delivery Time:</b><br>29 Nov 2022 </small>
          <small class="float-right text-right mt-2 mb-5"><b>Shipping By:</b><br>BLUEDART</small>
          <div class="card-text" style="clear: both;">
            <div class="track">
              <div class="step active"> <span class="icon"> <i class="fa fa-check"></i> </span> <small class="text">Order confirmed</small> </div>
              <div class="step active"> <span class="icon"> <i class="fa fa-truck"></i> </span> <small class="text"> On the way </small> </div>
              <div class="step "> <span class="icon"> <span class="material-symbols-outlined mt-2">
                local_florist
                </span> </span> <small class="text">Ready for pickup</small> 
              </div>
          </div>
          </div>

        </div>
        
      </div>
      <hr> -->
      <div class="mb-2">History: </div>
      <div class="card">
      	<table class="table table-hover" style="border: 0;">
      	<c:forEach var = "dh" items = "${dsdh}">
	      	<thead>
	      		<tr>
	      			<th>Order ID #${dh.maDonHang}</th>
	      		</tr>
		    </thead>
		    <tbody>
		    	<tr>
	      			<td class="d-flex flex-column justify-content-around">${TongSL} Bouquets
	      				<small class="text-muted">Date: ${dh.thoiDiemDat}</small>
	      			</td>
	      			<td>${dh.tongTien}</td>
	      		</tr>
	      		
		    </tbody>
		</c:forEach>
      </table>
      </div>
      
      <!-- <div class="card">
        <div class="card-header">
          Order ID <span style="color:#085B45">#23455678</span>
          <span class="badge badge-success">Delivered</span>
        </div>
        <div class="card-body">
          
          <div class="row align-items-center" style="clear: both;">
            <div class="col-3"><img class="img-fluid" src="https://i.pinimg.com/564x/38/6d/b4/386db4e109b97982550308463300a403.jpg"></div>
            <div class="col-3">
                <small class="row ">The Scorpio</small>
                <small class="row text-muted">Size: Original</small>
            </div>
            <div class="col-3 justify-content-center">
                <a href="#" class="text-muted text-right"><small class="">1</small></a>
            </div>
            <small class="col-3">44.00$</small>
          </div>
          
          </div>

        </div> -->
        
      </div>
      </div>
      
    </div>

    </div>

  </section>

 

  <!-- end account section -->

<!-- Footer -->

<!-- Footer End -->


<!-- JS Lib -->
<%@include file="/WEB-INF/views/web/include/jsLib.jsp"%>
<!-- JS Lib End -->