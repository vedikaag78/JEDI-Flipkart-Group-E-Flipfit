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

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getGymCenterId() { return gymCenterId; }

    public void setGymCenterId(int gymCenterId) { this.gymCenterId = gymCenterId; }

    private int slotId;
    private int gymCenterId;
    private String startTime;
    private String endTime;
}