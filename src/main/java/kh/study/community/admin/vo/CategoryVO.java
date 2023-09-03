package kh.study.community.admin.vo;


import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CategoryVO implements Cloneable {
//깊은 복사(deep copy) : 원본이 참조하고 있는 힙의 데이터까지 복제하는 것(기존의 객체의 주솟값 복사가 아님)
//깊은 복사 문제점 : 참조형 타입의 데이터를 복사했을 경우(예로 배열)
// 배열 같은경우 배열 자체는 완벽히 복사가 되었지만, 배열 내용물 객체는 얕은 복사가 되어버려 원본과
//배열본의 배열 요소가 담고있는 주소값이 같아 바라보고 있는 힙 데이터가 같게 되어버림.
	
//얕은 복사(shallow copy) : 참조형 타입의 변수를 그대로 복제하는 것(객체의 주솟값 복제)
//얕은 복사 문제점 : 얕은 복사인 경우 원본을 변경하려면 복사본도 영향을 받음	
	

	private int codeTypeId;
	private int code;
	private String categoryName;
	private int slaveCodeTypeId; //하위 카테고리의 코드 유형ID
	public List<CategoryVO> slaveList = new ArrayList<>(); //현 공통코드 유형ID에 종속된 하위 카테고리 리스트...  
	// 컨트롤단에서 연산후 리스트에 넣어줘야 함. 
	
	
	
	@Override
    public CategoryVO clone() throws CloneNotSupportedException {
        return (CategoryVO) super.clone();
    }
	
}

