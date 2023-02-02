package com.ptit.entity;

import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="PhieuNhap")
public class PhieuNhapEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="MaPhieuNhap")
	private Long maPhieuNhap;
	
	@Column(name="ThoiDiemNhap")
	private Date thoiDiemNhap;
	
	@Column(name="MaNguoiNhap")
	private int maNguoiNhap;
	
	@ManyToOne
    @JoinColumn(name = "MaNCC")
	private NhaCungCapEntity nhaNCC;
	
	@Column(name="TongTien")
	private float tongTien;
	
	@OneToMany(mappedBy="phieuNhap", cascade=CascadeType.ALL)
	private Collection<ChiTietPhieuNhapEntity> listCTPN;

	public Date getThoiDiemNhap() {
		return thoiDiemNhap;
	}

	public void setThoiDiemNhap(Date thoiDiemNhap) {
		this.thoiDiemNhap = thoiDiemNhap;
	}

	public int getMaNguoiNhap() {
		return maNguoiNhap;
	}

	public void setMaNguoiNhap(int maNguoiNhap) {
		this.maNguoiNhap = maNguoiNhap;
	}

	public NhaCungCapEntity getNhaNCC() {
		return nhaNCC;
	}

	public void setNhaNCC(NhaCungCapEntity nhaNCC) {
		this.nhaNCC = nhaNCC;
	}

	public void setMaPhieuNhap(Long maPhieuNhap) {
		this.maPhieuNhap = maPhieuNhap;
	}

	public float getTongTien() {
		return tongTien;
	}

	public void setTongTien(float tongTien) {
		this.tongTien = tongTien;
	}

	public Collection<ChiTietPhieuNhapEntity> getListCTPN() {
		return listCTPN;
	}

	public void setListCTPN(Collection<ChiTietPhieuNhapEntity> listCTPN) {
		this.listCTPN = listCTPN;
	}

	public Long getMaPhieuNhap() {
		return maPhieuNhap;
	}
	
	
	
	

}
