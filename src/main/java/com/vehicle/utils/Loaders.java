package com.vehicle.utils;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.vehicle.dao.VehicleRepoElasticSearch;
import com.vehicle.dto.Vehicle;

@Component
public class Loaders {
	
	@Autowired
	ElasticsearchOperations elasticsearchOperations;
	
	@Autowired
	VehicleRepoElasticSearch vehicleRepoElasticSearch;
	
	 @PostConstruct
	 @Transactional
	    public void loadAll(){

		 	elasticsearchOperations.putMapping(Vehicle.class);
	        System.out.println("Loading Data");
	        //vehicleRepoElasticSearch.save(getData());
	        //System.out.printf("Loading Completed");
	 }
	 
	 private List<Vehicle> getData() {
	        List<Vehicle> vehicles = new ArrayList<>();
	        vehicles.add(new Vehicle("fz","yamaha", "2009", "bike",25.2048,55.2708,"admin"));
	        vehicles.add(new Vehicle("jag","jaguar", "2009", "car",25.2048,55.2708,"admin"));
	        vehicles.add(new Vehicle("fortuner","toyota", "2009", "car",25.2048,55.2708,"admin"));
	        return vehicles;
	    }


}
