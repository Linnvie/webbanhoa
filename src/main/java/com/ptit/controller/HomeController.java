package com.ptit.controller;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ptit.entity.LoaiSanPhamEntity;
import com.ptit.entity.SanPhamEntity;

@Transactional
@Controller
public class HomeController {

	@Autowired
	SessionFactory factory;
	
	@RequestMapping("/trang-chu")
	public String index(ModelMap model) {
		List<SanPhamEntity> sanpham = this.getSanPham();
		
		model.addAttribute("sanpham", sanpham);
		
		List<LoaiSanPhamEntity> sanpham1 = this.getLSanPham();
		
		model.addAttribute("category", sanpham1);
		return "web/trangchu";
	}
	
	public List<SanPhamEntity> getSanPham(){
		Session session = factory.getCurrentSession();
		String hql = "FROM SanPhamEntity";
		Query query = session.createQuery(hql);
		List<SanPhamEntity> list = query.list();
		return list;
	}
	public List<LoaiSanPhamEntity> getLSanPham(){
		Session session = factory.getCurrentSession();
		String hql = "FROM LoaiSanPhamEntity";
		Query query = session.createQuery(hql);
		List<LoaiSanPhamEntity> list = query.list();
		return list;
	}
}
