package com.ptit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ptit.dao.IKhachHangDao;
import com.ptit.dao.impl.KhachHangDao;
import com.ptit.entity.KhachHangEntity;
import com.ptit.service.IKhachHangService;

@Service
public class KhachHangService implements IKhachHangService {
	//Linh
	@Autowired
	private IKhachHangDao khDao;
	
	@Override
	public List<KhachHangEntity> findAll() {
		return khDao.findAll();
	}

	@Override
	public KhachHangEntity findOneByMaKH(Long maKH) {
		return khDao.findOneByMaKH(maKH);
	}
	
	
	//Ngan
	@Autowired
	KhachHangDao khachHangDao;
	
	@Autowired
	TaiKhoanService taiKhoanService;

	@Override
	public List<KhachHangEntity> getDSKhachHang() {
		return khachHangDao.getDSKhachHang();
	}

	@Override
	public KhachHangEntity getBySdt(String sdt) {
		return khachHangDao.getBySdt(sdt);
	}

	@Override
	public KhachHangEntity getByMaKH(Long maKH) {
		return khachHangDao.getByMaKH(maKH);
	}

	@Override
	public Boolean themKH(KhachHangEntity khachHang) {
		return khachHangDao.themKH(khachHang);
	}

	@Override
	public Boolean suaKH(KhachHangEntity khachHang) {
		return khachHangDao.suaKH(khachHang);
	}

}
