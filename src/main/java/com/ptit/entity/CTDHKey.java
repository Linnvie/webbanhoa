package com.ptit.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CTDHKey implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name="MaDonHang")
	private Long maDonHang;
	
	@Column(name="MaSanPham")
	private Long maSanPham;

	public Long getMaDonHang() {
		return maDonHang;
	}

	public void setMaDonHang(Long maDonHang) {
		this.maDonHang = maDonHang;
	}

	public Long getMaSanPham() {
		return maSanPham;
	}

	public void setMaSanPham(Long maSanPham) {
		this.maSanPham = maSanPham;
	}
	
	

}
