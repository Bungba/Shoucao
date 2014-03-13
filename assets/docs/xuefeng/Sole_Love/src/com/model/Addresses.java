package com.model;

import java.sql.Timestamp;

/**
 * Addresses entity. @author MyEclipse Persistence Tools
 */

public class Addresses implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer uid;
	private String city;
	private String zip;
	private String address;
	private String name;
	private String tel;
	private Integer usecount;
	private Boolean delFlag;
	private Timestamp updatetime;
	private Timestamp creationtime;

	// Constructors

	/** default constructor */
	public Addresses() {
	}

	/** full constructor */
	public Addresses(Integer uid, String city, String zip, String address,
			String name, String tel, Integer usecount, Boolean delFlag,
			Timestamp updatetime, Timestamp creationtime) {
		this.uid = uid;
		this.city = city;
		this.zip = zip;
		this.address = address;
		this.name = name;
		this.tel = tel;
		this.usecount = usecount;
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

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZip() {
		return this.zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Integer getUsecount() {
		return this.usecount;
	}

	public void setUsecount(Integer usecount) {
		this.usecount = usecount;
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