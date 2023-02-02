<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<title>Phiếu xuất</title>
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
                <li class="breadcrumb-item active">Phiếu xuất</li>
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
                    <h3 class="mt-3"><b>Danh sách phiếu xuất</b></h3>
                  </div>
                  <div class="col-md-2">
                  <form:form action="/webbanhoa/quan-tri/tao-phieu-xuat" id="formLogin" method="post"
						modelAttribute="phieuXuat">
						<button type="submit" class="btn bg-primary mt-2">Tạo phiếu xuất mới</button>
					</form:form>
                  
<!--                     <button type="submit" class="btn bg-primary mt-2" data-toggle="modal" -->
<!--                       data-target="#modal-add-new"><i class="fas fa-plus mr-2"></i>Thêm mới</button> -->
<!--                   </div> -->

                </div>
                <!-- /.card-header -->
                <div class="card-body">
                  <table id="tablePN" class="table table-bordered table-striped text-center" >
                    <thead class="bg-primary ">
                      <tr>
                        <th>Mã Phiếu xuất</th>
                        <th>Ngày</th>
                        <th>Thao Tác</th>
                      </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="item" items="${dspx}">
                        <tr>
                     	 <td>${item.maPhieuXuatSP}</td>
						<td class="text-center">${item.ngay}</td>
						<td class="text-center">
                          <div class="d-flex justify-content-around px-4">    
                            <a class="" href="webbanhoa/quan-tri/chi-tiet-phieu-xuat${item.maPhieuXuatSP}" id="expand">
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
<script>
    // Click Open Img
    $(document).on('click', '[data-toggle="lightbox"]', function (event) {
      event.preventDefault();
      $(this).ekkoLightbox();
    });

    // Datatable
    $(function () {
        $('#tablePN').DataTable({
            columnDefs: [{ orderable: false, targets: 2 }],
            "responsive": true,
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

