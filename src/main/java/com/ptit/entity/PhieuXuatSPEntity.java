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
@Table(name="PhieuXuatSanPham")
public class PhieuXuatSPEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="MaPhieuXuatSP")
	private Long maPhieuXuatSP;
	
	@Column(name="Ngay")
	private Date ngay;
	
	@OneToMany(mappedBy="phieuXuatSP", cascade=CascadeType.ALL)
	private Collection<ChiTietPhieuXuatSPEntity> listCTPX;

	public Long getMaPhieuXuatSP() {
		return maPhieuXuatSP;
	}

	public void setMaPhieuXuatSP(Long maPhieuXuatSP) {
		this.maPhieuXuatSP = maPhieuXuatSP;
	}

	public Date getNgay() {
		return ngay;
	}

	public void setNgay(Date ngay) {
		this.ngay = ngay;
	}

	public Collection<ChiTietPhieuXuatSPEntity> getListCTPX() {
		return listCTPX;
	}

	public void setListCTPX(Collection<ChiTietPhieuXuatSPEntity> listCTPX) {
		this.listCTPX = listCTPX;
	}

	
	
	

}
