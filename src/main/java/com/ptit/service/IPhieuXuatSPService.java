package com.ptit.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ptit.entity.PhieuXuatSPEntity;

@Service
public interface IPhieuXuatSPService {
	public PhieuXuatSPEntity findOneByMaPX(Long maPX);
	public List<PhieuXuatSPEntity> findAll();
	public Boolean thempPhieuXuat(PhieuXuatSPEntity phieuXuatThem);
	public Boolean xoaPhieuXuat(PhieuXuatSPEntity phieuXuatXoa);
}
