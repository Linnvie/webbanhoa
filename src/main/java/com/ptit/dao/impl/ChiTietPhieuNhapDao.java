package com.ptit.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ptit.dao.IChiTietPhieuNhapDao;
import com.ptit.entity.ChiTietPhieuNhapEntity;

@Transactional
@Repository
public class ChiTietPhieuNhapDao implements IChiTietPhieuNhapDao {
	@Autowired
	SessionFactory factory;

	@Override
	public Boolean themCTPN(ChiTietPhieuNhapEntity CTPNThem) {
		Session session= factory.openSession();
		Transaction transaction= session.beginTransaction();
		try {		
			session.save(CTPNThem);
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
	public Boolean suaCTPN(ChiTietPhieuNhapEntity CTPNSua) {
		Session session= factory.openSession();
		Transaction transaction= session.beginTransaction();
		try {		
			session.update(CTPNSua);
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
	public Boolean xoaCTPN(ChiTietPhieuNhapEntity CTPNXoa) {
		Session session= factory.openSession();
		Transaction transaction= session.beginTransaction();
		try {		
			session.delete(CTPNXoa);
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
	public List<ChiTietPhieuNhapEntity> findAll() {
		Session session= factory.getCurrentSession();
		String hql="FROM ChiTietPhieuNhapEntity";
		Query query= session.createQuery(hql);
		List<ChiTietPhieuNhapEntity> list= query.list();
		return list;
	}

	@Override
	public List<ChiTietPhieuNhapEntity> findAllByMaPhieuNhap(Long maPhieuNhap) {
		Session session= factory.getCurrentSession();
		String hql="FROM ChiTietPhieuNhapEntity WHERE id.maPhieuNhap= :maPhieuNhap";
		Query query= session.createQuery(hql);
		query.setParameter("maPhieuNhap", maPhieuNhap);
		List<ChiTietPhieuNhapEntity> list= query.list();
		if(list.size()==0) {
			return null;
		}
		return list;
	}

	@Override
	public ChiTietPhieuNhapEntity findOneByMaPhieuNhapAndMaVatLieu(Long maPhieuNhap, Long maVatLieu) {
		Session session= factory.getCurrentSession();
		String hql="FROM ChiTietPhieuNhapEntity WHERE id.maPhieuNhap= :maPhieuNhap AND id.maVatLieu= :maVatLieu";
		Query query= session.createQuery(hql);
		query.setParameter("maPhieuNhap", maPhieuNhap);
		query.setParameter("maVatLieu", maVatLieu);
		List<ChiTietPhieuNhapEntity> list= query.list();
		if(list.size()==0) {
			return null;
		}
		return list.get(0);
	}

	
}
