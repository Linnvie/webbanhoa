package com.ptit.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ptit.entity.SanPhamEntity;

@Service
public interface ISanPhamService {
	public Boolean themSanPham(SanPhamEntity SPThem);
	public Boolean suaSanPham(SanPhamEntity SPSua);
	public Boolean xoaSanPham(SanPhamEntity SPXoa);
	public List<SanPhamEntity> findAll();
	public SanPhamEntity findOneByMaSanPham(Long maSanPham);
	public List<SanPhamEntity> findAllByMaLoaiSP(Integer maLoaiSP);

}
