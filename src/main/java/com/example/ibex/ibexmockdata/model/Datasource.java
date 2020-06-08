package com.example.ibex.ibexmockdata.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "datasource")
public class Datasource {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private int id;

	@Column(name="name",nullable = false)
	private String name;
	
	@Column(name="url",nullable = false)
	private String url;
	
	@Column(name = "properties")
	private String properties;

	
	@Column(name="metadata",nullable = false)
	@JsonIgnore
	private String metadata;

	public Datasource() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getProperties() {
		return properties;
	}

	public void setProperties(String properties) {
		this.properties = properties;
	}
	
	public String getMetadata() {
		return metadata;
	}

	public void setMetadata(String metadata) {
		this.metadata = metadata;
	}

	@Override
	public String toString() {
		return "Datasource [id=" + id + ", name=" + name + ", url=" + url + ", properties=" + properties + ", metadata="
				+ metadata + "]";
	}
}
