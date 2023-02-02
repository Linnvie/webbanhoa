package com.ptit.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ptit.dao.ISanPhamDao;
import com.ptit.entity.SanPhamEntity;

@Transactional
@Repository
public class SanPhamDao implements ISanPhamDao {
	@Autowired
	SessionFactory factory;

	@Override
	public Boolean themSanPham(SanPhamEntity SPThem) {
		Session session= factory.openSession();
		Transaction transaction= session.beginTransaction();
		try {		
			session.save(SPThem);
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();;
			return false;
		} finally {
			session.close();
		}
	}

	@Override
	public Boolean suaSanPham(SanPhamEntity SPSua) {
		Session session= factory.openSession();
		Transaction transaction= session.beginTransaction();
		try {		
			session.update(SPSua);
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();;
			return false;
		} finally {
			session.close();
		}
	}

	@Override
	public Boolean xoaSanPham(SanPhamEntity SPXoa) {
		Session session= factory.openSession();
		Transaction transaction= session.beginTransaction();
		try {		
			session.delete(SPXoa);
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();;
			return false;
		} finally {
			session.close();
		}
	}

	@Override
	public List<SanPhamEntity> findAll() {
		Session session= factory.getCurrentSession();
		String hql="FROM SanPhamEntity";
		Query query= session.createQuery(hql);
		List<SanPhamEntity> list= query.list();
		if(list.size()==0) {
			return null;
		}
		return list;
	}

	@Override
	public SanPhamEntity findOneByMaSanPham(Long maSanPham) {
		Session session= factory.getCurrentSession();
		String hql="FROM SanPhamEntity WHERE maSanPham= :maSanPham";
		Query query= session.createQuery(hql);
		query.setParameter("maSanPham", maSanPham);
		List<SanPhamEntity> list= query.list();
		if(list.size()==0) {
			return null;
		}
		return list.get(0);
	}

	@Override
	public List<SanPhamEntity> findAllByMaLoaiSP(Integer maLoaiSP) {
		Session session= factory.getCurrentSession();
		String hql="FROM SanPhamEntity WHERE loaiSP.maLoaiSP= :maLoaiSP";
		Query query= session.createQuery(hql);
		query.setParameter("maLoaiSP", maLoaiSP);
		List<SanPhamEntity> list= query.list();
		if(list.size()==0) {
			return null;
		}
		return list;
	}

}
