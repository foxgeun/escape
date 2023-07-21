package com.escape.Service;

import java.util.List;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.escape.dto.ReserveDto;

import com.escape.entity.Member;

import com.escape.entity.Theme;
import com.escape.entity.ThemeImg;
import com.escape.repository.MemberRepository;

import com.escape.repository.ThemeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class ThemeService {


	private final MemberRepository memberRepository;
	private final ThemeRepository themeRepository;
	private final ThemeImgService themeImgService;

	
	public void findres(ReserveDto reserveDto, String email) throws Exception{
		Member member = memberRepository.findByEmail(email);
		
	}
	

	
	public List<Theme> getThemeList(){
		return themeRepository.getThemeList();
	}
	
	
	public List<Theme> SearchthemeIdList(String themeName){
		return themeRepository.SearchthemeIdList(themeName);
	}
	
	public Theme updateList(int id) {
		return themeRepository.updateList(id);
	}
	
	
	public void saveImg(List<MultipartFile> themeImgFileList, Theme theme ) throws Exception {
		
		for(int i=0; i<themeImgFileList.size(); i++) {
			ThemeImg themeImg = new ThemeImg();
			themeImg.setImgName(themeImg.getImgName());
		
			themeImgService.saveThemeImg(themeImg, themeImgFileList.get(i));
			theme.setImgUrl(themeImg.getImgUrl());
			themeImg.setName(theme.getName());
			themeImg.setHorror(theme.getHorror());
			themeImg.setLevel(theme.getLevel());
			themeRepository.save(theme);
		}
		
		
		
	}
	
	
	
	
}
