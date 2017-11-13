package com.vehicle.service;

import java.util.List;
import java.util.Set;

import com.vehicle.dto.Login;
import com.vehicle.dto.LoginDTO;
import com.vehicle.dto.SearchDTO;
import com.vehicle.dto.Vehicle;
import com.vehicle.dto.VehicleDTO;

public interface VehicleService {

	Login authenticate(LoginDTO login);

	String addVehicle(VehicleDTO vehicle, String string);

	List<Vehicle> listVehicles();

	String delete(int id);

	Vehicle findById(int id);

	List<Vehicle> findbyUser(String name);

	Set<Vehicle> search(SearchDTO vehicle);

	Set<Vehicle> searchByType(SearchDTO vehicle);
	
	
	

}
