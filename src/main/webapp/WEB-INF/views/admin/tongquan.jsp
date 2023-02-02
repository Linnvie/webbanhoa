<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
	<title>Tổng quan</title>
<!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
      <!-- Content Header (Page header) -->
      <section class="content-header">
        <div class="container-fluid">
          <div class="row mb-2">
            <div class="col-sm-12">
              <ol class="breadcrumb ">
                <li class="breadcrumb-item">Quản lý</li>
                <li class="breadcrumb-item active">Tổng quan</li>
              </ol>
            </div>
            <div class="col-sm-6 mt-4 mb-3">
              <h1><b>Thống kê</b></h1>
            </div>
          </div>
        </div><!-- /.container-fluid -->
      </section>

      <!-- Main content -->
      <section class="content">
        <div class="container-fluid" >
          <!-- Small boxes (Stat box) -->
          <div class="row" >
          <div class="col-lg-3 col-6">
				<!-- small box -->
				 <div class="small-box  p-3" style="box-shadow: 2px 2px 10px #c7c7c7; border-radius: 15px;">
					<div class="inner">
						<h3 class="text-primary">${ListKhachHang.size()}</h3>

						 <h4 class="text-muted mt-4">Khách hàng</h4>
					</div>
					<div class="icon">
						<i class=" fas fa-users text-info"></i>
					</div>
					
				</div>
			</div>
            <div class="col-lg-3 col-6" >
              
              <div class="small-box  p-3" style="box-shadow: 2px 2px 10px #c7c7c7; border-radius: 15px;">
                <div class="inner">
                  <h3 class="text-primary">${ListDonHang.size()}</h3>

                  <h4 class="text-muted mt-4">Đơn hàng</h4>
                </div>
                <div class="icon">
                  <i class="fas fa-shopping-cart"></i>
                </div>
                
              </div>
            </div>
            <!-- ./col -->
            
            <div class="col-lg-3 col-6">
              
              <div class="small-box  p-3" style="box-shadow: 2px 2px 10px #c7c7c7; border-radius: 15px;">
                <div class="inner">
                  <h3 class="text-primary">${ListSP.size()}</h3>


                  <h4 class="text-muted mt-4">Sản phẩm</h4>
                </div>
                <div class="icon">
                  <i class="fas fa-gift"></i>
                </div>
                <!-- <a href="SanPham.html" class="small-box-footer">
                  Xem thêm <i class="fas fa-arrow-circle-right"></i>
                </a> -->
              </div>
            </div>
            <!-- ./col -->
            <div class="col-lg-3 col-6">
              
              <div class="small-box  p-3" style="box-shadow: 2px 2px 10px #c7c7c7; border-radius: 15px;">
                <div class="inner">
                  <h3 class="text-primary">${ListNCC.size()}</h3>

                  <h4 class="text-muted mt-4">Nhà cung cấp</h4>
                </div>
                <div class="icon">
                  <i class="fas fa-truck"></i>
                </div>
                
              </div>
            </div>
            <div class="col-lg-3 col-6">
              
              <div class="small-box  p-3" style="box-shadow: 2px 2px 10px #c7c7c7; border-radius: 15px;">
                <div class="inner">
                  <h3 class="text-primary">${ListPhieuNhap.size()}</h3>

                  <h4 class="text-muted mt-4">Phiếu nhập</h4>
                </div>
                <div class="icon">
                  <i class="fas fa-clipboard-list"></i>
                </div>
                <!-- <a href="PhieuNhap.html" class="small-box-footer">
                  Xem thêm <i class="fas fa-arrow-circle-right"></i>
                </a> -->
              </div>
            </div>
            <!-- ./col -->
            <div class="col-lg-3 col-6 ">
              
              <div class="small-box  p-3" style="box-shadow: 2px 2px 10px #c7c7c7; border-radius: 15px;">
                <div class="inner">
                  <h3 class="text-primary">${ListLoaiSP.size()}</h3>

                  <h4 class="text-muted mt-4">Danh mục</h4>
                </div>
                <div class="icon">
                  <i class="fas fa-grip-vertical"></i>
                </div>
             <!--   <a href="" data-toggle="modal" data-target="#modal-info-detail" class="small-box-footer">
                  Xem thêm <i class="fas fa-arrow-circle-right"></i>
                </a> -->
              </div>
            </div>
            <!-- ./col -->
            <div class="col-lg-4 col-6 ">
              
              <div class="small-box  p-3" style="box-shadow: 2px 2px 10px #c7c7c7; border-radius: 15px;">
                <div class="inner">
                  <h3 class="text-primary">
                  <c:set var="dt" value="0"></c:set>
					<c:forEach var="item" items="${ListDoanhThuTheoSP}">
						<c:set var="dt" value="${dt+item.doanhThu}"></c:set>   
					</c:forEach>
						<fmt:setLocale value="vi_VN" /> <fmt:formatNumber minFractionDigits="0" 
													value=" ${dt} " type="currency" pattern = "###,### vnđ"
													currencySymbol="vnđ" />        
                  </h3>

                  <h4 class="text-muted mt-4">Doanh thu</h4>
                </div>
                <div class="icon">
                  <i class="far fa-money-bill-alt"></i>
                </div>
                <!-- <a href="DanhMuc.html" class="small-box-footer">
                  Xem thêm <i class="fas fa-arrow-circle-right"></i>
                </a> -->
              </div>
            </div>
          </div>
          <!-- /.row -->

        </div>

      </section>
      <!-- /.content -->
      <div class="container mt-4" >
        <div class="row">
           <div class="col-md-6">
            <div class="card" style="box-shadow: 2px 2px 10px #c7c7c7; border-radius: 15px;">
              <div class="card-header bg-primary">
                <b>Sản phẩm theo loại</b>
              </div>
              <div class="card-body">
                <canvas id="myChart2" style="width:100%;max-width:500px"></canvas>
              </div>
            </div>
            
          </div>
          <div class="col-md-6">
            <div class="card" style="box-shadow: 2px 2px 10px #c7c7c7; border-radius: 15px;">
              <div class="card-header bg-primary">
                <b>Doanh thu</b>
              </div>
              <div class="card-body">
                <canvas id="myChart" style="width:100%;max-width:500px"></canvas>
              </div>
            </div>
          </div>
      
        </div>
        
      </div>
    </div>
    <!-- /.content-wrapper -->
    
     
    <div class="modal fade" id="modal-lg">
      <div class="modal-dialog modal-lg modal-dialog-scrollable">
        <div class="modal-content">
          <div class="modal-header">
            <h4 class="modal-title">Large Modal</h4>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <div class="modal-body">
            <div class="row">
              <!-- /.col -->
              <div class="col-md-12">
                <div class="card">
                  <div class="card-header p-2">
                    <ul class="nav nav-pills">
                      <li class="nav-item"><a class="nav-link active" href="#activity" data-toggle="tab">Activity</a>
                      </li>
                      <li class="nav-item"><a class="nav-link" href="#settings" data-toggle="tab">Settings</a></li>
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

                                  <h3 class="profile-username text-center">Nina Mcintire</h3>

                                  <p class="text-muted text-center">Software Engineer</p>



                                  <a href="#" class="btn btn-primary btn-block"><i class="fas fa-upload"></i></a>
                                </div>
                                <!-- /.card-body -->
                              </div>
                              <!-- /.card -->
                            </div>

                            <div class="col-md-9">

                              <div class="form-group row">
                                <label for="inputName" class="col-sm-2 col-form-label">Name</label>
                                <div class="col-sm-10">
                                  <input type="email" class="form-control" id="inputName" placeholder="Name">
                                </div>
                              </div>
                              <div class="form-group row">
                                <label for="inputEmail" class="col-sm-2 col-form-label">Email</label>
                                <div class="col-sm-10">
                                  <input type="email" class="form-control" id="inputEmail" placeholder="Email">
                                </div>
                              </div>
                              <div class="form-group row">
                                <label for="inputName2" class="col-sm-2 col-form-label">Name</label>
                                <div class="col-sm-10">
                                  <input type="text" class="form-control" id="inputName2" placeholder="Name">
                                </div>
                              </div>
                              <div class="form-group row">
                                <label for="inputExperience" class="col-sm-2 col-form-label">Experience</label>
                                <div class="col-sm-10">
                                  <textarea class="form-control" id="inputExperience"
                                    placeholder="Experience"></textarea>
                                </div>
                              </div>
                              <div class="form-group row">
                                <label for="inputSkills" class="col-sm-2 col-form-label">Skills</label>
                                <div class="col-sm-10">
                                  <input type="text" class="form-control" id="inputSkills" placeholder="Skills">
                                </div>
                              </div>
                              <div class="form-group row">
                                <div class="offset-sm-2 col-sm-10">
                                  <div class="checkbox">
                                    <label>
                                      <input type="checkbox"> I agree to the <a href="#">terms and conditions</a>
                                    </label>
                                  </div>
                                </div>
                              </div>
                              <div class="form-group row">
                                <div class="offset-sm-2 col-sm-10">
                                  <button type="submit" class="btn btn-danger">Submit</button>
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
                          <div class="form-group row">
                            <label for="inputName" class="col-sm-2 col-form-label">Passwword</label>
                            <div class="col-sm-10">
                              <input type="password" class="form-control" id="inputName" placeholder="Password">
                            </div>
                          </div>
                          <div class="form-group row">
                            <label for="inputEmail" class="col-sm-2 col-form-label">New password</label>
                            <div class="col-sm-10">
                              <input type="password" class="form-control" id="inputEmail" placeholder="New password">
                            </div>
                          </div>
                          <div class="form-group row">
                            <label for="inputName2" class="col-sm-2 col-form-label">Confirm new password</label>
                            <div class="col-sm-10">
                              <input type="password" class="form-control" id="inputName2"
                                placeholder="Confirm new password">
                            </div>
                          </div>

                          <div class="form-group row">
                            <div class="offset-sm-2 col-sm-10">
                              <button type="submit" class="btn btn-danger">Submit</button>
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
            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            <button type="button" class="btn btn-primary">Save changes</button>
          </div>
        </div>
        <!-- /.modal-content -->
      </div>
      <!-- /.modal-dialog -->
    </div>
    <!-- /.modal --> 
    
    <!-- /.control-sidebar -->
  </div>
  <!-- ./wrapper -->

<script>
function gennerateColor(){
	let r= parseInt(Math.random()*255);
	let g= parseInt(Math.random()*255);
	let b= parseInt(Math.random()*255);
	return "rgb("+ r+","+g+","+ b+")" 
}

$(document).ready(function () {

    var tenSP = [];
    var doanhThu = [];
    
    <c:forEach var="item" items="${ListDoanhThuTheoSP}">
    	tenSP.push('${item.tenSP}')
		doanhThu.push('${item.doanhThu}')
	</c:forEach>
		
    new Chart("myChart", {
      type: "line",
      data: {
        labels: tenSP,
        datasets: [{
          fill: false,
          pointRadius: 2,
          borderColor: "rgba(0,0,255,0.5)",
          data: doanhThu
        }]
      },    
      options: {
        legend: {display: false},
        title: {
          display: true,
          fontSize: 16
        }
      }
    });

	var xValues = [];
    var yValues = [];
	
	<c:forEach var="item" items="${sptheoloai}">
		xValues.push('${item[1]}')
		yValues.push('${item[2]}')
	</c:forEach>
    var barColors = [];
    for (var i=0; i < yValues.length; i++){
    	barColors.push(gennerateColor())
    }
    new Chart("myChart2", {
      type: "doughnut",
      data: {
        labels: xValues,
        datasets: [{
          backgroundColor: barColors,
          data: yValues
        }]
      },
      options: {
        title: {
          display: true,
          text: "Biểu đồ thống kê sản phẩm theo loại"
        }
      }
    });
    
});

//var barColors = [
//  "#b91d47",
//  "#00aba9",
// "#2b5797",
// "#e8c3b9",
 //"#1e7145"
//];
    </script>

<!-- JS Lib -->
<%@include file="/WEB-INF/views/admin/include/jsLib.jsp"%>
<!-- JS Lib End -->