package com.ptit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ptit.dao.IChiTietDonHangDao;
import com.ptit.entity.ChiTietDonHangEntity;
import com.ptit.service.IChiTietDonHangService;

@Service
public class ChiTietDonHangService implements IChiTietDonHangService{
	
	@Autowired
	private IChiTietDonHangDao ctdhDao;
	
	@Override
	public List<ChiTietDonHangEntity> getDSByMaDH(Integer MaDH) {
		return ctdhDao.getDSByMaDH(MaDH);
	}

	@Override
	public List<ChiTietDonHangEntity> getDSCTDH() {
		return ctdhDao.getDSCTDH();
	}

	@Override
	public Boolean themCTDH(ChiTietDonHangEntity ctdh) {
		return ctdhDao.themChiTietDH(ctdh);
	}

//	Linh
	@Override
	public List<ChiTietDonHangEntity> findAll() {
		return ctdhDao.findAll();
	}

	@Override
	public List<ChiTietDonHangEntity> findAllByMaDonHang(Long maDonHang) {
		return ctdhDao.findAllByMaDonHang(maDonHang);
	}

}
