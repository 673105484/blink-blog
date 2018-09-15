package com.ljn.blog.dao;

import java.io.Serializable;
import java.util.List;

import com.ljn.blog.po.Contents;
import com.ljn.blog.po.User;
import com.ljn.blog.po.UserInformation;

public interface UserDao {

	public User login(String userName);

	public Serializable add(User user);

	public void saveinfomation(UserInformation uifs);

	public UserInformation getuserinfor(Integer uid);
	public int getid(String userName);

	public void updateUserinfo(UserInformation uif);

	public void updatepwd(User u);

	public List<Contents> getcontents();
	
}
