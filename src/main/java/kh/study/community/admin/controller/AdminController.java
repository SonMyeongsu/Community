package kh.study.community.admin.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import groovyjarjarantlr4.v4.parse.ANTLRParser.element_return;
import kh.study.community.admin.service.AdminService;
import kh.study.community.admin.vo.CategoryVO;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Resource(name = "adminService")
	private AdminService adminService;
	
	
	//카테고리 관리 페이지
	@GetMapping("/cateManagePage")
	public String cateManagePage(Model model, CategoryVO categoryVO/* , int codeTypeId, int code */)	{
		
		
		List<CategoryVO> cateList = adminService.selectCategoryList();
		//카테고리 조회
		model.addAttribute("cateList", cateList);
		
		
		
		return "pages/admin/cateManagePage";
		
	}
	
	
	
	
	//카테고리 바 조회(사이드 바에서 카테고리 조회)
	public String categoryBar(Model model) {
		
		
		List<CategoryVO> cateList = adminService.selectCategoryList();
		//카테고리 조회
		model.addAttribute("cateList", cateList);
		
		
		return "fragment/cate";
	}
	
	
	
	
	//카테고리 등록기능
	@PostMapping("/regCateMethod")
	public String regCateMethod() {
		
		adminService.insertCommonCode();
		
		
		return"redirect:/admin/cateManagePage";
	}
	
	
	
	
	
	
}
