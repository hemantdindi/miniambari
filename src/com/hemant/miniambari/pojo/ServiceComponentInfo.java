package com.hemant.miniambari.pojo;

public class ServiceComponentInfo {
	public String componentName;
	public int started_count;
	public int unknown_count;
	public int total_count;
    
	public String getComponentName() {
		return componentName;
	}
	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}
	public int getStarted_count() {
		return started_count;
	}
	public void setStarted_count(int started_count) {
		this.started_count = started_count;
	}
	public int getUnknown_count() {
		return unknown_count;
	}
	public void setUnknown_count(int unknown_count) {
		this.unknown_count = unknown_count;
	}
	public int getTotal_count() {
		return total_count;
	}
	public void setTotal_count(int total_count) {
		this.total_count = total_count;
	}
	@Override
	public String toString() {
		return " [\ncomponentName=" + componentName + ", \nstarted_count=" + started_count
				+ ", \nunknown_count=" + unknown_count + ", \ntotal_count=" + total_count + "\n]";
	}
	
}
