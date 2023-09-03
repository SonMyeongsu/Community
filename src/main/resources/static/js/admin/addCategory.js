//카테고리 계층조회(selectBox 클릭시 이벤트, 해당 카테고리 값 가져오는 함수(코드 유형id & 코드))
function selectCateValue() {

		alert("!!!!!!!!!");
		
		let cateValue=document.querySelector('#aaaaa');
			
			
			return cateValue;


}
//카테고리 계층조회
function selectMoreCate(selectedCate) {

	let selectedOption = selectedCate.options[selectedCate.selectedIndex];
	let slaveCodeTypeIdValue = selectedOption.value;
	//ajax start
	$.ajax({
		url: '/admin/selectCategoryList', //요청경로
		type: 'get',
		data: {'slaveCodeTypeId': slaveCodeTypeIdValue
				}, //필요한 데이터
		success: function(result) {
			
			
			alert('성공');
		
		
			//선택한 코드의 하위 코드 리스트
			let cateList = document.querySelectorAll('#aaaaa');
		
		
		
			{
			alert(slaveCodeTypeIdValue);// 하위 카테고리 코드 유형
			
			let selectArea = document.querySelector("#selectArea");	
				
			let str = "";
			
			str +=`<select style="width: 150px;" name="selectCategory" onchange="selectMoreCate()">`;
			str +=	`<option value="">선택해주세요</option>`;
			
			for(var i = 0; i < cateList.length; i++){
				str +=	`<option value="` + cateList[i].codeTypeId + `">` + cateList[i].categoryName + `</option>`;
			}//챗 지피티 켜놓은거 참고하기
			
			//str +=	`<option th:each=" cate: ${cateList}" th:text="${cate.categoryName}" th:value="${cate.codeTypeId}">`
			
			//str +=	`</option>`
			str +=`</select>`;
			
			selectArea.insertAdjacentHTML('beforeend', str);
			}
		
		
		},
		error: function() {
			alert('실패');
		}
	});
	//ajax end

}
