package com.model;

import java.sql.Timestamp;

/**
 * Invcodes entity. @author MyEclipse Persistence Tools
 */

public class Invcodes implements java.io.Serializable {

	// Fields

	private Integer id;
	private String code;
	private Integer sid;
	private Timestamp updatetime;
	private Timestamp creationtime;

	// Constructors

	/** default constructor */
	public Invcodes() {
	}

	/** full constructor */
	public Invcodes(String code, Integer sid, Timestamp updatetime,
			Timestamp creationtime) {
		this.code = code;
		this.sid = sid;
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

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getSid() {
		return this.sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
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