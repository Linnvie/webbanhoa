package com.ptit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ptit.dao.IVatLlieuDao;
import com.ptit.entity.VatLieuEntity;
import com.ptit.service.IVatLieuService;

@Service
public class VatLieuService implements IVatLieuService{
	@Autowired
	private IVatLlieuDao vlDao;

	@Override
	public List<VatLieuEntity> findAll() {
		return vlDao.findAll();
	}

	@Override
	public Boolean themVatLieu(VatLieuEntity vatLieuThem) {
		return vlDao.themVatLieu(vatLieuThem);
	}

	@Override
	public Boolean suaVatLlieu(VatLieuEntity vatLieuSua) {
		return vlDao.suaVatLlieu(vatLieuSua);
	}

	@Override
	public VatLieuEntity findOneByMaVatLieu(Long maVL) {
		return vlDao.findOneByMaVatLieu(maVL);
	}

	@Override
	public Boolean xoaVatLieu(VatLieuEntity vatLieuXoa) {
		return vlDao.xoaVatLlieu(vatLieuXoa);
	}

}
