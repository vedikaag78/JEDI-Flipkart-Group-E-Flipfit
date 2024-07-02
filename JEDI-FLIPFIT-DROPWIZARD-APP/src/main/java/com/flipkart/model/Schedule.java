package com.flipkart.model;

import java.time.LocalDate;

public class Schedule {
    private int scheduleId;
    private int gymCenterId;
    private int slotId;
    private LocalDate scheduleDate;
    private int availablity;

    public int getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    public int getGymCenterId() {
        return gymCenterId;
    }

    public void setGymCenterId(int gymCenterId) {
        this.gymCenterId = gymCenterId;
    }

    public int getSlotId() {
        return slotId;
    }

    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }

    public LocalDate getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(LocalDate scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public int getAvailablity() {
        return availablity;
    }

    public void setAvailablity(int availablity) {
        this.availablity = availablity;
    }
}
