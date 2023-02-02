<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<title>Phiếu nhập</title>
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
                <li class="breadcrumb-item active">Phiếu nhập</li>
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
                    <h3 class="mt-3"><b>Danh sách phiếu nhập</b></h3>
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
                        <th>Mã Phiếu Nhập</th>
                        <th>Mã Người Nhập</th>
                        <th>Thời điểm nhập</th>
                        <th>Nhà cung cấp</th>
                        
                        <th>Thao Tác</th>
                      </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="item" items="${dspn}">
                        <tr>
                     	 <td>${item.maPhieuNhap}</td>
						<td class="text-center">${item.maNguoiNhap}</td>
						<td>${item.thoiDiemNhap}</td>
						<td>${item.nhaNCC.tenNCC}</td>
					
                        <td>
                          <div class="d-flex justify-content-between px-4">
                             <a class="" href="/webbanhoa/quan-tri/tao-phieu-nhap/${item.maPhieuNhap}?linkEdit" ><i
                                class="fas fa-edit"></i>
                            </a>     
                            <a class="" href="webbanhoa/quan-tri/chi-tiet-phieu-nhap${item.maPhieuNhap}" id="expand">
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
            <h4 class="modal-title">Thêm phiếu nhập</h4>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <div class="modal-body">
                <form:form action="webbanhoa/quan-tri/tao-phieu-nhap" class="form-horizontal" id="formLogin" method="post" 
		             modelAttribute="phieuNhap">
                    <div class="row">
                    <div class="col-md-12">
                    
                        <div class="form-group row">
                          <label for="inputName" class="col-sm-2 col-form-label">Nhà cung cấp</label>
                          <div class="col-sm-10">
                            <form:select class="form-control form-select select2bs4" path="nhaNCC.maNCC" items="${ListNCC}" 
			 					itemValue="maNCC" itemLabel="tenNCC"/> 
                          </div>
                        </div>
                        
                        <div class="form-group row">
                          <label for="inputName" class="col-sm-2 col-form-label">Người nhập</label>
                          <div class="col-sm-10">
                            <form:select class="form-control form-select select2bs4" path="maNguoiNhap" items="${ListQLActive}" 
			 					itemValue="maQL" itemLabel="ten"/> 
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
            <h4 class="modal-title">Sửa phiếu nhập ${phieuNhap.maPhieuNhap}</h4>
            <a href="/webbanhoa/quan-tri/tao-phieu-nhap" class="close" aria-label="Close"><span aria-hidden="true">&times;</span></a>
          </div>
          <div class="modal-body">
            <div class="row">
              <!-- /.col -->
              <div class="col-md-12">

                 <form:form action="webbanhoa/quan-tri/tao-phieu-nhap" class="form-horizontal" id="formLogin" method="post" 
		             modelAttribute="phieuNhap">
                    <div class="row">
                    <div class="col-md-12">
                    <input name="maPhieuNhap" hidden="true" value="${phieuNhap.maPhieuNhap}">
                    <input name="thoiDiem" hidden="true" value="${phieuNhap.thoiDiemNhap}" >
                        <div class="form-group row">
                          <label for="inputName" class="col-sm-2 col-form-label">Nhà cung cấp</label>
                          <div class="col-sm-10">
                            <form:select class="form-control form-select select2bs4" path="nhaNCC.maNCC" items="${ListNCC}" 
			 					itemValue="maNCC" itemLabel="tenNCC"/> 
                          </div>
                        </div>
                        
                        <div class="form-group row">
                          <label for="inputName" class="col-sm-2 col-form-label">Người nhập</label>
                          <div class="col-sm-10">
                            <form:select class="form-control form-select select2bs4" path="maNguoiNhap" items="${ListQLActive}" 
			 					itemValue="maQL" itemLabel="ten"/> 
                          </div>
                        </div>
                        
                      </div>
                    </div>

			           <div class="modal-footer justify-content-between">
			            <button name="btnEdit" class="btn bg-secondary">Lưu thay đổi</button>
			            <a href="/webbanhoa/quan-tri/tao-phieu-nhap" 
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



  
<script>
    // Click Open Img
    $(document).on('click', '[data-toggle="lightbox"]', function (event) {
      event.preventDefault();
      $(this).ekkoLightbox();
    });

    // Datatable
   $(document).ready(function () {
        $('#tablePN').DataTable({
            columnDefs: [{ orderable: false, targets: 5 }],
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