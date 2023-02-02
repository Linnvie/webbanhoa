package com.ptit.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface IThongKeService {
	public List<Object> CountAllSPGroupByMaLoaiSP();
	public List<Object> CountaLLDoanhThuBySP();
	public List<Object> CountDoanhThuBySP(Date fromDate, Date toDate);
}
