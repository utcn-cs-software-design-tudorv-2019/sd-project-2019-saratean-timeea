package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "uni.profile")
public class Hotel {
	@Id
    @Column(name = "id")
	private int id;
	@Column(name="name")
	private String name;
	@Column(name="location")
	private String location;
	public Hotel(int id, String name, String location) {
		this.id=id;
		this.name=name;
		this.location=location;
	}
	public Hotel() {}
	
	public int getId() {
		return this.id;
	}
	public String getName() {
		return this.name;
	}
	public String getLocation() {
		return this.location;
	}
	public void setId(int id) {
		this.id=id;
	}
	public void setName(String name) {
		this.name=name;
	}
	public void setLocation(String location) {
		this.location=location;
	}
	public String toString() {
		return(id+" "+name+" "+location);
	}
	
}
