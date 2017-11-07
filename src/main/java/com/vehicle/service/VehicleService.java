package com.vehicle.service;

import com.vehicle.dto.Login;
import com.vehicle.dto.LoginDTO;

public interface VehicleService {

	Login authenticate(LoginDTO login);

}
