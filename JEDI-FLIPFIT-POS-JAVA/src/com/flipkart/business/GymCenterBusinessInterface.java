package com.flipkart.business;

public interface GymCenterBusinessInterface {

    void createGymCenter();

    boolean updateGymCenter(int gymCenterId);

    boolean deleteGymCenter(int gymCenterId);

    void listGymCenter();

}