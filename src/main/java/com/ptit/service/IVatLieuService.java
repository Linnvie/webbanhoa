package com.ptit.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ptit.entity.VatLieuEntity;

@Service
public interface IVatLieuService {
	public List<VatLieuEntity> findAll();
	public VatLieuEntity findOneByMaVatLieu(Long maVL);
	public Boolean themVatLieu(VatLieuEntity vatLieuThem);
	public Boolean suaVatLlieu(VatLieuEntity vatLieuSua);
	public Boolean xoaVatLieu(VatLieuEntity vatLieuXoa);
}
