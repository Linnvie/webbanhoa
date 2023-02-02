package com.ptit.dao;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface IThongKeDao {
	public List<Object> CountAllSPGroupByMaLoaiSP();
	public List<Object> CountaLLDoanhThuBySP();
	public List<Object> CountDoanhThuBySP(Date fromDate, Date toDate);
}
