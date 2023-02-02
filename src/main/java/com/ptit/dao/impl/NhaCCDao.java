package com.ptit.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ptit.dao.INhaCCDao;
import com.ptit.entity.NhaCungCapEntity;
import com.ptit.entity.PhieuXuatSPEntity;

@Transactional
@Repository
public class NhaCCDao implements INhaCCDao{
	@Autowired
	SessionFactory factory;
	
	@Override
	public List<NhaCungCapEntity> findAll() {
		Session session= factory.getCurrentSession();
		String hql="FROM NhaCungCapEntity";
		Query query= session.createQuery(hql);
		List<NhaCungCapEntity> list= query.list();
		return list;
	}
	
	@Override
	public Boolean themNCC(NhaCungCapEntity nccThem) {
		Session session= factory.openSession();
		Transaction transaction= session.beginTransaction();
		try {		
			session.save(nccThem);
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
	public Boolean suaNCC(NhaCungCapEntity nccSua) {
		Session session= factory.openSession();
		Transaction transaction= session.beginTransaction();
		try {		
			session.update(nccSua);
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
	public NhaCungCapEntity findOneByMaNCC(Integer maNCC) {
		Session session= factory.getCurrentSession();
		String hql="FROM NhaCungCapEntity WHERE maNCC= :maNCC";
		Query query= session.createQuery(hql);
		query.setParameter("maNCC", maNCC);
		List<NhaCungCapEntity> list= query.list();
		if(list.size()==0) {
			return null;
		}
		return list.get(0);
	}

	@Override
	public Boolean xoaNCC(NhaCungCapEntity nccXoa) {
		Session session= factory.openSession();
		Transaction transaction= session.beginTransaction();
		try {		
			session.delete(nccXoa);
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
