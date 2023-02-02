package com.ptit.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.ptit.entity.TaiKhoanEntity;

public class DangNhapInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		TaiKhoanEntity tk=(TaiKhoanEntity) session.getAttribute("user");
		if (tk != null) {
			if(tk.getQuyen().getMaQuyen().equals("QL")) {
				response.sendRedirect(request.getContextPath() + "/quan-tri/trang-chu");
				return false;
			}
			response.sendRedirect(request.getContextPath() + "/trang-chu");
			return false;
		}
		return true;
	}

}
