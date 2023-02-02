package com.ptit.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ptit.dao.ILoaiSPDao;
import com.ptit.entity.LoaiSanPhamEntity;

@Transactional
@Repository
public class LoaiSPDao implements ILoaiSPDao{
	@Autowired
	SessionFactory factory;

	@Override
	public Boolean themLSP(LoaiSanPhamEntity lspThem) {
		Session session= factory.openSession();
		Transaction transaction= session.beginTransaction();
		try {		
			session.save(lspThem);
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
	public Boolean suaLSP(LoaiSanPhamEntity lspSua) {
		Session session= factory.openSession();
		Transaction transaction= session.beginTransaction();
		try {		
			session.update(lspSua);
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
	public List<LoaiSanPhamEntity> findAll() {
		Session session= factory.getCurrentSession();
		String hql="FROM LoaiSanPhamEntity";
		Query query= session.createQuery(hql);
		List<LoaiSanPhamEntity> list= query.list();
		return list;
	}

	@Override
	public LoaiSanPhamEntity findOneByMaLoaiSP(Integer maLoaiSP) {
		Session session= factory.getCurrentSession();
		String hql="FROM LoaiSanPhamEntity WHERE maLoaiSP= :maLoaiSP";
		Query query= session.createQuery(hql);
		query.setParameter("maLoaiSP", maLoaiSP);
		List<LoaiSanPhamEntity> list= query.list();
		if(list.size()==0) {
			return null;
		}
		return list.get(0);
	}

	@Override
	public Boolean xoaLSP(LoaiSanPhamEntity lspXoa) {
		Session session= factory.openSession();
		Transaction transaction= session.beginTransaction();
		try {		
			session.delete(lspXoa);
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();;
			return false;
		} finally {
			session.close();
		}
	}
}
