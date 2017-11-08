package com.vehicle.serviceImpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehicle.controller.VehicleController;
import com.vehicle.dao.VehicleRepository;
import com.vehicle.dto.Login;
import com.vehicle.dto.LoginDTO;
import com.vehicle.dto.Vehicle;
import com.vehicle.dto.VehicleDTO;
import com.vehicle.service.VehicleService;

@Service
public class VehicleServiceImpl implements VehicleService {
	
	@Autowired
	VehicleRepository vehicleRepository;
	
	
	
	private static final Logger logger = LoggerFactory
	        .getLogger(VehicleServiceImpl.class);

	@Override
	public Login authenticate(LoginDTO login) {
		Login user=vehicleRepository.authenticateUser(login);
		return user;
	}

	@Override
	public String addVehicle(VehicleDTO vehicle) {
		String status="";
		if (vehicle.isNew()) {
			//BeanUtils.copyProperties(myPojo, result);
			 status= vehicleRepository.save(getVehicleModel(vehicle));
		} else {
			status=vehicleRepository.update(getVehicleModel(vehicle));
		}
		return status;
	}

	private Vehicle getVehicleModel(VehicleDTO vehicle) {
		Vehicle modelVehicle = new Vehicle();
				if(null!=vehicle.getId()){
					modelVehicle.setId(vehicle.getId());	
				}
				modelVehicle.setVehiclename(vehicle.getVehiclename());
				modelVehicle.setBrand(vehicle.getBrand());
				modelVehicle.setModel(vehicle.getModel());
				modelVehicle.setType(vehicle.getType());
				modelVehicle.setLattitude(25.2048);
				modelVehicle.setLongitude(55.2708);
				
				//modelVehicle.setLattitude(vehicle.getLattitude());
				//modelVehicle.setLongitude(vehicle.getLongitude());
		return modelVehicle;
	}

	@Override
	public List<Vehicle> listVehicles() {
		return vehicleRepository.getVehicles();
	}

	@Override
	public String delete(int id) {
		String status=vehicleRepository.delete(id);
		return status;
		
	}

	@Override
	public Vehicle findById(int id) {
		return vehicleRepository.findVehicle(id);
	}

}
