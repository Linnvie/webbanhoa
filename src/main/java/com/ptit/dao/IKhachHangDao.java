package com.ptit.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ptit.entity.KhachHangEntity;

@Repository
public interface IKhachHangDao {
	//Linh
	public List<KhachHangEntity> findAll();
	public KhachHangEntity findOneByMaKH(Long maKH);
	
	//Ngaan
	public KhachHangEntity getByMaKH(Long maKH);
	public KhachHangEntity getBySdt(String sdt);
	public KhachHangEntity getByMaTK(Long maTK);
	public List<KhachHangEntity> getDSKhachHang();
	public Boolean themKH(KhachHangEntity khachHang);
	public Boolean suaKH(KhachHangEntity khachHang);
}
