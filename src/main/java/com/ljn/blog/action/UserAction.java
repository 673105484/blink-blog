package com.ljn.blog.action;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;

import com.ljn.blog.po.Contents;
import com.ljn.blog.po.User;
import com.ljn.blog.po.UserInformation;
import com.ljn.blog.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
@Controller
@ParentPackage("struts-default")
@Namespace("/")
public class UserAction extends ActionSupport{
	
	@Autowired  UserService us;
	private User user;
	private UserInformation uif;
	private List<Contents> contentslist;
	 private Map<String,String> m= new HashMap<>();
	//登录
	@Action(value="loginAction",results= {
			@Result(name="success",location="/view/index.jsp",type="redirect"),
			@Result(name="input",location="/view/login.jsp",type="redirect")
	})
      public String login() {
    	  System.out.println(user.getUserName()+user.getPassword());
		  boolean b=us.get(user);
		  if(b==true) {
	     HttpSession session=ServletActionContext.getRequest().getSession();
	     int uid=us.getid(user.getUserName());          //根据用户名查询ID
	     uif= us.getuserinfor(uid);                     //根据id查询用户信息
	     contentslist= us.getcontents();
	     for (Contents contents : contentslist) {
			 String author=contents.getAuthor();
			 UserInformation u= us.getuserinfor(us.getid(author));
			 String headimg= u.getHeadImg();
			 m.put(author, headimg);
		}
	     session.setAttribute("imgmap", m);
	     session.setAttribute("contentslist", contentslist);
	     session.setAttribute("userName", user.getUserName());
	     session.setAttribute("uid", uid);
	     session.setAttribute("uif", uif);
	     session.removeAttribute("message");
    	  return SUCCESS;
    	  
    	  }
    	  return "input";
      }
	//注册
	@Action(value="registerAction",results= {
			@Result(name="success",location="/view/login.jsp",type="redirect"),
			@Result(name="input",location="/view/register.jsp",type="redirect")
	})
	public String register() {
	
		if(us.add(user)==true) {
			return SUCCESS;
		}
	    return "input";
		
	}
	
	//退出
	@Action(value="loginoutAction",results={
		@Result(location="/view/login.jsp",type="redirect")
	})
	public String loginout() {
		HttpSession session=ServletActionContext.getRequest().getSession();
		session.removeAttribute("userName");
		session.removeAttribute("uid");
		session.removeAttribute("uif");
		return SUCCESS;
	}
	
	//更新用户信息                   updateUserInformation
	@Action(value="updateUserInformation",results={
		@Result(location="/view/settings/profile.jsp",type="redirect")
	})
	public String updateUserinfo() {
		us.updateUserinfo(uif);
		HttpSession session =ServletActionContext.getRequest().getSession();
		session.removeAttribute("uif");
		session.setAttribute("uif", uif);
		return SUCCESS;
	}
	
	//修改密码
	@Action(value="updatePassword",results= {
	    @Result(name="success",location="/view/login.jsp",type="redirect"),
	    @Result(name="fal",location="/view/settings/admin.jsp" ,type="redirect")
	})
	public String updatePassword() {
	     HttpServletRequest request= ServletActionContext.getRequest();
	     HttpSession session=request.getSession();
	     String userName=(String)session.getAttribute("userName");
	     String password=  request.getParameter("password");
	     String updatepassword1=request.getParameter("updatepassword1");
	     String updatepassword2= request.getParameter("updatepassword2");
	     if(!updatepassword1.equals(updatepassword2)) {
	    	 return "fal";
	     }else {
	    	 User u=us.getUser(userName);
	    	 if(u.getPassword().equals(password)) {
	    		 u.setPassword(updatepassword1);
	    		 us.updatepwd(u);
	    		 session.removeAttribute("userName");
	    		 session.removeAttribute("uid");
	    		 session.removeAttribute("uif");
	    		 return "success";
	    	 }
	    	 return "fal";
	     }
	}
	
	public List<Contents> getContentslist() {
		return contentslist;
	}
	public void setContentslist(List<Contents> contentslist) {
		this.contentslist = contentslist;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public UserInformation getUif() {
		return uif;
	}
	public void setUif(UserInformation uif) {
		this.uif = uif;
	}
	

}
