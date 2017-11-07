package com.vehicle.dao;

import com.vehicle.dto.Login;
import com.vehicle.dto.LoginDTO;

public interface VehicleRepository {

	Login authenticateUser(LoginDTO login);
	

}
