package com.ptit.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ptit.entity.LoaiSanPhamEntity;

@Service
public interface ILoaiSPService {
	public Boolean themLSP(LoaiSanPhamEntity lspThem);
	public Boolean suaLSP(LoaiSanPhamEntity lspSua);
	public Boolean xoaLSP(LoaiSanPhamEntity lspXoa);
	public List<LoaiSanPhamEntity> findAll();
	public LoaiSanPhamEntity findOneByMaLoaiSP(Integer maLoaiSP);

}
