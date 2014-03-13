package com.model;

import java.sql.Timestamp;

/**
 * Salers entity. @author MyEclipse Persistence Tools
 */

public class Salers implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer uid;
	private String code;
	private String idcode;
	private Timestamp updatetime;
	private Timestamp creationtime;

	// Constructors

	/** default constructor */
	public Salers() {
	}

	/** full constructor */
	public Salers(Integer uid, String code, String idcode,
			Timestamp updatetime, Timestamp creationtime) {
		this.uid = uid;
		this.code = code;
		this.idcode = idcode;
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

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getIdcode() {
		return this.idcode;
	}

	public void setIdcode(String idcode) {
		this.idcode = idcode;
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