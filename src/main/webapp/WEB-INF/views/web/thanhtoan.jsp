<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Header start  -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%-- <%@ include file="/WEB-INF/views/web/include/header.jsp" %> --%>
<style>
<%@include file="/resources/user/css/style_cart.css" %>
</style>
<!-- Header End -->


<!-- breadcrums section start -->
  <section class="breadcrumb_section container">
    <nav aria-label="breadcrumb">
        <ol class="breadcrumb">
          <li class="breadcrumb-item"><a href="#">Home</a></li>
          <li class="breadcrumb-item"><a href="#">Shopping Basket</a></li>
          <li class="breadcrumb-item active" aria-current="page">Checkout</li>
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
                        <div class="col"><h4><b>Checkout</b></h4></div>
                        <div class="col align-self-center text-right" style="color:#568B57;">${TongSL} bouquets</div>
                    </div>
                </div>
                <table class="table table-hover text-center">
                	<tbody>
                		<c:forEach var = "cart" items = "${Cart}">
				  		<tr>
					    
					      <td style="vertical-align: middle;"><img class="img-fluid" src='<c:url value="/resources/file/${cart.value.sp.hinhAnh}"/>'></td>
					      <td style="vertical-align: middle;">
					      	<div class="col">
	                            <div class="row ">${cart.value.sp.tenSanPham}</div>
<%-- 	                            <div class="row text-muted">${cart.value.sp.size}</div> --%>
	                        </div>
					      </td>
					      <td style="vertical-align: middle;">
					      	<div class="col">
					      	
	       
	                       <div id ="quanty-cart-${cart.key}"  class="input-sl text-center" style="width: 30px; height: 30px; margin-top: 20px;">${cart.value.sLuong}</div>
	                        </div>
					      </td>
					      <td style="vertical-align: middle;">
					      	<div class="col">
					      	<fmt:setLocale value="vi_VN" /> <fmt:formatNumber minFractionDigits="0" 
													value="${cart.value.sp.giaBan}" type="currency" pattern = "###,### vnđ"
													currencySymbol="vnđ" />
					   
					      </td>
					    </tr>
				  	</c:forEach>
                	</tbody>
                </table>    
               
               
                <div class="mt-5 d-flex flex-column justify-content-end ">
                    <div>
                        <h5 class="float-left" style="clear: both;">TOTAL PRICE</h5>
                        <h5 class="float-right mr-3">
                        <fmt:setLocale value="vi_VN" /> <fmt:formatNumber minFractionDigits="0" 
													value="${TongGia}" type="currency" pattern = "###,### vnđ"
													currencySymbol="vnđ" />
                        </h5>
                    </div>
                    
                    
                </div>
               
                <!-- <button type="submit" name="thanhtoan" class="float-right px-5 py-2 mt-4 mr-3" style="background-color: #085B45; border: 0; color: #ffffff">PURCHASE</button> -->
            
            </div>
            <div class="col-md-4 summary">
               
               
              
                <div class="mt-5">
                  <div class="mb-3"><h5><b>Address</b></h5></div>
                  <hr>
                  <div>
                    <!-- <div style="font-size: 13px;">Send to your address</div> -->
                    <!-- <select id="option-address" class="form-select" aria-label="Default select example" style="margin: 0; font-size: 13px; height: 40px; border-radius: 5px; ">
                      <option selected  value="3">79 Tavistock DrTuckerton, New Jersey(NJ)</option>
                      <option value="3" >Add new address...</option>
                    </select> -->
                  </div>
                  <div class="new_address">
                    <!-- <small class="text-muted">Please enter your new address</small> -->
                    <form:form  action="/webbanhoa/thanh-toan" class="form-horizontal" role="form" style="padding-top: 5px;" method="post" modelAttribute="dh">
                      <fieldset >
                        <!-- Text input-->
                        <%-- <div class="form-group" style="margin: 0;">
                          <small class=" control-label" for="textinput">Line 1</small>
                          <div class="">
                            <form:input path="" type="text" placeholder="Address Line 1" class="form-control" style="margin: 0; font-size: 13px;"/>
                          </div>
                        </div> --%>
              
                        <!-- Text input-->
                        <div class="form-group" style="margin: 0;">
                          <small class="" control-label" for="textinput">Recipient's Name</small>
                          <div class="">
                            <form:input path="nguoiNhan" type="text" placeholder="My Linh" class="form-control" style="margin: 0; font-size: 13px;"/>
                          </div>
                        </div>
              
                        <!-- Text input-->
                        <div class="form-group" style="margin: 0;">
                          <small class=" control-label" for="textinput">Detail Address</small>
                          <div class="">
                            <form:input path="diaChiGiao" type="text" placeholder="97 Man Thien, phuong Hiep Phu, Thanh pho Thu Duc" class="form-control" style="margin: 0; font-size: 13px;"/>
                          </div>
                        </div>
              
                        <div class="form-group" style="margin: 0;">
                          <small class=" control-label" for="textinput">Phone Number</small>
                          <div class="">
                            <form:input path="sdtGiaoHang" type="text" placeholder="+84-392-648-746" class="form-control" style="margin: 0; font-size: 13px;"/>
                          </div>
                        </div>
							<button  type="submit" class="btn px-5 py-2 mt-4 mr-3" style="background-color: #085B45; border: 0; color: #ffffff">PURCHASE</button>
                      </fieldset>
                    </form:form>
                  </div>
                  
                  <div class="send_gift" style="display: none;">
                    <small class="text-muted">Please enter recipient's address</small>
                    <form class="form-horizontal" role="form" style="padding-top: 5px;">
                      <fieldset >
                        <!-- Text input-->
                        <div class="form-group" style="margin: 0;">
                          <small class=" control-label" for="textinput">Line 1</small>
                          <div class="">
                            <input type="text" placeholder="Address Line 1" class="form-control" style="margin: 0; font-size: 13px;">
                          </div>
                        </div>
              
                        <!-- Text input-->
                        <div class="form-group" style="margin: 0;">
                          <small class=" control-label" for="textinput">Line 2</small>
                          <div class="">
                            <input type="text" placeholder="Address Line 2" class="form-control" style="margin: 0; font-size: 13px;">
                          </div>
                        </div>
              
                        <!-- Text input-->
                        <div class="form-group" style="margin: 0;">
                          <small class=" control-label" for="textinput">City</small>
                          <div class="">
                            <input type="text" placeholder="City" class="form-control" style="margin: 0; font-size: 13px;">
                          </div>
                        </div>
              
                        <!-- Text input-->
                        <div class="form-group" style="margin: 0;">
                          <small class=" control-label" for="textinput">State</small>
                          <div class="">
                            <input type="text" placeholder="State" class="form-control" style="margin: 0; font-size: 13px;">
                          </div>
                        </div>

                        <div class="form-group" style="margin: 0;">
                          <small class=" control-label" for="textinput">Phone Number</small>
                          <div class="">
                            <input type="text" placeholder="+84-392-648-746" class="form-control" style="margin: 0; font-size: 13px;">
                          </div>
                        </div>

                      </fieldset>
                    </form>
                  </div>
                </div>
            </div>
        </div>
        
    </div>
  </section>

  <!-- end account section -->
<%-- <%@include file="/WEB-INF/views/web/include/footer.jsp"%> --%>
<script>
	$("#btn-gift").click(function(){
		  $(".send_gift").toggle();
	});
</script>