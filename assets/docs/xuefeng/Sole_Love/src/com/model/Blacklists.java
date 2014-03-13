package com.model;

import java.sql.Timestamp;

/**
 * Blacklists entity. @author MyEclipse Persistence Tools
 */

public class Blacklists implements java.io.Serializable {

	// Fields

	private Integer id;
	private String ip;
	private Integer count;
	private Timestamp updatetime;
	private Timestamp creationtime;

	// Constructors

	/** default constructor */
	public Blacklists() {
	}

	/** full constructor */
	public Blacklists(String ip, Integer count, Timestamp updatetime,
			Timestamp creationtime) {
		this.ip = ip;
		this.count = count;
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

	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Integer getCount() {
		return this.count;
	}

	public void setCount(Integer count) {
		this.count = count;
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