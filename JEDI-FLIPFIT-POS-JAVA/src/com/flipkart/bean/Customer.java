/**
 *
 */
package com.flipkart.bean;

import com.flipkart.business.CustomerBusiness;

import java.util.ArrayList;

/**
 *
 */
public class Customer extends User {
    private int customerId;
    private String customerName;
    private String customerAddress;
    private String gender;
    private int age;
    private int contactNumber;
    private String cardDetails;
    private ArrayList<Integer> bookingIdList;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
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

    public int getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(int contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getCardDetails() {
        return cardDetails;
    }

    public void setCardDetails(String cardDetails) {
        this.cardDetails = cardDetails;
    }

    public ArrayList<Integer> getBookingIdList() {
        return bookingIdList;
    }

    public void setBookingIdList(ArrayList<Integer> bookingIdList) {
        this.bookingIdList = bookingIdList;
    }
}