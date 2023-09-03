package kh.study.community.board.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kh.study.community.board.vo.BoardHateVO;
import kh.study.community.board.vo.BoardLikeVO;
import kh.study.community.board.vo.BoardVO;
import kh.study.community.member.vo.MemberVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService{
//	Add unimplemented methods 하는 단축키는 아래와 같습니다. 
//	1.  Ctrl + .      (오류가 난 부분 선택)
//	2.  Ctrl + 1     (오류 해결방안)
//	3.  Enter        (적용)
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	//게시글 등록
	@Override
	public void regBoard(BoardVO boardVO) {
		//SqlSessionTemplate의 메서드(mybatis의 sql문id, 엑세스하는 객체)
		sqlSession.insert("boardMapper.regBoard", boardVO);
		
	}

	//게시글 검색 및 목록 조회
	@Override
	public List<BoardVO> boardList(Map<String, Object> map) {
		
		return sqlSession.selectList("boardMapper.selectBoardList", map);
	}
	
	//게시판 카테고리 조회
	
	

	//상세페이지
	@Override
	public BoardVO boardDetail(int boardNum) {
		return sqlSession.selectOne("boardMapper.selectBoardDetail", boardNum);
	}
	
		
		
		
	
	// 조회수 증가
	@Override
	public void updateReadCnt(int boardNum) {
		sqlSession.update("boardMapper.updateReadCnt", boardNum);
	}
	
	//수정하기
	@Override
	public void updateBoard(BoardVO boardVO) {
		sqlSession.update("boardMapper.updateBoard", boardVO);
	}
	
	//삭제하기
	@Override
	public void deleteBoard(int boardNum) {
		sqlSession.delete("boardMapper.deleteBoard", boardNum);
	}
	
	//게시글 총 개수 조회
	@Override
	public int selectBoardCnt() {
		return sqlSession.selectOne("boardMapper.selectBoardCnt");
	}






}
