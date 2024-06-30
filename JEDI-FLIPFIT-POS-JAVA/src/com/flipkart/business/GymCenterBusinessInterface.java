package com.flipkart.business;

import com.flipkart.bean.GymCenter;

public interface GymCenterBusinessInterface {

    void createGymCenter(GymCenter gymCenter, int gymOwnerId) ;

    boolean updateGymCenter(int gymCenterId);

    boolean deleteGymCenter(int gymCenterId);

    void listGymCenter();

}