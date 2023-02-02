<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!-- Header start  -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- Bootstrap styles -->
<link href='<c:url value = "/resources/assets/css/bootstrap.css"/>' rel="stylesheet"/>
<!-- Customize styles -->
<link href='<c:url value = "/resources/style.css"/>' rel="stylesheet"/>
<!-- font awesome styles -->
<link href='<c:url value = "/resources/assets/font-awesome/css/font-awesome.css"/>' rel="stylesheet">
<!-- Favicons -->
 <link rel="shortcut" href="/resources/assets/ico/favicon.ico">
<!-- Header End -->

<div class="hero_area">
  
    
    <!-- slider section -->
    <section class=" slider_section position-relative">
      <div class="container">
        <div class="row">
          <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
            <div class="carousel-inner">
              <div class="carousel-item">
                <div class="col-lg-8 col-md-8">
                  <div class="detail_box">
                    <h1>
                      A bouquet for every occasions
                    </h1>
                    <p class="text-white" style="font-size:15px;">
                      Want to send your congratulations, condolences, or your love and support?<br>
                      No matter the message you want to share, we have a bouquet for you.
                    </p>
                    <div>
                      <a href="">VIEW OCCASIONS</a>
                    </div>
                  </div>
                </div>
              </div>
              <div class="carousel-item  active">
                <div class="col-lg-8 col-md-8">
                  <div class="detail_box">
                    
                    <h1>
                      Welcome to <span style="color: rgb(255, 94, 94)">violette!</span>
                    </h1>
                    <p class="text-white" style="font-size:15px;">
                      Just living is not enough...one must have sunshine, freedom and a little flower.
                    </p>
                    <div>
                      <a href="">SHOP ALL FLOWERS</a>
                    </div>
                  </div>
                </div>
              </div>
              
            </div>
            <div class="carousel_btn-container">
              <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                <span class="sr-only">Previous</span>
              </a>
              <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                <span class="sr-only">Next</span>
              </a>
            </div>
          </div>
        </div>
      </div>

    </section>
    <!-- end slider section -->
  </div>

  <!-- start section suggest -->
  <section class="suggest_section">
    
    <div class="container text-center">
      <h1 class="mb-5"><strong>CATEGORY</strong></h1>
      
  </section>
  <!-- end section suggest -->

<div class="row">
<ul style="margin-right:20px; list-style-type:none;font-size:20px">
	<c:forEach var="item" items="${category}">
	
		<li> <a href = "/webbanhoa/category/${item.maLoaiSP}">${item.tenLoaiSP}</a></li>
	
	</c:forEach>
</ul>
  <!-- start category section -->
 <div class="well well-small">

	<section class="category_section">
    <div class="container mb-5">
      <div class="row">
        <c:forEach var="item" items="${sanpham}">
        <div class="col-md-4 d-flex flex-column" >
        <a href = "/webbanhoa/chi-tiet-san-pham/${item.maSanPham}">
          <div class="img_container">
            <img  src="<c:url value = '/resources/file/${item.hinhAnh}'/>"  style="object-fit:cover; width: 100%; max-height: 100%;">
          </div>     
          <div class="p-4" style="background-color:#FBEDE2; font-size: 20px;">${item.tenSanPham}<span><i class="bi bi-arrow-right"></i></span></div>
         </a>
          <div class="p-4" style="background-color:#FBEDE2;color:#CC0000; font-size: 20px;">
      
           <fmt:setLocale value="vi_VN" /> <fmt:formatNumber minFractionDigits="0" 
													value="${item.giaBan}" type="currency" pattern = "###,### vnđ"
													currencySymbol="vnđ" />
          <span><i class="bi bi-arrow-right"></i></span>
          <a href = "them-vao-gio-hang/${item.maSanPham}"> <i class="fa fa-shopping-cart" style="font-size:48px;color:red"></i></a>
          </div>
          
        </div>
        </c:forEach>
        
      </div>
    </div>
  </section>
 
 </div>
 </div>


  <!-- about section -->
  <section class="about_section ">
    <div class="" style="background-color:#FBEDE2;">
      <div class="row">
        <div class="col-md-7 col-xl-7">
          <div class="img-box">
            <img src="https://plus.unsplash.com/premium_photo-1661963622692-caef07f23a2c?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80" alt="" />
          </div>
        </div>
        <div class="col-md-5 col-xl-5 position-relative" style="top:0; left: 0;">
          <div class="detail_box position-absolute" style="top: 50%; left: 50%; transform:translate(-50%, -50%);">
            <h1 class="text-center">Our Story</h1>
            <p class="text-justify" style="font-size: 13px;">
              Violette's philosophy is simple: care about people, the planet, and the process of growing flowers. We believe in farm-direct, transparent sourcing, which means partnering with farmers who use sustainable growing practices like minimizing waste and recycling water. The end result? No more middlemen! Flowers stay fresher, longer — for birthdays, anniversaries, new beginnings, or just because.
            </p>
            <a href="#" class="d-flex justify-content-center " style="border:solid #86A48E; padding:15px 35px; border-radius:40px; color: #86A48E; font-size:15px;">LEARN MORE</a>
          </div>
        </div>

      </div>
    </div>
  </section>
  <!-- end about section -->
  <!-- end category section -->

  <!-- start subscribe section -->
  <section class="subscribe_section text-white" style="background-color:#FBEDE2; height: 500px;">
    <div class="card p-4" style="position:absolute; top: 50%; left:10%; transform:translate(-10%, -50%); background-color: #86A48E;">
      <div class="card-body">
        <h4 class="card-title">SUBSCRIBE TODAY</h4>
        <h1>30% Off Sitewide</h1>
        <p class="card-text">Celebrate our birthday with MAJOR holiday savings! Use code HBD30.</p>
        <a href="#" class="btn" style="background-color:#144B3C; padding: 15px 30px; border-radius: 30px; color: #ffffff;">SUBSCRIBE</a>
      </div>
    </div>
    
  </section>
  <!-- end subscribe section -->

  <!-- start follow us -->
  <section class="follow_section layout_padding">
    <div class="container text-center">
      <h1>Follow Along</h1>
      <div>Stay up-to-date by following us on Instagram <span style="color:#86A48E;">@deviolette</span></div>
      <div class="row mt-5">
        <div class="col-md-2 img_container" style="height: 170px;">
          <img src="https://i.pinimg.com/564x/16/2f/dd/162fdd6d323b74d828770ced428dfa6e.jpg" style="object-fit:cover; width: 100%; max-height: 100%;">
        </div>
        <div class="col-md-2 imgcontainer"  style="height: 170px;">
          <img src="https://i.pinimg.com/564x/b8/cf/16/b8cf16dca9b9cc3692cd86738e3e7fc5.jpg" style="object-fit:cover; width: 100%; max-height: 100%;">
        </div>
        <div class="col-md-2 img_container"  style="height: 170px;">
          <img src="https://i.pinimg.com/564x/e2/c0/8e/e2c08e570490ab6ec81303e78ec05209.jpg" style="object-fit:cover; width: 100%; max-height: 100%;">
        </div>
        <div class="col-md-2 img_container"  style="height: 170px;">
          <img src="https://i.pinimg.com/564x/37/af/90/37af902a030d1065cb8915d5758c2e81.jpg" style="object-fit:cover; width: 100%; max-height: 100%;">
        </div>
        <div class="col-md-2 img_container"  style="height: 170px;">
          <img src="https://i.pinimg.com/564x/4f/48/b5/4f48b53b7f5317ca5255a8685839f930.jpg" style="object-fit:cover; width: 100%; max-height: 100%;">
        </div>
        <div class="col-md-2 img_container"  style="height: 170px;">
          <img src="https://i.pinimg.com/564x/d5/ba/07/d5ba07cec5134c42e3965b2273b50522.jpg" style="object-fit:cover; width: 100%; max-height: 100%;">
        </div>
      </div>
    </div>
  </section>
  <!-- end follow us -->


<!-- JS Lib -->
<%@include file="/WEB-INF/views/web/include/jsLib.jsp"%>
<!-- JS Lib End -->