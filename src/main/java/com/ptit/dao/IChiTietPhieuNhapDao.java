package com.ptit.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ptit.entity.ChiTietPhieuNhapEntity;

@Repository
public interface IChiTietPhieuNhapDao {
		public Boolean themCTPN(ChiTietPhieuNhapEntity CTPNThem);
		public Boolean suaCTPN(ChiTietPhieuNhapEntity CTPNSua);
		public Boolean xoaCTPN(ChiTietPhieuNhapEntity CTPNXoa);
		public List<ChiTietPhieuNhapEntity> findAll();
		public List<ChiTietPhieuNhapEntity> findAllByMaPhieuNhap(Long maPhieuNhap);
		public ChiTietPhieuNhapEntity findOneByMaPhieuNhapAndMaVatLieu(Long maPhieuNhap, Long maVatLieu);
}
