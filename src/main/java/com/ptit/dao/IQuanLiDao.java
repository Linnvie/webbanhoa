package com.ptit.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ptit.entity.QuanLiEntity;

@Repository
public interface IQuanLiDao {
	public Boolean themQuanLi(QuanLiEntity QLThem);
	public Boolean suaQuanLi(QuanLiEntity QLSua);
	public List<QuanLiEntity> findAll();
	public List<QuanLiEntity> findAllActive();
	public QuanLiEntity findOneByMaQL(Integer maQL);
}
