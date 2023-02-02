package com.ptit.dao.impl;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ptit.dao.IVatLlieuDao;
import com.ptit.entity.VatLieuEntity;

@Transactional
@Repository
public class VatLieuDao implements IVatLlieuDao {
	@Autowired
	SessionFactory factory;

	@Override
	public Boolean themVatLieu(VatLieuEntity vatLieuThem) {
		Session session= factory.openSession();
		Transaction transaction= session.beginTransaction();
		try {		
			session.save(vatLieuThem);
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
	public List<VatLieuEntity> findAll() {
		Session session= factory.getCurrentSession();
		String hql="FROM VatLieuEntity";
		Query query= session.createQuery(hql);
		List<VatLieuEntity> list= query.list();
		return list;
	}

	@Override
	public Boolean suaVatLlieu(VatLieuEntity vatLieuSua) {
		Session session= factory.openSession();
		Transaction transaction= session.beginTransaction();
		try {		
			session.update(vatLieuSua);
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
	public VatLieuEntity findOneByMaVatLieu(Long maVL) {
		Session session= factory.getCurrentSession();
		String hql="FROM VatLieuEntity WHERE maVatLieu= :maVL";
		Query query= session.createQuery(hql);
		query.setParameter("maVL", 	maVL);
		List<VatLieuEntity> list= query.list();
		if(list.size()==0) {
			return null;
		}
		return list.get(0);
	}

	@Override
	public Boolean xoaVatLlieu(VatLieuEntity vatLieuXoa) {
		Session session= factory.openSession();
		Transaction transaction= session.beginTransaction();
		try {		
			session.delete(vatLieuXoa);
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
