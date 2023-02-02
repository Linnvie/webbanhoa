package com.ptit.controller;

import javax.transaction.Transactional;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ptit.service.ILoaiSPService;
import com.ptit.service.ISanPhamService;


@Transactional
@Controller
@RequestMapping()
public class CategoryController {
	@Autowired
	SessionFactory factory;
	
	@Autowired
	private ISanPhamService loai;
	
	@RequestMapping(value = "/category/{maLoaiSP}")
	public ModelAndView Product(@PathVariable Integer maLoaiSP , ModelMap model) {
		ModelAndView mv = new ModelAndView("web/flowers");
		mv.addObject("maLoaiSanPham", maLoaiSP);
		model.addAttribute("loai", loai.findAllByMaLoaiSP(maLoaiSP));
	//	mv.addObject("loai", loai.findAllByMa(maLoaiSP));
		return mv;
	}
	
	
}
