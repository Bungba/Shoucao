package com.model;

import java.sql.Timestamp;

/**
 * Salerlevels entity. @author MyEclipse Persistence Tools
 */

public class Salerlevels implements java.io.Serializable {

	// Fields

	private Integer id;
	private String title;
	private String icon;
	private Float saleroom;
	private Float ratio;
	private Timestamp updatetime;
	private Timestamp creationtime;

	// Constructors

	/** default constructor */
	public Salerlevels() {
	}

	/** full constructor */
	public Salerlevels(String title, String icon, Float saleroom, Float ratio,
			Timestamp updatetime, Timestamp creationtime) {
		this.title = title;
		this.icon = icon;
		this.saleroom = saleroom;
		this.ratio = ratio;
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

	public String getIcon() {
		return this.icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Float getSaleroom() {
		return this.saleroom;
	}

	public void setSaleroom(Float saleroom) {
		this.saleroom = saleroom;
	}

	public Float getRatio() {
		return this.ratio;
	}

	public void setRatio(Float ratio) {
		this.ratio = ratio;
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