package com.example.ibex.ibexmockdata.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="dashboardwidgets")
public class DashboardWidgets {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private Long id;
	
	@Column(name="dashboardid",nullable = false)
	private int dashboardid;
	
	@Column(name="widgetid",nullable = false)
	private int widgetid;
	
	@Column(name="configurationsetting")
	private String configurationsetting;
	

	public DashboardWidgets() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getDashboardid() {
		return dashboardid;
	}

	public void setDashboardid(int dashboardid) {
		this.dashboardid = dashboardid;
	}

	public int getWidgetid() {
		return widgetid;
	}

	public void setWidgetid(int widgetid) {
		this.widgetid = widgetid;
	}

	public String getConfigurationsetting() {
		return configurationsetting;
	}

	public void setConfigurationsetting(String configurationsetting) {
		this.configurationsetting = configurationsetting;
	}

	@Override
	public String toString() {
		return "DashboardWidgets [id=" + id + ", dashboardid=" + dashboardid + ", widgetid=" + widgetid
				+ ", configurationsetting=" + configurationsetting + "]";
	}	

}
