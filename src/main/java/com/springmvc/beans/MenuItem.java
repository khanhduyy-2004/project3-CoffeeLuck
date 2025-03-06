package com.springmvc.beans;

public class MenuItem {
	private String name;
	private String url;
	
	public MenuItem(String name,String url)
	{
		this.name=name;
		this.url=url;
	}
	
	/**
	 * 
	 */
	public MenuItem() {
		super();
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

}
