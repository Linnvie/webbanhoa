package com.ptit.service;

import java.util.List;

import com.ptit.entity.ChiTietDonHangEntity;

public interface IChiTietDonHangService {
	//Ngân
	public List<ChiTietDonHangEntity> getDSByMaDH(Integer MaDH);	
	public List<ChiTietDonHangEntity> getDSCTDH();
	public Boolean themCTDH(ChiTietDonHangEntity ctdh);
	
//	Linh
	public List<ChiTietDonHangEntity> findAll();
	public List<ChiTietDonHangEntity> findAllByMaDonHang(Long maDonHang);

}
