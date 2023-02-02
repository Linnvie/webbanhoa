package com.ptit.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ChiTietPhieuXuatSP")
public class ChiTietPhieuXuatSPEntity {
	@EmbeddedId
	private CTPXSPKey id;
	
	@ManyToOne
	@JoinColumn(name="MaSP",insertable = false, updatable = false)
	private SanPhamEntity sanPham;
	
	@ManyToOne
	@JoinColumn(name="MaPhieuXuatSP",insertable = false, updatable = false)
	private PhieuXuatSPEntity phieuXuatSP;
	
	@Column(name="SoLuong")
	private Integer soLuong;

	public CTPXSPKey getId() {
		return id;
	}

	public void setId(CTPXSPKey id) {
		this.id = id;
	}

	public SanPhamEntity getSanPham() {
		return sanPham;
	}

	public void setSanPham(SanPhamEntity sanPham) {
		this.sanPham = sanPham;
	}

	public PhieuXuatSPEntity getPhieuXuatSP() {
		return phieuXuatSP;
	}

	public void setPhieuXuatSP(PhieuXuatSPEntity phieuXuatSP) {
		this.phieuXuatSP = phieuXuatSP;
	}

	public Integer getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(Integer soLuong) {
		if(soLuong instanceof Integer) {
			this.soLuong = soLuong;
		}else {
			this.soLuong=0;
		}
		
	}

	
	
	
}
