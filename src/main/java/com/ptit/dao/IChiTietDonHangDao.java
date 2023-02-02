package com.ptit.dao;

import java.util.List;

import com.ptit.entity.ChiTietDonHangEntity;

public interface IChiTietDonHangDao {
	//Ngân
	public List<ChiTietDonHangEntity> getDSCTDH();
	public List<ChiTietDonHangEntity> getDSByMaDH(Integer MaDH);
	public Boolean themChiTietDH(ChiTietDonHangEntity ctdh);
	//public Boolean kiemTraCTDH(Integer MaCTSP);
	
	//Linh
	public List<ChiTietDonHangEntity> findAll();
	public List<ChiTietDonHangEntity> findAllByMaDonHang(Long maDonHang);
}
