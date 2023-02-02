package com.ptit.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CTPXSPKey implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name="MaSP")
	private Long maSP;
	
	@Column(name="MaPhieuXuatSP")
	private Long maPhieuXuatSP;

	public Long getMaSP() {
		return maSP;
	}

	public void setMaSP(Long maSP) {
		this.maSP = maSP;
	}

	public Long getMaPhieuXuatSP() {
		return maPhieuXuatSP;
	}

	public void setMaPhieuXuatSP(Long maPhieuXuatSP) {
		this.maPhieuXuatSP = maPhieuXuatSP;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
