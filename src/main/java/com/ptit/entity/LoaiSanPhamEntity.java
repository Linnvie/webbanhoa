package com.ptit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="LoaiSanPham")
public class LoaiSanPhamEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="MaLoaiSP")
	private Integer maLoaiSP;
	
	@Column(name="TenLoaiSanPham")
	private String tenLoaiSP;

	public Integer getMaLoaiSP() {
		return maLoaiSP;
	}

	public void setMaLoaiSP(Integer maLoaiSP) {
		this.maLoaiSP = maLoaiSP;
	}

	public String getTenLoaiSP() {
		return tenLoaiSP;
	}

	public void setTenLoaiSP(String tenLoaiSP) {
		this.tenLoaiSP = tenLoaiSP;
	}
	
	
	

}
