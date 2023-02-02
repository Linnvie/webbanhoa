package com.ptit.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ChiTietPhieuNhap")
public class ChiTietPhieuNhapEntity {
	@EmbeddedId
	private CTPNKey id;
	
	@ManyToOne
	@JoinColumn(name="MaPhieuNhap",insertable = false, updatable = false)
	private PhieuNhapEntity phieuNhap;
	
	@ManyToOne
	@JoinColumn(name="MaVatLieu",insertable = false, updatable = false)
	private VatLieuEntity vatLieu;
	
	@Column(name="SoLuong")
	private Integer soLuong;
	
	@Column(name="GiaNhap")
	private Float giaNhap;

	public CTPNKey getId() {
		return id;
	}

	public void setId(CTPNKey id) {
		this.id = id;
	}

	public PhieuNhapEntity getPhieuNhap() {
		return phieuNhap;
	}

	public void setPhieuNhap(PhieuNhapEntity phieuNhap) {
		this.phieuNhap = phieuNhap;
	}

	public VatLieuEntity getVatLieu() {
		return vatLieu;
	}

	public void setVatLieu(VatLieuEntity vatLieu) {
		this.vatLieu = vatLieu;
	}

	public Integer getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(Integer soLuong) {
		if(soLuong instanceof Integer) {
			this.soLuong = soLuong;
		}else {
			this.soLuong = 0;
		}
	}

	public Float getGiaNhap() {
		return giaNhap;
	}

	public void setGiaNhap(Float giaNhap) {
		if(giaNhap instanceof Number) {
			this.giaNhap = giaNhap;
		}else {
			this.giaNhap = (float) 0;
		}
	}

	
	
	
	
}
