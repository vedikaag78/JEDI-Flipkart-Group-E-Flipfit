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

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    private int slotId;
    private LocalTime startTime;
    private LocalTime endTime;
}