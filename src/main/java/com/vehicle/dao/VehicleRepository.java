package com.vehicle.dao;

import java.util.List;

import com.vehicle.dto.Login;
import com.vehicle.dto.LoginDTO;
import com.vehicle.dto.Vehicle;

public interface VehicleRepository   {

	Login authenticateUser(LoginDTO login);

	Integer saveVehicle(Vehicle vehicle);

	String updateVehicle(Vehicle vehicle);

	List<Vehicle> getVehicles();

	String deleteVehicle(int id);

	Vehicle findVehicle(int id);

	List<Vehicle> findVehicle(String name);
	

}
