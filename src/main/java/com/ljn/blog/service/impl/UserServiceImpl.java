package com.ljn.blog.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ljn.blog.dao.UserDao;
import com.ljn.blog.po.Contents;
import com.ljn.blog.po.User;
import com.ljn.blog.po.UserInformation;
import com.ljn.blog.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;
@Service
@Transactional
public class UserServiceImpl implements UserService{
	@Autowired UserDao ud;
	@Transactional
	public boolean get(User user) {
	   User u= ud.login(user.getUserName());
	   if(u!=null) {
	    if(u.getPassword().equals(user.getPassword())) {
	    	System.out.println("chenggong");

	    	return true;
	    }else {

       HttpSession session= ServletActionContext.getRequest().getSession();
        session.setAttribute("message", "密码错误");
	  
	    System.out.println("shibai");
	    return false;
	    }
	}else {
	       HttpSession session= ServletActionContext.getRequest().getSession();
	        session.setAttribute("message", "账号错误");
		  
		return false;
	}
	}
	@Override
	public boolean add(User user) {
		String name=user.getUserName();
		if(name!=null&&name.length()>=3&&name.length()<10) {
			if(user.getPassword().equals(user.getRepassword())) {
				Serializable  s=ud.add(user);
				return s!=null;
			}
		}
		
		return false;
	}
	@Override
	public int getid(String userName) {
		
		return ud.getid(userName);
	}
	
	//头像
	@Override
	public void saveinfornation(UserInformation uifs) {
        ud.saveinfomation(uifs);
		
	}
	//获取个人信息
	@Override
	public UserInformation getuserinfor(Integer uid) {
		
		return ud.getuserinfor(uid);
	}
	//更新个人信息
	@Override
	public void updateUserinfo(UserInformation uif) {
		
		ud.updateUserinfo(uif);
	}
   

	//修改密码
	@Override
	public void updatepwd(User u) {
		
		ud.updatepwd(u);
	}
	@Override
	public User getUser(String userName) {
		
		return ud.login(userName);
	}
	@Override
	public List<Contents> getcontents() {
		
		return ud.getcontents();
	}


}
