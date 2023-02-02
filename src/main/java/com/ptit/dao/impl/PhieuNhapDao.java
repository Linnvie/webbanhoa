package com.ptit.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ptit.dao.IPhieuNhapDao;
import com.ptit.entity.PhieuNhapEntity;

@Transactional
@Repository
public class PhieuNhapDao implements IPhieuNhapDao {
	@Autowired
	SessionFactory factory;

	@Override
	public PhieuNhapEntity findOneByMaPN(Long maPN) {
		Session session= factory.getCurrentSession();
		String hql="FROM PhieuNhapEntity WHERE maPhieuNhap= :maPN";
		Query query= session.createQuery(hql);
		query.setParameter("maPN", maPN);
		List<PhieuNhapEntity> list= query.list();
		if(list.size()==0) {
			return null;
		}
		return list.get(0);
	}

	@Override
	public List<PhieuNhapEntity> findAll() {
		Session session= factory.getCurrentSession();
		String hql="FROM PhieuNhapEntity";
		Query query= session.createQuery(hql);
		List<PhieuNhapEntity> list= query.list();
		if(list.size()==0) {
			return null;
		}
		return list;
	}

	@Override
	public Boolean thempPhieuNhap(PhieuNhapEntity phieuNhapThem) {
		Session session= factory.openSession();
		Transaction transaction= session.beginTransaction();
		try {		
			session.save(phieuNhapThem);
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
	public Boolean suaPhieuNhap(PhieuNhapEntity phieuNhapSua) {
		Session session= factory.openSession();
		Transaction transaction= session.beginTransaction();
		try {		
			session.update(phieuNhapSua);
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
	public Boolean xoaPhieuNhap(PhieuNhapEntity phieuNhapXoa) {
		Session session= factory.openSession();
		Transaction transaction= session.beginTransaction();
		try {		
			session.delete(phieuNhapXoa);
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
