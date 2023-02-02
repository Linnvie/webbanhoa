package com.ptit.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ptit.entity.ChiTietSanPhamEntity;

@Service
public interface IChiTietSPService {
	public Boolean themCTSP(ChiTietSanPhamEntity CTSPThem);
	public Boolean suaCTSP(ChiTietSanPhamEntity CTSPSua);
	public Boolean xoaCTSP(ChiTietSanPhamEntity CTSPXoa);
	public List<ChiTietSanPhamEntity> findAll();
	public List<ChiTietSanPhamEntity> findAllByMaSanPham(Long maSanPham);
	public ChiTietSanPhamEntity findOneByMaSanPhamAndMaVatLieu(Long maSanPham, Long maVatLieu);

}
