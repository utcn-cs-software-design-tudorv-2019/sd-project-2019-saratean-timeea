package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "uni.room")
public class Room {
	@Id
	@Column(name="number")
	private int number;
	@Column(name="price")
	private int price;
	@Column(name="capacity")
	private int capacity;
	public Room() {}
	public Room(int number, int price, int capacity) {
		this.number=number;
		this.price=price;
		this.capacity=capacity;
	}
	@Override
	public String toString() {
		return "Room [number=" + number + ", price=" + price + ", capacity=" + capacity + "]";
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
}
