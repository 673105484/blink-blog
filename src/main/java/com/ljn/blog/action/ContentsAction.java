package com.ljn.blog.action;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;

import com.ljn.blog.po.Comment;
import com.ljn.blog.po.Contents;
import com.ljn.blog.po.UserInformation;
import com.ljn.blog.service.ContentsService;
import com.ljn.blog.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import oracle.net.aso.s;
@Controller
@ParentPackage("struts-default")
@Namespace("/")
public class ContentsAction extends ActionSupport{
    @Autowired ContentsService cs;
    @Autowired  UserService us;
    private Contents contents;
    private Comment comment;
    private List<Contents> conlist;
    private List<Comment> commentlist;
	@Action(value="addContents",results= {
	   @Result(name="success" ,location="userContents",type="redirect"),
	   @Result(name="replay" ,location="/view/topic/new.jsp",type="redirect")
	})
	public String addContents() throws ParseException {
		HttpSession session=ServletActionContext.getRequest().getSession();
		String author=(String)session.getAttribute("userName");
		contents.setCreated(new Date());
		contents.setViews(0);
		contents.setReplies(0);
		contents.setAuthor(author);
		boolean b=cs.add(contents);
		if(b==true) {
		    conlist= us.getcontents();
		    session.setAttribute("contentslist", conlist);
		return "success";
		}
		return "replay";
	}
	//显示发表的文章
	@Action(value="userContents",results= @Result(name="success" ,location="/view/userContents.jsp"))
			public String userContents() throws ParseException {
		        int index=1;
		        HttpServletRequest  request=ServletActionContext.getRequest();
				HttpSession session=request.getSession();
				//得到传入的当前页数
				String  index2=request.getParameter("index2");
				System.out.println(index2+"11111");
				if(index2!=null) {
					index=Integer.parseInt(index2);
				}
				
				String author=(String)session.getAttribute("userName");
				//得到当前页面的用户文章内容
                conlist=cs.getcont(author,index);
               //得到总文章数
                int size= cs.getsize(author);
                int total=((int) Math.ceil(size / 5)) + 1;
                request.setAttribute("total", total);
                request.setAttribute("index", index);
				return "success";
			}
	//显示详细文章内容
	@Action(value="showContent",results=@Result(location="/view/topic/show.jsp"))
	public String showContent() {
		HttpServletRequest request=ServletActionContext.getRequest();
		int index=1;
		String  index2=request.getParameter("index2");
		System.out.println(index2+"11111");
		if(index2!=null) {
			index=Integer.parseInt(index2);
		}
		int contentid=Integer.parseInt(request.getParameter("contentid"));
		String author=request.getParameter("author");
		HttpSession session=request.getSession();
		String userName=(String)session.getAttribute("userName");
		 contents=cs.getcontent(contentid);
		 commentlist=cs.getcomment(contentid,index);
		 int size2= cs.getcommentsize(author);
         int total=((int) Math.ceil(size2 / 3)) + 1;
         request.setAttribute("total", total);
		 request.setAttribute("index", index);
		 if(!author.equals(userName)) {
		 cs.addviews(contentid);      //浏览次数加一
		 }                
		 return SUCCESS;
	}
	//添加回复
	@Action(value="Reply",results=@Result(location="/view/index.jsp",type="redirect"))
	public String reply() {
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		String userName=(String)session.getAttribute("userName");
		String author=request.getParameter("author");
		System.out.println(author);
		int contentsid= Integer.parseInt(request.getParameter("contentsid"));
		comment.setContentsid(contentsid);
		comment.toString();
		comment.setTime(new Date());
		comment.setAuthor(author);
		comment.setUserName(userName);
		cs.saveComment(comment);
	    cs.addreplys(contentsid);     //contents中回复数加一        
		return SUCCESS;
	}
	//删除
	@Action(value="deleteContent",results=@Result(location="userContents",type="redirect"))
	public String deleteContents() {
		
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		int id=Integer.parseInt( request.getParameter("contentid"));
		cs.deleteContents(id);
	    conlist= us.getcontents();
	    session.setAttribute("contentslist", conlist);
		return SUCCESS;
	}
	//更新
	@Action(value="updateContent",results=@Result(location="userContents",type="redirect"))
	
	public String updateContents() {
		
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		int id=Integer.parseInt( request.getParameter("contentid"));
		Contents con=cs.getcontent(id);
		con.setContent(contents.getContent());
		cs.updateContents(con);
	    conlist= us.getcontents();
	    session.setAttribute("contentslist", conlist);
		return SUCCESS;
	}	
	@Action(value="searchContent",results= {@Result(name="success",location="/view/searchContent.jsp",type="redirect"),
			@Result(name="false",location="/view/searchfalse.jsp",type="redirect")
	})
	public String searchContent() {
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		String search=request.getParameter("search");
	    conlist=cs.searchContent(search);
	    if(conlist.size()==0) {
	    	return "false";
	    }
	    session.setAttribute("searchContentlist", conlist);
		return SUCCESS;
	}
	
	
	
	
	
	public Comment getComment() {
		return comment;
	}
	public void setComment(Comment comment) {
		this.comment = comment;
	}
	public List<Comment> getCommentlist() {
		return commentlist;
	}
	public void setCommentlist(List<Comment> commentlist) {
		this.commentlist = commentlist;
	}
	public Contents getContents() {
		return contents;
	}
	public void setContents(Contents contents) {
		this.contents = contents;
	}
	public List<Contents> getConlist() {
		return conlist;
	}
	public void setConlist(List<Contents> conlist) {
		this.conlist = conlist;
	}
	
	
}
