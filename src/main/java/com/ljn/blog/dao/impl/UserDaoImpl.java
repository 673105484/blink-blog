package com.ljn.blog.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ljn.blog.dao.UserDao;
import com.ljn.blog.po.Contents;
import com.ljn.blog.po.User;
import com.ljn.blog.po.UserInformation;
@Repository
public class UserDaoImpl implements UserDao{
 //��¼ ��ѯ�û���Ϣ
   @Autowired SessionFactory sf;
	public User login(String userName) {
		Session  session= sf.getCurrentSession();
		User u=(User)session.createQuery("from User u where u.userName=:username").setParameter("username", userName).uniqueResult();
		return u;
	}
	//ע��
	@Override
	public Serializable add(User user) {
	    Session session=sf.getCurrentSession();
	    Serializable s= session.save(user);
	    User u=(User)session.createQuery("from User u where u.userName=:userName").setParameter("userName",  user.getUserName()).uniqueResult();
	    UserInformation uif=new UserInformation();
	    uif.setUid(u.getUid());
	    session.save(uif);
		return s;
	}
	//����ͼƬ
	@Override
	public void saveinfomation(UserInformation uifs) {
		if(uifs.getUid()!=null) {
			Session session=sf.getCurrentSession();
			session.update(uifs);
	    }else {
	    	 Session session=sf.getCurrentSession();
	 	    session.save(uifs);
	
	    }
	}
    //�����û�ID����û���Ϣ
	@Override
	public UserInformation getuserinfor(Integer uid) {
		Session session= sf.getCurrentSession();
		UserInformation u=(UserInformation)session.createQuery("from UserInformation u where u.uid=:uid").setParameter("uid", uid).uniqueResult();

		return u;
	}
	//�õ���¼�û���ID
	@Override
	public int getid(String userName) {
		Session session= sf.getCurrentSession();
		User u=(User)session.createQuery("from User u where u.userName=:userName").setParameter("userName", userName).uniqueResult();
		return u.getUid();
	}
    //�����û���Ϣ
	@Override
	public void updateUserinfo(UserInformation uif) {
		Session session= sf.getCurrentSession();
		session.update(uif);
	}
	//�޸�����
	@Override
	public void updatepwd(User u) {
		Session session=sf.getCurrentSession();
		session.update(u);
	}
	@Override
	public List<Contents> getcontents() {
		
		Session session=sf.getCurrentSession();
		List<Contents> contentslist=session.createQuery("from Contents c order by c.cid desc").list();
		return contentslist;
	}
	

}
