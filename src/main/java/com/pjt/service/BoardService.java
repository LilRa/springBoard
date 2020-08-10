package com.pjt.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.pjt.commom.Criteria;
import com.pjt.vo.BoardVO;

public interface BoardService {
	
	List<Map<String, Object>> selectBoardList(Criteria cri);

	void insertBoard(BoardVO boardVO) throws Exception;	
	
	Map<String, Object> viewBoardDetail(BoardVO boardVO);
	
	int countBoardListTotal();
	
    Map<String, Object> selectBoardDetail(BoardVO boardVO);
    
	BoardVO modifyBoard(BoardVO boardVO);
	
	void deleteBoard(BoardVO boardVO);
	
	void insertFile(MultipartFile[] file) throws Exception;
		
}
