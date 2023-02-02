package com.ptit.controller;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ptit.entity.SanPhamEntity;

@Transactional
@Controller
@RequestMapping()
public class SanPhamController {
	@Autowired
	SessionFactory factory;
	
	@RequestMapping("/chi-tiet-san-pham/{maSanPham}")
	public ModelAndView Index(@PathVariable long maSanPham) {
		ModelAndView mv = new ModelAndView("web/chitiet");
		mv.addObject("sanpham", getSanPhamID(maSanPham));
		return mv;
	}
	
	public List<SanPhamEntity> getSanPham(){
		Session session = factory.getCurrentSession();
		String hql = "FROM SanPhamEntity";
		Query query = session.createQuery(hql);
		List<SanPhamEntity> list = query.list();
		return list;
	}
	
	public List<SanPhamEntity> getSanPhamID(Long maSanPham){
		Session session = factory.getCurrentSession();
		String hql = "FROM SanPhamEntity where maSanPham = :maSanPham";
		Query query = session.createQuery(hql);
		query.setParameter("maSanPham", maSanPham);
		List<SanPhamEntity> list = query.list();
		return list;
	}
	
	
	
}
