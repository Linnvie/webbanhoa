package com.ptit.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ChiTietSanPham")
public class ChiTietSanPhamEntity {
	@EmbeddedId
	private CTSPKey id;
	
	@ManyToOne
	@JoinColumn(name="MaSanPham",insertable = false, updatable = false)
	private SanPhamEntity sanPham;
	
	@ManyToOne
	@JoinColumn(name="MaVatLieu",insertable = false, updatable = false)
	private VatLieuEntity vatLieu;
	
	@Column(name="SoLuong")
	private Integer soLuong;

	public CTSPKey getId() {
		return id;
	}

	public void setId(CTSPKey id) {
		this.id = id;
	}

	public SanPhamEntity getSanPham() {
		return sanPham;
	}

	public void setSanPham(SanPhamEntity sanPham) {
		this.sanPham = sanPham;
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
		if (soLuong instanceof Integer) {
			this.soLuong = soLuong;
		}else {
			this.soLuong = 0;
		}
		
	}


	
	
}
