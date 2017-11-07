package com.vehicle.dao;

import com.vehicle.dto.LoginDTO;

public interface VehicleRepository {

	String authenticateUser(LoginDTO login);
	

}
