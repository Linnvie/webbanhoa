package com.ptit.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ptit.dao.IDonHangDao;
import com.ptit.dto.GioHangDto;
import com.ptit.entity.ChiTietDonHangEntity;
import com.ptit.entity.DonHangEntity;
import com.ptit.entity.SanPhamEntity;
import com.ptit.entity.TaiKhoanEntity;

@Transactional
@Repository
public class DonHangDao implements IDonHangDao{
	@Autowired
	SessionFactory factory;
	
	@Override
	public DonHangEntity getDHMoiTao() {
		Session session = factory.getCurrentSession();
		String hql = "from DonHang as dh order by dh.maDH desc";
		Query query = session.createQuery(hql);
		List<DonHangEntity> res = query.list();
		
		if(res.size() == 0) {
			return null;
		}
		
		return res.get(0);
	}
	
	@Override
	public List<DonHangEntity> getDSDonHangByMaKH(Long maKH){
		Session session = factory.getCurrentSession();
		String hql = "from DonHangEntity  where maKhachHang = :maKH ";
		Query query = session.createQuery(hql);
		query.setParameter("maKH", maKH);
		List< DonHangEntity> list = query.list();
		
		return list;
	}
	
	@Override
	public List<DonHangEntity> getDSDonHang(){
		Session session = factory.getCurrentSession();
		String hql = "from  DonHang";
		Query query = session.createQuery(hql);
		List<DonHangEntity> list = query.list();
		
		return list;
	}
	
	@Override
	public DonHangEntity getDHByMaDH(Integer maDH) {
		Session session = factory.getCurrentSession();
		String hql = "from DonHang where maDH = :maDH";
		Query query = session.createQuery(hql);
		query.setParameter("maDH", maDH);
		List<DonHangEntity> res = query.list();
		
		if(res.size() == 0) {
			return null;
		}
		
		return res.get(0);
	}
	
	@Override
	public Boolean themDonHang(DonHangEntity donHang) {
		Session session= factory.openSession();
		Transaction transaction= session.beginTransaction();
		try {		
			session.save(donHang);
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
	
	
	public long getIdLastBill() {
		long maDh = 0;
		Session session= factory.getCurrentSession();
		String hql="FROM DonHangEntity WHERE maDonHang = :(SELECT max(maDonHang) FROM DonHangEntity)";
		Query query= session.createQuery(hql);
		query.setParameter("maDh", maDh);
		return maDh;
	}
	
	@Override
	public Boolean xoaDonHang(DonHangEntity donHang) {
		Session session= factory.openSession();
		Transaction transaction= session.beginTransaction();
		try {		
			session.delete(donHang);
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
	
	
	//Linh
	@Override
	public List<DonHangEntity> getByDate(Date fromdate, Date todate) {
		Session session = factory.getCurrentSession();
		String hql = "from DonHangEntity WHERE thoiDiemDat >= :fromdate AND thoiDiemDat <= :todate";
		Query query = session.createQuery(hql);
		query.setParameter("fromdate", fromdate);
		query.setParameter("todate", todate);
		List<DonHangEntity> list = query.list();
		
		if(list.isEmpty()) {
			return null;
		}
		
		return list;
	}

	@Override
	public List<DonHangEntity> findAll() {
		Session session= factory.getCurrentSession();
		String hql="FROM DonHangEntity";
		Query query= session.createQuery(hql);
		List<DonHangEntity> list= query.list();
		return list;
	}

	@Override
	public DonHangEntity findOneByMaDH(Long maDH) {
		Session session= factory.getCurrentSession();
		String hql="FROM DonHangEntity WHERE maDonHang= :maDH";
		Query query= session.createQuery(hql);
		query.setParameter("maDH", maDH);
		List<DonHangEntity> list= query.list();
		if(list.size()==0) {
			return null;
		}
		return list.get(0);
	}

	
}
