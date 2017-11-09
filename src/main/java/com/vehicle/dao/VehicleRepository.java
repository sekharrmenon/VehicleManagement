package com.vehicle.dao;

import java.util.List;

import com.vehicle.dto.Login;
import com.vehicle.dto.LoginDTO;
import com.vehicle.dto.Vehicle;
import com.vehicle.dto.VehicleDTO;

public interface VehicleRepository {

	Login authenticateUser(LoginDTO login);

	String save(Vehicle vehicle);

	String update(Vehicle vehicle);

	List<Vehicle> getVehicles();

	String delete(int id);

	Vehicle findVehicle(int id);

	List<Vehicle> findVehicle(String name);
	

}
