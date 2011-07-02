package com.seannewby.secondspringportlet.common.dao;

import java.util.List;

import com.seannewby.secondspringportlet.common.beans.Location;



public interface LocationDao {

	public List<Location> getLocations();
	
	public Location getLocation(int locationId);
	
	public Location addLocation(Location location);
	
	public Location updateLocation(Location location);
	
}
