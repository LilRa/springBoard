package com.pjt.commom;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class PageMaker {

	
	private Criteria cri;
	private int totalCount; 		//�� �Խñ� ��
	private int startPage;			//ȭ�鿡 ������ ù���� ������ ��ȣ, ���������� ��ȣ 
	private int endPage; 			//ȭ�鿡 ������ ������ ������ ��ȣ, �� ������ ��ȣ 
	private boolean prev;			//���� ��ư ���� ���� 
	private boolean next;			//���� ��ư ���� ���� 
	private int displayPageNum = 5;	//ȭ�鿡 �������� ������ ��ư�� �� 

	
	public Criteria getCri() {
		return cri;
	}
	public void setCri(Criteria cri) {
		this.cri = cri;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		calcDate();
	}
	
	private void calcDate() {
		//�������� = (����������/ȭ�鿡 �������� ������ ��ư�� ��)*������ ��ư�� ��
		endPage = (int) (Math.ceil(cri.getPage()/ (double) displayPageNum)*displayPageNum);
						//Math.ceil (�ø�/�ݿø�)
		int tempEndPage = (int) (Math.ceil(totalCount / (double) cri.getPerPageNum()));
		if(endPage > tempEndPage) {
			endPage = tempEndPage;
		}
		
		startPage = (endPage - displayPageNum) + 1;
		if(startPage < 0) startPage = 1;
		
		prev = startPage == 1 ? false : true;
		next = endPage * cri.getPerPageNum() >= totalCount ? false : true;
			
	}
	
	
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public boolean isPrev() {
		return prev;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	public int getDisplayPageNum() {
		return displayPageNum;
	}
	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}
	
	public String makeQuery(int page) {
		UriComponents uri = UriComponentsBuilder.newInstance()
				.queryParam("page", page)
				.queryParam("perPageNum", cri.getPerPageNum())
				.build();
		return uri.toUriString();
	}
	
	public String makeQueryPage(int idx, int page) {
		UriComponents uri = UriComponentsBuilder.newInstance()
				.queryParam("IDX", idx)
				.queryParam("page", page)
				.queryParam("perPageNum", cri.getPerPageNum())
				.build();
		return uri.toUriString();
	}

	public String makeSearch(int page) {
		UriComponents uri = UriComponentsBuilder.newInstance()
				.queryParam("page", page)
				.queryParam("perPageNum", cri.getPerPageNum())
				.queryParam("searchType", ((SearchCriteria) cri).getSearchType())
				.queryParam("keyword", encoding(((SearchCriteria) cri).getKeyword()))
				.build();
		return uri.toUriString();
	}
	private String encoding(String keyword) {
		if(keyword==null || keyword.trim().length()==0) return "";
		try {
			return URLEncoder.encode(keyword, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}
	
}