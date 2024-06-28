package com.flipkart.dao;

import java.time.LocalTime;
import java.util.List;

import com.flipkart.bean.Slot;

public interface FlipfitSlotDAOInterface {
	public List<Slot> getSlotList();
	public List<Slot> getAvailableSlotList (LocalTime startTime, LocalTime endTime) ;
}
