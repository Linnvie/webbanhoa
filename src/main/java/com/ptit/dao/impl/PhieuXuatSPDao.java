package com.ptit.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ptit.dao.IPhieuXuatSPDao;
import com.ptit.entity.PhieuXuatSPEntity;

@Transactional
@Repository
public class PhieuXuatSPDao implements IPhieuXuatSPDao {
	@Autowired
	SessionFactory factory;

	@Override
	public PhieuXuatSPEntity findOneByMaPX(Long maPX) {
		Session session= factory.getCurrentSession();
		String hql="FROM PhieuXuatSPEntity WHERE maPhieuXuatSP= :maPX";
		Query query= session.createQuery(hql);
		query.setParameter("maPX", maPX);
		List<PhieuXuatSPEntity> list= query.list();
		if(list.size()==0) {
			return null;
		}
		return list.get(0);
	}

	@Override
	public List<PhieuXuatSPEntity> findAll() {
		Session session= factory.getCurrentSession();
		String hql="FROM PhieuXuatSPEntity";
		Query query= session.createQuery(hql);
		List<PhieuXuatSPEntity> list= query.list();
		if(list.size()==0) {
			return null;
		}
		return list;
	}

	@Override
	public Boolean thempPhieuXuat(PhieuXuatSPEntity phieuXuatThem) {
		Session session= factory.openSession();
		Transaction transaction= session.beginTransaction();
		try {		
			session.save(phieuXuatThem);
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
	public Boolean xoaPhieuXuat(PhieuXuatSPEntity phieuXuatXoa) {
		Session session= factory.openSession();
		Transaction transaction= session.beginTransaction();
		try {		
			session.delete(phieuXuatXoa);
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
