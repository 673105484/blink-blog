package com.ljn.blog.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.swing.event.ListSelectionEvent;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ljn.blog.dao.ContentsDao;
import com.ljn.blog.po.Comment;
import com.ljn.blog.po.Contents;
import com.ljn.blog.service.ContentsService;

@Repository
public class ContentsDaoImpl implements ContentsDao {
	
	@Autowired
	SessionFactory sf;

	@Override
	public Serializable add(Contents contents) {
		Session session = sf.getCurrentSession();
		Serializable s = session.save(contents);
		return s;
	}

	// 查询用户写的文章
	@Override
	public List<Contents> getcont(String author, int index) {
		int stage = 5;
		List<Contents> list;
		Session session = sf.getCurrentSession();
		int size = session.createQuery("from Contents c where c.author=:author").setParameter("author", author).list().size();
		Query query=session.createQuery("from Contents c where c.author=:author order by c.id desc").setParameter("author", author);
		if (size >= index * stage) {
			query.setFirstResult((index - 1) * stage);
			query.setMaxResults( index * stage);
			list=query.list();
		}else {
			query.setFirstResult((index - 1) * stage);
			query.setMaxResults(size);
		    list=query.list();
		}

		return list;
	}
	//获取用户文章数

	@Override
	public int getsize(String author) {
		Session session = sf.getCurrentSession();
		int size = session.createQuery("from Contents c where c.author=:author").setParameter("author", author).list().size();
		return size;
	}
   //根据文章ID获取文章
	@Override
	public Contents getcontent(int contentid) {
		Session session = sf.getCurrentSession();
		Contents content=(Contents)session.createQuery("from Contents c where c.cid=:cid").setParameter("cid", contentid).uniqueResult();
		return content;
	}
   //获取评论
	@Override
	public List<Comment> getcomment(int contentsid, int index) {
		int stage = 3;
		List<Comment> list;
		Session session = sf.getCurrentSession();
		int size = session.createQuery("from Comment c where c.contentsid=:contentsid").setParameter("contentsid", contentsid).list().size();
		Query query=session.createQuery("from Comment c where c.contentsid=:contentsid order by c.id desc").setParameter("contentsid", contentsid);
		if (size >= index * stage) {
			query.setFirstResult((index - 1) * stage);
			query.setMaxResults( index * stage);
			list=query.list();
		}else {
			query.setFirstResult((index - 1) * stage);
			query.setMaxResults(size);
		    list=query.list();
		}

		return list;
	}
    //得到评论总数
	@Override
	public int getcommentsize(String author) {
		Session session = sf.getCurrentSession();
		int size = session.createQuery("from Comment c where c.author=:author").setParameter("author", author).list().size();
		return size;
	}
   //保存评论
	@Override
	public void saveComment(Comment comment) {
		Session session = sf.getCurrentSession();
		session.save(comment);
	}
   //回复数加一
	@Override
	public void addreplys(int contentsid) {
		Session session = sf.getCurrentSession();
		 Contents con= (Contents)session.createQuery("from Contents c where c.cid=:cid").setParameter("cid",contentsid).uniqueResult();
		 Integer re=con.getReplies()+1;
		 con.setReplies(re);
		 session.update(con);
	}
   //浏览次数加一
	@Override
	public void addiews(int contentsid) {
		Session session = sf.getCurrentSession();
		 Contents con= (Contents)session.createQuery("from Contents c where c.cid=:cid").setParameter("cid",contentsid).uniqueResult();
		 Integer re=con.getViews()+1;
		 con.setViews(re);
		 session.update(con);
		
	}
   //删除文章
	@Override
	public void delecteContents(int id) {
		Session session = sf.getCurrentSession();
		Contents con=(Contents)session.createQuery("from Contents c where c.cid=:cid").setParameter("cid",id).uniqueResult();
		session.delete(con);
	}
   //修改文章
	@Override
	public void updateContents(Contents con) {
		Session session = sf.getCurrentSession();
		session.update(con);
	}

	@Override
	public List<Contents> searchContents(String search) {
		Session session = sf.getCurrentSession();
		String hql = "from Contents c where c.title like:title or c.content like:content";
		List<Contents> conlist=session.createQuery(hql).setParameter("title", "%"+search+"%").setParameter("content", "%"+search+"%").list();
		
		return conlist;
	}

}
