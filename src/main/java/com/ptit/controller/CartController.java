package com.ptit.controller;

import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ptit.dto.GioHangDto;
import com.ptit.entity.DonHangEntity;
import com.ptit.entity.TaiKhoanEntity;
import com.ptit.service.ISanPhamService;
import com.ptit.service.impl.ChiTietDonHangService;
import com.ptit.service.impl.ChiTietSPService;
import com.ptit.service.impl.DonHangService;
import com.ptit.service.impl.GioHangService;

@Controller

public class CartController {
	
	@Autowired
	private GioHangService cartService = new GioHangService();
	
	@Autowired
	private DonHangService billService = new DonHangService();
	
	@Autowired
	private ChiTietSPService ctspService = new ChiTietSPService();
	
	@Autowired
	private ChiTietDonHangService ctdhService = new ChiTietDonHangService();
	
	@RequestMapping(value="/gio-hang", method=RequestMethod.GET)
	public String showLogin(ModelMap model) {
		return "web/giohang";
	}
	
	@RequestMapping(value="/them-vao-gio-hang/{id}")
	public String themVaoGioHang(HttpServletRequest request, HttpSession session, @PathVariable long id) {
		
		HashMap<Long, GioHangDto> cart = (HashMap<Long, GioHangDto>) session.getAttribute("Cart");
		if(cart == null) {
			cart = new HashMap<Long, GioHangDto>();
		}
		cart = cartService.themVaoGioHang(id, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("TongSL", cartService.tongSLGioHang(cart));
		session.setAttribute("TongGia", cartService.tongGiaGioHang(cart));
		return "redirect:" + request.getHeader("Referer");
	}
	
	
	@RequestMapping(value="/sua-gio-hang/{id}/{quanty}")
	public String chinhSuaGioHang(HttpServletRequest request, HttpSession session, @PathVariable long id, @PathVariable int quanty) {
		
		HashMap<Long, GioHangDto> cart = (HashMap<Long, GioHangDto>) session.getAttribute("Cart");
		if(cart == null) {
			cart = new HashMap<Long, GioHangDto>();
		}
		cart = cartService.suaGioHang(id, quanty, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("TongSL", cartService.tongSLGioHang(cart));
		session.setAttribute("TongGia", cartService.tongGiaGioHang(cart));
		return "redirect:" + request.getHeader("Referer");
	}
	
	
	@RequestMapping(value="/xoa-gio-hang/{id}")
	public String xoaGioHang(HttpServletRequest request, HttpSession session, @PathVariable long id) {
		
		HashMap<Long, GioHangDto> cart = (HashMap<Long, GioHangDto>) session.getAttribute("Cart");
		if(cart == null) {
			cart = new HashMap<Long, GioHangDto>();
		}
		cart = cartService.xoaGioHang(id, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("TongSL", cartService.tongSLGioHang(cart));
		session.setAttribute("TongGia", cartService.tongGiaGioHang(cart));
		return "redirect:" + request.getHeader("Referer");
	}
		
	@RequestMapping(value="/thanh-toan", method=RequestMethod.GET)
	public String showThongTinThanhToan(HttpServletRequest request, HttpSession session, ModelMap model) {
		
		DonHangEntity dh =  new DonHangEntity();
		TaiKhoanEntity loginInfo = (TaiKhoanEntity) session.getAttribute("LoginInfo");
		if(loginInfo != null) {
			dh.setDiaChiGiao(loginInfo.getKhachHang().getDiaChi());
			dh.setNguoiNhan(loginInfo.getKhachHang().getHo() + loginInfo.getKhachHang().getTen());
			dh.setSdtGiaoHang(loginInfo.getKhachHang().getSdt());
		}
		System.out.print("get");
		model.addAttribute("dh", dh);
		return "web/thanhtoan";
	}
	
	
	@RequestMapping(value="/thanh-toan", method=RequestMethod.POST)
	public String thanhToanDonHang(HttpServletRequest request, HttpSession session, ModelMap model,
			@ModelAttribute("dh") DonHangEntity dh) {
		//HashMap<Long, GioHangDto> cart1= (HashMap<Long, GioHangDto>) session.getAttribute("Cart");
		//System.out.print("check"+cart1.toString());
		dh.setTongTien( (float) session.getAttribute("TongGia"));
		
		//dh.setTongTien(1000000);
		dh.setThoiDiemDat(new Date());
		TaiKhoanEntity tk=(TaiKhoanEntity) session.getAttribute("user");
		dh.setMaKhachHang((long) tk.getKhachHang().getMaKH());
		dh.setMaTinhTrangDon(1);
		if(billService.themDH(dh)) {
			HashMap<Long, GioHangDto> cart = (HashMap<Long, GioHangDto>) session.getAttribute("Cart");
			billService.themChiTietDonHang(cart,dh.getMaDonHang());
			return "web/trangchu";
		}
		session.removeAttribute("Cart");
	
		return "web/thanhtoan";
	}

}
