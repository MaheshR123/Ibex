package com.example.ibex.ibexmockdata.model;

public class DashboardWidgetsCustom {
	
	private Integer id;

	private int dashboardid;

	private int widgetid;

	private String configurationsetting;
	
	private String basicsettings;

	private String widgetname;

	public DashboardWidgetsCustom() {
	
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

	public String getBasicsettings() {
		return basicsettings;
	}

	public void setBasicsettings(String basicsettings) {
		this.basicsettings = basicsettings;
	}

	public String getWidgetname() {
		return widgetname;
	}

	public void setWidgetname(String widgetname) {
		this.widgetname = widgetname;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "DashboardWidgetsCustom [id=" + id + ", dashboardid=" + dashboardid + ", widgetid=" + widgetid
				+ ", configurationsetting=" + configurationsetting + ", basicsettings=" + basicsettings
				+ ", widgetname=" + widgetname + "]";
	}
}
