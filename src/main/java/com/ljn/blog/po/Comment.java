package com.ljn.blog.po;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name="t_comment")
public class Comment {
	private Integer id;
	private String userName;
	private String author;
	private Integer contentsid;
	private String content;
	private Date time;
	@Id
	@GeneratedValue(generator="comment_cid" ,strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="comment_id",sequenceName="seq_comment_id",allocationSize=1)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false,updatable=false)
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public Integer getContentsid() {
		return contentsid;
	}
	public void setContentsid(Integer contentsid) {
		this.contentsid = contentsid;
	}
    
}
