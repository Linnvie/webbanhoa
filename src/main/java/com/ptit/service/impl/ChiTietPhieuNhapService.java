package com.ptit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ptit.dao.IChiTietPhieuNhapDao;
import com.ptit.entity.ChiTietPhieuNhapEntity;
import com.ptit.service.IChiTietPhieuNhapService;

@Service
public class ChiTietPhieuNhapService implements IChiTietPhieuNhapService {
	@Autowired
	private IChiTietPhieuNhapDao ctpnDao;

	@Override
	public Boolean themCTPN(ChiTietPhieuNhapEntity CTPNThem) {
		return ctpnDao.themCTPN(CTPNThem);
	}

	@Override
	public Boolean suaCTPN(ChiTietPhieuNhapEntity CTPNSua) {
		return ctpnDao.suaCTPN(CTPNSua);
	}

	@Override
	public Boolean xoaCTPN(ChiTietPhieuNhapEntity CTPNXoa) {
		return ctpnDao.xoaCTPN(CTPNXoa);
	}

	@Override
	public List<ChiTietPhieuNhapEntity> findAll() {
		return ctpnDao.findAll();
	}

	@Override
	public List<ChiTietPhieuNhapEntity> findAllByMaPhieuNhap(Long maPhieuNhap) {
		return ctpnDao.findAllByMaPhieuNhap(maPhieuNhap);
	}

	@Override
	public ChiTietPhieuNhapEntity findOneByMaPhieuNhapAndMaVatLieu(Long maPhieuNhap, Long maVatLieu) {
		return ctpnDao.findOneByMaPhieuNhapAndMaVatLieu(maPhieuNhap, maVatLieu);
	}

}
