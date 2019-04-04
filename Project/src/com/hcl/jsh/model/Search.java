package com.hcl.jsh.model;

public class Search {

	String type;
	String name;
	int age;
	String size;
	String place;
	int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAvmQty() {
		return avmQty;
	}
	public void setAvmQty(int avmQty) {
		this.avmQty = avmQty;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	int avmQty;
	String sex;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		System.out.println(type);
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		System.out.println(name);
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		System.out.println(" pojo age"+age);
		this.age = age;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		System.out.println(size);
		this.size = size;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	
	
	
	
}
