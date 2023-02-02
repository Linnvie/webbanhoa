package com.ptit.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ptit.dao.ITaiKhoanDao;
import com.ptit.entity.TaiKhoanEntity;


@Transactional
@Repository
public class TaiKhoanDao implements ITaiKhoanDao{
	@Autowired
	SessionFactory factory;

	@Override
	public TaiKhoanEntity findOneByEmail(String email) {
		Session session= factory.getCurrentSession();
		String hql="FROM TaiKhoanEntity WHERE email= :email";
		Query query= session.createQuery(hql);
		query.setParameter("email", email);
		List<TaiKhoanEntity> list= query.list();
		if(list.size()==0) {
			return null;
		}
		return list.get(0);
	}

	@Override
	public Boolean themTaiKhoan(TaiKhoanEntity taiKhoanDangKi) {
		Session session= factory.openSession();
		Transaction transaction= session.beginTransaction();
		try {		
			session.save(taiKhoanDangKi);
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
	public Boolean suaTaiKhoan(TaiKhoanEntity taiKhoanSua) {
		Session session= factory.openSession();
		Transaction transaction= session.beginTransaction();
		try {		
			session.update(taiKhoanSua);
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
