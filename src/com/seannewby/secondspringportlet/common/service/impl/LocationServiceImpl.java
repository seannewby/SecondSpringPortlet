package com.seannewby.secondspringportlet.common.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.seannewby.secondspringportlet.common.beans.Location;
import com.seannewby.secondspringportlet.common.dao.LocationDao;
import com.seannewby.secondspringportlet.common.service.LocationService;

@Service(value="locationService")
public class LocationServiceImpl implements LocationService {
	
	private LocationDao locationDao;

	public Location getLocation(int locationId) {
		
		return locationDao.getLocation(locationId);
	}

	public List<Location> getLocations() {
		
		return locationDao.getLocations();
	}
	
	public Location addLocation(Location location) { 
		return locationDao.addLocation(location); 
	}
	
	public Location updateLocation(Location location){
		return locationDao.updateLocation(location);
	}

	@Autowired
	public void setLocationDao(@Qualifier("locationDaoHardCoded")LocationDao locationDao) {
		this.locationDao = locationDao; 
	}
	
	

}
