package com.ptit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ptit.dao.IPhieuNhapDao;
import com.ptit.entity.PhieuNhapEntity;
import com.ptit.service.IPhieuNhapService;

@Service
public class PhieuNhapService implements IPhieuNhapService {
	@Autowired
	private IPhieuNhapDao pnDao;

	@Override
	public PhieuNhapEntity findOneByMaPN(Long maPN) {
		return pnDao.findOneByMaPN(maPN);
	}

	@Override
	public List<PhieuNhapEntity> findAll() {
		return pnDao.findAll();
	}

	@Override
	public Boolean thempPhieuNhap(PhieuNhapEntity phieuNhapThem) {
		return pnDao.thempPhieuNhap(phieuNhapThem);
	}

	@Override
	public Boolean suaPhieuNhap(PhieuNhapEntity phieuNhapSua) {
		return pnDao.suaPhieuNhap(phieuNhapSua);
	}

	@Override
	public Boolean xoaPhieuNhap(PhieuNhapEntity phieuNhapXoa) {
		return pnDao.xoaPhieuNhap(phieuNhapXoa);
	}

}
