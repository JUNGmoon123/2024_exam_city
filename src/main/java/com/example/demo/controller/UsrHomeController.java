package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.service.ArticleService;
import com.example.demo.util.crawlTest;
import com.example.demo.vo.City;
import com.example.demo.vo.Qna;
@Controller
public class UsrHomeController {
	
	@Autowired
	private ArticleService articleService; 
	
	
	public UsrHomeController(ArticleService articleService){
		this.articleService = articleService;
	}
	
	@RequestMapping("/usr/home/main")
	public <city> String showMain(Model model, @RequestParam(defaultValue = "") String searchKeywordTypeCode, @RequestParam(defaultValue = "") String searchKeyword) {
		
		List<City> citys = articleService.getForPrintcitys(searchKeywordTypeCode, searchKeyword);
		List<Qna> Qnas = articleService.getForQnas(searchKeywordTypeCode, searchKeyword);
		
		model.addAttribute("searchKeywordTypeCode", searchKeywordTypeCode);
		model.addAttribute("searchKeyword", searchKeyword);
		model.addAttribute("Qnas", Qnas);
		model.addAttribute("citys", citys);
		return "/usr/home/main";
	}

	
	@RequestMapping("/")
	public String showRoot() {
		
		return "redirect:/usr/home/main";
	}

}
