<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Header start  -->

<!-- Header End -->


<!-- breadcrums section start -->
  <section class="breadcrumb_section container">
    <nav aria-label="breadcrumb">
        <ol class="breadcrumb">
          <li class="breadcrumb-item"><a href="#">Home</a></li>
          <li class="breadcrumb-item active" aria-current="page">Flowers</li>
        </ol>
      </nav>
  </section>
  <!-- breadcrums section end -->

  <section class="mb-4">
    <div class="py-4 text-center d-flex justify-content-center align-items-center" style="height: 150px; background-image: url(https://media.urbanstems.com/image/upload/f_auto/v1644430329/Blog/ShopAll_banner_ylypk9.jpg); background-size: cover; background-repeat: no-repeat;">
      <h2 class="mb-2" style="vertical-align: middle;">FLOWERS</h2>
    </div>
  </section>

  <!-- start section all flowers -->

  <section class="all_section">
    <div class="container text-center">
        
        
        <div class="row" style="clear:both;">
        	<c:forEach var="item" items="${loai}">
        	<a href = "/webbanhoa/chi-tiet-san-pham/${item.maSanPham}">
            <div class="product_item col-md-6 d-flex flex-column" style="height:40%;">
                <div class="div_img" style="width:100%; height:60%; object-fit:cover">
                    <img class="flower-img"  src="<c:url value = '/resources/file/${item.hinhAnh}'/>">
                   
                </div>
                <div class="d-flex flex-row justify-content-between px-2 py-2" style="background-color: #FBEDE2;">
                 </a>
                    <div><strong>
                    ${item.tenSanPham}
                    
                    </strong></div>
                    
                    <div><strong>
                    <fmt:setLocale value="vi_VN" /> <fmt:formatNumber minFractionDigits="0" 
													value="${item.giaBan}" type="currency" pattern = "###,### vnđ"
													currencySymbol="vnđ" />
                    </strong></div>
                   
                </div>
                <small class="text-right px-2 pb-2" style="background-color: #FBEDE2;">Hand Delivery</small>
                
            </div>
            </c:forEach>
        </div>
        
        
    </div>
  </section>

  <!-- end section all flowers -->


  <section class="container mt-lg-5">
    <h4 class="h4">Farm-Fresh Flowers In Modern Arrangements</h4>
    <p class="text-justify">
        There’s no question that flowers have become a staple when it comes to freshening up your living space or just letting someone know you’re thinking about them. But nobody enjoys a bouquet with a short vase life. Luckily for all the flower lovers out there, The Bouqs Co. has you covered. We source our flowers from the highest quality sustainable farms. This means your bouquets are delivered farm-fresh, so they last a long time and maintain a lush, vibrant appearance. Because who likes a wilted Bouq? Not us!
        <br>Do you work from home and love flowers? Download one of our flower backgrounds for Zoom.
    </p>
    <h4>Artisan Crafted Floral Arrangements</h4>
    <p class="mb-lg-5 text-justify">
        Our vibrant arrangements are designed by florists who care about quality and variety. You can choose from different assortments of the freshest roses, tulips, peonies, lilies, and more! If you're wondering which type of flower to send, check out our wonderful selection. Need flowers delivered today? We offer same-day delivery in some ZIP codes when you order by noon in your recipient's time zone!
    </p>
  </section>


<!-- Footer -->

<!-- Footer End -->


<!-- JS Lib -->
<%@include file="/WEB-INF/views/web/include/jsLib.jsp"%>
<!-- JS Lib End -->