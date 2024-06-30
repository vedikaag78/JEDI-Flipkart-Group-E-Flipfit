package com.flipkart.bean;

import java.util.ArrayList;

/**
 *
 */
public class GymCenter {
    private int gymCenterId;
    private int gymOwnerId;
    private String gymCenterName;
    private String address;
    private String city;
    private int price;
    private int capacity;
    private ArrayList<Integer> slotListIds;
    private int slotID;

    public int getGymCenterId() {
        return gymCenterId;
    }

    public void setGymCenterId(int gymCenterId) {
        this.gymCenterId = gymCenterId;
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

    public ArrayList<Integer> getSlotListIds() {
        return slotListIds;
    }

    public void setSlotListIds(ArrayList<Integer> slotListIds) {
        this.slotListIds = slotListIds;
    }

    public int getSlotId() {return slotID;}

    public void setSlotId(int slotID) {
        this.slotID = slotID;
    }
}