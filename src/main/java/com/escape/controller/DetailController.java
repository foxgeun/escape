package com.escape.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.escape.Service.CommentService;
import com.escape.Service.ReserveService;
import com.escape.Service.TimeService;
import com.escape.entity.Comment;
import com.escape.entity.Reserve;
import com.escape.entity.Theme;
import com.escape.entity.ThemeImg;
import com.escape.entity.Time;
import com.escape.repository.ThemeImgRepository;
import com.escape.repository.ThemeRepository;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class DetailController {
	
	private final ReserveService reserveService;
	private final ThemeRepository themeRepository;
	private final ThemeImgRepository themeImgRepository;
	private final TimeService timeService;
	private final CommentService commentService;
	
	@GetMapping(value = "/details")
	public String ddd(){
		return "detail/details";
	}
	
	
	
	@GetMapping(value = "/details/{id}/{date}")
	public String details(Model model, @PathVariable("id") int id,@PathVariable("date") String date) {
		
		List<Theme> SearchthemeIdList = themeRepository.SearchthemeIdList2(id);
		List<ThemeImg> SearchthemeImgIdList = themeImgRepository.SearchthemeIdList(id);
		List<Time> timeList = timeService.getTimeList();
		List<Comment> cmtList = commentService.CommentList(SearchthemeIdList.get(0).getName());
		
		
		LocalDate now = LocalDate.now();
		try {
			List<Reserve> timeTable1 = reserveService.getwpqkfList2(SearchthemeIdList.get(0).getName(),date, timeList.get(0).getTime());
			List<Reserve> timeTable2 = reserveService.getwpqkfList2(SearchthemeIdList.get(0).getName(),date, timeList.get(1).getTime());
			List<Reserve> timeTable3 = reserveService.getwpqkfList2(SearchthemeIdList.get(0).getName(),date, timeList.get(2).getTime());
			

			Boolean time11 = (timeTable1.isEmpty());
			Boolean time12 = (timeTable2.isEmpty());
			Boolean time13 = (timeTable3.isEmpty());

			
			model.addAttribute("time11",time11);
			model.addAttribute("time12",time12);
			model.addAttribute("time13",time13);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		

		
		model.addAttribute("new" ,now);
		model.addAttribute("comment", cmtList);
		model.addAttribute("time", timeList);
		model.addAttribute("searchthemeIdList", SearchthemeIdList);
		model.addAttribute("searchthemeImgIdList",SearchthemeImgIdList);
		model.addAttribute("date", date);	
		return "detail/details";
	}
}
