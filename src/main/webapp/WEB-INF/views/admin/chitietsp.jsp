<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<title>Chi tiết sản phẩm</title>
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
      <!-- Content Header (Page header) -->
      <section class="content-header">
        <div class="container-fluid">
          <div class="row mb-2">
            <div class="col-sm-12">
          <h1>${message}</h1>
              <ol class="breadcrumb ">
                <li class="breadcrumb-item">Quản lý</li>
                <a href="/webbanhoa/quan-tri/ds-san-pham"><li class="breadcrumb-item ">Danh sách sản phẩm</li></a>
                <li class="breadcrumb-item active">Chi tiết sản phẩm</li>         
              </ol>
            </div>
            <div class="col-sm-6">

            </div>

          </div>
        </div><!-- /.container-fluid -->
      </section>

      <!-- Main content -->
      <section class="content">
        <div class="container-fluid">
          <div class="row">
            <div class="col-12">

              <div class="card">
              
              <div id="PNDetail">
                  <br>
                    <h3 class="mb-2 float-left"><b>Sản phẩm ${maSanPham}</b></h3>
                    
                    <table id="table_detail" class="table table-bordered table-striped text-center">
                        <thead class="bg-primary">
                          <tr>
                            <th scope="col">Mã sản phẩm</th>
                            <th scope="col">Phân loại sản phẩm</th>
                            <th scope="col">Tên sản phẩm</th>
                            <th scope="col">Tồn kho</th>
                            <th scope="col">Hình ảnh</th>
                            <th scope="col">Gía gốc</th>
                            <th scope="col">Gía bán</th>
                            </tr>
                        </thead>
                        <tbody>
                          <tr>
                            <td>${sanPham.maSanPham}</td>
							<td>${sanPham.loaiSP.tenLoaiSP}</td>
							<td>${sanPham.tenSanPham}</td>
							<td>${sanPham.tonKho}</td>
							<td class="text-center"><a
												href="resources/file/${sanPham.hinhAnh}"
												data-toggle="lightbox"><img
													src="<c:url value="/resources/file/${sanPham.hinhAnh}"/>"
													alt="Product Image" class="img-size-50" /></a></td>
						<td><fmt:setLocale value="vi_VN" /> <fmt:formatNumber minFractionDigits="0" 
													value="${sanPham.giaGoc}" type="currency" pattern = "###,### vnđ"
													currencySymbol="vnđ" /></td>
						<td><fmt:setLocale value="vi_VN" /> <fmt:formatNumber minFractionDigits="0" 
													value="${sanPham.giaBan}" type="currency" pattern = "###,### vnđ"
													currencySymbol="vnđ" /></td>
                        
                          </tr>
                        </tbody>
                      </table>
                  </div>
                  <br>
      
                <div class="card-header row">
                  <div class="col-md-10">
                    <h3 class="mt-3"><b>Danh sách chi tiết sản phẩm </b></h3>
                  </div>
                  <div class="col-md-2">
                    <button type="submit" class="btn bg-primary mt-2" data-toggle="modal"
                      data-target="#modal-add-new"><i class="fas fa-plus mr-2"></i>Thêm mới</button>
                  </div>


                </div>
                <!-- /.card-header -->
                <div class="card-body">
                  <table id="tablePN" class="table table-bordered table-striped text-center" >
                    <thead class="bg-primary ">
                      <tr>
                        <th>Vật liệu</th>
						<th>Số lượng</th>
						<th>Thao tác</th>
                      </tr>
                    </thead>
                    <tbody>
                   <c:forEach var="item" items="${listSPChiTiet}">
                        <tr>
                     	<td>${item.vatLieu.tenVatLieu}</td>
						<td>${item.soLuong }</td>
						<td>
                          <div class="d-flex justify-content-between px-2">
                            <a class="" href="webbanhoa/quan-tri/chi-tiet-sp${item.sanPham.maSanPham}/${item.vatLieu.maVatLieu}?linkEdit"><i
                                class="fas fa-edit"></i>
                            </a>
                             <a class="" href="" data-delete="${item.vatLieu.maVatLieu}" data-toggle="modal" data-target="#exampleModalDelete">
                              <i class="fas fa-trash-alt"></i> </a>       

                          </div>
                        </td>
                      </tr>
                      </c:forEach>

                    </tbody>                 
                  </table>             
                  
                </div>
                <!-- /.card-body -->
              </div>
              <!-- /.card -->
            </div>
          </div>
          <!-- /.row -->

        </div>

      </section>
      <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->


    <div class="modal fade in" id="modal-add-new" isShow="${isOpenModalAdd}">
      <div class="modal-dialog modal-lg modal-dialog-scrollable">
        <div class="modal-content">
          <div class="modal-header bg-primary">
            <h4 class="modal-title">Thêm chi tiết sản phẩm</h4>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <div class="modal-body">
                <form:form action="webbanhoa/quan-tri/chi-tiet-sp${sanPham.maSanPham}" class="form-horizontal" id="formLogin" method="post" 
		             modelAttribute="chiTietSP">
		      
                    <div class="row">
                  <div class="col-md-12">
                    
                         <div class="form-group row">
                          <label for="" class="col-sm-2 col-form-label">Vật liệu</label>
                          <div class="col-sm-10">
                          <form:errors path="id.maVatLieu" cssClass="text-danger" />
							<p class="text-danger" id="errors"></p>
                            <form:select class="form-control form-select select2bs4" path="id.maVatLieu" items="${ListVatLieu}"
			 					itemValue="maVatLieu" itemLabel="tenVatLieu"/>
                          </div>
                        </div>
                        
                         <div class="form-group row">
                          <label for="soLuong" class="col-sm-2 col-form-label">Số lượng</label>
                          <div class="col-sm-10">
                          <form:errors path="soLuong" cssClass="text-danger" />
							<p class="text-danger" id="errors"></p>
                          <form:input path="soLuong" type="number" class="form-control"
								id="soLuong" placeholder="30" />
                          </div>
                        </div>
                        
                       </div> 
                    </div> 
   					<div class="modal-footer justify-content-between"> 
 			            <button type="button" class="btn btn-default" data-dismiss="modal">Đóng</button> 
 			            <button name="btnAdd" class="btn bg-secondary">Lưu</button> 
 			          </div> 
                   </form:form> 
              </div>
              <!-- /.col -->
            </div>
          </div>
        </div>
        <!-- /.modal-content -->
      </div>
      <!-- /.modal-dialog -->
    </div>
    <!-- /.modal -->



    <div class="modal fade in" id="modal-edit" isShow="${isOpenModalEdit}" data-keyboard="false" data-backdrop="static">
      <div class="modal-dialog modal-lg modal-dialog-scrollable">
        <div class="modal-content">
          <div class="modal-header bg-secondary">
            <h4 class="modal-title">Sửa chi tiết sản phẩm </h4>
             <a href="/webbanhoa/quan-tri/chi-tiet-sp${sanPham.maSanPham}" class="close" aria-label="Close"><span aria-hidden="true">&times;</span></a>
          </div>
          <div class="modal-body">
            <div class="row">
              <!-- /.col -->
              <div class="col-md-12">

                <form:form action="webbanhoa/quan-tri/chi-tiet-sp${sanPham.maSanPham}/${chiTietSP.id.maVatLieu}" class="form-horizontal" id="formLogin" method="post" 
		             modelAttribute="chiTietSP">
                    <div class="row">
  
                      <div class="col-md-12">
                      <input name="id.maSanPham" hidden="true" value="${sanPham.maSanPham}">
                       <div class="form-group row">
                          <label for="inputName" class="col-sm-2 col-form-label">Vật liệu</label>
                          <div class="col-sm-10">
                            <form:select readonly="true" class="form-control form-select select2bs4" path="id.maVatLieu" items="${ListVatLieu}"
			 					itemValue="maVatLieu" itemLabel="tenVatLieu" />
			 				
                          </div>
                        </div>
                        
                         <div class="form-group row">
                          <label for="soLuong" class="col-sm-2 col-form-label">Số lượng</label>
                          <div class="col-sm-10">
                          <form:errors path="soLuong" cssClass="text-danger" />
							<p class="text-danger" id="errors"></p>
                          <form:input path="soLuong" type="number" class="form-control"
								id="soLuong" placeholder="30" />
                          </div>
                        </div>
                      </div>
                    </div>
  						<div class="modal-footer justify-content-between">
			            <button name="btnEdit" class="btn bg-secondary">Lưu thay đổi</button>
			            <a href="/webbanhoa/quan-tri/chi-tiet-sp${sanPham.maSanPham}" 
															class="mx-2 btn btn-secondary">Hủy</a>
			          </div>
				 	  <input name="id.maPhieuNhap" hidden="true" value="${phieuNhap.maPhieuNhap}">
                  </form:form>
                        <!-- /.Info profile -->
              </div>
              <!-- /.col -->
            </div>
          </div>
        </div>
        <!-- /.modal-content -->
      </div>
      <!-- /.modal-dialog -->
    </div> 


    <!-- Modal mở -->
    <div class="modal fade " id="exampleModalDelete" tabindex="-1" aria-labelledby="exampleModalDelete"
      aria-hidden="true">
      <div class="modal-dialog ">
        <div class="modal-content">
          <div class="modal-header bg-danger">
            <h5 class="modal-title" id="exampleModalLabel"><i class="fas fa-trash-alt"></i>
              &nbsp; Bạn chắc chắn muốn xóa chi tiết sản phẩm này?
            </h5>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <form action="/webbanhoa/quan-tri/chi-tiet-sp${sanPham.maSanPham}/?linkDelete"  method="post">
				<div class="modal-footer d-flex justify-content-between">
					<input type="text" name="vatLieu.maVatLieu" id="input-delete-ctsp" value="" hidden />
					<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Đóng</button>
						<button type="submit" class="btn btn-danger" >Xóa</button>
				</div>
			</form>
        </div>
      </div>
      <h1>${message}</h1>
    </div>

<script>
    // Click Open Img
    $(document).on('click', '[data-toggle="lightbox"]', function (event) {
      event.preventDefault();
      $(this).ekkoLightbox();
    });

    // Datatable
   $(document).ready(function () {
        $('#tablePN').DataTable({
            columnDefs: [{ orderable: false, targets: 2 }],
            "responsive": true,
            "scrollX"   : true,
            "ordering": true,
            "autoWidth": false,
            "language": {
            "lengthMenu": "Hiện _MENU_ dòng mỗi trang",
            "zeroRecords": "Không có kết quả phù hợp",
            "info": "Trang _PAGE_ / _PAGES_",
            "infoEmpty": "Không tìm thấy kết quả",
            "infoFiltered": "(filtered from _MAX_ total records)",
            "loadingRecords": "Đang tải...",
            "search": "Tìm kiếm:",
            paginate: {
                previous: '‹',
                next: '›'
            }}
        });
    });

  </script>