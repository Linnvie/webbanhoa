package com.ptit.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Quyen")
public class QuyenEntity {
	@Id
	@Column(name="MaQuyen")
	private String maQuyen;
	
	@Column(name="TenQuyen")
	private String tenQuyen;
	
	@OneToMany(mappedBy="quyen", fetch=FetchType.EAGER)
	private List<TaiKhoanEntity> TKList = new ArrayList<>();

	public String getMaQuyen() {
		return maQuyen;
	}

	public void setMaQuyen(String maQuyen) {
		this.maQuyen = maQuyen;
	}

	public String getTenQuyen() {
		return tenQuyen;
	}

	public void setTenQuyen(String tenQuyen) {
		this.tenQuyen = tenQuyen;
	}

	public List<TaiKhoanEntity> getTKList() {
		return TKList;
	}

	public void setTKList(List<TaiKhoanEntity> tKList) {
		TKList = tKList;
	}
	
	
}
