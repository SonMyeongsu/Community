package kh.study.community.admin.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kh.study.community.admin.vo.CategoryVO;

@Service("adminService")
public class AdminServiceImpl implements AdminService {
	
	@Autowired SqlSessionTemplate sqlSession;

	
	//조회
	@Override
	public List<CategoryVO> selectCategoryList() {
		
		
		
		List<CategoryVO> cateList = sqlSession.selectList("adminMapper.selectCategoryList");

		//100번대 카테고리 갯수를 세아린다.
		int numCategory100 = 0;
		for (CategoryVO cate : cateList) {
			if(cate.getCodeTypeId() == 100)
				numCategory100++;
		}


		while(true) {
			if( cateList.size() > numCategory100 ) { // 기존의 카테고리 조회문의 길이가 100번째 카테고리 갯수와 
													 //같아지기 전까지 내부작업 실행
				
				try {
				
					
					
					//맨 마지막 카테고리를 복제해놓는다.
					CategoryVO ca = cateList.get( cateList.size()-1 ).clone();

					//복제한 해당 카테고리의 상위 계층에 포함시키고 리스트에서 해당 카테고리를 삭제한다.
					for (CategoryVO cate : cateList) {
						if(cate.getSlaveCodeTypeId() == ca.getCodeTypeId()){
							cate.slaveList.add(0, ca);
							cateList.remove(cateList.size()-1);
							
							break;
							
						}
					}
				
					
					
				} catch (CloneNotSupportedException e) {
					e.printStackTrace();
				}
				
			}
			
			
			else {
				
				for (CategoryVO cate : cateList) {

					System.out.println(cate + "!!!!!!!!!!!!!!!!!!!!!!!");
				}
				
				
				
				return cateList;
			}
		}
		
		
		
	}

	//공통코드 튜플 생성
	@Transactional
	@Override
	public void insertCommonCode() {
		sqlSession.insert("adminMapper.insertCommonType");//자동 공통코드유형 튜플 생성 쿼리
		sqlSession.insert("adminMapper.insertCommonCode");//자동 공통코드 튜플 생성
	}



	
}
