package com.ptit.service.impl;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ptit.bean.UploadFile;

@Service
public class UtilsService {	
	@Autowired
	@Qualifier("uploadfile")
	UploadFile baseUploadFile;
	
	public String luuFile(MultipartFile file) {
		if(file.isEmpty()) {
			return null;
		}
		try{
			System.out.println("sys "+System.currentTimeMillis());
			String path = System.currentTimeMillis() + file.getOriginalFilename();

			String filePath= baseUploadFile.getBasePath()+ File.separator+path;

			System.out.println("filepath " + filePath);
			file.transferTo(new File(filePath));
			System.out.println("file " + path);
			System.out.println("file new" + file.getOriginalFilename());
			
			
			Thread.sleep(5000);
//			return file.getOriginalFilename();
			return path;
			
		}
		catch(Exception e){
			System.out.println(e.getCause());
			
		}
		return null;
	}
}
