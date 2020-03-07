package com.pjt.commom;

import org.apache.log4j.Logger;

public class Criteria {
	Logger log = Logger.getLogger(this.getClass());
	private int page;	//현재 페이지 번호
	private int perPageNum;	//페이지당 보여줄 게시글 수
	
	public Criteria() {
		this.page = 1;
		this.perPageNum =10;
	}

	
	// 특정 페이지의 게시글 시작 번호, 게시글 시작 행 번호
	public int getPageStart() {
		//현재 페이지의 게시글 시작번호 = (현재 페이지번호 -1)*페이지당 보여줄 게시글 수 
		return (this.page-1)*perPageNum;
	}

	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		if(page <= 0) {
			this.page = 1;
		} else {
			this.page = page;
		}
	}
	
	public int getPerPageNum() {
		return perPageNum;
	}
	
	public void setPerPageNum(int pageCount) {
		int cnt = this.perPageNum;
		log.debug("pageCount 값 :::::::::::> "+pageCount);
		log.debug("cnt 값 :::::::::::> "+cnt);
		if(pageCount != cnt) {
			this.perPageNum = cnt;
			log.debug("this.perPageNum :::::::::::> "+this.perPageNum);
		}else {
			this.perPageNum = pageCount;
			log.debug("else >>>>> this.perPageNum :::::::::::> "+this.perPageNum);			
		}
	}

}
