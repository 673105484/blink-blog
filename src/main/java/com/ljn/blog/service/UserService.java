package com.ljn.blog.service;

import java.util.List;

import com.ljn.blog.po.Contents;
import com.ljn.blog.po.User;
import com.ljn.blog.po.UserInformation;

public interface UserService {

	public boolean get(User user);

	public boolean add(User user);
	public void saveinfornation(UserInformation uifs);

	public UserInformation getuserinfor(Integer uid);

	public int getid(String userName);

	public void updateUserinfo(UserInformation uif);
	public void updatepwd(User u);

	public User getUser(String userName);

	public List<Contents> getcontents();

	


}
