package com.example.ibex.ibexmockdata.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "widgets")
public class Widgets {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private Long id;

	@Column(name = "name", nullable = false)
	@NotNull(message = "Add name Attribute to Data")
	private String name;

	@Column(name = "basicsettings")
	private String basicsettings;
	
	
	public Widgets() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBasicsettings() {
		return basicsettings;
	}

	public void setBasicsettings(String basicsettings) {
		this.basicsettings = basicsettings;
	}

	@Override
	public String toString() {
		return "Widgets [id=" + id + ", name=" + name + ", basicsettings=" + basicsettings + "]";
	}	
}
