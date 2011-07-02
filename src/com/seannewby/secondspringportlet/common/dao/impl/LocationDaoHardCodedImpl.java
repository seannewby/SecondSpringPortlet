package com.seannewby.secondspringportlet.common.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.seannewby.secondspringportlet.common.beans.Address;
import com.seannewby.secondspringportlet.common.beans.Location;
import com.seannewby.secondspringportlet.common.dao.LocationDao;
@Repository
public class LocationDaoHardCodedImpl implements LocationDao {
	
	private static ArrayList<Location> list;
	
	static {
		list = new ArrayList<Location>();
		
		Address address1 = new Address();
		address1.setAddress1("555 Mockingbird Lane");
		address1.setCity("Clayton");
		address1.setCountry("US");
		address1.setId(0);
		address1.setName("Main");
		address1.setState("MO");
		address1.setZip("75432");
		
		Address address2 = new Address();
		address2.setAddress1("222 23rd Place");
		address2.setCity("Phoenix");
		address2.setCountry("US");
		address2.setId(1);
		address2.setName("Main");
		address2.setState("AZ");
		address2.setZip("83221");
		
		Address address3 = new Address();
		address3.setAddress1("1264 Mason Rd");
		address3.setCity("Mason");
		address3.setCountry("US");
		address3.setId(2);
		address3.setName("Main");
		address3.setState("OH");
		address3.setZip("34205");
		
		Address address4 = new Address();
		address4.setAddress1("464 Mission Blvd");
		address4.setCity("San Diego");
		address4.setCountry("US");
		address4.setId(3);
		address4.setName("Main");
		address4.setState("CA");
		address4.setZip("91243");
		
		Location location1 = new Location();
		location1.setAddress(address1);
		location1.setDesc("Beautiful suburbs of St. Louis.");
		location1.setId(0);
		location1.setManager("Steve Smith");
		location1.setName("Inn at Galeria Crossing");
		location1.setRegion("Central");
		
		Location location2 = new Location();
		location2.setAddress(address3);
		location2.setDesc("Just outside of Cincinatti.");
		location2.setId(1);
		location2.setManager("Judy Jones");
		location2.setName("Mason Bridge Manor");
		location2.setRegion("North");

		Location location3 = new Location();
		location3.setAddress(address2);
		location3.setDesc("In the desert by the mountians");
		location3.setId(2);
		location3.setManager("Fred McMurray");
		location3.setName("Ocotillo Place");
		location3.setRegion("South West");
		
		Location location4 = new Location();
		location4.setAddress(address4);
		location4.setDesc("2 blocks from the beach.");
		location4.setId(3);
		location4.setManager("Nancy Sinatra");
		location4.setName("Seaside Place");
		location4.setRegion("Pacific");
		
		list.add(location1);
		list.add(location2);
		list.add(location3);
		list.add(location4);
	}

	public Location getLocation(int locationId) {
		
		return (Location)list.get(locationId);
	}

	public List<Location> getLocations() {
		
		return list;
	}
	
	public Location addLocation(Location location){
		
		location.setId(list.size());
		list.add(location);
		
		return location;
		
	}
	
	public Location updateLocation(Location location){
		
		list.set(location.getId(), location);
		
		return location;
	}

}
