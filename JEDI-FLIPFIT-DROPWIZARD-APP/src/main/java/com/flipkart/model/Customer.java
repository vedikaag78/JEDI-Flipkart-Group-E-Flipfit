/**
 *
 */
package com.flipkart.model;

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
    private String contactNumber;
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

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
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

    public void printProfile(){
        System.out.println("----- YOUR PROFILE -----");
        System.out.println("Customer Name: " + this.customerName);
        System.out.println("Customer Address: " + this.customerAddress);
        System.out.println("Gender: " + this.gender);
        System.out.println("Age: " + this.age);
        System.out.println("Contact Number: " + this.contactNumber);
        System.out.println("Card Details: " + this.cardDetails);
        System.out.println("------------------------");
    }
}