package com.pjt.controller;

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

@RestController
@RequestMapping("/search")
public class restController {
	Logger log = Logger.getLogger(this.getClass());
	
	
	@GetMapping(value="/blogList/{searchKey}/{searchWord}",produces="application/json; charset=utf-8")
	public String serchBlog(@PathVariable String searchKey, @PathVariable String searchWord) {
		HttpRestURLConnection restConn = new HttpRestURLConnection();
		System.out.println("0000000000000000000000000000000000000000000000000000000000000000000000000");
		log.debug("0000000000000000000000000000000000000000000000000000000000000000000000000");
		String data = restConn.httpURLConn(searchKey, searchWord);
		Gson gson = new Gson();
		JsonObject jsonObject = gson.fromJson(data, JsonObject.class);
		log.debug("jsonObject ======>>>> "+jsonObject);
		System.out.println(""+jsonObject.toString());
		return jsonObject.toString();
	}
	
	@RequestMapping(value="/searchBlog" ,method=RequestMethod.GET)
	public ModelAndView searchBlog() throws Exception{
		ModelAndView mav = new ModelAndView("/search/blogList");
		mav.addObject("");
		return mav;
	}

}
