package com.ljn.blog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ljn.blog.dao.ContentsDao;
import com.ljn.blog.po.Comment;
import com.ljn.blog.po.Contents;
import com.ljn.blog.service.ContentsService;

@Service
@Transactional
public class ContensServiceImpl implements ContentsService{
	@Autowired ContentsDao cd;
	@Transactional
	public boolean add(Contents contents) {
	   if(cd.add(contents)!=null)
		return true;
	    return false;
	}
	@Override
	public List<Contents> getcont(String author,int index) {
		
		return cd.getcont(author,index);
	}
	@Override
	public int getsize(String author) {
		return cd.getsize(author);
	}
	//
	@Override
	public Contents getcontent(int contentid) {
	
		return cd.getcontent(contentid);
	}
	
	@Override
	public List<Comment> getcomment(int contentsid, int index) {
		
		return cd.getcomment(contentsid,index);
	}
	@Override
	public int getcommentsize(String author) {
		
		return cd.getcommentsize(author);
	}
	@Override
	public void saveComment(Comment comment) {
		
		cd.saveComment(comment);
	}
	@Override
	public void addreplys(int contentsid) {
		cd.addreplys(contentsid);
	}
	@Override
	public void addviews(int contentsid) {
		cd.addiews(contentsid);
		
	}
	@Override
	public void deleteContents(int id) {
		cd.delecteContents(id);
		
	}
	@Override
	public void updateContents(Contents con) {
		
		cd.updateContents(con);
	}
	@Override
	public List<Contents> searchContent(String search) {
		
		return cd.searchContents(search);
	}
}
