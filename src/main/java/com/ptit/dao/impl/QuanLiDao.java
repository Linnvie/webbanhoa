package com.ptit.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ptit.dao.IQuanLiDao;
import com.ptit.entity.QuanLiEntity;

@Transactional
@Repository
public class QuanLiDao implements IQuanLiDao {
	@Autowired
	SessionFactory factory;

	@Override
	public Boolean themQuanLi(QuanLiEntity QLThem) {
		Session session= factory.openSession();
		Transaction transaction= session.beginTransaction();
		try {		
			session.save(QLThem);
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
	public Boolean suaQuanLi(QuanLiEntity QLSua) {
		Session session= factory.openSession();
		Transaction transaction= session.beginTransaction();
		try {		
			session.update(QLSua);
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
	public List<QuanLiEntity> findAll() {
		Session session= factory.getCurrentSession();
		String hql="FROM QuanLiEntity";
		Query query= session.createQuery(hql);
		List<QuanLiEntity> list= query.list();
		if(list.size()==0) {
			return null;
		}
		return list;
	}

	@Override
	public QuanLiEntity findOneByMaQL(Integer maQL) {
		Session session= factory.getCurrentSession();
		String hql="FROM QuanLiEntity WHERE maQL= :maQL";
		Query query= session.createQuery(hql);
		query.setParameter("maQL", maQL);
		List<QuanLiEntity> list= query.list();
		if(list.size()==0) {
			return null;
		}
		return list.get(0);
	}

	@Override
	public List<QuanLiEntity> findAllActive() {
		Session session= factory.getCurrentSession();
		String hql="FROM QuanLiEntity WHERE trangThai=True";
		Query query= session.createQuery(hql);
		List<QuanLiEntity> list= query.list();
		if(list.size()==0) {
			return null;
		}
		return list;
	}
}
