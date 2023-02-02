package com.ptit.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ptit.bean.DoanhThuTheoSanPham;
import com.ptit.entity.CTPNKey;
import com.ptit.entity.CTPXSPKey;
import com.ptit.entity.CTSPKey;
import com.ptit.entity.ChiTietDonHangEntity;
import com.ptit.entity.ChiTietPhieuNhapEntity;
import com.ptit.entity.ChiTietPhieuXuatSPEntity;
import com.ptit.entity.ChiTietSanPhamEntity;
import com.ptit.entity.DonHangEntity;
import com.ptit.entity.KhachHangEntity;
import com.ptit.entity.LoaiSanPhamEntity;
import com.ptit.entity.NhaCungCapEntity;
import com.ptit.entity.PhieuNhapEntity;
import com.ptit.entity.PhieuXuatSPEntity;
import com.ptit.entity.QuanLiEntity;
import com.ptit.entity.SanPhamEntity;
import com.ptit.entity.TaiKhoanEntity;
import com.ptit.entity.VatLieuEntity;
import com.ptit.service.IChiTietDonHangService;
import com.ptit.service.IChiTietPhieuNhapService;
import com.ptit.service.IChiTietPhieuXuatSPService;
import com.ptit.service.IChiTietSPService;
import com.ptit.service.IDonHangService;
import com.ptit.service.IKhachHangService;
import com.ptit.service.ILoaiSPService;
import com.ptit.service.INhaCCService;
import com.ptit.service.IPhieuNhapService;
import com.ptit.service.IPhieuXuatSPService;
import com.ptit.service.IQuanLiSservice;
import com.ptit.service.ISanPhamService;
import com.ptit.service.ITaiKhoanService;
import com.ptit.service.IThongKeService;
import com.ptit.service.IVatLieuService;
import com.ptit.service.impl.UtilsService;


@Controller
@RequestMapping(value="/quan-tri/")
public class QuanLiController {
	
	@Autowired
	private INhaCCService nccService;
	
	@Autowired
	private IPhieuNhapService pnService;
	
	@Autowired
	private IQuanLiSservice qlService;
	
	@Autowired
	private ITaiKhoanService tkService;
	
	@Autowired
	private IChiTietPhieuNhapService ctpnService;
	
	@Autowired
	private IVatLieuService vlService;
	
	@Autowired
	private ILoaiSPService lspService;
	
	@Autowired
	private ISanPhamService spService;
	
	@Autowired 
	private IChiTietSPService ctspService;
	
	@Autowired
	private IPhieuXuatSPService pxspService;
	
	@Autowired 
	private IChiTietPhieuXuatSPService ctpxService;
	
	@Autowired 
	private IChiTietDonHangService ctdhService;
	
	@Autowired 
	private IDonHangService dhService;
	
	@Autowired 
	private IKhachHangService khService;
	
	@Autowired
	private UtilsService utilsService;
	
	@Autowired
	private IThongKeService thongKeService;
	
	String regexSoLuong ="^\\\\d+$";
	String regexGia =" ^\\\\b\\\\d+(\\\\.\\\\d+)?\\\\b$ ";
	List<DoanhThuTheoSanPham> thongKeDoanhThu = new ArrayList<DoanhThuTheoSanPham>();
	
	@RequestMapping(value = "tong-quan", method = RequestMethod.GET)
	public String getViewTongQuan(ModelMap model, HttpSession ss) {
//		ss.setAttribute("fromDate", "");
//		ss.setAttribute("toDate", "");
		//model.addAttribute("isOpenModalEditUser", false);
		model.addAttribute("sptheoloai", thongKeService.CountAllSPGroupByMaLoaiSP());

		return "admin/tongquan";
	}
	
	@RequestMapping(value = "thong-ke", method = RequestMethod.GET)
	public String getViewThongKe(ModelMap model) {
		//model.addAttribute("isOpenModalInfo", false);
		//model.addAttribute("doanhthusp", thongKeService.CountaLLDoanhThuBySP());
		return "admin/ThongKe";
	}
	
	@RequestMapping(value = "thong-ke", params = "thongke", method = RequestMethod.POST)
	public String ThongKeTheoSP(ModelMap model, HttpSession ss,
			@RequestParam(name = "fromDate", required = false) String from,
			@RequestParam(name = "toDate", required = false) String to) throws ParseException {
		thongKeDoanhThu.clear();
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");

		System.out.println(from);

		Date fromdate = null;
		Date todate = null;

		if (from != "") {
			fromdate = f.parse(from);
		}
		if (to != "") {
			todate = f.parse(to);
		}

		if (fromdate == null) {
			model.addAttribute("fromdate", "chưa chọn ngày");
			return "admin/ThongKe";
		}
		if (todate == null) {
			model.addAttribute("todate", "chưa chọn ngày");
			return "admin/ThongKe";
		}

//		DateFormat fd = new SimpleDateFormat("yyyy/MM/dd");
//		DateFormat t = new SimpleDateFormat("yyyy/MM/dd");

		System.out.println(fromdate);

		List<DonHangEntity> listdh = dhService.getByDate(fromdate, todate);
//		System.out.println(dh.get(0).getMaDH());
		if (listdh != null) {
			for (int i = 0; i < listdh.size(); i++) {
				List<ChiTietDonHangEntity> listctdh = ctdhService.findAllByMaDonHang(listdh.get(i).getMaDonHang());
				for (int j = 0; j < listctdh.size(); j++) {
					boolean check = false;
					double doanhthu = (double) (listctdh.get(j).getGiaTien()*listctdh.get(j).getSoLuong());
					for (int z = 0; z < thongKeDoanhThu.size(); z++) {
						if (listctdh.get(j).getSanPham().getMaSanPham() == thongKeDoanhThu.get(z).getMaSP()) {
							thongKeDoanhThu.get(z).setDoanhThu(doanhthu + thongKeDoanhThu.get(z).getDoanhThu());
							check = true;
							break;
						}
					}
					if (check == false) {
						DoanhThuTheoSanPham dt = new DoanhThuTheoSanPham();
						dt.setMaSP(listctdh.get(i).getSanPham().getMaSanPham());
						dt.setTenSP(listctdh.get(i).getSanPham().getTenSanPham());
						dt.setDoanhThu(doanhthu);
						thongKeDoanhThu.add(dt);
					}
				}
			}
		}

		model.addAttribute("listDoanhThuCoNgay", thongKeDoanhThu);
		return "admin/ThongKe";
	}
	
	@RequestMapping(value="them-vat-lieu", method=RequestMethod.GET)
	public String showVatLieu(ModelMap model) {
		model.addAttribute("vatLieu",new VatLieuEntity());
		model.addAttribute("dsvl", vlService.findAll());
		return "admin/themvatlieu";
	}
	
	@RequestMapping(value="them-vat-lieu", method=RequestMethod.POST,params="btnAdd")
	public String postVL(ModelMap model,HttpServletRequest request, HttpSession ss,
			 @ModelAttribute("vatLieu") VatLieuEntity vatLieu,
			BindingResult errors) {
		if (vatLieu.getTenVatLieu().trim().isEmpty()) {
			errors.rejectValue("tenVatLieu", "vatLieu", "Tên vật liệu không được để trống!");
		}

		if (errors.hasErrors()) {
			model.addAttribute("isOpenModalAdd", true);
			model.addAttribute("dsvl", vlService.findAll());
			return "admin/themvatlieu";
		}
		if(vlService.themVatLieu(vatLieu)) {
			model.addAttribute("message", "Thêm mới thành công!");
		}
		else {
			model.addAttribute("message", "Thêm mới thất bại!");
		}
		model.addAttribute("dsvl", vlService.findAll());
		return "admin/themvatlieu";
	}

	@RequestMapping(value="them-vat-lieu/{maVatLieu}", params= "linkEdit")
	public String editVL(ModelMap model,  @ModelAttribute("vatLieu") VatLieuEntity vatLieu,
			HttpServletRequest request, HttpSession ss,
			@PathVariable("maVatLieu") Long maVatLieu) {
		model.addAttribute("vatLieu", vlService.findOneByMaVatLieu(maVatLieu));	
		model.addAttribute("isOpenModalEdit", true);
		model.addAttribute("dsvl", vlService.findAll());	
		return "admin/themvatlieu";
	}
	
	@RequestMapping(value="them-vat-lieu", method=RequestMethod.POST,params="btnEdit")
	public String editVL(ModelMap model, @ModelAttribute("vatLieu") VatLieuEntity vatLieu,
			HttpServletRequest request, HttpSession ss,
			@RequestParam("maVatLieu") Long maVatLieu,
			 BindingResult errors) {
		if (vatLieu.getTenVatLieu().trim().isEmpty()) {
			errors.rejectValue("tenVatLieu", "vatLieu", "Tên vật liệu không được để trống!");
		}
		if (errors.hasErrors()) {
			model.addAttribute("isOpenModalEdit", true);
			model.addAttribute("dsvl", vlService.findAll());
			return "admin/themvatlieu";
		}
		if(vlService.suaVatLlieu(vatLieu)) {
			model.addAttribute("message", "Sửa thành công!");
		} else {
			model.addAttribute("message", "Sửa thất bại");
		}
		model.addAttribute("dsvl", vlService.findAll());
		return "admin/themvatlieu";
	}
	
	@RequestMapping(value="tao-vat-lieu", params= "linkDelete", method=RequestMethod.POST)
	public String deleteVL(ModelMap model,
			HttpServletRequest request, HttpSession ss,
			@RequestParam("maVatLieu") Long maVatLieu) {
		VatLieuEntity vl=vlService.findOneByMaVatLieu(maVatLieu);
		if(vlService.xoaVatLieu(vl)) {
			model.addAttribute("message", "Xóa thành công");
		}
		else {
			model.addAttribute("message", "XóaThất bại");
		}
		model.addAttribute("dsvl", vlService.findAll());
		return "redirect:/quan-tri/tao-vat-lieu";
		
	}
	
	@RequestMapping(value="loai-sp", method=RequestMethod.GET)
	public String showLSP(ModelMap model) {
		model.addAttribute("loaiSP",new LoaiSanPhamEntity());
		model.addAttribute("dslsp", lspService.findAll());
		return "admin/loaisp";
	}
	
	@RequestMapping(value="loai-sp", method=RequestMethod.POST,params="btnAdd")
	public String postLSP(ModelMap model,HttpServletRequest request, HttpSession ss,
			 @ModelAttribute("loaiSP") LoaiSanPhamEntity loaiSP ,
			BindingResult errors) {
		if (loaiSP.getTenLoaiSP().trim().isEmpty()) {
			errors.rejectValue("tenLoaiSP", "loaiSP", "Tên loại sản phẩm không được để trống!");
		}

		if (errors.hasErrors()) {
			model.addAttribute("isOpenModalAdd", true);
			model.addAttribute("dslsp", lspService.findAll());
			return "admin/loaisp";
		}
		if(lspService.themLSP(loaiSP)) {
			model.addAttribute("message", "Thêm mới thành công!");
		}
		else {
			model.addAttribute("message", "Thêm mới thất bại!");
		}
		model.addAttribute("dslsp", lspService.findAll());
		return "admin/loaisp";
	}

	@RequestMapping(value="loai-sp/{maLoaiSP}", params= "linkEdit")
	public String editLSP(ModelMap model, @ModelAttribute("loaiSP") LoaiSanPhamEntity loaiSP ,
			HttpServletRequest request, HttpSession ss,
			@PathVariable("maLoaiSP") Integer maLoaiSP) {
		model.addAttribute("loaiSP", lspService.findOneByMaLoaiSP(maLoaiSP));	
		model.addAttribute("isOpenModalEdit", true);
		model.addAttribute("dslsp", lspService.findAll());	
		return "admin/loaisp";
	}
	
	@RequestMapping(value="loai-sp", method=RequestMethod.POST,params="btnEdit")
	public String editLSP(ModelMap model, @ModelAttribute("loaiSP") LoaiSanPhamEntity loaiSP ,
			HttpServletRequest request, HttpSession ss,
			@RequestParam("maLoaiSP") Integer maLoaiSP,
			 BindingResult errors) {
		if (loaiSP.getTenLoaiSP().trim().isEmpty()) {
			errors.rejectValue("tenLoaiSP", "loaiSP", "Tên loại sản phẩm không được để trống!");
		}
		if (errors.hasErrors()) {
			model.addAttribute("isOpenModalEdit", true);
			model.addAttribute("dslsp", lspService.findAll());
			return "admin/loaisp";
		}
		if(lspService.suaLSP(loaiSP)) {
			model.addAttribute("message", "Sửa thành công!");
		} else {
			model.addAttribute("message", "Sửa thất bại");
		}
		model.addAttribute("dslsp", lspService.findAll());
		return "admin/loaisp";
	}
	
	@RequestMapping(value="loai-sp", params= "linkDelete", method=RequestMethod.POST)
	public String deleteLSP(ModelMap model,
			HttpServletRequest request, HttpSession ss,
			@RequestParam("maLoaiSP") Integer maLoaiSP) {
		LoaiSanPhamEntity lsp=lspService.findOneByMaLoaiSP(maLoaiSP);
		if(lspService.xoaLSP(lsp)) {
			model.addAttribute("message", "Xóa thành công");
		}
		else {
			model.addAttribute("message", "XóaThất bại");
		}
		model.addAttribute("dslsp", lspService.findAll());
		return "redirect:/quan-tri/loai-sp";
		
	}
	
	@RequestMapping(value="tao-phieu-nhap", method=RequestMethod.GET)
	public String showPhieuNhap(ModelMap model) {
		model.addAttribute("phieuNhap",new PhieuNhapEntity());
		model.addAttribute("dspn", pnService.findAll());
		return "admin/taophieunhap";
	}
	
	@RequestMapping(value="tao-phieu-nhap", method=RequestMethod.POST,params="btnAdd")
	public String postPhieuNhap(ModelMap model,HttpServletRequest request, HttpSession ss,
			@ModelAttribute("phieuNhap") PhieuNhapEntity phieuNhap) {
		float money=0;
		phieuNhap.setTongTien(money);
//		TaiKhoanEntity user=(TaiKhoanEntity) ss.getAttribute("user");
//		phieuNhap.setMaNguoiNhap(user.getQuanLi().getMaQL());
		phieuNhap.setThoiDiemNhap(new Date());
		phieuNhap.setNhaNCC(phieuNhap.getNhaNCC());
		phieuNhap.getNhaNCC().setMaNCC(phieuNhap.getNhaNCC().getMaNCC());
		if(pnService.thempPhieuNhap(phieuNhap)) {
			model.addAttribute("maPhieuNhap", phieuNhap.getMaPhieuNhap());
			model.addAttribute("phieuNhap",phieuNhap);
			return "redirect:/quan-tri/chi-tiet-phieu-nhap{maPhieuNhap}";
		}else {
			model.addAttribute("message", "Tạo phiếu nhập không thành công!");
		}
		return "admin/taophieunhap";
	}
	
	@RequestMapping(value="tao-phieu-nhap/{maPhieuNhap}", params= "linkEdit")
	public String editPN(ModelMap model, @ModelAttribute("phieuNhap") PhieuNhapEntity phieuNhap,
			HttpServletRequest request, HttpSession ss,
			@PathVariable("maPhieuNhap") Long maPhieuNhap) {
		model.addAttribute("phieuNhap", pnService.findOneByMaPN(maPhieuNhap));	
		model.addAttribute("isOpenModalEdit", true);
		model.addAttribute("dspn", pnService.findAll());	
		return "admin/taophieunhap";
	}
	
	@RequestMapping(value="tao-phieu-nhap", method=RequestMethod.POST,params="btnEdit")
	public String editPN(ModelMap model, @ModelAttribute("phieuNhap") PhieuNhapEntity phieuNhap,
			HttpServletRequest request, HttpSession ss,
			@RequestParam("maPhieuNhap") Long maPhieuNhap,
			@RequestParam("thoiDiem") String thoiDiemNhap,
			 BindingResult errors) {
		try {
			phieuNhap.setThoiDiemNhap(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(thoiDiemNhap));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if(pnService.suaPhieuNhap(phieuNhap)) {
			model.addAttribute("message", "Sửa thành công!");
		} else {
			model.addAttribute("message", "Sửa thất bại");
		}
		model.addAttribute("dspn", pnService.findAll());
		return "admin/taophieunhap";
	}
			
	@RequestMapping(value="chi-tiet-phieu-nhap{maPhieuNhap}", method=RequestMethod.GET)
	public String showChiTietPhieuNhap(ModelMap model, @PathVariable("maPhieuNhap") Long maPhieuNhap) {
		float money=0;
		model.addAttribute("chiTietPhieuNhap",new ChiTietPhieuNhapEntity());
		model.addAttribute("phieuNhap", pnService.findOneByMaPN(maPhieuNhap));
		List<ChiTietPhieuNhapEntity>listCTPN=ctpnService.findAllByMaPhieuNhap(maPhieuNhap);
		model.addAttribute("listChiTiet", listCTPN);
		if(listCTPN!=null) {
			for(ChiTietPhieuNhapEntity item: listCTPN) {
				money=money+item.getGiaNhap()*item.getSoLuong();
			}
		}
		model.addAttribute("tongTien", money);
		return "admin/chitietphieunhap";
	}
	
	@RequestMapping(value="chi-tiet-phieu-nhap{maPhieuNhap}",params="btnAdd", method=RequestMethod.POST)
	public String postChiTietPhieuNhap(ModelMap model, @PathVariable("maPhieuNhap") Long maPhieuNhap,
			HttpServletRequest request, HttpSession ss,
			@ModelAttribute("chiTietPhieuNhap") ChiTietPhieuNhapEntity chiTietPhieuNhap,
			 BindingResult errors) {
		List<ChiTietPhieuNhapEntity> listCTPN=ctpnService.findAllByMaPhieuNhap(maPhieuNhap);
		float money=0;
		if (chiTietPhieuNhap.getSoLuong()==null || String.valueOf(chiTietPhieuNhap.getGiaNhap()).trim().isEmpty()) {
			errors.rejectValue("giaNhap", "chiTietPhieuNhap", "Gía nhập không được để trống!");
		} else if (chiTietPhieuNhap.getGiaNhap()<=0 || Pattern.compile(regexGia)
														.matcher(String.valueOf(chiTietPhieuNhap.getGiaNhap()).trim())
														.matches()) {
			errors.rejectValue("giaNhap", "chiTietPhieuNhap", "Gía nhập không hợp lệ!");
		}
		if (chiTietPhieuNhap.getSoLuong()==null ||String.valueOf(chiTietPhieuNhap.getSoLuong()).trim().isEmpty()) {
			errors.rejectValue("soLuong", "chiTietPhieuNhap", "Số lượng không được để trống!");
		} else if (chiTietPhieuNhap.getSoLuong()<=0 || Pattern.compile(regexSoLuong)
														.matcher(String.valueOf(chiTietPhieuNhap.getSoLuong()).trim())
														.matches()) {
			errors.rejectValue("soLuong", "chiTietPhieuNhap", "Số lượng không hợp lệ!");
		}
		if(listCTPN!=null) {
			for(ChiTietPhieuNhapEntity item: listCTPN) {
				money=money+item.getGiaNhap()*item.getSoLuong();
				if(chiTietPhieuNhap.getId().getMaVatLieu()==item.getVatLieu().getMaVatLieu()) {
					errors.rejectValue("id.maVatLieu", "chiTietPhieuNhap", "Vật liệu đã được chọn!");
				}
			}
		}else {
			money=0;
		}
		if (errors.hasErrors()) {
			model.addAttribute("isOpenModalAdd", true);
			model.addAttribute("listChiTiet", listCTPN);
			model.addAttribute("phieuNhap", pnService.findOneByMaPN(maPhieuNhap));
			return "admin/chitietphieunhap";
		}
		Long maVL=chiTietPhieuNhap.getId().getMaVatLieu();
		VatLieuEntity vl=vlService.findOneByMaVatLieu(maVL);
		vl.setTonKho(vl.getTonKho()+chiTietPhieuNhap.getSoLuong());
		chiTietPhieuNhap.setId(new CTPNKey());
		chiTietPhieuNhap.getId().setMaVatLieu(maVL);
		chiTietPhieuNhap.getId().setMaPhieuNhap(maPhieuNhap);	
		model.addAttribute("tongTien", money);
		if(ctpnService.themCTPN(chiTietPhieuNhap) && vlService.suaVatLlieu(vl)) {
			//model.addAttribute("maPhieuNhap", maPhieuNhap);
			model.addAttribute("message","Thành công");
		//	return "redirect:/quan-tri/chi-tiet-phieu-nhap{maPhieuNhap}";
		}
		model.addAttribute("listChiTiet", listCTPN);
		return "admin/chitietphieunhap";
	}
	
	@RequestMapping(value="chi-tiet-phieu-nhap{item.phieuNhap.maPhieuNhap}/{item.vatLieu.maVatLieu}", params= "linkEdit")
	public String edit(ModelMap model, @ModelAttribute("chiTietPhieuNhap") ChiTietPhieuNhapEntity chiTietPhieuNhap,
			HttpServletRequest request, HttpSession ss,
			@PathVariable("item.phieuNhap.maPhieuNhap") Long maPhieuNhap,
			@PathVariable("item.vatLieu.maVatLieu") Long maVatLieu,
			BindingResult errors) {
		ChiTietPhieuNhapEntity ctpn=ctpnService.findOneByMaPhieuNhapAndMaVatLieu(maPhieuNhap, maVatLieu);
		model.addAttribute("listChiTiet", ctpnService.findAllByMaPhieuNhap(maPhieuNhap));
		model.addAttribute("slCu",ctpn.getSoLuong());
		model.addAttribute("phieuNhap", pnService.findOneByMaPN(maPhieuNhap));
		model.addAttribute("isOpenModalEdit", true);	
		model.addAttribute("chiTietPhieuNhap", ctpn);
		return "admin/chitietphieunhap";
	}
	
	@RequestMapping(value="chi-tiet-phieu-nhap{maPhieuNhap}", params= "linkDelete",method=RequestMethod.POST)
	public String delete(ModelMap model,
			HttpServletRequest request, HttpSession ss,
			@PathVariable("maPhieuNhap") Long maPhieuNhap,
			@RequestParam("maVatLieu") Long maVatLieu) {
		ChiTietPhieuNhapEntity ctpn=ctpnService.findOneByMaPhieuNhapAndMaVatLieu(maPhieuNhap, maVatLieu);
		VatLieuEntity vl=vlService.findOneByMaVatLieu(maVatLieu);
		vl.setTonKho(vl.getTonKho()-ctpn.getSoLuong());
		model.addAttribute("maPhieuNhap",maPhieuNhap);
		if(ctpnService.xoaCTPN(ctpn) && vlService.suaVatLlieu(vl)) {
			model.addAttribute("message", "Xóa thành công");
			return "redirect:/quan-tri/chi-tiet-phieu-nhap{maPhieuNhap}";
		}else {
			model.addAttribute("message", "Thất bại");
		}
		model.addAttribute("listChiTiet", ctpnService.findAllByMaPhieuNhap(maPhieuNhap));
		return "admin/chitietphieunhap";
	}
	
	@RequestMapping(value="chi-tiet-phieu-nhap{maPhieuNhap}/{maVatLieu}", method=RequestMethod.POST,params="btnEdit")
	public String postChiTietPhieuNhap(ModelMap model, @ModelAttribute("chiTietPhieuNhap") ChiTietPhieuNhapEntity chiTietPhieuNhap,
			HttpServletRequest request, HttpSession ss,
			@PathVariable("maPhieuNhap") Long maPhieuNhap,
			@PathVariable("maVatLieu") Long maVatLieu,
			 BindingResult errors) {
		List<ChiTietPhieuNhapEntity> listCTPN=ctpnService.findAllByMaPhieuNhap(maPhieuNhap);
		model.addAttribute("phieuNhap", pnService.findOneByMaPN(maPhieuNhap));
		if (chiTietPhieuNhap.getGiaNhap()==null ||String.valueOf(chiTietPhieuNhap.getGiaNhap()).trim().isEmpty()) {
			errors.rejectValue("giaNhap", "chiTietPhieuNhap", "Gía nhập không được để trống!");
		} else if (chiTietPhieuNhap.getGiaNhap()<=0 || Pattern.compile(regexGia)
														.matcher(String.valueOf(chiTietPhieuNhap.getGiaNhap()).trim())
														.matches()) {
			errors.rejectValue("giaNhap", "chiTietPhieuNhap", "Gía nhập không hợp lệ!");
		}
		if (chiTietPhieuNhap.getSoLuong()==null ||String.valueOf(chiTietPhieuNhap.getSoLuong()).trim().isEmpty()) {
			errors.rejectValue("soLuong", "chiTietPhieuNhap", "Số lượng không được để trống!");
		} else if (chiTietPhieuNhap.getSoLuong()<=0 || Pattern.compile(regexSoLuong)
														.matcher(String.valueOf(chiTietPhieuNhap.getSoLuong()).trim())
														.matches()) {
			errors.rejectValue("soLuong", "chiTietPhieuNhap", "Số lượng không hợp lệ!");
		}
		if (errors.hasErrors()) {
			model.addAttribute("isOpenModalEdit", true);
			model.addAttribute("listChiTiet", listCTPN);
			model.addAttribute("slCu",ctpnService.findOneByMaPhieuNhapAndMaVatLieu(maPhieuNhap, maVatLieu).getSoLuong());
			return "admin/chitietphieunhap";
	
		}
		float money=0;
		if(listCTPN!=null) {
			for(ChiTietPhieuNhapEntity item: listCTPN) {
				money=money+item.getGiaNhap()*item.getSoLuong();
			}
		}else {
			money=0;
		}
		int slCu=Integer.parseInt(request.getParameter("slCu"));
		VatLieuEntity vl=vlService.findOneByMaVatLieu(chiTietPhieuNhap.getId().getMaVatLieu());
		vl.setTonKho(vl.getTonKho()-slCu+chiTietPhieuNhap.getSoLuong());	
		model.addAttribute("tongTien", money);
		if(ctpnService.suaCTPN(chiTietPhieuNhap) && vlService.suaVatLlieu(vl)) {
			model.addAttribute("maPhieuNhap", maPhieuNhap);
			model.addAttribute("message", "edit thành công");
		}else {
			model.addAttribute("message", "edit thất bại");
		}
		
		model.addAttribute("listChiTiet", ctpnService.findAllByMaPhieuNhap(maPhieuNhap));
		return "admin/chitietphieunhap";
	}
	
	@RequestMapping(value="ds-san-pham", method=RequestMethod.GET)
	public String showDsSanPham(ModelMap model) {
		model.addAttribute("sanPham", new SanPhamEntity());
		model.addAttribute("dssp", spService.findAll());
		return "admin/dssanpham";
	}
	
	@RequestMapping(value="ds-san-pham", method=RequestMethod.POST, params="btnAdd")
	public String themSanPham(ModelMap model,HttpServletRequest request, HttpSession ss,
			@ModelAttribute("sanPham") SanPhamEntity sanPham,
			@RequestParam("anh") MultipartFile anh,
			 BindingResult errors) {
		if (sanPham.getTenSanPham().trim().isEmpty()) {
			errors.rejectValue("tenSanPham", "sanPham", "Tên sản phẩm không được để trống!");
		}
		if (sanPham.getGiaGoc()==null ||String.valueOf(sanPham.getGiaGoc()).trim().isEmpty()) {
			errors.rejectValue("giaGoc", "sanPham", "Giá gốc không được để trống!");
		} else if (sanPham.getGiaGoc()<=0 || Pattern.compile(regexGia)
														.matcher(String.valueOf(sanPham.getGiaGoc()).trim())
														.matches()) {
			errors.rejectValue("giaGoc", "sanPham", "Gía nhập không hợp lệ!");
		}
		if (sanPham.getGiaBan()==null ||String.valueOf(sanPham.getGiaBan()).trim().isEmpty()) {
			errors.rejectValue("giaBan", "sanPham", "Giá bán không được để trống!");
		} else if (sanPham.getGiaBan()<=0 || Pattern.compile(regexGia)
														.matcher(String.valueOf(sanPham.getGiaBan()).trim())
														.matches()) {
			errors.rejectValue("giaBan", "sanPham", "Gía bán không hợp lệ!");
		}
		if (errors.hasErrors()) {
			model.addAttribute("isOpenModalAdd", true);
			model.addAttribute("dssp", spService.findAll());
			return "admin/dssanpham";
		}
		sanPham.setTonKho(0);
		String hinh = "";
		System.out.println("anh " + anh);
		if (!anh.isEmpty()) {
			hinh = utilsService.luuFile(anh);
			if (!hinh.isEmpty()) {
				sanPham.setHinhAnh(hinh);
			}
		}
		if(spService.themSanPham(sanPham)) {
			model.addAttribute("maSanPham", sanPham.getMaSanPham());
			model.addAttribute("sanPham",sanPham);
			return "redirect:/quan-tri/chi-tiet-sp{maSanPham}";
		}
		return "admin/dssanpham";
	}

	@RequestMapping(value="ds-san-pham{maSanPham}", params= "linkEdit")
	public String editSP(ModelMap model, @PathVariable("maSanPham") Long maSanPham,
			HttpServletRequest request, HttpSession ss,
			@ModelAttribute("sanPham") SanPhamEntity sanPham) {
		model.addAttribute("sanPham", spService.findOneByMaSanPham(maSanPham));
		model.addAttribute("isOpenModalEdit", true);	
		model.addAttribute("dssp", spService.findAll());
		return "admin/dssanpham";
	}
	
	@RequestMapping(value="ds-san-pham{maSanPham}", method=RequestMethod.POST, params="btnEdit")
	public String suaSanPham(ModelMap model,HttpServletRequest request, HttpSession ss,
			@ModelAttribute("sanPham") SanPhamEntity sanPham, @PathVariable("maSanPham") Long maSanPham,
			@RequestParam("anh") MultipartFile anh, 
			BindingResult errors) {
		if (sanPham.getTenSanPham().trim().isEmpty()) {
			errors.rejectValue("tenSanPham", "sanPham", "Tên sản phẩm không được để trống!");
		}
		if (sanPham.getGiaGoc()==null ||String.valueOf(sanPham.getGiaGoc()).trim().isEmpty()) {
			errors.rejectValue("giaGoc", "sanPham", "Giá gốc không được để trống!");
		} else if (sanPham.getGiaGoc()<=0 || Pattern.compile(regexGia)
														.matcher(String.valueOf(sanPham.getGiaGoc()).trim())
														.matches()) {
			errors.rejectValue("giaGoc", "sanPham", "Gía nhập không hợp lệ!");
		}
		if (sanPham.getGiaBan()==null ||String.valueOf(sanPham.getGiaBan()).trim().isEmpty()) {
			errors.rejectValue("giaBan", "sanPham", "Giá bán không được để trống!");
		} else if (sanPham.getGiaBan()<=0 || Pattern.compile(regexGia)
														.matcher(String.valueOf(sanPham.getGiaBan()).trim())
														.matches()) {
			errors.rejectValue("giaBan", "sanPham", "Gía bán không hợp lệ!");
		}
		if (errors.hasErrors()) {
			model.addAttribute("isOpenModalEdit", true);
			model.addAttribute("dssp", spService.findAll());
			return "admin/dssanpham";
		}
		String hinh = "";
		System.out.println("anh " + anh);
		if (!anh.isEmpty()) {
			hinh = utilsService.luuFile(anh);
			if (!hinh.isEmpty()) {
				sanPham.setHinhAnh(hinh);
			}
		}
		if(spService.suaSanPham(sanPham)) {
			model.addAttribute("message","Sửa thành công!");
			model.addAttribute("maSanPham", sanPham.getMaSanPham());
			model.addAttribute("sanPham",sanPham);
			return "redirect:/quan-tri/chi-tiet-sp{maSanPham}";
		}
		model.addAttribute("message", "Sửa thất bại!");
		model.addAttribute("dssp", spService.findAll());
		return "admin/dssanpham";
	}
	
	@RequestMapping(value="chi-tiet-sp{maSanPham}", method=RequestMethod.GET)
	public String showChiTiet(ModelMap model, @PathVariable("maSanPham") Long maSanPham) {
		model.addAttribute("chiTietSP",new ChiTietSanPhamEntity());
		model.addAttribute("sanPham", spService.findOneByMaSanPham(maSanPham));
		model.addAttribute("listSPChiTiet", ctspService.findAllByMaSanPham(maSanPham));
		return "admin/chitietsp";
	}
	
	@RequestMapping(value="chi-tiet-sp{maSanPham}",params="btnAdd", method=RequestMethod.POST)
	public String postChiTietSP(ModelMap model, @PathVariable("maSanPham") Long maSanPham,
			HttpServletRequest request, HttpSession ss,
			@ModelAttribute("chiTietSP") ChiTietSanPhamEntity chiTietSP,
			 BindingResult errors) {
		List<ChiTietSanPhamEntity> listCTSP= ctspService.findAllByMaSanPham(maSanPham);
		model.addAttribute("sanPham", spService.findOneByMaSanPham(maSanPham));
		if (chiTietSP.getSoLuong()==null ||String.valueOf(chiTietSP.getSoLuong()).trim().isEmpty()) {
			errors.rejectValue("soLuong", "chiTietSP", "Số lượng không được để trống!");
		} else if (chiTietSP.getSoLuong()<=0 || Pattern.compile(regexSoLuong)
														.matcher(String.valueOf(chiTietSP.getSoLuong()).trim())
														.matches()) {
			errors.rejectValue("soLuong", "chiTietSP", "Số lượng không hợp lệ!");
		}
		if(listCTSP!=null) {
			for(ChiTietSanPhamEntity item: listCTSP) {
			
				if(chiTietSP.getId().getMaVatLieu()==item.getVatLieu().getMaVatLieu()) {
					errors.rejectValue("id.maVatLieu", "chiTietSP", "Vật liệu đã được chọn!");
				}
			}
		}
		if (errors.hasErrors()) {
			model.addAttribute("isOpenModalAdd", true);
			model.addAttribute("listSPChiTiet", listCTSP);
			return "admin/chitietsp";
		}
		Long maVL=chiTietSP.getId().getMaVatLieu();
		chiTietSP.setId(new CTSPKey());
		chiTietSP.getId().setMaVatLieu(maVL);
		chiTietSP.getId().setMaSanPham(maSanPham);
		if(ctspService.themCTSP(chiTietSP)) {
			model.addAttribute("message", "Thêm mới thành công!");
		}
		model.addAttribute("listSPChiTiet", ctspService.findAllByMaSanPham(maSanPham));
		return "admin/chitietsp";
	}

	@RequestMapping(value="chi-tiet-sp{maSanPham}/{maVatLieu}", params= "linkEdit")
	public String editSP(ModelMap model, @ModelAttribute("chiTietSP") ChiTietSanPhamEntity chiTietSP,
			HttpServletRequest request, HttpSession ss,
			@PathVariable("maSanPham") Long maSanPham,
			@PathVariable("maVatLieu") Long maVatLieu) {
		ChiTietSanPhamEntity ctpn=ctspService.findOneByMaSanPhamAndMaVatLieu(maSanPham, maVatLieu);
		model.addAttribute("sanPham", spService.findOneByMaSanPham(maSanPham));
		model.addAttribute("isOpenModalEdit", true);
		model.addAttribute("chiTietSP", ctpn);	
		return "admin/chitietsp";
	}
	
	@RequestMapping(value="chi-tiet-sp{maSanPham}/{maVatLieu}", method=RequestMethod.POST,params="btnEdit")
	public String editCtsp(ModelMap model,@ModelAttribute("chiTietSP") ChiTietSanPhamEntity chiTietSP,
			HttpServletRequest request, HttpSession ss,
			@PathVariable("maSanPham") Long maSanPham,
			@PathVariable("maVatLieu") Long maVatLieu,
			 BindingResult errors) {
		model.addAttribute("sanPham", spService.findOneByMaSanPham(maSanPham));
		model.addAttribute("listSPChiTiet", ctspService.findAllByMaSanPham(maSanPham));
		if (chiTietSP.getSoLuong()==null ||String.valueOf(chiTietSP.getSoLuong()).trim().isEmpty()) {
			errors.rejectValue("soLuong", "chiTietSP", "Số lượng không được để trống!");
		} else if (chiTietSP.getSoLuong()<=0 || Pattern.compile(regexSoLuong)
														.matcher(String.valueOf(chiTietSP.getSoLuong()).trim())
														.matches()) {
			errors.rejectValue("soLuong", "chiTietSP", "Số lượng không hợp lệ!");
		}
		if (errors.hasErrors()) {
			model.addAttribute("isOpenModalEdit", true);
			return "admin/chitietsp";
		}
		if(ctspService.suaCTSP(chiTietSP)) {
			model.addAttribute("message", "Sửa thành công");
			model.addAttribute("listSPChiTiet", ctspService.findAllByMaSanPham(maSanPham));
		}else {
			model.addAttribute("message", "Sửa thất bại");
		}
		return "admin/chitietsp";
	}
	
	@RequestMapping(value="chi-tiet-sp{maSanPham}", params= "linkDelete" ,method=RequestMethod.POST)
	public String deleteCTSP(ModelMap model,
			HttpServletRequest request, HttpSession ss,
			@PathVariable("maSanPham") Long maSanPham,
			@RequestParam("vatLieu.maVatLieu") Long maVatLieu) {
		ChiTietSanPhamEntity ctsp=ctspService.findOneByMaSanPhamAndMaVatLieu(maSanPham, maVatLieu);
		model.addAttribute("maSanPham",maSanPham);
		model.addAttribute("sanPham", spService.findOneByMaSanPham(maSanPham));
		if(ctspService.xoaCTSP(ctsp)) {
			model.addAttribute("message", "Xóa thành công");
			return "redirect:/quan-tri/chi-tiet-sp{maSanPham}";
		}else {
			model.addAttribute("message", "XóaThất bại");	
		}		
		return "admin/chitietsp";
		
	}
	
	@RequestMapping(value="tao-phieu-xuat", method=RequestMethod.GET)
	public String showPhieuXuat(ModelMap model) {
		model.addAttribute("phieuXuat",new PhieuXuatSPEntity());
		model.addAttribute("dspx", pxspService.findAll());
		return "admin/taophieuxuat";
	}
	
	@RequestMapping(value="tao-phieu-xuat", method=RequestMethod.POST)
	public String postPhieuXuat(ModelMap model,HttpServletRequest request, HttpSession ss,
			@ModelAttribute("phieuXuat") PhieuXuatSPEntity phieuXuat) {
		phieuXuat.setNgay(new Date());
		if(pxspService.thempPhieuXuat(phieuXuat)) {
			model.addAttribute("maPhieuXuat", phieuXuat.getMaPhieuXuatSP());
			model.addAttribute("phieuXuat",phieuXuat);
			return "redirect:/quan-tri/chi-tiet-phieu-xuat{maPhieuXuat}";
		}
		model.addAttribute("message", "Tạo phiếu xuất không thành công!");
		return "admin/taophieuxuat";
	}
	
	@RequestMapping(value="chi-tiet-phieu-xuat{maPhieuXuat}", method=RequestMethod.GET)
	public String showChiTietPhieuXuat(ModelMap model, @PathVariable("maPhieuXuat") Long maPhieuXuat) {
		model.addAttribute("chiTietPhieuXuat",new ChiTietPhieuXuatSPEntity());
		model.addAttribute("phieuXuat", pxspService.findOneByMaPX(maPhieuXuat));
		if(ctpxService.findAllByMaPhieuXuat(maPhieuXuat)!=null) {
			model.addAttribute("listChiTiet", ctpxService.findAllByMaPhieuXuat(maPhieuXuat));
		}
		return "admin/chitietphieuxuat";
	}
	
	@RequestMapping(value="chi-tiet-phieu-xuat{maPhieuXuat}",params="btnAdd", method=RequestMethod.POST)
	public String postChiTietPhieuXuat(ModelMap model, @PathVariable("maPhieuXuat") Long maPhieuXuat,
			HttpServletRequest request, HttpSession ss,
			@ModelAttribute("chiTietPhieuXuat") ChiTietPhieuXuatSPEntity chiTietPhieuXuat,
			 BindingResult errors) {
		Long maSP=chiTietPhieuXuat.getId().getMaSP();
		SanPhamEntity sp=spService.findOneByMaSanPham(maSP);
		List<ChiTietSanPhamEntity> listCTSP=ctspService.findAllByMaSanPham(maSP);
		List<ChiTietPhieuXuatSPEntity> listCTPX=ctpxService.findAllByMaPhieuXuat(maPhieuXuat);
		Boolean flag=true;
		model.addAttribute("phieuXuat", pxspService.findOneByMaPX(maPhieuXuat));
		if (chiTietPhieuXuat.getSoLuong()==null ||String.valueOf(chiTietPhieuXuat.getSoLuong()).trim().isEmpty()) {
			errors.rejectValue("soLuong", "chiTietPhieuXuat", "Số lượng không được để trống!");
		} else if (chiTietPhieuXuat.getSoLuong()<=0 || Pattern.compile(regexSoLuong)
														.matcher(String.valueOf(chiTietPhieuXuat.getSoLuong()).trim())
														.matches()) {
			errors.rejectValue("soLuong", "chiTietPhieuXuat", "Số lượng không hợp lệ!");
		}
		if(listCTPX!=null) {
			for(ChiTietPhieuXuatSPEntity item: listCTPX) {
				if(chiTietPhieuXuat.getId().getMaSP()==item.getId().getMaSP()) {
					errors.rejectValue("id.maSP", "chiTietPhieuXuat", "Sản phẩm đã được chọn!");
				}
			}
		}
		if (errors.hasErrors()) {
			model.addAttribute("isOpenModalAdd", true);
			model.addAttribute("listChiTiet", listCTPX);
			return "admin/chitietphieuxuat";
		}
		sp.setTonKho(sp.getTonKho()+chiTietPhieuXuat.getSoLuong());
		chiTietPhieuXuat.setId(new CTPXSPKey());
		chiTietPhieuXuat.getId().setMaSP(maSP);;
		chiTietPhieuXuat.getId().setMaPhieuXuatSP(maPhieuXuat);	
		if(listCTSP!=null) {
			for(ChiTietSanPhamEntity item: listCTSP) {
				VatLieuEntity vl=vlService.findOneByMaVatLieu(item.getId().getMaVatLieu());
				vl.setTonKho(vl.getTonKho()-item.getSoLuong()*chiTietPhieuXuat.getSoLuong());
				if(!vlService.suaVatLlieu(vl)) {
					flag=false;
					break;
				}
			}
		}
		if(ctpxService.themCTPX(chiTietPhieuXuat) && spService.suaSanPham(sp) && flag) {
			model.addAttribute("message","Thành công");
		}else {
			model.addAttribute("message","Thất bại");
		}
		model.addAttribute("listChiTiet", ctpxService.findAllByMaPhieuXuat(maPhieuXuat));
		return "admin/chitietphieuxuat";
	}
	
	@RequestMapping(value="chi-tiet-phieu-xuat{maPhieuXuat}/{maSP}", params= "linkEdit")
	public String edit(ModelMap model,
			@ModelAttribute("chiTietPhieuXuat") ChiTietPhieuXuatSPEntity chiTietPhieuXuat,
			HttpServletRequest request, HttpSession ss,
			@PathVariable("maPhieuXuat") Long maPhieuXuat,
			@PathVariable("maSP") Long maSP) {
		ChiTietPhieuXuatSPEntity ctpx= ctpxService.findOneByMaPhieuXuatAndMaSP(maPhieuXuat, maSP);
		model.addAttribute("slCu",ctpx.getSoLuong());
		model.addAttribute("phieuXuat", pxspService.findOneByMaPX(maPhieuXuat));
		model.addAttribute("isOpenModalEdit", true);
		model.addAttribute("chiTietPhieuXuat", ctpx);	
		model.addAttribute("listChiTiet", ctpxService.findAllByMaPhieuXuat(maPhieuXuat));
		return "admin/chitietphieuxuat";
	}
	
	
	@RequestMapping(value="chi-tiet-phieu-xuat{maPhieuXuat}/{maSP}", method=RequestMethod.POST,params="btnEdit")
	public String postChiTietPhieuXuat(ModelMap model,
			@ModelAttribute("chiTietPhieuXuat") ChiTietPhieuXuatSPEntity chiTietPhieuXuat,
			HttpServletRequest request, HttpSession ss,
			@PathVariable("maPhieuXuat") Long maPhieuXuat,
			@PathVariable("maSP") Long maSP,
			 BindingResult errors) {
		List<ChiTietSanPhamEntity> listCTSP=ctspService.findAllByMaSanPham(chiTietPhieuXuat.getId().getMaSP());
		List<ChiTietPhieuXuatSPEntity> listCTPX=ctpxService.findAllByMaPhieuXuat(maPhieuXuat);
		model.addAttribute("phieuXuat", pxspService.findOneByMaPX(maPhieuXuat));
		if (chiTietPhieuXuat.getSoLuong()==null ||String.valueOf(chiTietPhieuXuat.getSoLuong()).trim().isEmpty()) {
			errors.rejectValue("soLuong", "chiTietPhieuXuat", "Số lượng không được để trống!");
		} else if (chiTietPhieuXuat.getSoLuong()<=0 || Pattern.compile(regexSoLuong)
														.matcher(String.valueOf(chiTietPhieuXuat.getSoLuong()).trim())
														.matches()) {
			errors.rejectValue("soLuong", "chiTietPhieuXuat", "Số lượng không hợp lệ!");
		}
		if (errors.hasErrors()) {
			model.addAttribute("slCu",ctpxService.findOneByMaPhieuXuatAndMaSP(maPhieuXuat, maSP).getSoLuong());
			model.addAttribute("isOpenModalEdit", true);
			model.addAttribute("listChiTiet", listCTPX);
			return "admin/chitietphieuxuat";
		}
		Boolean flag=true;
		int slCu=Integer.parseInt(request.getParameter("slCu"));
		SanPhamEntity sp=spService.findOneByMaSanPham(chiTietPhieuXuat.getId().getMaSP());	
		sp.setTonKho(sp.getTonKho()-slCu+chiTietPhieuXuat.getSoLuong());
		if(listCTSP!=null) {
			for(ChiTietSanPhamEntity item: listCTSP) {
				VatLieuEntity vl=vlService.findOneByMaVatLieu(item.getId().getMaVatLieu());
				vl.setTonKho(vl.getTonKho()+item.getSoLuong()*slCu-item.getSoLuong()*chiTietPhieuXuat.getSoLuong());
				if(!vlService.suaVatLlieu(vl)) {
					flag=false;
					break;
				}
			}
		}

		if(ctpxService.suaCTPX(chiTietPhieuXuat) && spService.suaSanPham(sp) && flag) {
			model.addAttribute("maPhieuXuat", maPhieuXuat);
			model.addAttribute("message", "edit thành công");
		}else {
			model.addAttribute("message", "Sửa thất bại!");
		}
		model.addAttribute("listChiTiet", ctpxService.findAllByMaPhieuXuat(maPhieuXuat));
		return "admin/chitietphieuxuat";
	}
	
	
	@RequestMapping(value="chi-tiet-phieu-xuat{maPhieuXuat}", params= "linkDelete", method=RequestMethod.POST)
	public String deleteCTPX(ModelMap model,
			HttpServletRequest request, HttpSession ss,
			@PathVariable("maPhieuXuat") Long maPhieuXuat,
			@RequestParam("sanPham.maSanPham") Long maSP) {
		Boolean flag=true;
		ChiTietPhieuXuatSPEntity ctpx= ctpxService.findOneByMaPhieuXuatAndMaSP(maPhieuXuat, maSP);
		SanPhamEntity sp=spService.findOneByMaSanPham(maSP);	
		sp.setTonKho(sp.getTonKho()-ctpx.getSoLuong());
		List<ChiTietSanPhamEntity> listCTSP=ctspService.findAllByMaSanPham(maSP);
		if(listCTSP!=null) {
			for(ChiTietSanPhamEntity item: listCTSP) {
				VatLieuEntity vl=vlService.findOneByMaVatLieu(item.getId().getMaVatLieu());
				vl.setTonKho(vl.getTonKho()+item.getSoLuong()*ctpx.getSoLuong());
				if(!vlService.suaVatLlieu(vl)) {
					flag=false;
					break;
				}
			}
		}
		if(ctpxService.xoaCTPX(ctpx) && spService.suaSanPham(sp) && flag) {
			model.addAttribute("message", "Xóa thành công");
			return "redirect:/quan-tri/chi-tiet-phieu-xuat{maPhieuXuat}";
		}
		model.addAttribute("message", "Thất bại");			
		return "admin/chitietphieuxuat";
	}
	
	@RequestMapping(value="nha-cung-cap", method=RequestMethod.GET)
	public String showNCC(ModelMap model) {
		model.addAttribute("nhaCungCap",new NhaCungCapEntity());
		model.addAttribute("dsncc", nccService.findAll());
		return "admin/NhaCungCap";
	}
	
	
	@RequestMapping(value="nha-cung-cap/{maNCC}", method=RequestMethod.GET,params="linkDetail")
	public String chitietNCC(ModelMap model, @ModelAttribute("nhaCungCap") NhaCungCapEntity nhaCungCap,
			HttpServletRequest request, HttpSession ss,
			@PathVariable("maNCC") Integer maNCC) {
		model.addAttribute("nhaCungCap", nccService.findOneByMaNCC(maNCC));	
		model.addAttribute("isOpenModalDetail", true);
		model.addAttribute("dsncc", nccService.findAll());	
		return "admin/NhaCungCap";
	}
	
	@RequestMapping(value="nha-cung-cap", method=RequestMethod.POST,params="btnAdd")
	public String postNCC(ModelMap model,HttpServletRequest request, HttpSession ss,
			@ModelAttribute("nhaCungCap") NhaCungCapEntity nhaCungCap,
			BindingResult errors) {
		if (nhaCungCap.getTenNCC().trim().isEmpty()) {
			errors.rejectValue("tenNCC", "nhaCungCap", "Tên nhà cung cấp không được để trống!");
		}

		if (nhaCungCap.getSdt().trim().isEmpty()) {
			errors.rejectValue("sdt", "nhaCungCap", "Số điện thoại không được để trống!");
		} else if (!nhaCungCap.getSdt().trim().matches("^[0-9]*$")) {
			errors.rejectValue("sdt", "nhaCungCap", "Số điện thoại không hợp lệ!");
		}

		if (nhaCungCap.getDiaChi().trim().isEmpty()) {
			errors.rejectValue("diaChi", "nhaCungCap", "Địa chỉ không được để trống!");
		}

		if (errors.hasErrors()) {
			model.addAttribute("isOpenModalAdd", true);
			model.addAttribute("dsncc", nccService.findAll());
			return "admin/NhaCungCap";
		}
		if(nccService.themNCC(nhaCungCap)) {
			model.addAttribute("message", "Thêm mới thành công!");
		}
		else {
			model.addAttribute("message", "Thêm mới thất bại!");
		}
		model.addAttribute("dsncc", nccService.findAll());
		return "admin/NhaCungCap";
	}
	
	@RequestMapping(value="nha-cung-cap/{maNCC}", params= "linkEdit")
	public String editNCC(ModelMap model, @ModelAttribute("nhaCungCap") NhaCungCapEntity nhaCungCap,
			HttpServletRequest request, HttpSession ss,
			@PathVariable("maNCC") Integer maNCC) {
		model.addAttribute("nhaCungCap", nccService.findOneByMaNCC(maNCC));	
		model.addAttribute("isOpenModalEdit", true);
		model.addAttribute("dsncc", nccService.findAll());	
		return "admin/NhaCungCap";
	}
	
	@RequestMapping(value="nha-cung-cap", method=RequestMethod.POST,params="btnEdit")
	public String editNCC(ModelMap model, @ModelAttribute("nhaCungCap") NhaCungCapEntity nhaCungCap,
			HttpServletRequest request, HttpSession ss,
			@RequestParam("maNCC") Integer maNCC,
			 BindingResult errors) {
		if (nhaCungCap.getTenNCC().trim().isEmpty()) {
			errors.rejectValue("tenNCC", "nhaCungCap", "Tên nhà cung cấp không được để trống!");
		}

		if (nhaCungCap.getSdt().trim().isEmpty()) {
			errors.rejectValue("sdt", "nhaCungCap", "Số điện thoại không được để trống!");
		} else if (!nhaCungCap.getSdt().trim().matches("^[0-9]*$")) {
			errors.rejectValue("sdt", "nhaCungCap", "Số điện thoại không hợp lệ!");
		}

		if (nhaCungCap.getDiaChi().trim().isEmpty()) {
			errors.rejectValue("diaChi", "nhaCungCap", "Địa chỉ không được để trống!");
		}

		if (errors.hasErrors()) {
			model.addAttribute("isOpenModalEdit", true);
			model.addAttribute("dsncc", nccService.findAll());
			return "admin/NhaCungCap";
		}
		if(nccService.suaNCC(nhaCungCap)) {
			model.addAttribute("message", "Sửa thành công!");
		} else {
			model.addAttribute("message", "Sửa thất bại");
		}
		model.addAttribute("dsncc", nccService.findAll());
		return "admin/NhaCungCap";
	}
		
	@RequestMapping(value="nha-cung-cap", params= "linkDelete", method=RequestMethod.POST)
	public String deleteNCC(ModelMap model,
			HttpServletRequest request, HttpSession ss,
			@RequestParam("maNCC") Integer maNCC) {
		NhaCungCapEntity ncc=nccService.findOneByMaNCC(maNCC);
		if(nccService.xoaNCC(ncc)) {
			model.addAttribute("message", "Xóa thành công");
		}
		else {
			model.addAttribute("message", "XóaThất bại");
		}
		model.addAttribute("dsncc", nccService.findAll());
		return "redirect:/quan-tri/nha-cung-cap";
		
	}
	
	@RequestMapping(value="ds-don-hang", method=RequestMethod.GET)
	public String showDsDonHang(ModelMap model) {
		model.addAttribute("donHang",new DonHangEntity());
		return "admin/DonHang";
	}
	
	@RequestMapping(value="ds-don-hang/{maDonHang}", method=RequestMethod.GET,params="linkDetail")
	public String chitietDonHang(ModelMap model, @ModelAttribute("donHang") DonHangEntity donHang,
			HttpServletRequest request, HttpSession ss,
			@PathVariable("maDonHang") Long maDonHang) {
		model.addAttribute("donHang", dhService.findOneByMaDH(maDonHang));	
		model.addAttribute("isOpenModalDetail", true);	
		if(ctdhService.findAllByMaDonHang(maDonHang)!=null) {
			model.addAttribute("listChiTiet", ctdhService.findAllByMaDonHang(maDonHang));
		}
		return "admin/DonHang";
	}
	
	@RequestMapping(value="ds-khach-hang", method=RequestMethod.GET)
	public String showDsKhachHang(ModelMap model) {
		//model.addAttribute("khachHang",new KhachHangEntity());
		return "admin/KhachHang";
	}
	
	@RequestMapping(value="ds-khach-hang", params= "linkLock", method=RequestMethod.POST)
	public String lockKH(ModelMap model,
			HttpServletRequest request, HttpSession ss,
			@RequestParam("email") String email) {
		TaiKhoanEntity tk=tkService.findOneByEmail(email);
		if(tk.getTrangThai()) {
			tk.setTrangThai(false);
		}else {
			tk.setTrangThai(true);
		}
		if(tkService.suaTaiKhoan(tk)) {
			model.addAttribute("message", "Đổi trạng thái thành công");
		}
		else {
			model.addAttribute("message", "Đổi trạng thái thất bại");
		}
		return "redirect:/quan-tri/ds-khach-hang";
		
	}
	
	@ModelAttribute("ListVatLieu")
	public List<VatLieuEntity> findAllVL() {
		return vlService.findAll();	
	}
	
	@ModelAttribute("ListNCC")
	public List<NhaCungCapEntity> findAllNCC() {
		return nccService.findAll();	
	}
	
	@ModelAttribute("ListLoaiSP")
	public List<LoaiSanPhamEntity> findAllLSP() {
		return lspService.findAll();	
	}
	
	@ModelAttribute("ListSP")
	public List<SanPhamEntity> findAllSP() {
		return spService.findAll();	
	}
	
	@ModelAttribute("ListQL")
	public List<QuanLiEntity> findAllQL() {
		return qlService.findAll();	
	}
	
	@ModelAttribute("ListQLActive")
	public List<QuanLiEntity> findAllQLActive() {
		return qlService.findAllActive();	
	}
	
	@ModelAttribute("ListDonHang")
	public List<DonHangEntity> findAllDonHang() {
		return dhService.findAll();	
	}
	
	@ModelAttribute("ListKhachHang")
	public List<KhachHangEntity> findAllKhachHang() {
		return khService.findAll();	
	}
	
	@ModelAttribute("ListPhieuNhap")
	public List<PhieuNhapEntity> findAllPhieuNhap() {
		return pnService.findAll();	
	}
	
	@ModelAttribute("ListDoanhThuTheoSP")
	public List<DoanhThuTheoSanPham> dsDoanhThu(HttpSession ss) {
		thongKeDoanhThu.clear();
		List<ChiTietDonHangEntity> listdh = ctdhService.findAll();
		for (int i = 0; i < listdh.size(); i++) {
			boolean check = false;
			double doanhthu = (double) (listdh.get(i).getGiaTien()*listdh.get(i).getSoLuong());
			for (int j = 0; j < thongKeDoanhThu.size(); j++) {
				if (listdh.get(i).getSanPham().getMaSanPham() == thongKeDoanhThu.get(j).getMaSP()) {
					thongKeDoanhThu.get(j).setDoanhThu(doanhthu + thongKeDoanhThu.get(j).getDoanhThu());
					check = true;
					break;
				}
			}
			if (check == false) {
				DoanhThuTheoSanPham dt = new DoanhThuTheoSanPham();
				dt.setMaSP(listdh.get(i).getSanPham().getMaSanPham());
				dt.setTenSP(listdh.get(i).getSanPham().getTenSanPham());
				dt.setDoanhThu(doanhthu);
				thongKeDoanhThu.add(dt);
			}
		}
		return thongKeDoanhThu;
	}
}