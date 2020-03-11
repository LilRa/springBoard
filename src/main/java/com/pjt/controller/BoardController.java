package com.pjt.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pjt.commom.Criteria;
import com.pjt.commom.PageMaker;
import com.pjt.service.BoardService;
import com.pjt.vo.BoardVO;

@Controller
public class BoardController {

	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="boardService")
	private BoardService boardService;
	
	@RequestMapping(value="/board/boardList")
	public ModelAndView openBoardList(Criteria cri) throws Exception {
		
		ModelAndView mav = new ModelAndView("/board/boardList");
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		log.debug("其捞瘤 皋捞目目目目目目目---------------"+pageMaker.getStartPage());
		log.debug("其捞瘤 皋捞目目目目目目目---------------"+pageMaker.getStartPage());
		log.debug("其捞瘤 皋捞目目目目目目目---------------"+pageMaker.getStartPage());
		log.debug("其捞瘤 皋捞目目目目目目目---------------"+pageMaker.getStartPage());
		log.debug("其捞瘤 皋捞目目目目目目目---------------"+pageMaker.getStartPage());
		log.debug("其捞瘤 皋捞目目目目目目目---------------"+pageMaker.getStartPage());
		
		
		
		
		
		
		
		
		
		
		
		
		log.debug("ssssssssssssssss目---------------"+cri.getPageStart());
		log.debug("ssssssssssssssss目---------------"+cri.getPage());
		log.debug("ssssssssssssssss目---------------"+cri.getPerPageNum());
		pageMaker.setTotalCount(boardService.countBoardListTotal());
		log.debug("ssssssssssssssss目---------------"+boardService.countBoardListTotal());		
		List<Map<String,Object>> list = boardService.selectBoardList(cri);
		mav.addObject("list",list);
		mav.addObject("pageMaker",pageMaker);
		log.debug("list 蔼涝聪促. ----------> "+list.toString());
		return mav;
	}
	
	@RequestMapping(value="/board/boardWrite",  method=RequestMethod.GET)
	public String boardWrite() throws Exception{
		return "/board/boardWrite";
	}
	
    @RequestMapping(value="/board/boardWrite", method=RequestMethod.POST)
    public ModelAndView boardWritePOST(BoardVO boardVO) throws Exception {
    	ModelAndView mav = new ModelAndView("redirect:/board/boardList");
    	log.debug("咯扁鳖柳 甸绢吭聪? ");
    	boardService.insertBoard(boardVO);
        return mav;
    }

	@RequestMapping(value="/board/boardDetail")
	public ModelAndView boardDetail(BoardVO boardVO,Criteria cri) throws Exception{
		
		ModelAndView mv = new ModelAndView("/board/boardDetail");
		Map<String, Object> detail = boardService.viewBoardDetail(boardVO);
		mv.addObject("detail",detail);
		mv.addObject("cri",cri);
		log.debug("叼抛老蔼 ----------------> :"+detail);
		return mv;
	}
	
	@RequestMapping(value="/board/boardModify", method=RequestMethod.GET)
	public ModelAndView boardModify(BoardVO boardVO,Criteria cri) throws Exception{
		ModelAndView mv =new ModelAndView("/board/boardModify");
		Map<String, Object> detail = boardService.selectBoardDetail(boardVO);
		mv.addObject("detail", detail);
		mv.addObject("cri",cri);
		log.debug("荐沥其捞瘤 ----------------> :"+detail);
		return mv;
	}
	
	@RequestMapping(value="/board/boardModify", method=RequestMethod.POST)
	public ModelAndView boardModifyPOST(BoardVO boardVO,Criteria cri,RedirectAttributes redAttr) throws Exception{
		ModelAndView mv = new ModelAndView("redirect:/board/boardList");
		//mv.addObject("detail", detail);
		mv.addObject("IDX", boardVO.getIDX());
		
		log.debug("idx ===========================================>"+boardVO.getIDX());
		boardService.modifyBoard(boardVO);
        redAttr.addAttribute("page", cri.getPage());
        redAttr.addAttribute("perPagNum", cri.getPerPageNum());
		return mv;
	}
	
	@RequestMapping(value="/board/boardDelete")
	public ModelAndView boardDelete(BoardVO boardVO, Criteria cri, RedirectAttributes redAttr) throws Exception{
		ModelAndView mv = new ModelAndView("redirect:/board/boardList");
		boardService.deleteBoard(boardVO);
        redAttr.addAttribute("page", cri.getPage());
        redAttr.addAttribute("perPagNum", cri.getPerPageNum());
        return mv;
	}
}