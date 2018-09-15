package com.ljn.blog.action;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import com.ljn.blog.po.User;
import com.ljn.blog.po.UserInformation;
import com.ljn.blog.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
@Controller
@ParentPackage("struts-default")
@Namespace("/")
public class FileAction extends ActionSupport{
	@Autowired UserService userService;
	private File headImg ;
    private String headImgContentType;
    private String headImgFileName;
    private User user;
	@Action(value ="fileUpload",results = @Result(name = "success" ,location = "/view/settings/profile.jsp",type = "redirect"))
	public String flieUpload(){
		if(headImg!=null) {
		HttpSession session=ServletActionContext.getRequest().getSession();
		String filePath =("F:/eclipse demo/blog2/WebContent/upload/"+(String)session.getAttribute("userName"));
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String fileName=dateFormat.format(new Date())+headImgFileName.substring(headImgFileName.lastIndexOf("."));
        try {
			FileUtils.copyFile(headImg, new File(filePath,fileName));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
        String userName= (String)session.getAttribute("userName");
        int uid=(int)session.getAttribute("uid");
        UserInformation userinformation= userService.getuserinfor(uid);
        userinformation.setHeadImg(userName+"/"+fileName);
		userService.updateUserinfo(userinformation);
		session.setAttribute("uif",userinformation);
		}
		return SUCCESS;
	}
	
     
    
	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}

	public File getHeadImg() {
		return headImg;
	}

	public void setHeadImg(File headImg) {
		this.headImg = headImg;
	}

	public String getHeadImgContentType() {
		return headImgContentType;
	}

	public void setHeadImgContentType(String headImgContentType) {
		this.headImgContentType = headImgContentType;
	}

	public String getHeadImgFileName() {
		return headImgFileName;
	}

	public void setHeadImgFileName(String headImgFileName) {
		this.headImgFileName = headImgFileName;
	}

}
