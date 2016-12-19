package com.nengneng.appstore.model;

public class App {
	private int id;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getZipfile() {
		return zipfile;
	}

	public void setZipfile(String zipfile) {
		this.zipfile = zipfile;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	private String name;
	private String description;
	private String icon;
	private String zipfile;
	private String version;
}
