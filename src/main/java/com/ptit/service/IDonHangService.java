package com.ptit.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.ptit.entity.ChiTietDonHangEntity;

import com.ptit.dto.GioHangDto;
import com.ptit.entity.DonHangEntity;

public interface IDonHangService {
	//Ngân
	public DonHangEntity getDHMoiTao();
	public List<DonHangEntity> getDSDonHangByMaKH(Long maKH);
	public List<DonHangEntity> getDSDonHang();
	public DonHangEntity getByMaDH(Integer maDH);
	public Boolean themDH(DonHangEntity dh);
	public Boolean xoaDH(DonHangEntity dh);
	public void themChiTietDonHang(HashMap<Long, GioHangDto> cart, Long maDH);
	
	
	//Linh
	public List<DonHangEntity> getByDate(Date fromdate, Date todate);
	public List<DonHangEntity> findAll();
	public DonHangEntity findOneByMaDH(Long maDH);
}
