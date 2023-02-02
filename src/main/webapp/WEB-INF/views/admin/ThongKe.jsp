<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<title>Thống kê</title>
<!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper" >
      <!-- Content Header (Page header) -->
      <section class="content-header">
        <div class="container-fluid">
          <div class="row mb-2">
            <div class="col-sm-12">
              <ol class="breadcrumb ">
                <li class="breadcrumb-item">Quản lý</li>
                <li class="breadcrumb-item active">Thống kê</li>
              </ol>
            </div>
            <div class="col-sm-6 mt-4 mb-3">
              <h1><b>Thống kê doanh thu</b></h1>
            </div>
          </div>
        </div><!-- /.container-fluid -->
      </section>
      
      <div class="col-8" style="margin-left:18%">
			<form action="" method="post">
				<!-- <div class="form-group">
					<label>Từ khóa</label> <input type="text" name="kw"
						class="form-control" />
				</div> -->
				<div class="form-group">
					<label>Từ thời điểm</label> <input type="date" name="fromDate"
						class="form-control" />
				</div>
				<p class="text-danger">${fromdate }</p>
				<div class="form-group">
					<label>Từ thời điểm</label> <input type="date" name="toDate"
						class="form-control" />
				</div>
				<p class="text-danger">${todate }</p>
				<button type="submit" name="thongke" class="btn btn-success">Báo
					cáo</button>

			</form>
		</div>

      <!-- /.content -->
      <c:if test="${listDoanhThuCoNgay != null}">
      <div class="container mt-4" style="margin-left:10%" >
        <div class="row">
          <div class="col-md-10">
            <div class="card" style="box-shadow: 2px 2px 10px #c7c7c7; border-radius: 15px;">
              <div class="card-header bg-primary">
                <b>Doanh thu</b>
              </div>
              <div class="card-body">
                <canvas id="myChart" style="width:100%;max-width:1000px"></canvas>
              </div>
            </div>
          </div>
        </div>
        
      </div>
      
       <div class="container mt-4" style="margin-left:10%" >
        <div class="row">
          <div class="col-md-10">
       
              <div class="card-body">
              <table id="tableNCC" class="table table-bordered table-striped text-center" >
                    <thead class="bg-primary ">
                      <tr>
                        <th>Mã sản phẩm</th>
                        <th>Tên sản phẩm</th>
                        <th>Doanh thu</th>
                      </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="item" items="${listDoanhThuCoNgay}">
                      <tr>
                        <td>${item.maSP} </td>
                        <td class="text-center">${item.tenSP} </td>
                        <td>${item.doanhThu}</td>
                      </tr>
				</c:forEach>
                    </tbody>
                  </table>
               
              </div>
            </div>
          </div>
        </div>
        
      </div>
      </c:if>
   
    <!-- /.content-wrapper -->
   
    <!-- /.control-sidebar -->
  </div>
  <!-- ./wrapper -->


<script>
$(document).ready(function () {
	 var tenSP = [];
	    var doanhThu = [];
	    
	    <c:forEach var="item" items="${listDoanhThuCoNgay}">
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

});
    </script>

<!-- JS Lib -->
<%@include file="/WEB-INF/views/admin/include/jsLib.jsp"%>
<!-- JS Lib End -->