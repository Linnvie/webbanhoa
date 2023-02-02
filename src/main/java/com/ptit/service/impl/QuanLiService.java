package com.ptit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ptit.dao.IQuanLiDao;
import com.ptit.entity.QuanLiEntity;
import com.ptit.service.IQuanLiSservice;

@Service
public class QuanLiService implements IQuanLiSservice {
	@Autowired
	private IQuanLiDao qlDao;
	
	@Override
	public Boolean themQuanLi(QuanLiEntity QLThem) {
		return qlDao.themQuanLi(QLThem);
	}

	@Override
	public Boolean suaQuanLi(QuanLiEntity QLSua) {
		return qlDao.suaQuanLi(QLSua);
	}

	@Override
	public List<QuanLiEntity> findAll() {
		return qlDao.findAll();
	}

	@Override
	public QuanLiEntity findOneByMaQL(Integer maQL) {
		return qlDao.findOneByMaQL(maQL);
	}

	@Override
	public List<QuanLiEntity> findAllActive() {
		return qlDao.findAllActive();
	}

}
