package com.ptit.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ptit.entity.ChiTietPhieuXuatSPEntity;

@Repository
public interface IChiTietPhieuXuatSPDao {
	public Boolean themCTPX(ChiTietPhieuXuatSPEntity CTPXThem);
	public Boolean suaCTPX(ChiTietPhieuXuatSPEntity CTPXSua);
	public Boolean xoaCTPX(ChiTietPhieuXuatSPEntity CTPXXoa);
	public List<ChiTietPhieuXuatSPEntity> findAll();
	public List<ChiTietPhieuXuatSPEntity> findAllByMaPhieuXuat(Long maPhieuXuat);
	public ChiTietPhieuXuatSPEntity findOneByMaPhieuXuatAndMaSP(Long maPhieuXuat, Long maSP);
}
