package com.ptit.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ptit.entity.NhaCungCapEntity;

@Repository
public interface INhaCCDao {
	public Boolean themNCC(NhaCungCapEntity nccThem);
	public Boolean suaNCC(NhaCungCapEntity nccSua);
	public Boolean xoaNCC(NhaCungCapEntity nccXoa);
	public List<NhaCungCapEntity> findAll();
	public NhaCungCapEntity findOneByMaNCC(Integer maNCC);
}
