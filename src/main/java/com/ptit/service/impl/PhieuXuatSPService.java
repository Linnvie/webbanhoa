package com.ptit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ptit.dao.IPhieuXuatSPDao;
import com.ptit.entity.PhieuXuatSPEntity;
import com.ptit.service.IPhieuXuatSPService;

@Service
public class PhieuXuatSPService implements IPhieuXuatSPService{
	@Autowired
	private IPhieuXuatSPDao pxspDao;

	@Override
	public PhieuXuatSPEntity findOneByMaPX(Long maPX) {
		return pxspDao.findOneByMaPX(maPX);
	}

	@Override
	public List<PhieuXuatSPEntity> findAll() {
		return pxspDao.findAll();
	}

	@Override
	public Boolean thempPhieuXuat(PhieuXuatSPEntity phieuXuatThem) {
		return pxspDao.thempPhieuXuat(phieuXuatThem);
	}

	@Override
	public Boolean xoaPhieuXuat(PhieuXuatSPEntity phieuXuatXoa) {
		return pxspDao.xoaPhieuXuat(phieuXuatXoa);
	}

}
