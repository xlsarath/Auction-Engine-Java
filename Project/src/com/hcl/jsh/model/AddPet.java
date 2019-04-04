package com.hcl.jsh.model;

public class AddPet 
{
	String pname,place,sex,size,type;
    int age,qty,petId;
	public int getPetId() {
		//System.out.println("addpet get method"+petId);
		return petId;
	}

	public void setPetId(int petId) {
		//System.out.println("addpet set method  "+petId);
		this.petId = petId;
	}

	public String getPname() {
		
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	

}
