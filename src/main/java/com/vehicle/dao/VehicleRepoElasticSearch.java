package com.vehicle.dao;

import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.vehicle.dto.Vehicle;

@Repository
public interface VehicleRepoElasticSearch extends ElasticsearchCrudRepository<Vehicle, Integer>  {
	

}
