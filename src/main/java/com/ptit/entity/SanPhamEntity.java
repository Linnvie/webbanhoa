package com.ptit.entity;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="SanPham")
public class SanPhamEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="MaSanPham")
	private Long maSanPham;
	
	@Column(name="TenSanPham")
	private String tenSanPham;
	
	@Column(name="GiaGoc")
	private Float giaGoc;
	
	@Column(name="GiaBan")
	private Float giaBan;
	
	@Column(name="MoTa")
	private String moTa;
	
	@Column(name="HinhAnh")
	private String hinhAnh;
	
	@Column(name="TonKho")
	private int tonKho;
	
	@ManyToOne
    @JoinColumn(name = "MaLoaiSP")
	private LoaiSanPhamEntity loaiSP;
	
	@OneToMany(mappedBy="sanPham", fetch=FetchType.EAGER)
	private Collection<ChiTietSanPhamEntity> CTSPList = new ArrayList<>();
	
	@OneToMany(mappedBy="sanPham")
	private Collection<ChiTietPhieuXuatSPEntity> listCTPX;
	
	@OneToMany(mappedBy="sanPham")
	private Collection<ChiTietDonHangEntity> listCTDH;

	public Long getMaSanPham() {
		return maSanPham;
	}

	public void setMaSanPham(Long maSanPham) {
		this.maSanPham = maSanPham;
	}

	public String getTenSanPham() {
		return tenSanPham;
	}

	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}

	public Float getGiaGoc() {
		return giaGoc;
	}

	public void setGiaGoc(Float giaGoc) {
		if(giaGoc instanceof Number) {
			this.giaGoc = giaGoc;
		}else {
			this.giaGoc = (float) 0;
		}
	}

	public Float getGiaBan() {
		return giaBan;
	}

	public void setGiaBan(Float giaBan) {
		if(giaBan instanceof Number) {
			this.giaBan = giaBan;
		}else {
			this.giaBan = (float) 0;
		}
	}

	public Collection<ChiTietPhieuXuatSPEntity> getListCTPX() {
		return listCTPX;
	}

	public void setListCTPX(Collection<ChiTietPhieuXuatSPEntity> listCTPX) {
		this.listCTPX = listCTPX;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public String getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	public int getTonKho() {
		return tonKho;
	}

	public void setTonKho(int tonKho) {
		this.tonKho = tonKho;
	}

	public LoaiSanPhamEntity getLoaiSP() {
		return loaiSP;
	}

	public void setLoaiSP(LoaiSanPhamEntity loaiSP) {
		this.loaiSP = loaiSP;
	}

	public Collection<ChiTietSanPhamEntity> getCTSPList() {
		return CTSPList;
	}

	public void setCTSPList(Collection<ChiTietSanPhamEntity> cTSPList) {
		CTSPList = cTSPList;
	}

	public Collection<ChiTietDonHangEntity> getListCTDH() {
		return listCTDH;
	}

	public void setListCTDH(Collection<ChiTietDonHangEntity> listCTDH) {
		this.listCTDH = listCTDH;
	}

	
	
	
	
}
