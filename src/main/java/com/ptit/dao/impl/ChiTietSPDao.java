package com.ptit.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ptit.dao.IChiTietSPDao;
import com.ptit.entity.ChiTietSanPhamEntity;

@Transactional
@Repository
public class ChiTietSPDao implements IChiTietSPDao {
	@Autowired
	SessionFactory factory;

	@Override
	public Boolean themCTSP(ChiTietSanPhamEntity CTSPThem) {
		Session session= factory.openSession();
		Transaction transaction= session.beginTransaction();
		try {		
			session.save(CTSPThem);
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
	public Boolean suaCTSP(ChiTietSanPhamEntity CTSPSua) {
		Session session= factory.openSession();
		Transaction transaction= session.beginTransaction();
		try {		
			session.update(CTSPSua);
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
	public Boolean xoaCTSP(ChiTietSanPhamEntity CTSPXoa) {
		Session session= factory.openSession();
		Transaction transaction= session.beginTransaction();
		try {		
			session.delete(CTSPXoa);
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
	public List<ChiTietSanPhamEntity> findAll() {
		Session session= factory.getCurrentSession();
		String hql="FROM ChiTietSanPhamEntity";
		Query query= session.createQuery(hql);
		List<ChiTietSanPhamEntity> list= query.list();
		return list;
	}

	@Override
	public List<ChiTietSanPhamEntity> findAllByMaSanPham(Long maSanPham) {
		Session session= factory.getCurrentSession();
		String hql="FROM ChiTietSanPhamEntity WHERE id.maSanPham= :maSanPham";
		Query query= session.createQuery(hql);
		query.setParameter("maSanPham", maSanPham);
		List<ChiTietSanPhamEntity> list= query.list();
		if(list.size()==0) {
			return null;
		}
		return list;
	}

	@Override
	public ChiTietSanPhamEntity findOneByMaSanPhamAndMaVatLieu(Long maSanPham, Long maVatLieu) {
		Session session= factory.getCurrentSession();
		String hql="FROM ChiTietSanPhamEntity WHERE id.maSanPham= :maSanPham AND id.maVatLieu= :maVatLieu";
		Query query= session.createQuery(hql);
		query.setParameter("maSanPham", maSanPham);
		query.setParameter("maVatLieu", maVatLieu);
		List<ChiTietSanPhamEntity> list= query.list();
		if(list.size()==0) {
			return null;
		}
		return list.get(0);
	}
}
