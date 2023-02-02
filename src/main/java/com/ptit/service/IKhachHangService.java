package com.ptit.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ptit.entity.KhachHangEntity;

@Service
public interface IKhachHangService {
	//Linh
	public List<KhachHangEntity> findAll();
	public KhachHangEntity findOneByMaKH(Long maKH);
	
	//Ngan
	public List<KhachHangEntity> getDSKhachHang();
	public KhachHangEntity getBySdt(String sdt);
	public KhachHangEntity getByMaKH(Long maKH);
	public Boolean themKH(KhachHangEntity khachHang);
	public Boolean suaKH(KhachHangEntity khachHang);
}
