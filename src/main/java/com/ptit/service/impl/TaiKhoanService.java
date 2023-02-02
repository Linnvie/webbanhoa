package com.ptit.service.impl;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ptit.dao.ITaiKhoanDao;
import com.ptit.entity.TaiKhoanEntity;
import com.ptit.service.ITaiKhoanService;

@Service
public class TaiKhoanService implements ITaiKhoanService{
	@Autowired
	private ITaiKhoanDao tkDao;
	
	@Override
	public TaiKhoanEntity findOneByEmailAndMatKhau(String email, String mk) {
		TaiKhoanEntity tk= tkDao.findOneByEmail(email);
		if(tk!=null && BCrypt.checkpw(mk, tk.getMatKhau())) {
			return tk;
		}
		return null;
	}

	@Override
	public TaiKhoanEntity findOneByEmail(String email) {
		return tkDao.findOneByEmail(email);
	}

	@Override
	public Boolean themTaiKhoan(TaiKhoanEntity taiKhoanDangKi) {
		taiKhoanDangKi.setMatKhau(BCrypt.hashpw(taiKhoanDangKi.getMatKhau(), BCrypt.gensalt(12)));
		return tkDao.themTaiKhoan(taiKhoanDangKi);
	}

	@Override
	public Boolean suaTaiKhoan(TaiKhoanEntity taiKhoanSua) {
		return tkDao.suaTaiKhoan(taiKhoanSua);
	}

	

}
