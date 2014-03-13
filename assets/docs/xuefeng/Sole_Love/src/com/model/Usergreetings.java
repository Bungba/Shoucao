package com.model;

import java.sql.Timestamp;

/**
 * Usergreetings entity. @author MyEclipse Persistence Tools
 */

public class Usergreetings implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer uid;
	private Integer gid;
	private Integer usecount;
	private Timestamp updatetime;
	private Timestamp creationtime;

	// Constructors

	/** default constructor */
	public Usergreetings() {
	}

	/** full constructor */
	public Usergreetings(Integer uid, Integer gid, Integer usecount,
			Timestamp updatetime, Timestamp creationtime) {
		this.uid = uid;
		this.gid = gid;
		this.usecount = usecount;
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

	public Integer getGid() {
		return this.gid;
	}

	public void setGid(Integer gid) {
		this.gid = gid;
	}

	public Integer getUsecount() {
		return this.usecount;
	}

	public void setUsecount(Integer usecount) {
		this.usecount = usecount;
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