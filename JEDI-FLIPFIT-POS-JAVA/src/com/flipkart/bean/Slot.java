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

    private int slotId;
    private String startTime;
    private String endTime;
}