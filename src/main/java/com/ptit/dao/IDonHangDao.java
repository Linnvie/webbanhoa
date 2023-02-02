package com.ptit.dao;

import java.util.Date;
import java.util.List;

import com.ptit.entity.DonHangEntity;

public interface IDonHangDao {
	//Linh
	public List<DonHangEntity> getByDate(Date fromdate, Date todate);
	public List<DonHangEntity> findAll();
	public DonHangEntity findOneByMaDH(Long maDH);
	
	
	//Ngân
	public DonHangEntity getDHMoiTao();
	public List<DonHangEntity> getDSDonHangByMaKH(Long maKH);
	public List<DonHangEntity> getDSDonHang();
	public DonHangEntity getDHByMaDH(Integer maDH);
	public Boolean themDonHang(DonHangEntity donHang);
	public Boolean xoaDonHang(DonHangEntity donHang);

}
