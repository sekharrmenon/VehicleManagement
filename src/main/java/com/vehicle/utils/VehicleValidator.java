package com.vehicle.utils;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.vehicle.dto.Vehicle;
import com.vehicle.dto.VehicleDTO;

@Component
public class VehicleValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return VehicleDTO.class.equals(arg0) || Vehicle.class.equals(arg0) ;
	}	

	@Override
	public void validate(Object arg0, Errors err) {
	      ValidationUtils.rejectIfEmptyOrWhitespace(err, "vehiclename", "Empty.vehicleForm.vehiclename");
	      ValidationUtils.rejectIfEmptyOrWhitespace(err, "brand", "Empty.vehicleForm.brand");
	      ValidationUtils.rejectIfEmptyOrWhitespace(err, "model", "Empty.vehicleForm.model");
	      ValidationUtils.rejectIfEmptyOrWhitespace(err, "type", "Empty.vehicleForm.type");
	      //ValidationUtils.rejectIfEmptyOrWhitespace(err, "lattitude", "Empty.vehicleForm.lattitude");
	      //ValidationUtils.rejectIfEmptyOrWhitespace(err, "longitude", "Empty.vehicleForm.longitude");
	}

}
