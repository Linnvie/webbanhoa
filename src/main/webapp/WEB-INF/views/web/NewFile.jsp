<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
      <table id="tableNCC" class="table table-bordered table-striped text-center" >
                    <thead class="bg-primary ">
                      <tr>
                        <th>Mã NCC</th>
                        <th>Tên NCC</th>
                        <th>Địa chỉ</th>
                        <th>Liên hệ</th>
                        
                        <th>Thao Tác</th>
                      </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="item" items="${sanpham}">
                      <tr>
                        <td>  <a href="them-vao-gio-hang/${item.maSanPham}">${item.maSanPham}</a> </td>
                        <td class="text-center">${item.tenSanPham} </td>
                        <td>${item.hinhAnh}</td>
                        <td class="text-center">${item.giaBan}</td>
                        <td>
                       

                        </td>
                      </tr>
				</c:forEach>
                    </tbody>
                  </table>
</table>
</body>
</html>