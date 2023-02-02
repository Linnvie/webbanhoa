<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<title>Chi tiết phiếu xuất</title>
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
                <li class="breadcrumb-item "><a href="/webbanhoa/quan-tri/tao-phieu-xuat">Danh sách phiếu xuất</a></li>
                <li class="breadcrumb-item active">Chi tiết phiếu xuất</li>         
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
                    <h3 class="mb-2 float-left"><b>Phiếu xuất ${phieuXuat.maPhieuXuatSP}</b></h3>
                    
                    <table id="table_detail" class="table table-bordered table-striped text-center">
                        <thead class="bg-primary">
                          <tr>
                            <th scope="col">Mã phiếu xuất</th>
                            <th scope="col">Thời điểm</th>
                        </thead>
                        <tbody>
                          <tr>
                            <td>${phieuXuat.maPhieuXuatSP}</td>
							<td>${phieuXuat.ngay}</td>
                          </tr>
                        </tbody>
                      </table>
                  </div>
                  <br>
      
                <div class="card-header row">
                  <div class="col-md-10">
                    <h3 class="mt-3"><b>Danh sách chi tiết phiếu xuất </b></h3>
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
                        <th>Sản phẩm</th>
						<th>Số lượng</th>
						<th>Thao tác</th>
                      </tr>
                    </thead>
                    <tbody>
                   <c:forEach var="item" items="${listChiTiet}">
                        <tr>
                     	<td>${item.sanPham.tenSanPham}</td>
						<td>${item.soLuong }</td>
                        <td>
                          <div class="d-flex justify-content-between px-4">
                            <a class="" href="webbanhoa/quan-tri/chi-tiet-phieu-xuat${phieuXuat.maPhieuXuatSP}/${item.sanPham.maSanPham}?linkEdit"><i
                                class="fas fa-edit"></i>
                            </a>
                             <a class="" href="" data-delete="${item.sanPham.maSanPham}" data-toggle="modal" data-target="#exampleModalDelete">
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
            <h4 class="modal-title">Thêm chi tiết phiếu xuất</h4>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <div class="modal-body">
		        <form:form action="webbanhoa/quan-tri/chi-tiet-phieu-xuat${phieuXuat.maPhieuXuatSP}" class="form-horizontal" id="formLogin" method="post"
					modelAttribute="chiTietPhieuXuat">
		      
                    <div class="row">
                  <div class="col-md-12">
                    
                         <div class="form-group row">
                          <label for="" class="col-sm-2 col-form-label">Sản phẩm</label>
                          <div class="col-sm-10">
                          <form:errors path="id.maSP" cssClass="text-danger" />
							<p class="text-danger" id="errors"></p>
							<form:select class="form-control form-select select2bs4" path="id.maSP" items="${ListSP}"
								itemValue="maSanPham" itemLabel="tenSanPham"/>
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
                        
                        <input name="slCu" hidden="true" value="${slCu}">
						<input name="id.maPhieuXuatSP" hidden="true" value="${phieuXuat.maPhieuXuatSP}">      
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
            <h4 class="modal-title">Sửa chi tiết phiếu nhập </h4>
             <a href="/webbanhoa/quan-tri/chi-tiet-phieu-xuat${phieuXuat.maPhieuXuatSP}" class="close" aria-label="Close"><span aria-hidden="true">&times;</span></a>
          </div>
          <div class="modal-body">
            <div class="row">
              <!-- /.col -->
              <div class="col-md-12">

                <form:form action="webbanhoa/quan-tri/chi-tiet-phieu-xuat${phieuXuat.maPhieuXuatSP}/${chiTietPhieuXuat.id.maSP}" class="form-horizontal" id="formLogin" method="post" 
		             modelAttribute="chiTietPhieuXuat">
                    <div class="row">
  
                      <div class="col-md-12">
                       <div class="form-group row">
                          <label for="" class="col-sm-2 col-form-label">Sản phẩm</label>
                          <div class="col-sm-10">
                          <form:errors path="id.maSP" cssClass="text-danger" />
							<p class="text-danger" id="errors"></p>
							<form:select class="form-control form-select select2bs4" path="id.maSP" items="${ListSP}"
								itemValue="maSanPham" itemLabel="tenSanPham"/>
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
			            <a href="/webbanhoa/quan-tri/chi-tiet-phieu-xuat${phieuXuat.maPhieuXuatSP}" 
															class="mx-2 btn btn-secondary">Hủy</a>
			          </div>
			          <input name="slCu" hidden="true" value="${slCu}">
				 	  <input name="id.maPhieuXuatSP" hidden="true" value="${phieuXuat.maPhieuXuatSP}">
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
              &nbsp; Bạn chắc chắn muốn xóa chi tiết phiếu xuất này?
            </h5>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <form action="/webbanhoa/quan-tri/chi-tiet-phieu-xuat${phieuXuat.maPhieuXuatSP}?linkDelete"  method="post">
				<div class="modal-footer d-flex justify-content-between">
					<input type="text" name="sanPham.maSanPham" id="input-delete-ctpx" value="" hidden />
					<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Đóng</button>
						<button type="submit" class="btn btn-danger" >Xóa</button>
				</div>
			</form>
        </div>
      </div>
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
