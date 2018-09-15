package com.ljn.blog.po;


import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name="t_contents")
public class Contents {
	private Integer cid;
	private String title;
	private Date created;
	private String content;
	private String author;
	private String type;
	private Integer views;
	private Integer replies;
	@Id
	@GeneratedValue(generator="content_cid" ,strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="content_cid",sequenceName="seq_content_cid",allocationSize=1)
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	@Column(length=30,nullable=false,updatable=false)
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_time")
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}

	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getViews() {
		return views;
	}
	public void setViews(Integer views) {
		this.views = views;
	}
	public Integer getReplies() {
		return replies;
	}
	public void setReplies(Integer replies) {
		this.replies = replies;
	}
	@Override
	public String toString() {
		return "Contents [cid=" + cid + ", title=" + title + ", created=" + created + ", content=" + content
				+ ", author=" + author + ", type=" + type + ", views=" + views + ", replies=" + replies + "]";
	}
	
}
