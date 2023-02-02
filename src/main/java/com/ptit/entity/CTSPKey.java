package com.ptit.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CTSPKey implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name="MaSanPham")
	private Long maSanPham;
	
	@Column(name="MaVatLieu")
	private Long maVatLieu;

	public Long getMaSanPham() {
		return maSanPham;
	}

	public void setMaSanPham(Long maSanPham) {
		this.maSanPham = maSanPham;
	}

	public Long getMaVatLieu() {
		return maVatLieu;
	}

	public void setMaVatLieu(Long maVatLieu) {
		this.maVatLieu = maVatLieu;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
