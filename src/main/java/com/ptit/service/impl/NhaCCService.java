package com.ptit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ptit.dao.INhaCCDao;
import com.ptit.entity.NhaCungCapEntity;
import com.ptit.service.INhaCCService;

@Service
public class NhaCCService implements INhaCCService {
	@Autowired
	private INhaCCDao nccDao;

	@Override
	public Boolean themNCC(NhaCungCapEntity nccThem) {
		return nccDao.themNCC(nccThem);
	}

	@Override
	public Boolean suaNCC(NhaCungCapEntity nccSua) {
		return nccDao.suaNCC(nccSua);
	}

	@Override
	public List<NhaCungCapEntity> findAll() {
		return nccDao.findAll();
	}

	@Override
	public NhaCungCapEntity findOneByMaNCC(Integer maNCC) {
		return nccDao.findOneByMaNCC(maNCC);
	}

	@Override
	public Boolean xoaNCC(NhaCungCapEntity nccXoa) {
		return nccDao.xoaNCC(nccXoa);
	}
}
