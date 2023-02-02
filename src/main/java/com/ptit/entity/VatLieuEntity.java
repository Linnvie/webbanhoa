package com.ptit.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="VatLieu")
public class VatLieuEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="MaVatLieu")
	private Long maVatLieu;
	
	@Column(name="TenVatLieu")
	private String tenVatLieu;
	
	@Column(name="TonKho")
	private int tonKho;
	
	@OneToMany(mappedBy="vatLieu")
	private Collection<ChiTietPhieuNhapEntity> listCTPN;

	public String getTenVatLieu() {
		return tenVatLieu;
	}
	

	public void setMaVatLieu(Long maVatLieu) {
		this.maVatLieu = maVatLieu;
	}


	public void setTenVatLieu(String tenVatLieu) {
		this.tenVatLieu = tenVatLieu;
	}

	public Collection<ChiTietPhieuNhapEntity> getListCTPN() {
		return listCTPN;
	}

	public void setListCTPN(Collection<ChiTietPhieuNhapEntity> listCTPN) {
		this.listCTPN = listCTPN;
	}

	public Long getMaVatLieu() {
		return maVatLieu;
	}


	public int getTonKho() {
		return tonKho;
	}


	public void setTonKho(int tonKho) {
		this.tonKho = tonKho;
	}
	
	
	
	

}
