package com.pjt.commom;

import org.apache.log4j.Logger;

public class Criteria {
	Logger log = Logger.getLogger(this.getClass());
	private int page;	//���� ������ ��ȣ
	private int perPageNum;	//�������� ������ �Խñ� ��
	
	public Criteria() {
		this.page = 1;
		this.perPageNum =10;
	}

	
	// Ư�� �������� �Խñ� ���� ��ȣ, �Խñ� ���� �� ��ȣ
	public int getPageStart() {
		//���� �������� �Խñ� ���۹�ȣ = (���� ��������ȣ -1)*�������� ������ �Խñ� �� 
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
		log.debug("pageCount �� :::::::::::> "+pageCount);
		log.debug("cnt �� :::::::::::> "+cnt);
		if(pageCount != cnt) {
			this.perPageNum = cnt;
			log.debug("this.perPageNum :::::::::::> "+this.perPageNum);
		}else {
			this.perPageNum = pageCount;
			log.debug("else >>>>> this.perPageNum :::::::::::> "+this.perPageNum);			
		}
	}

}