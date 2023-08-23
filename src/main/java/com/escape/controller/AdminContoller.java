package com.escape.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.escape.Service.ThemeImgService;
import com.escape.Service.ThemeService;
import com.escape.entity.Reserve;
import com.escape.entity.Theme;
import com.escape.entity.ThemeImg;
import com.escape.repository.ReserveRepository;
import com.escape.repository.ThemeImgRepository;
import com.escape.repository.ThemeRepository;

import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
public class AdminContoller {
	
	private final ThemeRepository themeRepository;
	private final ThemeImgRepository themeImgRepository;
	private final ThemeService themeService;
	private final ThemeImgService themeImgService;
	private final ReserveRepository reserveRepository;
	
	
	

	@GetMapping(value= "/admin/insert")
	public String adinsert1(Model model) {
		
		
		model.addAttribute("Theme", new Theme());
		return "admin/adinsert";
	}
	
	
	@GetMapping(value= "/admin")
	public String admin(Model model) {
		
		List<ThemeImg> imgList = themeImgRepository.getImgList();
		List<Reserve> resList = reserveRepository.getresList();
		
		model.addAttribute("reserve", resList);
		model.addAttribute("imgList", imgList);
	
		return "admin/admin";
	}
	
	@GetMapping(value= "/admin/update/{id}")
	public String adupdate(Model model, @PathVariable("id") int id ) {
		Theme themeupdate = themeRepository.updateList(id);
		List<ThemeImg> imgList = themeImgRepository.getImgList();
		List<Theme> SearchthemeIdList = themeRepository.SearchthemeIdList2(id);
		List<ThemeImg> SearchthemeImgIdList = themeImgRepository.SearchthemeIdList(id);
		
		
		
		
		model.addAttribute("updateid", id);
		model.addAttribute("searchthemeIdList", SearchthemeIdList);
		model.addAttribute("searchthemeImgIdList",SearchthemeImgIdList);
		model.addAttribute("theme", themeupdate);
		model.addAttribute("imgList", imgList);
	
		return "admin/adupdate";
	}
	

	//등록!
	@PostMapping(value= "/insert")
	public String adinsert2( Model model,
			@RequestParam("themeImgFile") List<MultipartFile> themeImgFileList,Theme theme) { 
		

		
		try {
			themeService.saveImg(themeImgFileList,theme);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		
		
		}
		
		return "redirect:/";
	}
	
	//수정
	@PostMapping(value= "/admin/update/{id}")
	public String adupdate2( Model model,
			@RequestParam("themeImgFile") List<MultipartFile> themeImgFileList,Theme theme, @PathVariable("id") int id) { 
		

		
		try {
			themeService.updateImg(themeImgFileList, theme);
			themeService.updateTheme(theme, id);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		
		
		}
		
		return "redirect:/";
	}
	
	
	@GetMapping(value= "/admin/delete/{id}")
	public String delete(@PathVariable("id") int Id, Principal principal) {
		
		
		themeService.deletetheme(Id);
		
		return "redirect:/";
	}
	
}
