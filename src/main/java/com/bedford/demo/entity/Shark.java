package com.bedford.demo.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;



@Entity
public class Shark {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	@Min(1)
	@Max(300)
	private int age;
	
	@Column(unique=true, nullable = false)
	private String name;
	
	@Column
	private String type;
	
	@Column
	private String location;
	
	public Shark() {}
	
	public Shark(@Min(1)@Max(300) int age, String name, String type, String location) {
		super();
		this.age = age;
		this.name = name;
		this.type = type;
		this.location = location;
	}
	
	public Shark(long id, @Min(1) @Max(300) int age, String name, String type, String location) {
		super();
		this.id = id;
		this.age = age;
		this.name = name;
		this.type = type;
		this.location = location;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Shark [id=" + id + ", age=" + age + ", name=" + name + ", type=" + type + ", location=" + location
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, id, location, name, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Shark other = (Shark) obj;
		return age == other.age && id == other.id && Objects.equals(location, other.location)
				&& Objects.equals(name, other.name) && Objects.equals(type, other.type);
	}
	
	
	
	
}
