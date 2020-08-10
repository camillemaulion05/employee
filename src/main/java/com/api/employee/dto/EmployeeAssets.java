package com.api.employee.dto;

import java.util.ArrayList;

public class EmployeeAssets {

	private String id;
	private String name;
	private String role;
	private ArrayList<String> assets;
	
	public EmployeeAssets() {}

	public EmployeeAssets(String id, String name, String role, ArrayList<String> assets) {
		this.id = id;
		this.name = name;
		this.role = role;
		this.assets = assets;
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public ArrayList<String> getAssets() {
		return assets;
	}

	public void setAssets(ArrayList<String> assets) {
		this.assets = assets;
	}

	@Override
	public String toString() {
		return "EmployeeWithAssets [id=" + id + ", name=" + name + ", role=" + role + ", assets=" + assets + "]";
	}
}
