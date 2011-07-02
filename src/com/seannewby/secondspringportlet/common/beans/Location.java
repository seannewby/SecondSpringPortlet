package com.seannewby.secondspringportlet.common.beans;

import org.apache.commons.lang.builder.ToStringBuilder;

public class Location {
	private int id;
	private String name;
	private String desc;
	private Address address = new Address();
	private String region;
	private String manager;
	
	public Address getAddress() {	
		return address;		
	}
	public void setAddress(Address address) {
		System.out.println("Setting address");
		this.address = address;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
	
}
