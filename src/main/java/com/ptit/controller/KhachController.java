package com.ptit.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ptit.entity.DonHangEntity;
import com.ptit.entity.KhachHangEntity;
import com.ptit.entity.TaiKhoanEntity;
import com.ptit.service.ISanPhamService;
import com.ptit.service.impl.DonHangService;
import com.ptit.service.impl.KhachHangService;
import com.ptit.service.impl.TaiKhoanService;

@Controller

public class KhachController {
	
	@Autowired
	TaiKhoanService taiKhoanService;
	
	@Autowired
	KhachHangService khachHangService;
	
	@Autowired
	DonHangService donHangService;
	
	@Autowired
	private ISanPhamService sp;
	
//	@RequestMapping (value ="/trang-chu", method=RequestMethod.GET)
//	public String showIndex(ModelMap model) {
//		model.addAttribute("sanpham", sp.findAll());
//		return "web/NewFile";
//	}
	
	@RequestMapping (value ="/about", method=RequestMethod.GET)
	public String showabout(ModelMap model) {
		return "web/about";
	}
	
	@RequestMapping(value="/tai-khoan", method=RequestMethod.GET)
	public String suaTaiKhoan(ModelMap model, HttpSession session) {
		model.addAttribute("khachhang", new KhachHangEntity());
		TaiKhoanEntity tk = (TaiKhoanEntity) session.getAttribute("user");
		List<DonHangEntity> dsdh = donHangService.getDSDonHangByMaKH(tk.getKhachHang().getMaKH());
		model.addAttribute("dsdh", dsdh);
		return "web/taikhoan";
	}
	
	@RequestMapping(value="/tai-khoan", method=RequestMethod.POST)
	public String suaTTKhachHang(ModelMap model, HttpSession session, @ModelAttribute("khachhang") KhachHangEntity khachhang, BindingResult errors) {
		
//		if (khachhang.getHo().trim().isEmpty()) {
//			errors.rejectValue("ho", "khachhang", "Há»� khÃ´ng Ä‘Æ°á»£c Ä‘á»ƒ trá»‘ng");
//		}
//
//		if (khachhang.getTen().trim().isEmpty()) {
//			errors.rejectValue("ten", "khachhang", "TÃªn khÃ´ng Ä‘Æ°á»£c Ä‘á»ƒ trá»‘ng");
//		}
//
//		if (khachhang.getDiaChi().trim().isEmpty()) {
//			errors.rejectValue("ngaySinh", "khachhang", "Ä�á»‹a chá»‰ khÃ´ng Ä‘Æ°á»£c Ä‘á»ƒ trá»‘ng");
//		}
//
//		if (khachhang.getSdt().trim().isEmpty()) {
//			errors.rejectValue("sdt", "khachhang", "Sá»‘ Ä‘iá»‡n thoáº¡i khÃ´ng Ä‘Æ°á»£c Ä‘á»ƒ trá»‘ng");
//		} else if (!khachhang.getSdt().trim().matches("^[0-9]*$")) {
//			errors.rejectValue("sdt", "khachhang", "Sá»‘ Ä‘iá»‡n thoáº¡i khÃ´ng há»£p lá»‡");
//		}
//
//		if (errors.hasErrors()) {
//
//			return "web/taikhoan";
//		}

		TaiKhoanEntity tk = (TaiKhoanEntity) session.getAttribute("user");
		KhachHangEntity khachhangcu = tk.getKhachHang();
		if (!khachhangcu.getHo().equals(khachhang.getHo())) {
			khachhangcu.setHo(khachhang.getHo());
		}

		if (!khachhangcu.getTen().equals(khachhang.getTen())) {
			khachhangcu.setTen(khachhang.getTen());
		}

		if (khachhangcu.getGioiTinh() != khachhang.getGioiTinh()) {
			khachhangcu.setGioiTinh(khachhang.getGioiTinh());
		}

		if (!khachhangcu.getDiaChi().equals(khachhang.getDiaChi())) {
			khachhangcu.setDiaChi(khachhang.getDiaChi());
		}

		if (!khachhangcu.getSdt().equals(khachhang.getSdt())) {
			khachhangcu.setSdt(khachhang.getSdt());
		}
		

		if (khachHangService.suaKH(khachhangcu)) {
			//khachhangcu = khachHangService.getByMaKH(tk.getKhachHang().getMaKH());
			//tk.setKhachHang(khachhangcu);

			session.setAttribute("user", tk);
//			model.addAttribute("alertMessage", "Sá»­a thÃ´ng tin cÃ¡ nhÃ¢n thÃ nh cÃ´ng");
			model.addAttribute("khachhang", khachhangcu);

		} else {
		
//			model.addAttribute("alertMessage", "Sá»­a thÃ´ng tin cÃ¡ nhÃ¢n tháº¥t báº¡i");
		}
		
		return "web/taikhoan";
	}
	

}
