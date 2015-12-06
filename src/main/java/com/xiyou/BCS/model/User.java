package com.xiyou.BCS.model;
//com.xiyou.BCS.model.User
/**
 * 用户表
 */
public class User {
	
    private int id;
    
    private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String string) {
		this.name = string;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}
    
	
	
}