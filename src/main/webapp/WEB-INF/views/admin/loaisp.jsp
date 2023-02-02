<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<title>Danh mục sản phẩm</title>
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
                <li class="breadcrumb-item active">Danh mục sản phẩm</li>
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
                    <h3 class="mt-3"><b>Danh sách loại sản phẩm</b></h3>
                  </div>
                  <div class="col-md-2">
                    <button type="submit" class="btn bg-primary mt-2" data-toggle="modal"
                      data-target="#modal-add-new"><i class="fas fa-plus mr-2"></i>Thêm mới</button>
                  </div>


                </div>
                <!-- /.card-header -->
                <div class="card-body">
                  <table id="tableNCC" class="table table-bordered table-striped text-center" >
                    <thead class="bg-primary ">
                      <tr>
                        <th scope="col">Mã loại sản phẩm</th>
                        <th scope="col">Tên loại sản phẩm</th>             
                        <th scope="col">Thao Tác</th>
                      </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="item" items="${dslsp}">
                      <tr>
                        <td>${item.maLoaiSP} </td>
                        <td class="text-center">${item.tenLoaiSP} </td>
                        <td>
                          <div class="d-flex justify-content-around px-4">
                            <a class="" href="/webbanhoa/quan-tri/loai-sp/${item.maLoaiSP}?linkEdit" ><i
                                class="fas fa-edit"></i>
                            </a>
                            <a class="" href="" data-delete="${item.maLoaiSP}" data-toggle="modal" data-target="#exampleModalDelete">
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
            <h4 class="modal-title">Thêm danh mục hàng</h4>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <div class="modal-body">
            <div class="row">
              <!-- /.col -->
              <div class="col-md-12">
                
                <form:form class="form-horizontal" action="/webbanhoa/quan-tri/loai-sp" id="formLogin" method="post"
						modelAttribute="loaiSP">
                    <div class="row">
  
                      <div class="col-md-12">
  
                        <div class="form-group row">
                          <label for="tenNCC" class="col-sm-2 col-form-label">Tên danh mục sản phẩm</label>
                          <div class="col-sm-10">
                          <form:errors path="tenLoaiSP" cssClass="text-danger" />
							<p class="text-danger" id="errors"></p> 
                          <form:input path="tenLoaiSP" type="text" class="form-control"
								id="tenLoaiSP" placeholder="Hoa cưới" />                      
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
            <h4 class="modal-title">Sửa danh mục sản phẩm ${loaiSP.tenLoaiSP}</h4>
             <a href="/webbanhoa/quan-tri/loai-sp" class="close" aria-label="Close"><span aria-hidden="true">&times;</span></a>
       
          </div>
          <div class="modal-body">
            <div class="row">
              <!-- /.col -->
              <div class="col-md-12">

             
                <form:form class="form-horizontal" action="/webbanhoa/quan-tri/loai-sp" id="formLogin" method="post"
						modelAttribute="loaiSP">
                    <div class="row">
  						<div class="col-md-12">
  						<input name="maLoaiSP" hidden="true" value="${loaiSP.maLoaiSP}">
                        <div class="form-group row">
                          <label for="tenLoaiSP" class="col-sm-2 col-form-label">Tên danh mục</label>
                          <div class="col-sm-10">
                          <form:errors path="tenLoaiSP" cssClass="text-danger" />
							<p class="text-danger" id="errors"></p> 
                           <form:input path="tenLoaiSP" type="text" class="form-control"
								id="tenLoaiSP" placeholder="Hoa hướng dương" />                       
                          </div>
                        </div>
                      </div>
                    </div>
 					 <div class="modal-footer justify-content-between">
			            <button name="btnEdit" class="btn bg-secondary">Lưu thay đổi</button>
			            <a href="/webbanhoa/quan-tri/loai-sp" 
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
    <div class="modal fade " id="exampleModalDelete" tabindex="-1" aria-labelledby="exampleModalDelete"
      aria-hidden="true">
      <div class="modal-dialog ">
        <div class="modal-content">
          <div class="modal-header bg-danger">
            <h5 class="modal-title" id="exampleModalLabel"><i class="fas fa-trash-alt"></i>
              &nbsp; Bạn chắc chắn muốn danh mục này?
            </h5>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <form action="/webbanhoa/quan-tri/loai-sp?linkDelete"  method="post">
				<div class="modal-footer d-flex justify-content-between">
					<input type="text" name="maLoaiSP" id="input-delete-lsp" value="" hidden />
					<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Đóng</button>
						<button type="submit" class="btn btn-danger" >Xóa</button>
				</div>
			</form>
        </div>
      </div>
    </div>
    <!-- /.modal  confirm mở-->
<script>
    // Click Open Img
    $(document).on('click', '[data-toggle="lightbox"]', function (event) {
      event.preventDefault();
      $(this).ekkoLightbox();
    });

    // Datatable
   $(document).ready(function () {
        $('#tableNCC').DataTable({
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
