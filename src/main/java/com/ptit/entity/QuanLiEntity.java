package com.ptit.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="QuanLi")
public class QuanLiEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="MaQL")
	private Integer maQL;
	
	@Column(name="Ho")
	private String ho;
	
	@Column(name="Ten")
	private String ten;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Column(name="NgaySinh")
	private Date ngaySinh;
	
	@Column(name="DiaChi")
	private String diaChi;
	
	@Column(name="SDT")
	private String sdt;
	
	@Column(name="CCCD")
	private String cccd;
	
	@Column(name="GioiTinh")
	private Boolean gioiTinh;
	
	@Column(name="HinhAnh")
	private String hinhAnh;
	
	@Column(name="TrangThai")
	private Boolean trangThai;
	
//	@OneToOne
//    @JoinColumn(name = "MaTK")
//    private TaiKhoanEntity taiKhoan;

	public Boolean getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(Boolean trangThai) {
		this.trangThai = trangThai;
	}

	public void setMaQL(Integer maQL) {
		this.maQL = maQL;
	}

	public String getHo() {
		return ho;
	}

	public void setHo(String ho) {
		this.ho = ho;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getCccd() {
		return cccd;
	}

	public void setCccd(String cccd) {
		this.cccd = cccd;
	}

	public Boolean getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(Boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

//	public TaiKhoanEntity getTaiKhoan() {
//		return taiKhoan;
//	}
//
//	public void setTaiKhoan(TaiKhoanEntity taiKhoan) {
//		this.taiKhoan = taiKhoan;
//	}

	public Integer getMaQL() {
		return maQL;
	}

	@Override
	public String toString() {
		return "QuanLiEntity [ho=" + ho + ", ten=" + ten + "]";
	}
	
	
}
