package com.escape.Service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.util.StringUtils;

import com.escape.entity.ThemeImg;
import com.escape.repository.ThemeImgRepository;


import lombok.RequiredArgsConstructor;




@Service
@RequiredArgsConstructor
@Transactional
public class ThemeImgService {
	
	private final ThemeImgRepository themeImgRepository;
	private String themeImgLocation = "C:/theme";
	private final FileService fileService;
	
	
	public void saveThemeImg(ThemeImg themeImg, MultipartFile themeImgFile) throws Exception{
		String oriImgName = themeImgFile.getOriginalFilename();
		String imgName = "";
		String imgUrl = "";
		
		if(!StringUtils.isEmpty(oriImgName)) {
			imgName = fileService.uploadFile(themeImgLocation, 
					oriImgName, themeImgFile.getBytes());
			imgUrl = "/images/" + imgName;
			
			}
		
		
		themeImg.updateThemeImg(oriImgName, imgName, imgUrl);
		themeImgRepository.save(themeImg);
		
		
		
	}
	
	
	public List<ThemeImg> getImgList(){
		return themeImgRepository.getImgList();
	}
	
}
