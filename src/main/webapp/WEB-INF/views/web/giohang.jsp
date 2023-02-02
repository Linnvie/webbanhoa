<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- Header start  
<%@ include file="/WEB-INF/views/web/include/header.jsp" %>
<style>
<%@include file="/resources/user/css/style_cart.css" %>
</style>

<!-- Header End -->
<!-- breadcrums section start -->
  <section class="breadcrumb_section container">
    <nav aria-label="breadcrumb">
        <ol class="breadcrumb">
          <li class="breadcrumb-item"><a href="#">Home</a></li>
          <li class="breadcrumb-item active" aria-current="page">Shopping Basket</li>
        </ol>
      </nav>
  </section>
  <!-- breadcrums section end -->

  <!-- start account section -->

  <section class="section_cart mb-5">
    <div class="card">
        <div class="row">
            <div class="col-md-8 cart">
                <div class="title">
                    <div class="row">
                        <div class="col"><h4><b>Basket</b></h4></div>
                        <div class="col align-self-center text-right" style="color:#568B57;">${TongSL} bouquets</div>
                    </div>
                </div>    
                <table class="table table-hover text-center">
				  <tbody>
				  	<c:forEach var = "cart" items = "${Cart}">
				  		<tr data-id="${cart.key}">
					   
					      <td style="vertical-align: middle;"><img class="img-fluid" src='<c:url value="/resources/file/${cart.value.sp.hinhAnh}"/>'></td>
					      <td style="vertical-align: middle;">
					      	<div class="col">
	                            <div class="row ">${cart.value.sp.tenSanPham}</div>
<%-- 	                            <div class="row text-muted">${cart.value.sp.size}</div> --%>
	                        </div>
					      </td>
					      <td style="vertical-align: middle;">
					      	<div class="col">
					      	
	       
	                       <input id="quanty-cart-${cart.key}" value="${cart.value.sLuong}" min="1" max="99" class="input-sl text-center" style="width: 30px; height: 30px; margin-top: 20px;"/>
	                        </div>
					      </td>
					      <td style="vertical-align: middle;">
					      	<div class="col">
					      	<fmt:setLocale value="vi_VN" /> <fmt:formatNumber minFractionDigits="0" 
													value="${cart.value.sp.giaBan}" type="currency" pattern = "###,### vnđ"
													currencySymbol="vnđ" />
					      	
					      	<a href="/webbanhoa/xoa-gio-hang/${cart.key}" class="close">&#10005;</a></div>
					      </td>
					    </tr>
				  	</c:forEach>

				  </tbody>
				</table>
                <div class="back-to-shop"><a href="/webbanhoa/trang-chu">&leftarrow;</a><span class="" style="color:#568B57;">Back to shop</span></div>
            </div>
            <div class="col-md-4 summary">
                <div><h5><b>Summary</b></h5></div>
                <hr>
                <div class="row">
                    <div class="col" style="padding-left:0; ">${TongSL} BOUQUETS</div>
                    <div class="col text-right">
                    <fmt:setLocale value="vi_VN" /> <fmt:formatNumber minFractionDigits="0" 
													value="${TongGia}" type="currency" pattern = "###,### vnđ"
													currencySymbol="vnđ" />
                    
                    </div>
                </div>
                <form>
                    <p>SHIPPING</p>
                    <select><option class="text-muted">Standard-Delivery</option></select>
                    <p>GIVE CODE</p>
                    <input id="code" placeholder="Enter your code">
                </form>
                <div class="row" style="border-top: 1px solid rgba(0,0,0,.1); padding: 2vh 0;">
                    <div class="col">TOTAL PRICE</div>
                    <div class="col text-right">
                     <fmt:setLocale value="vi_VN" /> <fmt:formatNumber minFractionDigits="0" 
													value="${TongGia}" type="currency" pattern = "###,### vnđ"
													currencySymbol="vnđ" />
               
                    </div>
                </div>
                <button  class="btn text-white" style="background-color: #085B45; color:white; border: 0;"><a  class="text-white"  href="/webbanhoa/thanh-toan">CHECKOUT</a></button>
            </div>
        </div>
        
    </div>
  </section>

<%-- <%@include file="/WEB-INF/views/web/include/footer.jsp"%> --%>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<script>
var sl;
var id;
var link;
$('.input-sl').blur(function() { 
	var tr = $(this).closest("tr");
	id = $(tr).data("id");
    sl = $("#quanty-cart-" + id).val();
    window.location = "sua-gio-hang/" + id + "/" + sl;
});

</script>
