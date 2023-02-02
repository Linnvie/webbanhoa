package com.ptit.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ptit.entity.SanPhamEntity;

@Repository
public interface ISanPhamDao {
	public Boolean themSanPham(SanPhamEntity SPThem);
	public Boolean suaSanPham(SanPhamEntity SPSua);
	public Boolean xoaSanPham(SanPhamEntity SPXoa);
	public List<SanPhamEntity> findAll();
	public SanPhamEntity findOneByMaSanPham(Long maSanPham);
	public List<SanPhamEntity> findAllByMaLoaiSP(Integer maLoaiSP);

}
