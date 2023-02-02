package com.ptit.entity;

import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="DonHang")
public class DonHangEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="MaDonHang")
	private Long maDonHang;
	
	@Column(name="ThoiDiemDat")
	private Date thoiDiemDat;
	
	@Column(name="SDTGiaoHang")
	private String sdtGiaoHang;
	
	@Column(name="DiaChiGiao")
	private String diaChiGiao;
	
	@Column(name="MaTinhTrangDon")
	private int maTinhTrangDon;
	
	@Column(name="GhiChu")
	private String ghiChu;
	
	@Column(name="NguoiNhan")
	private String nguoiNhan;
	
	@Column(name="MaKH")
	private Long maKhachHang;
	
	@Column(name="TongTien")
	private float tongTien;
	
	@OneToMany(mappedBy="donHang", cascade=CascadeType.ALL)
	private Collection<ChiTietDonHangEntity> listCTDH;

	public Long getMaDonHang() {
		return maDonHang;
	}

	public void setMaDonHang(Long maDonHang) {
		this.maDonHang = maDonHang;
	}

	public Date getThoiDiemDat() {
		return thoiDiemDat;
	}

	public void setThoiDiemDat(Date thoiDiemDat) {
		this.thoiDiemDat = thoiDiemDat;
	}

	public String getSdtGiaoHang() {
		return sdtGiaoHang;
	}

	public void setSdtGiaoHang(String sdtGiaoHang) {
		this.sdtGiaoHang = sdtGiaoHang;
	}

	public String getDiaChiGiao() {
		return diaChiGiao;
	}

	public void setDiaChiGiao(String diaChiGiao) {
		this.diaChiGiao = diaChiGiao;
	}

	public int getMaTinhTrangDon() {
		return maTinhTrangDon;
	}

	public void setMaTinhTrangDon(int maTinhTrangDon) {
		this.maTinhTrangDon = maTinhTrangDon;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	public String getNguoiNhan() {
		return nguoiNhan;
	}

	public void setNguoiNhan(String nguoiNhan) {
		this.nguoiNhan = nguoiNhan;
	}

	public Long getMaKhachHang() {
		return maKhachHang;
	}

	public void setMaKhachHang(Long maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	public float getTongTien() {
		return tongTien;
	}

	public void setTongTien(float tongTien) {
		this.tongTien = tongTien;
	}

	public Collection<ChiTietDonHangEntity> getListCTDH() {
		return listCTDH;
	}

	public void setListCTDH(Collection<ChiTietDonHangEntity> listCTDH) {
		this.listCTDH = listCTDH;
	}
	
	

}
