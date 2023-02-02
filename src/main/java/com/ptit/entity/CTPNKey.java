package com.ptit.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CTPNKey implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name="MaPhieuNhap")
	private Long maPhieuNhap;
	
	@Column(name="MaVatLieu")
	private Long maVatLieu;

	public Long getMaPhieuNhap() {
		return maPhieuNhap;
	}

	public void setMaPhieuNhap(Long maPhieuNhap) {
		this.maPhieuNhap = maPhieuNhap;
	}

	public Long getMaVatLieu() {
		return maVatLieu;
	}

	public void setMaVatLieu(Long maVatLieu) {
		this.maVatLieu = maVatLieu;
	}
	
	
}
