package com.ptit.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="TaiKhoan")
public class TaiKhoanEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="MaTK")
	private Long maTK;
	
	@Column(name="Email")
	private String email;
	
	@Column(name="MatKhau")
	private String matKhau;
	
	@Column(name="TrangThai")
	private Boolean trangThai;
	
	@ManyToOne
	@JoinColumn(name="MaQuyen")
	private QuyenEntity quyen;
	
//	@OneToOne(mappedBy = "taiKhoan")
//    private KhachHangEntity khachHang;
	
	@OneToOne(mappedBy="taiKhoan", cascade=CascadeType.ALL)
	private KhachHangEntity khachHang;
	
//	@OneToOne(mappedBy="taiKhoan", cascade=CascadeType.ALL)
//	private QuanLiEntity quanLi;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public Boolean getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(Boolean trangThai) {
		this.trangThai = trangThai;
	}

	public QuyenEntity getQuyen() {
		return quyen;
	}

	public void setQuyen(QuyenEntity quyen) {
		this.quyen = quyen;
	}

	public Long getMaTK() {
		return maTK;
	}

	public KhachHangEntity getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHangEntity khachHang) {
		this.khachHang = khachHang;
	}

//	public QuanLiEntity getQuanLi() {
//		return quanLi;
//	}
//
//	public void setQuanLi(QuanLiEntity quanLi) {
//		this.quanLi = quanLi;
//	}
	

	
	
	

}
