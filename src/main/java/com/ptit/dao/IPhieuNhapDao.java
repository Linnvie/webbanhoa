package com.ptit.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ptit.entity.PhieuNhapEntity;

@Repository
public interface IPhieuNhapDao {
	public PhieuNhapEntity findOneByMaPN(Long maPN);
	public List<PhieuNhapEntity> findAll();
	public Boolean thempPhieuNhap(PhieuNhapEntity phieuNhapThem);
	public Boolean suaPhieuNhap(PhieuNhapEntity phieuNhapSua);
	public Boolean xoaPhieuNhap(PhieuNhapEntity phieuNhapXoa);
}
