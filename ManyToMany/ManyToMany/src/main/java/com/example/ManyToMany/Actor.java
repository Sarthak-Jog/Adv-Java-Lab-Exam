package com.example.ManyToMany;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Actor {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String phone;
	@ManyToMany(mappedBy="actor")
	private List<Role> role=new ArrayList<>();
	
	
//	public Actor() {
//		// TODO Auto-generated constructor stub
//	}
	public List<Role> getRole() {
		return role;
	}
	public void setRole(List<Role> role) {
		this.role = role;
	}
//	public Actor(int id, String name, String phone) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.phone = phone;
//	}
	
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Override
	public String toString() {
		return "Actor [id=" + id + ", name=" + name + ", phone=" + phone + "]";
	}
	
	
}
