/**
 * 
 */
package com.flipkart.bean;

import java.util.List;

/**
 * 
 */
public class GymCenter {
	public int getGymId() {
		return gymId;
	}

	public void setGymId(int gymId) {
		this.gymId = gymId;
	}

	public int getGymOwnerId() {
		return gymOwnerId;
	}

	public void setGymOwnerId(int gymOwnerId) {
		this.gymOwnerId = gymOwnerId;
	}

	public String getGymCenterName() {
		return gymCenterName;
	}

	public void setGymCenterName(String gymCenterName) {
		this.gymCenterName = gymCenterName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
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

	public List<String> getSlotListIds() {
		return slotListIds;
	}

	public void setSlotListIds(List<String> slotListIds) {
		this.slotListIds = slotListIds;
	}

	private int gymId;
	private int gymOwnerId;
	private String gymCenterName;
	private String address;
	private String city;
	private int price;
	private int capacity;
	private List<String> slotListIds;
}
