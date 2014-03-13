package com.model;

import java.sql.Timestamp;

/**
 * Orderdetails entity. @author MyEclipse Persistence Tools
 */

public class Orderdetails implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer oid;
	private Integer pid;
	private Float price;
	private Integer count;
	private Timestamp updatetime;
	private Timestamp creationtime;

	// Constructors

	/** default constructor */
	public Orderdetails() {
	}

	/** full constructor */
	public Orderdetails(Integer oid, Integer pid, Float price, Integer count,
			Timestamp updatetime, Timestamp creationtime) {
		this.oid = oid;
		this.pid = pid;
		this.price = price;
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

	public Integer getOid() {
		return this.oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public Integer getPid() {
		return this.pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public Float getPrice() {
		return this.price;
	}

	public void setPrice(Float price) {
		this.price = price;
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