package com.pjt.controller;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.pjt.commom.HttpRestURLConnection;
import com.pjt.vo.ItemVO;
import com.pjt.vo.SearchVO;

@RestController
@RequestMapping("/search")
public class restController {
	Logger log = Logger.getLogger(this.getClass());
	
	
	@GetMapping(value="/blogList/{searchKey}/{searchWord}",produces="application/json; charset=UTF-8")
	public List<HashMap<String, String>> serchBlog(@PathVariable String searchKey, @PathVariable String searchWord) {
		HttpRestURLConnection restConn = new HttpRestURLConnection();
//		List list = new Array();
		log.debug("0000000000000000000000000000000000000000000000000000000000000000000000000");
		String data = restConn.httpURLConn(searchKey, searchWord);
		Gson gson = new Gson();
		SearchVO searchVO = gson.fromJson(data, SearchVO.class);
		log.debug("searchVO >>>>>>>>>>>>>>>>>>>> "+data.toString());
		List<ItemVO> itemList = searchVO.getItems();
		log.debug("itemList>>>>>>>>>>>>>>>>>>>> "+itemList.toString());
		List<HashMap<String, String>> list = new ArrayList<HashMap<String,String>>();
		HashMap<String, String> map = null;
			for(int i=0; i < itemList.size(); i++) {
				map = new HashMap<String, String>();
				map.put("title", itemList.get(i).getTitle());
				map.put("link", itemList.get(i).getLink());
				list.add(map);
			}
			log.debug("jsonData >>>>> "+list.toString());
		return list;
	}
	
	@RequestMapping(value="/searchBlog" ,method=RequestMethod.GET)
	public ModelAndView searchBlog() throws Exception{
		ModelAndView mav = new ModelAndView("/search/blogList");
		mav.addObject("");
		return mav;
	}

}
