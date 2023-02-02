package com.ptit.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ptit.dao.IChiTietDonHangDao;
import com.ptit.entity.CTDHKey;
import com.ptit.entity.ChiTietDonHangEntity;

@Transactional
@Repository
public class ChiTietDonHangDao implements IChiTietDonHangDao{
	
	@Autowired
	SessionFactory factory;

	@Override
	public List<ChiTietDonHangEntity> getDSCTDH() {
		Session session = factory.getCurrentSession();
		String hql = "from ChiTietDonHang";
		Query query = session.createQuery(hql);
		List<ChiTietDonHangEntity> res = query.list();
		
		if(res.isEmpty()) {
			return null;
		}
		
		return res;
	}

	@Override
	public List<ChiTietDonHangEntity> getDSByMaDH(Integer MaDH) {
		Session session = factory.getCurrentSession();
		String hql = "from ChiTietDonHangEntity where MaDH = :MaDH";
		Query query = session.createQuery(hql);
		query.setParameter("MaDH", MaDH);
		List<ChiTietDonHangEntity> res = query.list();
		
		if(res.size() == 0) {
			return null;
		}
		
		return res;
	}

	@Override
	public Boolean themChiTietDH(ChiTietDonHangEntity ctdh) {
		Session session= factory.openSession();
		Transaction transaction= session.beginTransaction();
		try {		
			session.save(ctdh);
			transaction.commit();
			return true;
		} catch (Exception e) {
			System.out.println(e);
			System.out.println(e.getCause());
			transaction.rollback();;
			return false;
		} finally {
			session.close();
		}
	}



//	@Override
//	public Boolean kiemTraCTDH(CTDHKey MaCTSP) {
//		Session session = factory.getCurrentSession();
//		String hql = "from ChiTietDonHang where MaCTSP = :MaCTSP";
//		Query query = session.createQuery(hql);
//		query.setParameter("MaCTSP", MaCTSP);
//		List<ChiTietDonHangEntity> res = query.list();
//		
//		if(res.isEmpty()) {
//			return false;
//		}
//		
//		return true;
//	}
	
	//Linh
	@Override
	public List<ChiTietDonHangEntity> findAll() {
		Session session= factory.getCurrentSession();
		String hql="FROM ChiTietDonHangEntity";
		Query query= session.createQuery(hql);
		List<ChiTietDonHangEntity> list= query.list();
		return list;
	}

	@Override
	public List<ChiTietDonHangEntity> findAllByMaDonHang(Long maDonHang) {
		Session session= factory.getCurrentSession();
		String hql="FROM ChiTietDonHangEntity WHERE id.maDonHang= :maDonHang";
		Query query= session.createQuery(hql);
		query.setParameter("maDonHang", maDonHang);
		List<ChiTietDonHangEntity> list= query.list();
		if(list.size()==0) {
			return null;
		}
		return list;
	}

}
