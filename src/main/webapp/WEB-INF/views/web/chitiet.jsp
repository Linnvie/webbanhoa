<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!-- Header start  -->

<!-- Header End -->


<!-- breadcrums section start -->
  <section class="breadcrumb_section container">
    <nav aria-label="breadcrumb">
        <ol class="breadcrumb">
          <li class="breadcrumb-item"><a href="#">Home</a></li>
          <li class="breadcrumb-item"><a href="#">Flowers</a></li>
          
        </ol>
      </nav>
  </section>
  <!-- breadcrums section end -->

  <!-- start section detail -->
<c:forEach var="item" items="${sanpham}">
  <section class="detail_section mb-5" >
    <div class="container">
        <div class="row">
            <div class="col-md-12 col-xl-6 col-sm-12">
                <img src="<c:url value = '/resources/file/${item.hinhAnh}'/>" width="500px">
            </div>
            <div class="col-md-12 col-xl-6 col-sm-12">
                <h1 class="text-left"><strong>${item.tenSanPham}</strong></h1>
                <h2 class="">
               
                
           <fmt:setLocale value="vi_VN" /> <fmt:formatNumber minFractionDigits="0" 
													value="${item.giaBan}" type="currency" pattern = "###,### vnđ"
													currencySymbol="vnđ" />
                </h2>
                <hr>
                <h5 class="float-left" ><b>Description</b></h5>
                <!-- <button type="button" class="btn btn-primary" data-toggle="modal" data-target=".bd-example-modal-lg">Large modal</button> -->
                
                <p class="text-justify" style="clear: both;" >${item.moTa}</p>

                

                <a href="/webbanhoa/them-vao-gio-hang/${item.maSanPham}" class="btn text-center" style="width: 100%; padding: 18px 30px; background-color: #085B45; color: white;">Add to basket</a>
                
            </div>
        </div>
    </div>
  </section>
 </c:forEach>
  
  <!-- end section detail -->

  <!-- start suggest section -->

  <section class="suggest_section py-5" style="background-color: #FBEDE2;">
    
    <div class="container text-center">
      <h3 class="mb-5 float-left">YOU MAY ALSO LIKE</h3>
      <a href="" class="float-right" style="color: black;">View more <i class="fa-solid fa-arrow-right"></i></a>
      <div class="row" style="clear: both;">
        <div class="col-md-3 d-flex flex-column">
          <div class="img_container">
            <img src="https://i.pinimg.com/564x/e7/b8/ca/e7b8ca7632fd27a9b8b4d804c3b120fc.jpg"  style="object-fit:cover; width: 100%; max-height: 100%;">
          </div>
          <div class="d-flex flex-row justify-content-between px-2 py-2" style="background-color: #ffffff;">
            <div><strong>THE PEARL</strong></div>
            <div><strong>68$</strong></div>
        </div>
        <small class="text-right px-2 pb-2" style="background-color: #ffffff;">Hand Delivery</small>
        </div>
        <div class="col-md-3 d-flex flex-column">
          <div class="img_container">
            <img src="https://i.pinimg.com/564x/44/0e/94/440e94187b13346c498e982d9a65d33e.jpg"  style="object-fit:cover; width: 100%; max-height: 100%;">
          </div>
          <div class="d-flex flex-row justify-content-between px-2 py-2" style="background-color: #ffffff;">
            <div><strong>THE MANHATTAN</strong></div>
            <div><strong>68$</strong></div>
        </div>
        <small class="text-right px-2 pb-2" style="background-color: #ffffff;">Overnight Shipping</small>
        </div>
        <div class="col-md-3 d-flex flex-column">
          <div class="img_container">
            <img src="https://i.pinimg.com/564x/20/54/7c/20547cb2b09cb3207d2bcfb869ef9c78.jpg"  style="object-fit:cover; width: 100%; max-height: 100%;">
          </div>
          <div class="d-flex flex-row justify-content-between px-2 py-2" style="background-color: #ffffff;">
            <div><strong>THE MORELLO</strong></div>
            <div><strong>68$</strong></div>
        </div>
        <small class="text-right px-2 pb-2" style="background-color: #ffffff;">Only 5 Left</small>
        </div>
        <div class="col-md-3 d-flex flex-column">
          <div class="img_container">
            <img src="https://i.pinimg.com/564x/ba/03/2c/ba032c502caedd1d4a83467112e56560.jpg"  style="object-fit:cover; width: 100%; max-height: 100%;">
          </div>
          <div class="d-flex flex-row justify-content-between px-2 py-2" style="background-color: #ffffff;">
            <div><strong>THE SCORPIO</strong></div>
            <div><strong>68$</strong></div>
        </div>
        <small class="text-right px-2 pb-2" style="background-color: #ffffff;">Hand Delivery</small>
        </div>
      </div>
      <!-- <a href="#" class="d-inline-block mt-5 mb-5" style="color:#000000; border: solid #000000 2px; padding: 16px 30px; border-radius: 30px; width: 180px;">VIEW MORE</a> -->
    </div>
  </section>

  <!-- end suggest section -->

  <!-- start care section -->
  <section class="section_care mb-5 mt-5">
    <div class="container d-flex flex-column justify-content-center">
      <h5 class="text-center" style="font-size: 13px;">ROSES</h5>
      <h3 class="text-center">CARE INSTRUCTIONS</h3>
      <div class="text-center" style="width: 750px; margin: auto; font-size: 13px;">Roses are delivered with guard petals still attached — these protect the roses in transit and can be easily removed. They may appear lighter in color or have spots (this is normal!). Trim stems at an angle and fill vase with water. For the longest vase life, continue trimming stems at an angle as well as removing extra leaves when refreshing your arrangement. Please display in an area safely out of your pet's reach.</div>  
    </div>
    <div class="row">
      <div class="col-md-6 col-xl-6" style="overflow: hidden;" >
        <img class="container" src="https://bouqs.com/media/W1siZiIsIjIwMTkvMTAvMTMvMjMvNDkvMDAvNmJkNWIyN2YtZGM3Zi00ZTQ4LWIyNmYtZmQyZWIzMzBmNGEwL3Jvc2VzX0ZvY2FsQ2FyZV93YXRlcmNvbG9yNy5qcGciXSxbInAiLCJ0aHVtYiIsIjc3NHg0NjAiXV0/roses_FocalCare_watercolor7.jpg?sha=785be4fd24a4a863" width="500px">
      </div>
      <div class="col-md-6 col-xl-6" style="transform: translateY(25%);">
        <div class="d-flex flex-row">
          <div><span class="material-symbols-outlined" style="font-size: 60px; margin-right: 10px">
            light_mode
            </span></div>
          <div>
            <div style="font-size: 13px;">LIGHT</div>
            <h5>INDIRECT</h5>
            <p style="font-size: 13px;">When the path of sunlight reaching your plant is not direct, or is filtered by something else (ex: sheer curtains).</p>
          </div> 
        </div>
        <div class="d-flex flex-row">
          <div><span class="material-symbols-outlined" style="font-size: 60px; margin-right: 10px">
            water_drop
            </span></div>
          <div>
            <div style="font-size: 13px;">WATER</div>
            <h5>EVERY 2-3 DAYS FULL</h5>
            <p style="font-size: 13px;">Keep your vase filled with water. Water should be changed every 2 to 3 days.</p>
          </div> 
        </div>
      </div>
    </div>
    

  </section>
  <!-- end care section -->

  <!-- modal section start -->
  <!-- Large modal -->


<div class="modal fade bd-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
        <div class="modal-header">
            <h5 class="modal-title" id="exampleModalCenterTitle">Modal title</h5>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
        </div>
        <div class="modal-body">
            ...
        </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
            <button type="button" class="btn btn-primary">Save changes</button>
          </div> 
    </div>
  </div>
</div>

  <!-- modal section end -->


<!-- Footer -->

<!-- Footer End -->


<!-- JS Lib -->
<%@include file="/WEB-INF/views/web/include/jsLib.jsp"%>
<!-- JS Lib End -->