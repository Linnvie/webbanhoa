package com.ptit.service;

import org.springframework.stereotype.Service;

import com.ptit.entity.TaiKhoanEntity;

@Service
public interface ITaiKhoanService {
	public TaiKhoanEntity findOneByEmailAndMatKhau(String email, String mk);
	public TaiKhoanEntity findOneByEmail(String email);
	public Boolean themTaiKhoan(TaiKhoanEntity taiKhoanDangKi);
	public Boolean suaTaiKhoan(TaiKhoanEntity taiKhoanSua);
}
