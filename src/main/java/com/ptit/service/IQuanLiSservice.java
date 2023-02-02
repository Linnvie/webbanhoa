package com.ptit.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ptit.entity.QuanLiEntity;

@Service
public interface IQuanLiSservice {
	public Boolean themQuanLi(QuanLiEntity QLThem);
	public Boolean suaQuanLi(QuanLiEntity QLSua);
	public List<QuanLiEntity> findAll();
	public QuanLiEntity findOneByMaQL(Integer maQL);
	public List<QuanLiEntity> findAllActive();
}
