package com.model;

import java.sql.Timestamp;

/**
 * Infos entity. @author MyEclipse Persistence Tools
 */

public class Infos implements java.io.Serializable {

	// Fields

	private Integer id;
	private String key;
	private Float value;
	private Timestamp updatetime;
	private Timestamp creationtime;

	// Constructors

	/** default constructor */
	public Infos() {
	}

	/** full constructor */
	public Infos(String key, Float value, Timestamp updatetime,
			Timestamp creationtime) {
		this.key = key;
		this.value = value;
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

	public String getKey() {
		return this.key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Float getValue() {
		return this.value;
	}

	public void setValue(Float value) {
		this.value = value;
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