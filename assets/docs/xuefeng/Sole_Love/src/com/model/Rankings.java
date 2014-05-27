package com.model;

import java.sql.Timestamp;

/**
 * Rankings entity. @author MyEclipse Persistence Tools
 */

public class Rankings implements java.io.Serializable {

	// Fields

	private Integer id;
	private Double saleroom;
	private String name;
	private String city;
	private Timestamp updatetime;
	private Timestamp creationtime;

	// Constructors

	/** default constructor */
	public Rankings() {
	}

	/** full constructor */
	public Rankings(Double saleroom, String name, String city,
			Timestamp updatetime, Timestamp creationtime) {
		this.saleroom = saleroom;
		this.name = name;
		this.city = city;
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

	public Double getSaleroom() {
		return this.saleroom;
	}

	public void setSaleroom(Double saleroom) {
		this.saleroom = saleroom;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
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