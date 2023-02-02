package com.ptit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ptit.dao.IChiTietSPDao;
import com.ptit.entity.ChiTietSanPhamEntity;
import com.ptit.service.IChiTietSPService;

@Service
public class ChiTietSPService implements IChiTietSPService {
	@Autowired
	private IChiTietSPDao ctspDao;

	@Override
	public Boolean themCTSP(ChiTietSanPhamEntity CTSPThem) {
		return ctspDao.themCTSP(CTSPThem);
	}

	@Override
	public Boolean suaCTSP(ChiTietSanPhamEntity CTSPSua) {
		return ctspDao.suaCTSP(CTSPSua);
	}

	@Override
	public Boolean xoaCTSP(ChiTietSanPhamEntity CTSPXoa) {
		return ctspDao.xoaCTSP(CTSPXoa);
	}

	@Override
	public List<ChiTietSanPhamEntity> findAll() {
		return ctspDao.findAll();
	}

	@Override
	public List<ChiTietSanPhamEntity> findAllByMaSanPham(Long maSanPham) {
		return ctspDao.findAllByMaSanPham(maSanPham);
	}

	@Override
	public ChiTietSanPhamEntity findOneByMaSanPhamAndMaVatLieu(Long maSanPham, Long maVatLieu) {
		return ctspDao.findOneByMaSanPhamAndMaVatLieu(maSanPham, maVatLieu);
	}
	
	
}
