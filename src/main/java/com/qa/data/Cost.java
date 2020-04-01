package com.qa.data;

import java.util.ArrayList;
import java.util.List;

public class Cost {
	
	String level;
	
	int value;

	public Cost(String level, int value) {
		super();
		this.level = level;
		this.value = value;
	}
	
	public List<Object> addtoList(String level,int value)
	{
		List<Object> a= new ArrayList<Object>();
		a.add(level);
		a.add(value);
		return a;
		
	}

	public String getLevel() {
		
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	

}
