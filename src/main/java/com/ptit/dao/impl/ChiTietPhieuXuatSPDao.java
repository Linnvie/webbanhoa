package com.ptit.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ptit.dao.IChiTietPhieuXuatSPDao;
import com.ptit.entity.ChiTietPhieuXuatSPEntity;

@Transactional
@Repository
public class ChiTietPhieuXuatSPDao implements IChiTietPhieuXuatSPDao {
	@Autowired
	SessionFactory factory;

	@Override
	public Boolean themCTPX(ChiTietPhieuXuatSPEntity CTPXThem) {
		Session session= factory.openSession();
		Transaction transaction= session.beginTransaction();
		try {		
			session.save(CTPXThem);
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
	public Boolean suaCTPX(ChiTietPhieuXuatSPEntity CTPXSua) {
		Session session= factory.openSession();
		Transaction transaction= session.beginTransaction();
		try {		
			session.update(CTPXSua);
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
	public Boolean xoaCTPX(ChiTietPhieuXuatSPEntity CTPXXoa) {
		Session session= factory.openSession();
		Transaction transaction= session.beginTransaction();
		try {		
			session.delete(CTPXXoa);
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
	public List<ChiTietPhieuXuatSPEntity> findAll() {
		Session session= factory.getCurrentSession();
		String hql="FROM ChiTietPhieuXuatSPEntity";
		Query query= session.createQuery(hql);
		List<ChiTietPhieuXuatSPEntity> list= query.list();
		return list;
	}

	@Override
	public List<ChiTietPhieuXuatSPEntity> findAllByMaPhieuXuat(Long maPhieuXuat) {
		Session session= factory.getCurrentSession();
		String hql="FROM ChiTietPhieuXuatSPEntity WHERE id.maPhieuXuatSP= :maPhieuXuat";
		Query query= session.createQuery(hql);
		query.setParameter("maPhieuXuat",maPhieuXuat);
		List<ChiTietPhieuXuatSPEntity> list= query.list();
		if(list.size()==0) {
			return null;
		}
		return list;
	}

	@Override
	public ChiTietPhieuXuatSPEntity findOneByMaPhieuXuatAndMaSP(Long maPhieuXuat, Long maSP) {
		Session session= factory.getCurrentSession();
		String hql="FROM ChiTietPhieuXuatSPEntity WHERE id.maPhieuXuatSP= :maPhieuXuat AND id.maSP= :maSP";
		Query query= session.createQuery(hql);
		query.setParameter("maPhieuXuat", maPhieuXuat);
		query.setParameter("maSP", maSP);
		List<ChiTietPhieuXuatSPEntity> list= query.list();
		if(list.size()==0) {
			return null;
		}
		return list.get(0);
	}

	

}
