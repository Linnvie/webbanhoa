package com.ptit.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ptit.dao.IThongKeDao;
import com.ptit.service.IThongKeService;

@Service
public class ThongKeService implements IThongKeService {
	@Autowired
	private IThongKeDao thongKeDao;

	@Override
	public List<Object> CountAllSPGroupByMaLoaiSP() {
		return thongKeDao.CountAllSPGroupByMaLoaiSP();
	}

	@Override
	public List<Object> CountaLLDoanhThuBySP() {
		return thongKeDao.CountaLLDoanhThuBySP();
	}

	@Override
	public List<Object> CountDoanhThuBySP(Date fromDate, Date toDate) {
		return thongKeDao.CountDoanhThuBySP(fromDate, toDate);
	}
}
