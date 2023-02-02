package com.ptit.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ChiTietDonHang")
public class ChiTietDonHangEntity {
	@EmbeddedId
	private CTDHKey id;
	
	@ManyToOne
	@JoinColumn(name="MaDonHang",insertable = false, updatable = false)
	private DonHangEntity donHang;
	
	@ManyToOne
	@JoinColumn(name="MaSanPham",insertable = false, updatable = false)
	private SanPhamEntity sanPham;
	
	@Column(name="SoLuong")
	private Integer soLuong;
	
	@Column(name="GiaTien")
	private Float giaTien;

	public CTDHKey getId() {
		return id;
	}

	public void setId(CTDHKey id) {
		this.id = id;
	}

	public DonHangEntity getDonHang() {
		return donHang;
	}

	public void setDonHang(DonHangEntity donHang) {
		this.donHang = donHang;
	}

	public SanPhamEntity getSanPham() {
		return sanPham;
	}

	public void setSanPham(SanPhamEntity sanPham) {
		this.sanPham = sanPham;
	}

	public Integer getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(Integer soLuong) {
		this.soLuong = soLuong;
	}

	public Float getGiaTien() {
		return giaTien;
	}

	public void setGiaTien(Float giaTien) {
		this.giaTien = giaTien;
	}
	
	

}
