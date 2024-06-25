/**
 * 
 */
package com.flipkart.bean;

import java.time.LocalTime;

/**
 * 
 */
public class Slot {
	public int getSlotId() {
		return slotId;
	}

	public void setSlotId(int slotId) {
		this.slotId = slotId;
	}

	public int getGymCenterId() {
		return gymCenterId;
	}

	public void setGymCenterId(int gymCenterId) {
		this.gymCenterId = gymCenterId;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	private int slotId;
	private int gymCenterId;
	private LocalTime time;
}
