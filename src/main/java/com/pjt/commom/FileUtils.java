package com.pjt.commom;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartRequest;

/* xml의 Bean으로 fileUtils를 등록한다. */
@Component("fileUtils")
public class FileUtils {

	private Log log = LogFactory.getLog(this.getClass());
	
	@Resource(name="uploadPath")
	String uploadPath;
	
public List<Map<String, Object>> parseFileInfo(MultipartFile[] file) throws Exception {
		log.debug("parseFileInfo 탔다!");
		log.debug("fileUtil fileLength >>>>>:"+file.length);
		File target = new File(uploadPath);
		if(!target.exists()) target.mkdirs();
		
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> listMap = null;
		
		for(int i=0; i<file.length; i++ ) {
			log.debug("================== file start ==================");
			log.debug("파일 이름: "+file[i].getName());
			log.debug("파일 실제 이름: "+file[i].getOriginalFilename());
			log.debug("파일 크기: "+file[i].getSize());
			log.debug("content type: "+file[i].getContentType());
			log.debug("파일 존재 유무: "+file[i].isEmpty());
			log.debug("파일 데이터: file.getBytes()");
			log.debug("inputStream: file.getInputStream()");
			log.debug("transferTO: 업로드한 파일 데이터를 지정한 폴더에 저장");
			log.debug("================== file   END ==================");
			
			if(!file[i].isEmpty()) {
				
				String orgFileName = file[i].getOriginalFilename();
				String orgFileExtension = orgFileName.substring(orgFileName.lastIndexOf("."));
				String saveFileName = UUID.randomUUID().toString().replaceAll("-", "") + orgFileExtension;
				
				target = new File(uploadPath, saveFileName);
				file[i].transferTo(target);
				
				listMap = new HashMap<String, Object>();
				listMap.put("ORG_FILE_NAME", orgFileName);
				listMap.put("SAVE_FILE_NAME", saveFileName);
				listMap.put("FILE_SIZE", file[i].getSize());
				list.add(listMap);
			}

		}
		
		return list;
		
	}

}
