package com.ptit.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ptit.entity.PhieuXuatSPEntity;

@Repository
public interface IPhieuXuatSPDao {
	public PhieuXuatSPEntity findOneByMaPX(Long maPX);
	public List<PhieuXuatSPEntity> findAll();
	public Boolean thempPhieuXuat(PhieuXuatSPEntity phieuXuatThem);
	public Boolean xoaPhieuXuat(PhieuXuatSPEntity phieuXuatXoa);
}
