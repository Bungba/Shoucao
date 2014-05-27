package com.model;

import java.sql.Timestamp;

/**
 * Greetings entity. @author MyEclipse Persistence Tools
 */

public class Greetings implements java.io.Serializable {

	// Fields

	private Integer id;
	private String charactor;
	private String background;
	private String sound;
	private String code;
	private Timestamp updatetime;
	private Timestamp creationtime;

	// Constructors

	/** default constructor */
	public Greetings() {
	}

	/** full constructor */
	public Greetings(String charactor, String background, String sound,
			String code, Timestamp updatetime, Timestamp creationtime) {
		this.charactor = charactor;
		this.background = background;
		this.sound = sound;
		this.code = code;
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

	public String getCharactor() {
		return this.charactor;
	}

	public void setCharactor(String charactor) {
		this.charactor = charactor;
	}

	public String getBackground() {
		return this.background;
	}

	public void setBackground(String background) {
		this.background = background;
	}

	public String getSound() {
		return this.sound;
	}

	public void setSound(String sound) {
		this.sound = sound;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
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