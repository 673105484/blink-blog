package com.ljn.blog.dao;

import java.io.Serializable;
import java.util.List;

import com.ljn.blog.po.Comment;
import com.ljn.blog.po.Contents;

public interface ContentsDao {

	Serializable add(Contents contents);

	List<Contents> getcont(String author,int index);

	int getsize(String author);

	Contents getcontent(int contentid);

	List<Comment> getcomment(int contentsid, int index);

	int getcommentsize(String author);

	void saveComment(Comment comment);

	void addreplys(int contentsid);

	void addiews(int contentsid);

	void delecteContents(int id);

	void updateContents(Contents con);

	List<Contents> searchContents(String search);

}
