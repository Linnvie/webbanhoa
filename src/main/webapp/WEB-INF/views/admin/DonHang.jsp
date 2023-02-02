<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<title>Đơn hàng</title>

<!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
      <!-- Content Header (Page header) -->
      <section class="content-header">
        <div class="container-fluid">
          <div class="row mb-2">
            <div class="col-sm-12">
              <ol class="breadcrumb ">
                <li class="breadcrumb-item">Quản lý</li>
                <li class="breadcrumb-item active">Đơn hàng</li>
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
                    <h3 class="mt-3"><b>Danh sách đơn hàng</b></h3>
                  </div>
              
                </div>
                <!-- /.card-header -->
                <div class="card-body">
                  <table id="tableDH" class="table table-bordered table-striped text-center" >
                    <thead class="bg-primary ">
                      <tr>
                        <th>Mã ĐH</th>
                        <th>Mã Khách hàng</th>
                        <th>Thời điểm đặt</th>
                        <th>SĐT giao</th>
                        <th>Địa chỉ giao</th>
                        <th>Trạng thái đơn</th>
                        <th>Tổng tiền</th>
                        <th>Thao Tác</th>
                      </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="item" items="${ListDonHang}">
                      <tr>
                        <td class="text-center">${item.maDonHang }</td>
                        <td>${item.maKhachHang }</td>   
                        <td class="text-center">${item.thoiDiemDat }</td>
                        <td class="text-center">${item.sdtGiaoHang }</td>
                        <td class="text-center">${item.diaChiGiao }</td>  
                        <td><span class="badge badge-warning">Đã giao ${item.maTinhTrangDon }</span></td>
                        <td><fmt:setLocale value="vi_VN" /> <fmt:formatNumber minFractionDigits="0" 
													value="${item.tongTien } " type="currency" pattern = "###,### vnđ"
													currencySymbol="vnđ" /></td>
                        <td>
                          <div class="d-flex justify-content-around px-4">
                            <a class="" href="/webbanhoa/quan-tri/ds-don-hang/${item.maDonHang}?linkDetail"><i
                                class="fas fa-info-circle"></i> </a>
                           
                            <a class="" href="#" data-toggle="modal" data-target="#exampleModalConfirm">
                                <i class="far fa-check-circle"></i> </a>
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

    <div class="modal fade in" id="modal-info-detail" isShow="${isOpenModalDetail}" data-keyboard="false" data-backdrop="static">
      <div class="modal-dialog modal-lg modal-dialog-scrollable">
        <div class="modal-content">
          <div class="modal-header bg-primary">
            <h4 class="modal-title">Thông tin đơn hàng</h4>
            <a href="/webbanhoa/quan-tri/ds-don-hang" class="close" aria-label="Close"><span aria-hidden="true">&times;</span></a>
            </button>
          </div>
          <div class="modal-body">
            <div class="row">
              <!-- /.col -->
              <div class="col-md-12">
                <form:form class="form-horizontal" action="/webbanhoa/quan-tri/ds-don-hang/${donHang.maDonHang}" id="formLogin" method="get"
						modelAttribute="donHang">
                    <div class="row">
  
                      <div class="col-md-12">
  
                        <div class="form-group row">
                          <label for="sdt" class="col-sm-2 col-form-label">Mã đơn hàng</label>
                          <div class="col-sm-10">
                          <form:input path="maDonHang" type="number" class="form-control"
								id="sdt" placeholder="0982365498" />
                          </div>
                        </div>
                        <div class="form-group row">
                          <label for="sdt" class="col-sm-2 col-form-label">Mã khách hàng</label>
                          <div class="col-sm-10">
                          <form:input path="maKhachHang" type="text" class="form-control"
								id="sdt" placeholder="0982365498" />
                          </div>
                        </div>
                         <div class="form-group row">
                          <label for="sdt" class="col-sm-2 col-form-label">Thời điểm đặt</label>
                          <div class="col-sm-10">
                          <form:input path="thoiDiemDat" type="text" class="form-control"
								id="sdt" placeholder="0982365498" />
                          </div>
                        </div>
                         <div class="form-group row">
                          <label for="sdt" class="col-sm-2 col-form-label">SĐT giao</label>
                          <div class="col-sm-10">
                          <form:input path="sdtGiaoHang" type="text" class="form-control"
								id="sdt" placeholder="0982365498" />
                          </div>
                        </div>
                         <div class="form-group row">
                          <label for="sdt" class="col-sm-2 col-form-label">Địa chỉ giao</label>
                          <div class="col-sm-10">
                          <form:input path="diaChiGiao" type="text" class="form-control"
								id="sdt" placeholder="0982365498" />
                          </div>
                        </div>
                        <div class="form-group row">
                          <label for="sdt" class="col-sm-2 col-form-label">Ghi chú</label>
                          <div class="col-sm-10">
                          <form:input path="ghiChu" type="text" class="form-control"
								id="sdt" placeholder="0982365498" />
                          </div>
                        </div>
                      <div class="form-group row">
                          <label for="sdt" class="col-sm-2 col-form-label">Người nhận</label>
                          <div class="col-sm-10">
                          <form:input path="nguoiNhan" type="text" class="form-control"
								id="sdt" placeholder="0982365498" />
                          </div>
                        </div>
                         <div class="form-group row">
                          <label for="sdt" class="col-sm-2 col-form-label">Trạng thái đơn</label>
                          <div class="col-sm-10">
                          <form:input path="maTinhTrangDon" type="text" class="form-control"
								id="sdt" placeholder="0982365498" />
                          </div>
                        </div>
                     <div class="form-group row">
                          <label for="sdt" class="col-sm-2 col-form-label">Tổng tiền</label>
                          <div class="col-sm-10">
                          <form:input path="tongTien" type="text" class="form-control"
								id="sdt" placeholder="0982365498" />
                          </div>
                        </div>
                        <div class="form-group ">
                            <label for="inputExperience" class=" col-form-label">Chi tiết đơn hàng</label>
                            <table id="table_detail" class="table table-bordered table-striped text-center">
                                <thead class="bg-primary">
                                  <tr>
                                    <th scope="col">Tên sản phẩm</th>
                                    <th scope="col">Hình ảnh</th>
                                    <th scope="col">Số lượng</th>
                                    <th scope="col">Đơn giá</th>
                                    
                                    
                                </thead>
                                <tbody>
                                 <c:forEach var="item" items="${listChiTiet}">
                                  <tr>
                                    <td>${item.sanPham.tenSanPham}</td>
                                    <td class="text-center"> <a href="https://i.pinimg.com/564x/a6/ed/a4/a6eda4f603f684811eee6aabd934c1ba.jpg" data-toggle="lightbox"
                                        data-title="The juliet"><img src="<c:url value="/resources/file/${item.sanPham.hinhAnh}"/>" alt="Product Image"
                                          class="img-size-50" /></a>
                                      </td>
                                    <td>${item.soLuong}</td>
                                    <td><fmt:setLocale value="vi_VN" /> <fmt:formatNumber minFractionDigits="0" 
													value=" ${item.giaTien} " type="currency" pattern = "###,### vnđ"
													currencySymbol="vnđ" /></td>  
                                  </tr>
 							  </c:forEach>
                                </tbody>
                              </table>
                          </div>
  
                      </div>
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

    <!-- Control Sidebar -->
    <aside class="control-sidebar control-sidebar-dark">
      <!-- Control sidebar content goes here -->
    </aside>
    <!-- /.control-sidebar -->
  </div>
  <!-- ./wrapper -->


<script>
    // Click Open Img
    $(document).on('click', '[data-toggle="lightbox"]', function (event) {
      event.preventDefault();
      $(this).ekkoLightbox();
    });

    // Datatable
    $(function () {
        $('#tableDH').DataTable({
            columnDefs: [{ orderable: false, targets: 5 }],
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


        $("#expand").click(function(){
            $("#PNDetail").toggle();
        });

    });

  </script>


<!-- JS Lib -->
<%@include file="/WEB-INF/views/admin/include/jsLib.jsp"%>
<!-- JS Lib End -->