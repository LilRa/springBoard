package com.pjt.dao;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.pjt.commom.Criteria;
import com.pjt.vo.BoardVO;

@Repository("boardDAO")
public class BoardDAO {
	
	@Inject
	SqlSessionTemplate sqlSession;
	
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> selectBoardList(Criteria cri){
		return sqlSession.selectList("board.selectBoardList",cri);
	}
	
	public void insertBoard(BoardVO boardVO) {
		sqlSession.insert("board.insertBoard",boardVO);
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> detailBoard(BoardVO boardVO){
		return sqlSession.selectOne("board.detailBoard",boardVO);
	}
	
	public void updateHitBoard(BoardVO boardVO) {
		sqlSession.update("board.updateHitBoard",boardVO);
	}
	
	public int countBoardList() {
		return sqlSession.selectOne("board.countBoardList");
	}
	
	@SuppressWarnings("unchecked")
	public void modifyBoard(BoardVO boardVO) {
		sqlSession.update("board.updateBoard",boardVO);
	}

	public void delete(String string, BoardVO boardVO) {
		// TODO Auto-generated method stub
		sqlSession.delete("board.deleteBoard", boardVO);
	}
	
	public void fileInsert() {
		sqlSession.insert("board.insertFile");
	}

	public void fileInsert(Map<String, Object> map) {
		// TODO Auto-generated method stub
		sqlSession.insert("board.insertFile",map);
	}
}
