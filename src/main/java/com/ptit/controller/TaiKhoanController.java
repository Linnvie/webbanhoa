package com.ptit.controller;

import java.util.Random;
import java.util.regex.Pattern;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ptit.entity.KhachHangEntity;
import com.ptit.entity.QuyenEntity;
import com.ptit.entity.TaiKhoanEntity;
import com.ptit.service.ITaiKhoanService;

@Controller
public class TaiKhoanController {
	@Autowired 
	private ITaiKhoanService tkService;
	
	@Autowired
	JavaMailSender mailSender;
	
	String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
            + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
	
	@RequestMapping(value="/dang-nhap", method=RequestMethod.GET)
	public String showLogin(ModelMap model) {
		model.addAttribute("taiKhoanLogin",new TaiKhoanEntity());
		return "decorators/login";
	}
	
	@RequestMapping(value="/dang-nhap", method=RequestMethod.POST)
	public String Login(ModelMap model, HttpServletRequest request, HttpSession ss,
			@ModelAttribute("taiKhoanLogin") TaiKhoanEntity taiKhoanLlogin,
			 BindingResult errors) {
		TaiKhoanEntity tk=tkService.findOneByEmailAndMatKhau(taiKhoanLlogin.getEmail(), taiKhoanLlogin.getMatKhau());
		if(taiKhoanLlogin.getEmail().trim().length()==0) {
			errors.rejectValue("email", "taiKhoanLlogin", "Vui lòng nhập Email!!");
		}else {
			if( !Pattern.compile(regexPattern)
					.matcher(taiKhoanLlogin.getEmail().trim())
					.matches()) {
				
				errors.rejectValue("email", "taiKhoanLlogin", "Email không hợp lệ!");
			}
		}
		
		if(taiKhoanLlogin.getMatKhau().trim().length()==0) {
			errors.rejectValue("matKhau", "taiKhoanLlogin", "Vui lòng nhập Mật khẩu!");
		}
		if(errors.hasErrors()) {
			return "decorators/login";
		}
		if(tk!=null) {
			if(!tk.getTrangThai()) {
				model.addAttribute("message","Tài khoản hiện đang bị khóa!");
				return "decorators/login";
			}else {
				model.addAttribute("message","Đăng nhập thành công");
				ss.setAttribute("user", tk);
				if(tk.getQuyen().getMaQuyen().equals("QL")) {
					return "redirect:/quan-tri/tong-quan";
				}else {
					return "redirect:/trang-chu";
				}
			}
		}
		model.addAttribute("message","Sai Email hoặc Mật khẩu!");
		return "decorators/login";
	}
	
	@RequestMapping(value="/dang-ki", method=RequestMethod.GET)
	public String showDangKi(ModelMap model) {
		model.addAttribute("taiKhoanDangKi",new TaiKhoanEntity());
		return "decorators/dangki";
	}
	
	@RequestMapping(value="/dang-ki", method=RequestMethod.POST)
	public String dangKi(ModelMap model, HttpServletRequest request, HttpSession ss,
			@ModelAttribute("taiKhoanDangKi") TaiKhoanEntity taiKhoanDangKi,
			@RequestParam("matKhauXacNhan") String matKhauXacNhan,
			 BindingResult errors) {
		if(taiKhoanDangKi.getEmail().trim().length()==0) {
			errors.rejectValue("email", "taiKhoanDangKi", "Vui lòng nhập Email!!");
		}else {
			if( !Pattern.compile(regexPattern)
					.matcher(taiKhoanDangKi.getEmail().trim())
					.matches()) {
				
				errors.rejectValue("email", "taiKhoanDangKi", "Email không hợp lệ!");
			}
			if(tkService.findOneByEmail(taiKhoanDangKi.getEmail())!=null) {
				errors.rejectValue("email", "taiKhoanDangKi", "Email đã đăng kí!!");
			}
		}
		if(taiKhoanDangKi.getMatKhau().trim().length()==0) {
			errors.rejectValue("matKhau", "taiKhoanDangKi", "Vui lòng nhập Mật khẩu!");
		}
		if(!matKhauXacNhan.equals(taiKhoanDangKi.getMatKhau())) {
			errors.rejectValue("matKhau", "taiKhoanDangKi", "Mật khẩu và mật khẩu xác nhận không trùng nhau!");
		}
		if(taiKhoanDangKi.getKhachHang().getHo().trim().length()==0) {
			errors.rejectValue("khachHang.ho", "taiKhoanDangKi", "Vui lòng nhập Họ!");
		}
		if(taiKhoanDangKi.getKhachHang().getTen().trim().length()==0) {
			errors.rejectValue("khachHang.ten", "taiKhoanDangKi", "Vui lòng nhập Tên!");
		}
		if(taiKhoanDangKi.getKhachHang().getSdt().trim().length()!=10) {
			errors.rejectValue("khachHang.sdt", "taiKhoanDangKi", "Vui lòng nhập đúng Số điện thoại!");
		}
		if(taiKhoanDangKi.getKhachHang().getDiaChi().trim().length()==0) {
			errors.rejectValue("khachHang.diaChi", "taiKhoanDangKi", "Vui lòng nhập Địa chỉ!");
		}
		
		if(errors.hasErrors()) {
			System.out.print(errors.toString());
			model.addAttribute("message", "Lỗi!");
			return "decorators/dangki";
		}
		taiKhoanDangKi.setQuyen(new QuyenEntity());
		taiKhoanDangKi.getQuyen().setMaQuyen("USER");
		taiKhoanDangKi.setKhachHang(taiKhoanDangKi.getKhachHang());
		taiKhoanDangKi.getKhachHang().setTaiKhoan(taiKhoanDangKi);
		taiKhoanDangKi.setTrangThai(true);
		if(taiKhoanDangKi.getKhachHang()!=null && tkService.themTaiKhoan(taiKhoanDangKi)) {
			model.addAttribute("message", "Đăng kí thành công!");
			model.addAttribute("taiKhoanLogin",new TaiKhoanEntity());
			return "redirect:/dang-nhap";
		}
		model.addAttribute("message", "Đăng kí không thành công!");
		model.addAttribute("taiKhoanDangKi",new TaiKhoanEntity());
		return "decorators/dangki";
	}
	
	@RequestMapping(value="/quen-mat-khau", method=RequestMethod.GET)
	public String showQuenMatKhau(ModelMap model) {
		model.addAttribute("taikhoan",new TaiKhoanEntity());
		return "decorators/quenmatkhau";
	}
	@RequestMapping(value = "/quen-mat-khau", method = RequestMethod.POST)
	public String postQuenMatKhau(ModelMap model, HttpSession ss,
			@ModelAttribute("taikhoan") TaiKhoanEntity taikhoan,
			BindingResult errors) {
		if (taikhoan.getEmail().trim().isEmpty()) {
			errors.rejectValue("email", "taikhoan", "Vui lòng nhập Email");
		}
		if( !Pattern.compile(regexPattern)
				.matcher(taikhoan.getEmail().trim())
				.matches()) {
			
			errors.rejectValue("email", "taikhoan", "Email không hợp lệ!");
		}
		if (errors.hasErrors()) {
			return "decorators/quenmatkhau";
		}
		if(tkService.findOneByEmail(taikhoan.getEmail())!=null) {
			Random generator = new Random();
			int ramdom = generator.nextInt(99999999) + 100000;
			String mkmoi = String.valueOf(ramdom);
			taikhoan.setMatKhau(mkmoi);
			tkService.suaTaiKhoan(taikhoan);
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message);

			try {
				helper.setFrom("no-reply-email");
				helper.setTo(taikhoan.getEmail());
				helper.setSubject("Đổi mật khẩu thành công!");
				helper.setText("Mật khẩu mới của bạn là: " + mkmoi+"\n"+"Bạn nên đổi lại mật khẩu sau khi đăng nhập lại!");
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			mailSender.send(message);
			model.addAttribute("taiKhoanLogin",new TaiKhoanEntity());
			model.addAttribute("message", "Mật khẩu mới đã được gửi vào Email của bạn!");
			return "decorators/login";
		}
		model.addAttribute("message", "Mail chưa được đăng kí!");
		return "decorators/quenmatkhau";
	}
	
	@RequestMapping(value = "/dang-xuat")
	public String dangXuat(HttpSession ss) {
		
		if(ss.getAttribute("user") != null) {
			 
			ss.removeAttribute("user");
		}
		return "redirect:/";
	}
		
}
