package com.ptit.service;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.ptit.dto.GioHangDto;

@Service
public interface IGioHangService {
	public HashMap<Long, GioHangDto> themVaoGioHang(long id, HashMap<Long, GioHangDto> cart);
	public HashMap<Long, GioHangDto> suaGioHang(long id, int sl, HashMap<Long, GioHangDto> cart);
	public HashMap<Long, GioHangDto> xoaGioHang(long id, HashMap<Long, GioHangDto> cart);
	public int tongSLGioHang(HashMap<Long, GioHangDto> cart);
	public float tongGiaGioHang(HashMap<Long, GioHangDto> cart);
	

}
