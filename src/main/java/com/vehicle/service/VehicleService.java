package com.vehicle.service;

import java.util.List;

import com.vehicle.dto.Login;
import com.vehicle.dto.LoginDTO;
import com.vehicle.dto.Vehicle;
import com.vehicle.dto.VehicleDTO;

public interface VehicleService {

	Login authenticate(LoginDTO login);

	String addVehicle(VehicleDTO vehicle);

	List<Vehicle> listVehicles();

	String delete(int id);

	Vehicle findById(int id);
	
	
	

}
