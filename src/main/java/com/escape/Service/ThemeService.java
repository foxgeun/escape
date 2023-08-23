package com.escape.Service;

import java.util.List;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.escape.dto.ReserveDto;
import com.escape.dto.ThemeFormDto;
import com.escape.entity.Member;

import com.escape.entity.Theme;
import com.escape.entity.ThemeImg;
import com.escape.repository.MemberRepository;
import com.escape.repository.ThemeImgRepository;
import com.escape.repository.ThemeRepository;
import com.escape.repository.TimeRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class ThemeService {


	private final MemberRepository memberRepository;
	private final ThemeRepository themeRepository;
	private final ThemeImgService themeImgService;
	private final ThemeImgRepository thmeImgRepository;


	
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
	
	public void updateTheme(Theme theme, int id) {
		Theme theme1 = themeRepository.SearchthemeIdList4(id);
		ThemeImg themeImg = thmeImgRepository.SearchthemeIdList2(id);
		
		themeImg.updateImg(theme);
		theme1.updateTheme(theme);
		
		
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
	
	public void updateImg(List<MultipartFile> themeImgFileList, Theme theme ) throws Exception {
		
		for(int i=0; i<themeImgFileList.size(); i++) {
			ThemeImg themeImg = new ThemeImg();
			themeImg.setImgName(themeImg.getImgName());
			themeImgService.updateThemeImg(themeImg, themeImgFileList.get(i));
			theme.setImgUrl(themeImg.getImgUrl());
			
			

		}
		
		
		
	}
	
	public void deletetheme(int Id) {
		List<Theme> order = themeRepository.SearchthemeIdList2(Id);
		List<ThemeImg> orders = themeImgService.deleteImg(Id);
            
		themeRepository.deleteAll(order);		
		thmeImgRepository.deleteAll(orders);
	}
	
	
	
	
}
