<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<title>Danh sách sản phẩm</title>
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
                <li class="breadcrumb-item active">Sản phẩm</li>
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
                <div class="card-header row">
                  <div class="col-md-10">
                    <h3 class="mt-3"><b>Danh sách sản phẩm</b></h3>
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
                        <th>Mã sản phẩm</th>
						<th>Phân loại sản phẩm</th>
						<th>Tên sản phẩm</th>
						<th>Tồn kho</th>
						<th>Hình ảnh</th>
						<th>Gía gốc</th>
						<th>Gía bán</th>
                        <th>Thao Tác</th>
                      </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="item" items="${dssp}">
                        <tr>
                     	 <td>${item.maSanPham}</td>
						<td>${item.loaiSP.tenLoaiSP}</td>
						<td>${item.tenSanPham}</td>
						<td>${item.tonKho}</td>
						<td class="text-center"><a
												href="resources/file/${item.hinhAnh}"
												data-toggle="lightbox"><img
													src="<c:url value="/resources/file/${item.hinhAnh}"/>"
													alt="Product Image" class="img-size-50" /></a></td>
						<td><fmt:setLocale value="vi_VN" /> <fmt:formatNumber minFractionDigits="0" 
													value="${item.giaGoc}" type="currency" pattern = "###,### vnđ"
													currencySymbol="vnđ" /></td>
						<td><fmt:setLocale value="vi_VN" /> <fmt:formatNumber minFractionDigits="0" 
													value="${item.giaBan}" type="currency" pattern = "###,### vnđ"
													currencySymbol="vnđ" /></td>
                        <td>
                          <div class="d-flex justify-content-between px-4">
                             <a class="" href="/webbanhoa/quan-tri/ds-san-pham${item.maSanPham}?linkEdit" ><i
                                class="fas fa-edit"></i>
                            </a>     
                            <a class="" href="/webbanhoa/quan-tri/chi-tiet-sp${item.maSanPham}" id="expand">
                              <i class="fas fa-plus-circle"></i> </a>
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
            <h4 class="modal-title">Thêm sản phẩm</h4>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <div class="modal-body">
          		<form:form action="/webbanhoa/quan-tri/ds-san-pham" class="form-horizontal" id="formLogin" method="post"
					modelAttribute="sanPham" enctype="multipart/form-data">
                    <div class="row">
                    <div class="col-md-12">
                    
                        <div class="form-group row">
                          <label for="inputName" class="col-sm-2 col-form-label">Phân loại sản phẩm</label>
                          <div class="col-sm-10">
                            <form:select class="form-control form-select select2bs4" path="loaiSP.maLoaiSP" items="${ListLoaiSP}"
								itemValue="maLoaiSP" itemLabel="tenLoaiSP"/> 
                          </div>
                        </div>
                          <div class="form-group row">
                          <label for="tenSanPham" class="col-sm-2 col-form-label">Tên sản phẩm</label>
                          <div class="col-sm-10">
                          <form:errors path="tenSanPham" cssClass="text-danger" />
							<p class="text-danger" id="errors"></p>
                          <form:input path="tenSanPham" type="text" class="form-control"
								id="tenSanPham" placeholder="Bó hoa hồng cho ngày lãng mạn" />
                          </div>
                        </div>
                        <div class="form-group row">
                          <label for="giaGoc" class="col-sm-2 col-form-label">Gía gốc</label>
                          <div class="col-sm-10">
                          <form:errors path="giaGoc" cssClass="text-danger" />
							<p class="text-danger" id="errors"></p>
                          <form:input path="giaGoc" type="tel" class="form-control"
								id="giaGoc" placeholder="480000" />
                          </div>
                        </div>
                        <div class="form-group row">
                          <label for="giaBan" class="col-sm-2 col-form-label">Gía bán</label>
                          <div class="col-sm-10">
                          <form:errors path="giaBan" cssClass="text-danger" />
							<p class="text-danger" id="errors"></p>
                          <form:input path="giaBan" type="number" class="form-control"
								id="giaBan" placeholder="450000" />
                          </div>
                        </div>
                        <div class="form-group row">
                          <label for="moTa" class="col-sm-2 col-form-label">Mô tả</label>
                          <div class="col-sm-10">
                          <form:errors path="moTa" cssClass="text-danger" />
							<p class="text-danger" id="errors"></p>
                          <form:textarea id="editor" rows="4" path="moTa" type="text" class="form-control"
								 placeholder="Description" />
                          </div>
                        </div>
                        
                        
                        <div class="form-group row">
                        <label for="tenSanPham" class="col-sm-2 col-form-label">Hình ảnh</label>
                        <div class="col-sm-10">
                          <input name="anh" type="file" class="form-control" height="4000px"
										id="userName" placeholder="Hình ảnh" />
                        </div>
                        
                      </div>
                    
  					<div class="modal-footer justify-content-between">
			            <button type="button" class="btn btn-default" data-dismiss="modal">Đóng</button>
			            <button name="btnAdd" class="btn bg-primary">Lưu</button>
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
            <h4 class="modal-title">Sửa thông tin sản phẩm ${sanPham.maSanPham}</h4>
             <a href="/webbanhoa/quan-tri/ds-san-pham" class="close" aria-label="Close"><span aria-hidden="true">&times;</span></a>
       
          </div>
          <div class="modal-body">
            <div class="row">
              <!-- /.col -->
              <div class="col-md-12">

             
                <form:form class="form-horizontal" action="/webbanhoa/quan-tri/ds-san-pham${sanPham.maSanPham}" id="formLogin" method="post"
						modelAttribute="sanPham" enctype="multipart/form-data">
                    <div class="row">
  						<div class="col-md-12">
  						<input name="maSanPham" hidden="true" value="${sanPham.maSanPham}">
                        <div class="form-group row">
                          <label for="inputName" class="col-sm-2 col-form-label">Phân loại sản phẩm</label>
                          <div class="col-sm-10">
                            <form:select class="form-control form-select select2bs4" path="loaiSP.maLoaiSP" items="${ListLoaiSP}"
								itemValue="maLoaiSP" itemLabel="tenLoaiSP"/> 
                          </div>
                        </div>
                          <div class="form-group row">
                          <label for="tenSanPham" class="col-sm-2 col-form-label">Tên sản phẩm</label>
                          <div class="col-sm-10">
                          <form:errors path="tenSanPham" cssClass="text-danger" />
							<p class="text-danger" id="errors"></p>
                          <form:input path="tenSanPham" type="text" class="form-control"
								id="tenSanPham" placeholder="Bó hoa hồng cho ngày lãng mạn" />
                          </div>
                        </div>
                        <div class="form-group row">
                          <label for="giaGoc" class="col-sm-2 col-form-label">Gía gốc</label>
                          <div class="col-sm-10">
                          <form:errors path="giaGoc" cssClass="text-danger" />
							<p class="text-danger" id="errors"></p>
                          <form:input path="giaGoc" type="tel" class="form-control"
								id="giaGoc" placeholder="480000" />
                          </div>
                        </div>
                        <div class="form-group row">
                          <label for="giaBan" class="col-sm-2 col-form-label">Gía bán</label>
                          <div class="col-sm-10">
                          <form:errors path="giaBan" cssClass="text-danger" />
							<p class="text-danger" id="errors"></p>
                          <form:input path="giaBan" type="number" class="form-control"
								id="giaBan" placeholder="450000" />
                          </div>
                        </div>
                        <div class="form-group row">
                          <label for="moTa" class="col-sm-2 col-form-label">Mô tả</label>
                          <div class="col-sm-10">
                          <form:errors path="moTa" cssClass="text-danger" />
							<p class="text-danger" id="errors"></p>
                          <form:textarea id="editor1" rows="4" path="moTa" type="text" class="form-control"
								 placeholder="12, Nguyễn Đình Chiểu, phường ĐaKao quận 1, HCM" />
                          </div>
                        </div>
                        
                        <div class="form-group row">
                        <label for="tenSanPham" class="col-sm-2 col-form-label">Hình ảnh</label>
                        <div class="col-sm-10">
                        <div class="text-center">
										<img id="modal-update-avatar"
											class="profile-user-img img-fluid img-circle"
											src="<c:url value="/resources/file/${sanPham.hinhAnh}"/>" alt="product picture"
											style="width: 120px;" />
									</div>
                          <input name="anh" type="file" class="form-control" height="4000px"
										id="userName" placeholder="Hình ảnh"  />
                        </div>
                        
                      </div>
                        
                      </div>
                    </div>
 					 <div class="modal-footer justify-content-between">
			            <button name="btnEdit" class="btn bg-secondary">Lưu thay đổi</button>
			            <a href="/webbanhoa/quan-tri/ds-san-pham" 
															class="mx-2 btn btn-secondary">Hủy</a>
			          </div>
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
    <div class="modal fade " id="image" tabindex="-1" aria-labelledby="exampleModalDelete"
      aria-hidden="true">
      <div class="modal-dialog ">
        <div class="modal-content">
          <div class="modal-header bg-danger">
            <h5 class="modal-title" id="exampleModalLabel"><i class="fas fa-trash-alt"></i>
              &nbsp; Hình ảnh sản phẩm
            </h5>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
				<div class="modal-footer d-flex justify-content-between">
					<input type="text" name="maNCC" id="input-delete-hinh" value="" hidden />
					<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Đóng</button>
				</div>

        </div>
      </div>
    </div>
    <!-- /.modal  confirm mở-->
  <script src="https://cdn.ckeditor.com/4.20.1/standard/ckeditor.js"></script>
    <script>
    // Click Open Img
    $(document).on('click', '[data-toggle="lightbox"]', function (event) {
      event.preventDefault();
      $(this).ekkoLightbox();
    });

    // Datatable
   $(document).ready(function () {
        $('#tablePN').DataTable({
            columnDefs: [{ orderable: false, targets: 7 }],
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
  <script>
   
  		CKEDITOR.replace( 'editor1' );
      CKEDITOR.replace( 'editor' );
  </script>
