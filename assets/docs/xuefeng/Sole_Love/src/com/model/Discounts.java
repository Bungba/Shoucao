package com.model;

import java.sql.Timestamp;

/**
 * Discounts entity. @author MyEclipse Persistence Tools
 */

public class Discounts implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer sid;
	private Float amount;
	private Timestamp updatetime;
	private Timestamp creationtime;

	// Constructors

	/** default constructor */
	public Discounts() {
	}

	/** full constructor */
	public Discounts(Integer sid, Float amount, Timestamp updatetime,
			Timestamp creationtime) {
		this.sid = sid;
		this.amount = amount;
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

	public Integer getSid() {
		return this.sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public Float getAmount() {
		return this.amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
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