package com.ptit.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ptit.dao.IKhachHangDao;
import com.ptit.entity.KhachHangEntity;

@Transactional
@Repository
public class KhachHangDao implements IKhachHangDao{
	@Autowired
	SessionFactory factory;
	
	@Override
	public List<KhachHangEntity> findAll() {
		Session session= factory.getCurrentSession();
		String hql="FROM KhachHangEntity";
		Query query= session.createQuery(hql);
		List<KhachHangEntity> list= query.list();
		return list;
	}

	@Override
	public KhachHangEntity findOneByMaKH(Long maKH) {
		Session session= factory.getCurrentSession();
		String hql="FROM KhachHangEntity WHERE maKH= :maKH";
		Query query= session.createQuery(hql);
		query.setParameter("maKH", maKH);
		List<KhachHangEntity> list= query.list();
		if(list.size()==0) {
			return null;
		}
		return list.get(0);
	}
	
	
	//Ngan
	@Override
	public KhachHangEntity getByMaKH(Long maKH) {
		Session session = factory.getCurrentSession();
		String hql = "from KhachHang where maKH = :maKH";
		Query query = session.createQuery(hql);
		query.setParameter("maKH", maKH);
		List<KhachHangEntity> res = query.list();
		
		if(res.size() == 0) {
			return null;
		}
		
		KhachHangEntity kh = res.get(0);
		return kh;
	}

	@Override
	public KhachHangEntity getBySdt(String sdt) {
		Session session = factory.getCurrentSession();
		String hql = "from KhachHang where sdt = :sdt";
		Query query = session.createQuery(hql);
		query.setParameter("sdt", sdt);
		List<KhachHangEntity> res = query.list();
		
		if(res.size() == 0) {
			return null;
		}
		
		KhachHangEntity kh = res.get(0);
		return kh;
	}

	@Override
	public KhachHangEntity getByMaTK(Long maTK) {
		Session session = factory.getCurrentSession();
		String hql = "from KhachHang where maTK = :maTK";
		Query query = session.createQuery(hql);
		query.setParameter("maTK", maTK);
		List<KhachHangEntity> res = query.list();
		
		if(res.size() == 0) {
			return null;
		}
		
		KhachHangEntity kh = res.get(0);
		return kh;
	}

	@Override
	public List<KhachHangEntity> getDSKhachHang() {
		Session session = factory.getCurrentSession();
		String hql ="from KhachHang";
		Query query = session.createQuery(hql);
		List<KhachHangEntity> list = query.list();
		return list;
	}

	@Override
	public Boolean themKH(KhachHangEntity khachHang) {
		Session session= factory.openSession();
		Transaction transaction = session.beginTransaction();
		try {		
			session.save(khachHang);
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			return false;
		} finally {
			session.close();
		}
	}

	@Override
	public Boolean suaKH(KhachHangEntity khachHang) {
		Session session= factory.openSession();
		Transaction transaction= session.beginTransaction();
		try {		
			session.update(khachHang);
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
