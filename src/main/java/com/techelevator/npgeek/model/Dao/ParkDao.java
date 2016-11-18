package com.techelevator.npgeek.model.Dao;

import java.util.List;

import com.techelevator.npgeek.model.Park;

public interface ParkDao {
	
	public List<Park> getAllParks();
	public Park getParkDetailsByParkCode(String parkCode);
	
}
