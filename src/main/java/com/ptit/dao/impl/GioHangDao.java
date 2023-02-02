package com.ptit.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ptit.dto.GioHangDto;
import com.ptit.entity.SanPhamEntity;

@Repository
public class GioHangDao {
	@Autowired
	SanPhamDao spDao = new SanPhamDao();
	
	public HashMap<Long, GioHangDto> themVaoGioHang(long id, HashMap<Long, GioHangDto> cart) {
		GioHangDto itemCart = new GioHangDto();
		SanPhamEntity sp = spDao.findOneByMaSanPham(id);
		if(sp != null && cart.containsKey(id)) {
			itemCart =  cart.get(id);
			itemCart.setsLuong(itemCart.getsLuong() + 1);
			itemCart.setTongGia(itemCart.getsLuong() * itemCart.getSp().getGiaBan());
		}
		else {
			itemCart.setSp(sp);
			itemCart.setsLuong(1);
			itemCart.setTongGia(sp.getGiaBan());
		}
		cart.put(id, itemCart);
		return cart;
	}
	
	public HashMap<Long, GioHangDto> suaGioHang(long id, int sl, HashMap<Long, GioHangDto> cart) {
		if(cart == null) {
			return cart;
		}
		GioHangDto itemCart = new GioHangDto();
		if(cart.containsKey(id)) {
			itemCart = cart.get(id);
			itemCart.setsLuong(sl);
			Float tongGia = sl * itemCart.getSp().getGiaBan();
			itemCart.setTongGia(tongGia);
		}
		cart.put(id, itemCart);
		return cart;
	}
	
	public HashMap<Long, GioHangDto> xoaGioHang(long id, HashMap<Long, GioHangDto> cart) {
		if(cart == null) {
			return cart;
		}
		if(cart.containsKey(id)) {
			cart.remove(id);
		}
		return cart;
	}
	
	public int tongSLGioHang(HashMap<Long, GioHangDto> cart) {
		int tongSL = 0;
		for (Map.Entry<Long, GioHangDto> itemCart : cart.entrySet()) {
			
			tongSL += itemCart.getValue().getsLuong();
		}
		return tongSL;
	}
	
	public float tongGiaGioHang(HashMap<Long, GioHangDto> cart) {
		float tongGia = 0;
		for (Map.Entry<Long, GioHangDto> itemCart : cart.entrySet()) {
			
			tongGia += itemCart.getValue().getSp().getGiaBan();
		}
		return tongGia;
	}

}
