package com.pjt.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.pjt.service.BoardService;
import com.pjt.vo.BoardVO;

@Controller
public class UploadController {
	Logger log = Logger.getLogger(this.getClass());
	@Resource(name="boardService")
	private BoardService boardService;
	
	@Resource(name="uploadPath")
	String uploadPath;
	
	@RequestMapping(value="/upload/uploadPage")
	public String boardInsert() throws Exception{
		return "/upload/uploadPage";
	}
	
//	@RequestMapping(value="/upload/fileUpload")
//	public String fileInsert(MultipartHttpServletRequest mtfRequest) {
//        List<MultipartFile> fileList = mtfRequest.getFiles("file");
//        for (MultipartFile mf : fileList) {
//            String originFileName = mf.getOriginalFilename(); // 원본 파일 명
//            long fileSize = mf.getSize(); // 파일 사이즈
//
//            System.out.println("originFileName : " + originFileName);
//            System.out.println("fileSize : " + fileSize);
//
//            String safeFile = uploadPath + System.currentTimeMillis() + originFileName;
//            try {
//                mf.transferTo(new File(safeFile));
//            } catch (IllegalStateException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            } catch (IOException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//        }
//		return "redirect:/upload/uploadPage";
//	}
	
	
	@RequestMapping(value="/upload/fileUpload")
	public String fileInsert(MultipartFile[] file) throws Exception {
        boardService.insertFile(file);
        return "redirect:/board/boardList";
	}

}
