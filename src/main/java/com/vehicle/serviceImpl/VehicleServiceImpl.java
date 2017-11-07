package com.vehicle.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehicle.dao.VehicleRepository;
import com.vehicle.dto.Login;
import com.vehicle.dto.LoginDTO;
import com.vehicle.service.VehicleService;

@Service
public class VehicleServiceImpl implements VehicleService {
	
	@Autowired
	VehicleRepository vehicleRepository;

	@Override
	public Login authenticate(LoginDTO login) {
		Login user=vehicleRepository.authenticateUser(login);
		return user;
	}

}
