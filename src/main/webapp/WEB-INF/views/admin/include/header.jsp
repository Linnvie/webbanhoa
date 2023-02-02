 <%@ page language="java" contentType="text/html; charset=UTF-8" 
   pageEncoding="UTF-8"%> 
<!-- Navigation -->
  <!-- Site wrapper -->
 
    <!-- Navbar -->
    <nav class="main-header navbar navbar-expand navbar-white navbar-light">
      <!-- Left navbar links -->
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link" data-widget="pushmenu" href="#" role="button"><i class="fas fa-bars"></i></a>
        </li>
      </ul>

      <!-- Right navbar links -->
      <ul class="navbar-nav ml-auto">

        <li class="nav-item dropdown user-menu">
          <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">
            <img src="<c:url value="/resources/admin/dist/img/user2-160x160.jpg"/>" class="user-image img-circle elevation-2" alt="User Image">
            <span class="d-none d-md-inline">${user.email}</span>
          </a>
          <div class="dropdown-menu " style="width: 160px;">
            <a href="#" class="dropdown-item" data-toggle="modal" data-target="#modal-lg">Tài khoản</a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" tabindex="-1" href="webbanhoa/dang-xuat">Đăng xuất</a>
          </div>

        </li>

        <!-- <li class="nav-item">
          <a class="nav-link" data-widget="control-sidebar" data-slide="true" href="#" role="button">
            <i class="fas fa-th-large"></i>
          </a>
        </li> -->
      </ul>
    </nav>
    <!-- /.navbar -->

    <!-- Main Sidebar Container -->
    <aside class="main-sidebar sidebar-dark-primary elevation-4 position-fixed">
      <!-- Brand Logo -->
      <a href="/webbanhoa/quan-tri/tong-quan" class="brand-link">
      
        <img src="<c:url value="/resources/admin/dist/img/AdminLTELogo.png"/>" alt="AdminLTE Logo" class="user-image img-circle elevation-2"
          style="opacity: .8; width:38px; height:38px;margin-left:5%">
        <span class="brand-text font-weight-light" style="margin-left:5%;">Violette</span>
      </a>

      <!-- Sidebar -->
      <div class="sidebar ">

        <!-- Sidebar Menu -->
        <nav class="mt-2">
          <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">

            <li class="nav-item">
              <a href="/webbanhoa/quan-tri/tong-quan" class="nav-link active">
                <i class="nav-icon fas fa-th"></i>
                <p>

                  Tổng quan

                </p>
              </a>
            </li>
            <li class="nav-item">
              <a href="/webbanhoa/quan-tri/ds-khach-hang" class="nav-link ">
                <i class="nav-icon fas fa-users"></i>
                <p>

                  Khách hàng

                </p>
              </a>
            </li>
            <!-- <li class="nav-item">
              <a href="NhanVien.html" class="nav-link ">
                <i class="nav-icon fas fa-user-tie"></i>
                <p>
                  Nhân viên
                </p>
              </a>
            </li> -->
            <li class="nav-item">
              <a href="webbanhoa/quan-tri/loai-sp" class="nav-link ">
                <i class="nav-icon fas fa-grip-vertical"></i>
                <p>
                  Danh mục

                </p>
              </a>
            </li>
            <li class="nav-item">
              <a href="/webbanhoa/quan-tri/them-vat-lieu" class="nav-link">
                <i class="nav-icon fas fa-box-open"></i>
                <p>
                  Vật liệu
                </p>
              </a>
            </li>
            <li class="nav-item">
              <a href="/webbanhoa/quan-tri/ds-san-pham" class="nav-link">
                <i class="nav-icon fas fa-box-open"></i>
                <p>
                  Sản phẩm
                </p>
              </a>
            </li>
            <li class="nav-item">
              <a href="/webbanhoa/quan-tri/ds-don-hang" class="nav-link">
                <i class="nav-icon fas fa-file-invoice"></i>
                <p>
                  Đơn hàng

                </p>
              </a>
            </li>
            <li class="nav-item">
              <a href="/webbanhoa/quan-tri/tao-phieu-nhap" class="nav-link ">
                <i class="nav-icon fas fa-clipboard-list"></i>
                <p>
                  Phiếu nhập

                </p>
              </a>
            </li>
                 <li class="nav-item">
              <a href="/webbanhoa/quan-tri/tao-phieu-xuat" class="nav-link ">
                <i class="nav-icon fas fa-clipboard-list"></i>
                <p>
                  Phiếu xuất

                </p>
              </a>
            </li>
            <li class="nav-item">
              <a href="/webbanhoa/quan-tri/nha-cung-cap" class="nav-link ">
                <i class="nav-icon fas fa-truck"></i>
                <p>
                  Nhà cung cấp

                </p>
              </a>
            </li>
            <li class="nav-item">
              <a href="/webbanhoa/quan-tri/thong-ke" class="nav-link ">
                <i class="nav-icon fas fa-tachometer-alt"></i>

                <p>
                  Thống kê

                </p>
              </a>
            </li>
          </ul>
        </nav>
        <!-- /.sidebar-menu -->
      </div>
      <!-- /.sidebar -->
    </aside>
    
    
   