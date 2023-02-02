package com.ptit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ptit.dao.IChiTietPhieuXuatSPDao;
import com.ptit.entity.ChiTietPhieuXuatSPEntity;
import com.ptit.service.IChiTietPhieuXuatSPService;

@Service
public class ChiTietPhieuXuatSPService implements IChiTietPhieuXuatSPService{
	@Autowired
	private IChiTietPhieuXuatSPDao ctpxDao;

	@Override
	public Boolean themCTPX(ChiTietPhieuXuatSPEntity CTPXThem) {
		return ctpxDao.themCTPX(CTPXThem);
	}

	@Override
	public Boolean suaCTPX(ChiTietPhieuXuatSPEntity CTPXSua) {
		return ctpxDao.suaCTPX(CTPXSua);
	}

	@Override
	public Boolean xoaCTPX(ChiTietPhieuXuatSPEntity CTPXXoa) {
		return ctpxDao.xoaCTPX(CTPXXoa);
	}

	@Override
	public List<ChiTietPhieuXuatSPEntity> findAll() {
		return ctpxDao.findAll();
	}

	@Override
	public List<ChiTietPhieuXuatSPEntity> findAllByMaPhieuXuat(Long maPhieuXuat) {
		return ctpxDao.findAllByMaPhieuXuat(maPhieuXuat);
	}

	@Override
	public ChiTietPhieuXuatSPEntity findOneByMaPhieuXuatAndMaSP(Long maPhieuXuat, Long maSP) {
		return ctpxDao.findOneByMaPhieuXuatAndMaSP(maPhieuXuat, maSP);
	}

}
