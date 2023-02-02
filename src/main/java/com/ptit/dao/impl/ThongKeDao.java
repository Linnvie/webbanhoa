package com.ptit.dao.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ptit.dao.IThongKeDao;

@Transactional
@Repository
public class ThongKeDao implements IThongKeDao{
	@Autowired
	SessionFactory factory;

	@Override
	public List<Object> CountAllSPGroupByMaLoaiSP() {
		Session session= factory.getCurrentSession();
		String hql="SELECT loaiSP.maLoaiSP, loaiSP.tenLoaiSP, COUNT(maSanPham) AS slSP FROM SanPhamEntity GROUP BY loaiSP.maLoaiSP, loaiSP.tenLoaiSP";
		Query query= session.createQuery(hql);
		List<Object> list= query.list();
		if(list.size()==0) {
			return null;
		}
		return list;
	}

	@Override
	public List<Object> CountDoanhThuBySP(Date fromDate, Date toDate) {
		Session session= factory.getCurrentSession();
		String hql="SELECT sanPham.maSanPham, sanPham.tenSanPham, SUM(PROD(soLuong, giaTien)) AS doanhThu"
				+ " FROM ChiTietDonHangEntity"
				+" WHERE donHang.thoiDiemDat>= :fromDate AND donHang.thoiDiemDat <= :toDate"
				+ " GROUP BY sanPham.maSanPham, sanPham.tenSanPham";
		Query query= session.createQuery(hql);
		query.setParameter("fromDate", fromDate);
		query.setParameter("toDate", toDate);
		List<Object> list= query.list();
		if(list.size()==0) {
			return null;
		}
		return list;
	}

	@Override
	public List<Object> CountaLLDoanhThuBySP() {
		Session session= factory.getCurrentSession();
		String hql="SELECT SanPhamEntity.maSanPham, SanPhamEntity.tenSanPham, SUM(PROD(ChiTietDonHangEntity.soLuong, ChiTietDonHangEntity.giaTien)) AS doanhThu"
				+ " FROM ChiTietDonHangEntity, SanPhamEntity"
				+" WHERE ChiTietDonHangEntity.id.maSanPham = SanPhamEntity.maSanPham"
				+ " GROUP BY SanPhamEntity.maSanPham, SanPhamEntity.tenSanPham";
		Query query= session.createQuery(hql);
		List<Object> list= query.list();
		if(list.size()==0) {
			return null;
		}
		return list;
	}

	

	

}
