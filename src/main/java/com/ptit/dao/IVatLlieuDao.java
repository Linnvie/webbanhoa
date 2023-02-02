package com.ptit.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ptit.entity.VatLieuEntity;

@Repository
public interface IVatLlieuDao {
	public Boolean themVatLieu(VatLieuEntity vatLieuThem);
	public Boolean suaVatLlieu(VatLieuEntity vatLieuSua);
	public Boolean xoaVatLlieu(VatLieuEntity vatLieuXoa);
	public List<VatLieuEntity> findAll();
	public VatLieuEntity findOneByMaVatLieu(Long maVL);
}
