package com.ptit.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ptit.dao.IDonHangDao;
import com.ptit.dao.impl.ChiTietDonHangDao;
import com.ptit.dto.GioHangDto;
import com.ptit.entity.CTDHKey;
import com.ptit.entity.ChiTietDonHangEntity;
import com.ptit.entity.DonHangEntity;
import com.ptit.entity.SanPhamEntity;
import com.ptit.service.IDonHangService;

@Service
public class DonHangService implements IDonHangService{
	
	@Autowired
	private IDonHangDao dhDao;
	
	@Autowired
	private ChiTietDonHangDao ctdhDao;
	
	@Autowired
	private SanPhamService spService;

	@Override
	public DonHangEntity getDHMoiTao() {
		return dhDao.getDHMoiTao();
	}

	@Override
	public List<DonHangEntity> getDSDonHangByMaKH(Long maKH) {
		return dhDao.getDSDonHangByMaKH(maKH);
	}

	@Override
	public List<DonHangEntity> getDSDonHang() {
		return dhDao.getDSDonHang();
	}

	@Override
	public DonHangEntity getByMaDH(Integer maDH) {
		return dhDao.getDHByMaDH(maDH);
	}

	@Override
	public Boolean themDH(DonHangEntity dh) {
		return dhDao.themDonHang(dh);
	}

//	@Override
//	public Boolean suaDH(DonHangEntity dh) {
//		return dhDao.;
//	}

	@Override
	public Boolean xoaDH(DonHangEntity dh) {
		return dhDao.xoaDonHang(dh);
	}

	

	@Override
	public void themChiTietDonHang(HashMap<Long, GioHangDto> cart,Long maDH) {
//		Long maDhMoi = dhDao.getIdLastBill();
		for(Map.Entry<Long, GioHangDto> itemCart : cart.entrySet()) {	
			if(itemCart.getValue().getsLuong() <= itemCart.getValue().getSp().getTonKho()) {
				ChiTietDonHangEntity ctdh = new ChiTietDonHangEntity();
				ctdh.setId(new CTDHKey());
				ctdh.getId().setMaSanPham(itemCart.getValue().getSp().getMaSanPham());
				ctdh.getId().setMaDonHang(maDH);
				ctdh.setSoLuong(itemCart.getValue().getsLuong());
				ctdh.setGiaTien((float) itemCart.getValue().getSp().getGiaBan());
				ctdhDao.themChiTietDH(ctdh);
				SanPhamEntity spCu = spService.findOneByMaSanPham(itemCart.getValue().getSp().getMaSanPham());
				spCu.setTonKho(spCu.getTonKho() - itemCart.getValue().getsLuong());
			}
		}
		
	}
	
	
	
	//Linh
	@Override
	public List<DonHangEntity> getByDate(Date fromdate, Date todate) {
		return dhDao.getByDate(fromdate, todate);
	}

	@Override
	public List<DonHangEntity> findAll() {
		return dhDao.findAll();
	}

	@Override
	public DonHangEntity findOneByMaDH(Long maDH) {
		return dhDao.findOneByMaDH(maDH);
	}
	
	
	

}
