package com.pjt.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.pjt.commom.Criteria;
import com.pjt.dao.BoardDAO;
import com.pjt.vo.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService{
	
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="boardDAO")
	private BoardDAO boardDAO;

	@Override
	public List<Map<String, Object>> selectBoardList(Criteria cri) {
		// TODO Auto-generated method stub
		return boardDAO.selectBoardList(cri);
	}
	

	@Override
	public void insertBoard(BoardVO boardVO) throws Exception {
		//MultipartFile을 배열형태로 가져온다.
		// TODO Auto-generated method stub
		boardDAO.insertBoard(boardVO);
		//fileUtils 클래스에서 가공된 정보들을 하나씩 sql처리 해서 등록한다.
		/*List<Map<String, Object>> fileList = fileUtils.parseFileInfo((Map<String, Object>) commandMap.getMap(), file);
		for(int i=0; i<fileList.size(); i++) {
			boardDAO.insertFile(fileList.get(i));
		}*/
	}

	@Override
	public Map<String, Object> viewBoardDetail(BoardVO boardVO) {
		// TODO Auto-generated method stub
		boardDAO.updateHitBoard(boardVO);
		Map<String, Object> detail = boardDAO.detailBoard(boardVO);
		return detail;
	}

	@Override
	public int countBoardListTotal() {
		// TODO Auto-generated method stub
		return boardDAO.countBoardList();
	}

	@Override
	public Map<String, Object> selectBoardDetail(BoardVO boardVO) {
		// TODO Auto-generated method stub
		return boardDAO.detailBoard(boardVO);
	}

	@Override
	public BoardVO modifyBoard(BoardVO boardVO) {
		// TODO Auto-generated method stub
		boardDAO.modifyBoard(boardVO);
		return boardVO;
	}

	@Override
	public void deleteBoard(BoardVO boardVO) {
		// TODO Auto-generated method stub
		boardDAO.delete("board.deleteBoard", boardVO);
	}

	
}
