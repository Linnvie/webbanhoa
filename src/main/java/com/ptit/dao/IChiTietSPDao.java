package com.ptit.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ptit.entity.ChiTietSanPhamEntity;

@Repository
public interface IChiTietSPDao {
	public Boolean themCTSP(ChiTietSanPhamEntity CTSPThem);
	public Boolean suaCTSP(ChiTietSanPhamEntity CTSPSua);
	public Boolean xoaCTSP(ChiTietSanPhamEntity CTSPXoa);
	public List<ChiTietSanPhamEntity> findAll();
	public List<ChiTietSanPhamEntity> findAllByMaSanPham(Long maSanPham);
	public ChiTietSanPhamEntity findOneByMaSanPhamAndMaVatLieu(Long maSanPham, Long maVatLieu);

}
