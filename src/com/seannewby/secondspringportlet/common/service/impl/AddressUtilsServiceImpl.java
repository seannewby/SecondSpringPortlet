package com.seannewby.secondspringportlet.common.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seannewby.secondspringportlet.common.dao.StateDao;
import com.seannewby.secondspringportlet.common.service.AddressUtilsService;

@Service
public class AddressUtilsServiceImpl implements AddressUtilsService {
	
	private StateDao stateDao;

	public List<String> getStates() {
		
		return stateDao.getStateAbbrList();
	}
	
	@Autowired
	public void setStateDao(StateDao stateDao) {
		this.stateDao = stateDao;
	}

}
