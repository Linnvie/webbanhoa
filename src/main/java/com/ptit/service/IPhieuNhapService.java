package com.ptit.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ptit.entity.PhieuNhapEntity;

@Service
public interface IPhieuNhapService {
	public PhieuNhapEntity findOneByMaPN(Long maPN);
	public List<PhieuNhapEntity> findAll();
	public Boolean thempPhieuNhap(PhieuNhapEntity phieuNhapThem);
	public Boolean suaPhieuNhap(PhieuNhapEntity phieuNhapSua);
	public Boolean xoaPhieuNhap(PhieuNhapEntity phieuNhapXoa);
}
