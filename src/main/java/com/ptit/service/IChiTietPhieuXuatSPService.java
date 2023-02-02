package com.ptit.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ptit.entity.ChiTietPhieuXuatSPEntity;

@Service
public interface IChiTietPhieuXuatSPService {
	public Boolean themCTPX(ChiTietPhieuXuatSPEntity CTPXThem);
	public Boolean suaCTPX(ChiTietPhieuXuatSPEntity CTPXSua);
	public Boolean xoaCTPX(ChiTietPhieuXuatSPEntity CTPXXoa);
	public List<ChiTietPhieuXuatSPEntity> findAll();
	public List<ChiTietPhieuXuatSPEntity> findAllByMaPhieuXuat(Long maPhieuXuat);
	public ChiTietPhieuXuatSPEntity findOneByMaPhieuXuatAndMaSP(Long maPhieuXuat, Long maSP);
}
