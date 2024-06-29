package com.flipkart.utils;

import com.flipkart.bean.GymCenter;
import com.flipkart.bean.Slot;

import java.util.List;

public class GymCenterUtils {
    public static void printGymCenterList(List<GymCenter> gymCenterList){
        int i = 1;
        System.out.println("--------------------------------------------");
        System.out.println("List of all Gym Centers");
        for (GymCenter gymCenter: gymCenterList) {
            System.out.println(i + ". CenterId-> " + gymCenter.getGymCenterId() + "\t\t" +
                    "Center Name: " + gymCenter.getGymCenterName() + "\t\t" +
                    "Center City: " + gymCenter.getCity());
            i++;
        }
        System.out.println("--------------------------------------------\n");
    }

    public static void printGymCenterSlotList(List<Slot> slotList){
        if(slotList.size() == 0){
            System.out.println("No Slots Available");
            return;
        }

        int i = 1;
        System.out.println("--------------------------------------------");
        System.out.println("List of all Gym Slots");
        for (Slot slot: slotList) {
            System.out.println(i + ". slotId-> " + slot.getSlotId() + "\t\t" +
                    "start time: " + slot.getStartTime() + "\t\t" +
                    "end time: " + slot.getEndTime());
            i++;
        }
        System.out.println("--------------------------------------------");
    }
}
