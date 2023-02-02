<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<title>Khách hàng</title>
<!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
      <!-- Content Header (Page header) -->
      <section class="content-header">
        <div class="container-fluid">
          <div class="row mb-2">
            <div class="col-sm-12">
              <ol class="breadcrumb ">
                <li class="breadcrumb-item">Quản lý</li>
                <li class="breadcrumb-item active">Khách hàng</li>
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
                    <h3 class="mt-3"><b>Danh sách khách hàng</b></h3>
                  </div>
                  <div class="col-md-2">
                    <!-- <button type="submit" class="btn bg-primary mt-2" data-toggle="modal"
                      data-target="#modal-add-new"><i class="fas fa-plus mr-2"></i>Thêm mới</button> -->
                  </div>


                </div>
                <!-- /.card-header -->
                 <div class="card-body">
                  <table id="tableKH" class="table table-bordered table-striped text-center" >
                    <thead class="bg-primary ">
                      <tr>
                        <th>Mã KH</th>
                        <th>Email</th>
                        <th>Mã Tài khoản</th>
                        <th>Trạng thái Tài khoản</th>
                        <th>Họ tên</th>
                        
                        <th>SĐT</th>
                        <th>Địa chỉ</th>
                        <th>Giới tính</th>
                        <th>Thao Tác</th>
                      </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="item" items="${ListKhachHang}">
                      <tr>
                        <td class="text-center">${item.maKH }</td>
                        <td>${item.taiKhoan.email}</td>
                        <td>${item.taiKhoan.maTK}</td>  
                        <td>
                           <c:choose>
						    <c:when test="${item.taiKhoan.trangThai}">
						        Mở 
						    </c:when>    
						    <c:otherwise>
						        Khóa 
						    </c:otherwise>
						</c:choose>
                        </td>  
                        <td class="text-center">${item.ho }${item.ten}</td>
                       
                        <td class="text-center">${item.sdt }</td>
                        <td class="text-center">${item.diaChi}</td>  
                        <td class="text-center">
                        <c:choose>
						    <c:when test="${item.gioiTinh}">
						        Nam 
						    </c:when>    
						    <c:otherwise>
						        Nữ 
						    </c:otherwise>
						</c:choose>
                        
                        </td>
                      <td>
                          <div class="d-flex justify-content-around px-4">
                          <c:choose>
						    <c:when test="${item.taiKhoan.trangThai}">
						         <a class="" href="" data-delete="${item.taiKhoan.email}" data-toggle="modal" data-target="#exampleModalDelete">
                              <i class="fa fa-lock" ></i> </a> 
						    </c:when>    
						    <c:otherwise>
						         <a class="" href="" data-delete="${item.taiKhoan.email}" data-toggle="modal" data-target="#exampleModalDelete">
                              <i class="fa fa-unlock-alt" ></i> </a> 
						    </c:otherwise>
						</c:choose>
                          
                            </div>
                          </td>

                        </td>
                      </tr>

                     </c:forEach>
                    </tbody>
                  </table>            
                </div>
                <!-- /.card-body -->
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
      <!-- Modal mở -->
    <div class="modal fade " id="exampleModalDelete" tabindex="-1" aria-labelledby="exampleModalDelete"
      aria-hidden="true">
      <div class="modal-dialog ">
        <div class="modal-content">
          <div class="modal-header bg-danger">
            <h5 class="modal-title" id="exampleModalLabel"><i class="fa fa-unlock-alt"></i>
              &nbsp; Bạn chắc chắn muốn đổi trạng thái tài khoản khách hàng này?
            </h5>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <form action="/webbanhoa/quan-tri/ds-khach-hang?linkLock"  method="post">
				<div class="modal-footer d-flex justify-content-between">
					<input type="text" name="email" id="input-delete-ncc" value="" hidden />
					<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Đóng</button>
						<button type="submit" class="btn btn-danger" >Đổi</button>
				</div>
			</form>
        </div>
      </div>
    </div>
    <!-- /.modal  confirm mở-->

    <div class="modal fade" id="modal-info-detail">
      <div class="modal-dialog modal-lg modal-dialog-scrollable">
        <div class="modal-content">
          <div class="modal-header bg-primary">
            <h4 class="modal-title">Thông tin khách hàng</h4>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <div class="modal-body">
            <div class="row">
              <!-- /.col -->
              <div class="col-md-12">
                <form class="form-horizontal">
                  <div class="row">
                    <div class="col-md-4">
                      <!-- Profile Image -->
                      <div class="card card-primary card-outline">
                        <div class="card-body box-profile">
                          <div class="text-center">
                            <img class="profile-user-img img-fluid img-circle" src="./dist/img/user4-128x128.jpg"
                              alt="User profile picture" style="width: 120px;">
                          </div>

                          <h3 class="profile-username text-center text-primary">Mỹ Linh</h3>

                          

                        </div>
                        <!-- /.card-body -->
                      </div>
                      <!-- /.card -->
                    </div>

                    <div class="col-md-8">
                      <div class="card">
                        <div class="card-body text-primary">

                          <div class="form-group row">
                            <label for="inputName" class="col-sm-2 col-form-label">Mã KH</label>
                            <div class="col-sm-10">
                              <input type="email" class="form-control" id="inputName" placeholder="KH01">
                            </div>
                          </div>
                          <div class="form-group row">
                            <label for="inputEmail" class="col-sm-2 col-form-label">Tên KH</label>
                            <div class="col-sm-10">
                              <input type="email" class="form-control" id="inputEmail" placeholder="Trần Thị Mỹ Linh">
                            </div>
                          </div>
                          <div class="form-group row">
                            <label for="inputName2" class="col-sm-2 col-form-label">Giới tính</label>
                            <div class="col-sm-10">
                              <input type="text" class="form-control" id="inputName2" placeholder="Nữ">
                            </div>
                          </div>
                          <div class="form-group row">
                            <label for="inputExperience" class="col-sm-2 col-form-label ">Ngày sinh</label>
                            <div class="col-sm-10">
                              <input class="form-control" id="inputExperience" placeholder="08/03/2001"></input>
                            </div>
                          </div>
                          <!-- <div class="form-group row">
                            <label for="inputSkills" class="col-sm-2 col-form-label text-primary">CCCD</label>
                            <div class="col-sm-10">
                              <input type="text" class="form-control" id="inputSkills" placeholder="01234567890">
                            </div>
                          </div> -->
                          <div class="form-group row">
                            <label for="inputSkills" class="col-sm-2 col-form-label ">SĐT</label>
                            <div class="col-sm-10">
                              <input type="text" class="form-control" id="inputSkills" placeholder="0123456789">
                            </div>
                          </div>
                          <div class="form-group row">
                            <label for="inputSkills" class="col-sm-2 col-form-label">Địa chỉ</label>
                            <div class="col-sm-10">
                              <input type="text" class="form-control" id="inputSkills"
                                placeholder="97 Man Thien, Q9 TP. HCM">
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>

                </form>
              </div>
              <!-- /.col -->
            </div>
          </div>
          <!-- <div class="modal-footer justify-content-between">
            <button type="button" class="btn btn-default" data-dismiss="modal">Đóng</button>
            <button type="button" class="btn bg-dark">Lưu</button>
          </div> -->
        </div>
        <!-- /.modal-content -->
      </div>
      <!-- /.modal-dialog -->
    </div>
    <!-- /.modal -->

    <div class="modal fade" id="modal-add-new">
      <div class="modal-dialog modal-lg modal-dialog-scrollable">
        <div class="modal-content">
          <div class="modal-header">
            <h4 class="modal-title">Thêm nhân viên</h4>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <div class="modal-body">
            <div class="row">
              <!-- /.col -->
              <div class="col-md-12">
                <form class="form-horizontal">
                  <div class="row">
                    <div class="col-md-4">
                      <!-- Profile Image -->
                      <div class="card card-primary card-outline">
                        <div class="card-body box-profile">
                          <div class="text-center">
                            <img class="profile-user-img img-fluid img-circle" src="./dist/img/user4-128x128.jpg"
                              alt="User profile picture" style="width: 120px;">
                          </div>

                          <h3 class="profile-username text-center">Nina Mcintire</h3>

                          <p class="text-muted text-center">Nhân viên</p>

                        </div>
                        <!-- /.card-body -->
                      </div>
                      <!-- /.card -->
                    </div>

                    <div class="col-md-8">

                      <div class="form-group row">
                        <label for="inputName" class="col-sm-2 col-form-label">Mã NV</label>
                        <div class="col-sm-10">
                          <input type="email" class="form-control" id="inputName" placeholder="NV1">
                        </div>
                      </div>
                      <div class="form-group row">
                        <label for="inputEmail" class="col-sm-2 col-form-label">Tên NV</label>
                        <div class="col-sm-10">
                          <input type="email" class="form-control" id="inputEmail" placeholder="Võ Thị Thanh Ngân">
                        </div>
                      </div>
                      <div class="form-group row">
                        <label for="inputName2" class="col-sm-2 col-form-label">Giới tính</label>
                        <div class="col-sm-10">
                          <input type="text" class="form-control" id="inputName2" placeholder="Nữ">
                        </div>
                      </div>
                      <div class="form-group row">
                        <label for="inputExperience" class="col-sm-2 col-form-label">Ngày sinh</label>
                        <div class="col-sm-10">
                          <input class="form-control" id="inputExperience" placeholder="13/11/2001"></input>
                        </div>
                      </div>
                      <div class="form-group row">
                        <label for="inputSkills" class="col-sm-2 col-form-label">CCCD</label>
                        <div class="col-sm-10">
                          <input type="text" class="form-control" id="inputSkills" placeholder="01234567890">
                        </div>
                      </div>
                      <div class="form-group row">
                        <label for="inputSkills" class="col-sm-2 col-form-label">SĐT</label>
                        <div class="col-sm-10">
                          <input type="text" class="form-control" id="inputSkills" placeholder="0123456789">
                        </div>
                      </div>

                    </div>
                  </div>

                </form>
              </div>
              <!-- /.col -->
            </div>
          </div>
          <div class="modal-footer justify-content-between">
            <button type="button" class="btn btn-default" data-dismiss="modal">Đóng</button>
            <button type="button" class="btn bg-dark">Lưu</button>
          </div>
        </div>
        <!-- /.modal-content -->
      </div>
      <!-- /.modal-dialog -->
    </div>
    <!-- /.modal -->



    <div class="modal fade" id="modal-edit">
      <div class="modal-dialog modal-lg modal-dialog-scrollable">
        <div class="modal-content">
          <div class="modal-header bg-secondary">
            <h4 class="modal-title">Sửa thông tin khách hàng #KH01</h4>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <div class="modal-body">
            <div class="row">
              <!-- /.col -->
              <div class="col-md-12">
                <div class="card">
                  <div class="card-header p-2 ">
                    <ul class="nav nav-pills">
                      <li class="nav-item"><a class="nav-link active" href="#activity" data-toggle="tab">Thông tin</a>
                      </li>
                      <li class="nav-item"><a class="nav-link" href="#settings" data-toggle="tab">Cài đặt</a></li>
                    </ul>
                  </div><!-- /.card-header -->
                  <div class="card-body">
                    <div class="tab-content">
                      <div class="active tab-pane" id="activity">
                        <!-- Info profile -->

                        <form class="form-horizontal">
                          <div class="row">
                            <div class="col-md-3">
                              <!-- Profile Image -->
                              <div class="card card-primary card-outline">
                                <div class="card-body box-profile">
                                  <div class="text-center">
                                    <img class="profile-user-img img-fluid img-circle"
                                      src="./dist/img/user4-128x128.jpg" alt="User profile picture">
                                  </div>

                                  <h3 class="profile-username text-center">Mỹ Linh</h3>

                                  <!-- <p class="text-muted text-center"></p>



                                  <a href="#" class="btn bg-dark btn-block"><i class="fas fa-upload"></i></a> -->
                                </div>
                                <!-- /.card-body -->
                              </div>
                              <!-- /.card -->
                            </div>

                            <div class="col-md-9">

                              <div class="form-group row">
                                <label for="inputName" class="col-sm-2 col-form-label">Mã KH</label>
                                <div class="col-sm-10">
                                  <input type="email" class="form-control" id="inputName" placeholder="NV1">
                                </div>
                              </div>
                              <div class="form-group row">
                                <label for="inputEmail" class="col-sm-2 col-form-label">Tên KH</label>
                                <div class="col-sm-10">
                                  <input type="email" class="form-control" id="inputEmail"
                                    placeholder="Võ Thị Thanh Ngân">
                                </div>
                              </div>
                              <div class="form-group row">
                                <label for="inputName2" class="col-sm-2 col-form-label">Giới tính</label>
                                <div class="col-sm-10">
                                  <input type="text" class="form-control" id="inputName2" placeholder="Nữ">
                                </div>
                              </div>
                              <div class="form-group row">
                                <label for="inputExperience" class="col-sm-2 col-form-label">Ngày sinh</label>
                                <div class="col-sm-10">
                                  <input class="form-control" id="inputExperience" placeholder="08/03/2001"></input>
                                </div>
                              </div>
                              <!-- <div class="form-group row">
                                <label for="inputSkills" class="col-sm-2 col-form-label">CCCD</label>
                                <div class="col-sm-10">
                                  <input type="text" class="form-control" id="inputSkills" placeholder="01234567890">
                                </div>
                              </div> -->
                              <div class="form-group row">
                                <label for="inputSkills" class="col-sm-2 col-form-label">SĐT</label>
                                <div class="col-sm-10">
                                  <input type="text" class="form-control" id="inputSkills" placeholder="0123456789">
                                </div>
                              </div>
                              <div class="form-group row">
                                <label for="inputSkills" class="col-sm-2 col-form-label">Địa chỉ</label>
                                <div class="col-sm-10">
                                  <input type="text" class="form-control" id="inputSkills"
                                    placeholder="97 Man Thien, Q9 TP. HCM">
                                </div>
                              </div>

                            </div>
                          </div>

                        </form>
                        <!-- /.Info profile -->
                      </div>
                      <!-- /.tab-pane -->


                      <div class="tab-pane" id="settings">
                        <form class="form-horizontal">
                          <!-- <div class="form-group row">
                            <label for="inputName" class="col-sm-2 col-form-label">Mật khẩu</label>
                            <div class="col-sm-10">
                              <input type="password" class="form-control" id="inputName" placeholder="Mật khẩu">
                            </div>
                          </div>
                          <div class="form-group row">
                            <label for="inputEmail" class="col-sm-2 col-form-label">Mật khẩu mới</label>
                            <div class="col-sm-10">
                              <input type="password" class="form-control" id="inputEmail"
                                placeholder="Nhập mật khẩu mới">
                            </div>
                          </div>
                          <div class="form-group row">
                            <label for="inputName2" class="col-sm-2 col-form-label">Nhập lại</label>
                            <div class="col-sm-10">
                              <input type="password" class="form-control" id="inputName2"
                                placeholder="Nhập lại mật khẩu mới">
                            </div>
                          </div> -->

                          <div class="form-group">
                            <div class="col-sm-12">
                              <button type="submit" class="btn bg-dark">Reset mật khẩu</button>
                            </div>
                          </div>
                        </form>
                      </div>
                      <!-- /.tab-pane -->
                    </div>
                    <!-- /.tab-content -->
                  </div><!-- /.card-body -->
                </div>
                <!-- /.card -->
              </div>
              <!-- /.col -->
            </div>
          </div>
          <div class="modal-footer justify-content-between">
            <button type="button" class="btn btn-default" data-dismiss="modal">Đóng</button>
            <button type="button" class="btn bg-dark">Lưu thay đổi</button>
          </div>
        </div>
        <!-- /.modal-content -->
      </div>
      <!-- /.modal-dialog -->
    </div>

    <!-- Modal mở -->
    <div class="modal fade " id="exampleModalConfirm" tabindex="-1" aria-labelledby="exampleModalConfirm"
      aria-hidden="true">
      <div class="modal-dialog ">
        <div class="modal-content">
          <div class="modal-header bg-primary">
            <h5 class="modal-title" id="exampleModalLabel"><i class="fas fa-lock-open"></i>&nbsp; Bạn muốn mở hoạt động
              tài khoản này?
            </h5>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <!-- <div class="modal-body">
            <p class="text-center">Bạn muốn mở hoạt động tài khoản này?</p>
          </div> -->
          <div class="modal-footer d-flex justify-content-end">
            <button type="button" class="btn btn-primary" data-dismiss="modal">Tiếp tục</button>
            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
          </div>
        </div>
      </div>
    </div>
    <!-- /.modal  confirm mở-->
    <!--Modal tắt hđ-->
    <div class="modal fade " id="exampleModalDisable" tabindex="-1" aria-labelledby="exampleModalConfirm"
      aria-hidden="true">
      <div class="modal-dialog ">
        <div class="modal-content">
          <div class="modal-header bg-secondary">
            <h5 class="modal-title" id="exampleModalLabel"><i class="fas fa-lock"></i>&nbsp; Bạn muốn tắt hoạt động tài
              khoản
              này?
            </h5>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <!-- <div class="modal-body">
            <p class="text-center">Bạn muốn tắt hoạt động tài khoản này?</p>
          </div> -->
          <div class="modal-footer d-flex justify-content-end">
            <button type="button" class="btn btn-primary" data-dismiss="modal">Tiếp tục</button>
            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
          </div>
        </div>
      </div>
    </div>
    <!--Modal tắt hđ-->

    <footer class="main-footer">
      <div class="float-right d-none d-sm-block">
        <b>Version</b> 1.0.0
      </div>
      <strong>Copyright &copy; 2014-2022 <a href="https://adminlte.io">AdminLTE.io</a>.</strong> All rights reserved.
    </footer>

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
      $("#tableKH").DataTable({
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
          },
        },
        columnDefs: [{
          orderable: false,
          targets: 1
        }, {
          orderable: false,
          targets: 6
        }]

      });
      $("#example1").DataTable({
        "responsive": true,
        "lengthChange": false,
        "autoWidth": false,
        "buttons": ["copy", "csv", "excel", "pdf", "print", "colvis"]
      }).buttons().container().appendTo('#example1_wrapper .col-md-6:eq(0)');
      $('#example2').DataTable({
        "paging": true,
        "lengthChange": false,
        "searching": false,
        "ordering": true,
        "info": true,
        "autoWidth": false,
        "responsive": true,
      });
    });

    $('#tableKH').DataTable({
        columnDefs: [{ orderable: false, targets: 5}, { orderable: false, targets: 2}],
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
          },
        }
        
    });

  </script>

<!-- JS Lib -->
<%@include file="/WEB-INF/views/admin/include/jsLib.jsp"%>
<!-- JS Lib End -->