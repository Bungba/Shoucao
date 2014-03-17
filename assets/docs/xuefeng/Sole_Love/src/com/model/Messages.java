package com.model;

import java.sql.Timestamp;

/**
 * Messages entity. @author MyEclipse Persistence Tools
 */

public class Messages implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer uid;
	private String title;
	private String content;
	private String sender;
	private int hasread;
	private int delFlag;
	private Timestamp updatetime;
	private Timestamp creationtime;

	// Constructors

	/** default constructor */
	public Messages() {
	}

	/** full constructor */
	public Messages(Integer uid, String title, String content, String sender,
			int hasread, int delFlag, Timestamp updatetime,
			Timestamp creationtime) {
		this.uid = uid;
		this.title = title;
		this.content = content;
		this.sender = sender;
		this.hasread = hasread;
		this.delFlag = delFlag;
		this.updatetime = updatetime;
		this.creationtime = creationtime;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSender() {
		return this.sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public int getHasread() {
		return this.hasread;
	}

	public void setHasread(int hasread) {
		this.hasread = hasread;
	}

	public int getDelFlag() {
		return this.delFlag;
	}

	public void setDelFlag(int delFlag) {
		this.delFlag = delFlag;
	}

	public Timestamp getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}

	public Timestamp getCreationtime() {
		return this.creationtime;
	}

	public void setCreationtime(Timestamp creationtime) {
		this.creationtime = creationtime;
	}

}