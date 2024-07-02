/**
 *
 */
package com.flipkart.bean;

import java.util.ArrayList;

/**
 *
 */
public class GymOwner extends User {

    private int gymOwnerId;
    private String gymOwnerName;
    private String gymOwnerAddress;
    private String gender;
    private int age;
    private String contactNumber;
    private String gstNumber;
    private String adharCardNumber;
    private boolean isVerified;
    private ArrayList<Integer> gymCenterIdList;

    public int getGymOwnerId() {
        return gymOwnerId;
    }

    public void setGymOwnerId(int gymOwnerId) {
        this.gymOwnerId = gymOwnerId;
    }

    public String getGymOwnerName() {
        return gymOwnerName;
    }

    public void setGymOwnerName(String gymOwnerName) {
        this.gymOwnerName = gymOwnerName;
    }

    public String getGymOwnerAddress() {
        return gymOwnerAddress;
    }

    public void setGymOwnerAddress(String gymOwnerAddress) {
        this.gymOwnerAddress = gymOwnerAddress;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getGstNumber() {
        return gstNumber;
    }

    public void setGstNumber(String gstNumber) {
        this.gstNumber = gstNumber;
    }

    public String getAdharCardNumber() {
        return adharCardNumber;
    }

    public void setAdharCardNumber(String adharCardNumber) {
        this.adharCardNumber = adharCardNumber;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public void setVerified(boolean verified) {
        isVerified = verified;
    }

    public ArrayList<Integer> getGymCenterIds() {
        return gymCenterIdList;
    }

    public void setGymCenterIds(ArrayList<Integer> gymCenterIds) {
        this.gymCenterIdList = gymCenterIds;
    }
}