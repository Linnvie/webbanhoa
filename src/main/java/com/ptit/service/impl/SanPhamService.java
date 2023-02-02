package com.ptit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ptit.dao.ISanPhamDao;
import com.ptit.entity.SanPhamEntity;
import com.ptit.service.ISanPhamService;

@Service
public class SanPhamService implements ISanPhamService{
	@Autowired
	private ISanPhamDao spDao;

	@Override
	public Boolean themSanPham(SanPhamEntity SPThem) {
		return spDao.themSanPham(SPThem);
	}

	@Override
	public Boolean suaSanPham(SanPhamEntity SPSua) {
		return spDao.suaSanPham(SPSua);
	}

	@Override
	public Boolean xoaSanPham(SanPhamEntity SPXoa) {
		return spDao.xoaSanPham(SPXoa);
	}

	@Override
	public List<SanPhamEntity> findAll() {
		return spDao.findAll();
	}

	@Override
	public SanPhamEntity findOneByMaSanPham(Long maSanPham) {
		return spDao.findOneByMaSanPham(maSanPham);
	}

	@Override
	public List<SanPhamEntity> findAllByMaLoaiSP(Integer maLoaiSP) {
		return spDao.findAllByMaLoaiSP(maLoaiSP);
	}

}
