package kh.study.community.admin.service;

import java.util.List;

import kh.study.community.admin.vo.CategoryVO;

public interface AdminService {

	
	//카테고리 조회
	List<CategoryVO> selectCategoryList();
	
	//공통코드 튜플 생성
	void insertCommonCode();
	
	
	
	
}
