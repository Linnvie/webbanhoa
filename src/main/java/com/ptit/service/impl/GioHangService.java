package com.ptit.service.impl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ptit.dao.impl.GioHangDao;
import com.ptit.dto.GioHangDto;
import com.ptit.service.IGioHangService;

@Service
public class GioHangService implements IGioHangService{
	@Autowired
	private GioHangDao cartDao = new GioHangDao();

	@Override
	public HashMap<Long, GioHangDto> themVaoGioHang(long id, HashMap<Long, GioHangDto> cart) {
		return cartDao.themVaoGioHang(id, cart);
	}

	@Override
	public HashMap<Long, GioHangDto> suaGioHang(long id, int sl, HashMap<Long, GioHangDto> cart) {
		return cartDao.suaGioHang(id, sl, cart);
	}

	@Override
	public HashMap<Long, GioHangDto> xoaGioHang(long id, HashMap<Long, GioHangDto> cart) {
		return cartDao.xoaGioHang(id, cart);
	}

	@Override
	public int tongSLGioHang(HashMap<Long, GioHangDto> cart) {
		return cartDao.tongSLGioHang(cart);
	}

	@Override
	public float tongGiaGioHang(HashMap<Long, GioHangDto> cart) {
		return cartDao.tongGiaGioHang(cart);
	}
	

}
