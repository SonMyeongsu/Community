package kh.study.community.board.service;

import java.util.List;
import java.util.Map;

import kh.study.community.board.vo.BoardHateVO;
import kh.study.community.board.vo.BoardLikeVO;
import kh.study.community.board.vo.BoardVO;


public interface BoardService {

	//게시글 검색 및 목록 조회
	List<BoardVO> boardList(Map<String, Object> map);
	
	//게시글 등록
	void regBoard(BoardVO boardVO);
	
	//상세페이지
	BoardVO boardDetail(int boardNum);
	
	//조회수 증가
	void updateReadCnt(int boardNum);
	
	
		
	//수정하기
	void updateBoard(BoardVO boardVO);
	
	//삭제하기
	void deleteBoard(int boardNum);
	
	//게시글 총 개수 조회
	int selectBoardCnt();
	
}
