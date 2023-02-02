package com.ptit.dto;

import com.ptit.entity.SanPhamEntity;

public class GioHangDto {
	
	private int sLuong;
	
	private double tongGia;
	
	private SanPhamEntity sp;

	public int getsLuong() {
		return sLuong;
	}

	public void setsLuong(int sLuong) {
		this.sLuong = sLuong;
	}

	public double getTongGia() {
		return tongGia;
	}

	public void setTongGia(double tongGia) {
		this.tongGia = tongGia;
	}

	public SanPhamEntity getSp() {
		return sp;
	}

	public void setSp(SanPhamEntity sp) {
		this.sp = sp;
	}

	public GioHangDto(int sLuong, double tongGia, SanPhamEntity sp) {
		this.sLuong = sLuong;
		this.tongGia = tongGia;
		this.sp = sp;
	}

	public GioHangDto() {
	}
	
	

}
