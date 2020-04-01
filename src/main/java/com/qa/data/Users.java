package com.qa.data;

import java.util.ArrayList;
import java.util.List;

//import org.json.JSONArray;

//pojo-plain old java object

public class Users {

	String industry;
	String name;
	String desc;
	int duration;
	List<Object> cost;
	
	// String cost[];
	@SuppressWarnings({ "rawtypes", "unchecked" })
	//List<Cost> cost = new ArrayList();
	//Cost cost;
	 
	public Users(String industry, String name, String desc, int duration,List<Object> cost) {
		this.industry = industry;
		this.name = name;
		this.desc = desc;
		this.duration = duration;
		this.cost = cost;

	}

	

	public List<Object> getCost() {
		return cost;
	}



	public void setCost(List<Object> cost) {
		this.cost = cost;
	}



	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	
}
