package com.ptit.dao;

import org.springframework.stereotype.Repository;

import com.ptit.entity.TaiKhoanEntity;

@Repository
public interface ITaiKhoanDao {
	public TaiKhoanEntity findOneByEmail(String email);
	public Boolean themTaiKhoan(TaiKhoanEntity taiKhoanDangKi);
	public Boolean suaTaiKhoan(TaiKhoanEntity taiKhoanSua);
}
