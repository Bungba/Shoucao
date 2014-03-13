package com.model;

import java.sql.Timestamp;

/**
 * Expresses entity. @author MyEclipse Persistence Tools
 */

public class Expresses implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private Float fee;
	private Boolean delFlag;
	private Timestamp updatetime;
	private Timestamp creationtime;

	// Constructors

	/** default constructor */
	public Expresses() {
	}

	/** full constructor */
	public Expresses(String name, Float fee, Boolean delFlag,
			Timestamp updatetime, Timestamp creationtime) {
		this.name = name;
		this.fee = fee;
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getFee() {
		return this.fee;
	}

	public void setFee(Float fee) {
		this.fee = fee;
	}

	public Boolean getDelFlag() {
		return this.delFlag;
	}

	public void setDelFlag(Boolean delFlag) {
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