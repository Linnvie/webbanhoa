package com.ptit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ptit.dao.ILoaiSPDao;
import com.ptit.entity.LoaiSanPhamEntity;
import com.ptit.service.ILoaiSPService;

@Service
public class LoaiSPService implements ILoaiSPService{
	@Autowired
	private ILoaiSPDao lspDao;

	@Override
	public Boolean themLSP(LoaiSanPhamEntity lspThem) {
		return lspDao.themLSP(lspThem);
	}

	@Override
	public Boolean suaLSP(LoaiSanPhamEntity lspSua) {
		return lspDao.suaLSP(lspSua);
	}

	@Override
	public List<LoaiSanPhamEntity> findAll() {
		return lspDao.findAll();
	}

	@Override
	public LoaiSanPhamEntity findOneByMaLoaiSP(Integer maLoaiSP) {
		return lspDao.findOneByMaLoaiSP(maLoaiSP);
	}

	@Override
	public Boolean xoaLSP(LoaiSanPhamEntity lspXoa) {
		return lspDao.xoaLSP(lspXoa);
	}

}
