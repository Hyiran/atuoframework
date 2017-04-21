package com.yhq.fastjson;

import java.util.List;

public class Teacher {
	private int id;
	private String name;
	
	List <Student> myStudent;

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

	public List<Student> getMyStudent() {
		return myStudent;
	}

	public void setMyStudent(List<Student> myStudent) {
		this.myStudent = myStudent;
	}
	
	public Teacher(){
		
	}
	public Teacher(int id,String name){
		this.id = id;
		this.name = name;
	}
}
