package com.ptit.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ptit.entity.ChiTietPhieuNhapEntity;

@Service
public interface IChiTietPhieuNhapService {
	public Boolean themCTPN(ChiTietPhieuNhapEntity CTPNThem);
	public Boolean suaCTPN(ChiTietPhieuNhapEntity CTPNSua);
	public Boolean xoaCTPN(ChiTietPhieuNhapEntity CTPNXoa);
	public List<ChiTietPhieuNhapEntity> findAll();
	public List<ChiTietPhieuNhapEntity> findAllByMaPhieuNhap(Long maPhieuNhap);
	public ChiTietPhieuNhapEntity findOneByMaPhieuNhapAndMaVatLieu(Long maPhieuNhap, Long maVatLieu);
}
