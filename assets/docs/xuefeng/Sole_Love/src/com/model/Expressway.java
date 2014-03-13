package com.model;

import java.sql.Timestamp;

/**
 * Expressway entity. @author MyEclipse Persistence Tools
 */

public class Expressway implements java.io.Serializable {

	// Fields

	private Integer id;
	private String title;
	private Float fee;
	private Timestamp updatetime;
	private Timestamp creationtime;

	// Constructors

	/** default constructor */
	public Expressway() {
	}

	/** full constructor */
	public Expressway(String title, Float fee, Timestamp updatetime,
			Timestamp creationtime) {
		this.title = title;
		this.fee = fee;
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

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Float getFee() {
		return this.fee;
	}

	public void setFee(Float fee) {
		this.fee = fee;
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