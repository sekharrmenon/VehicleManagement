package com.vehicle.serviceImpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.PostConstruct;

import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.MatchQueryBuilder.Operator;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
//import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.vehicle.controller.VehicleController;
import com.vehicle.dao.VehicleRepoElasticSearch;
//import com.vehicle.dao.VehicelRepoElasticSearch;
import com.vehicle.dao.VehicleRepository;
import com.vehicle.dto.Login;
import com.vehicle.dto.LoginDTO;
import com.vehicle.dto.QueryDecider;
import com.vehicle.dto.SearchDTO;
import com.vehicle.dto.Vehicle;
import com.vehicle.dto.VehicleDTO;
import com.vehicle.service.VehicleService;
import com.vehicle.utils.EsConfig;

@Service
public class VehicleServiceImpl implements VehicleService {
	
	@Autowired
	VehicleRepository vehicleRepository;
	@Autowired
	private VehicleRepoElasticSearch vehicelRepoElasticSearch;

	
	
	private static final Logger logger = LoggerFactory
	        .getLogger(VehicleServiceImpl.class);

	@Override
	public Login authenticate(LoginDTO login) {
		Login user=vehicleRepository.authenticateUser(login);
		return user;
	}

	@Override
	public String addVehicle(VehicleDTO vehicle,String name) {
		String status="";
		Vehicle vehicleModel= getVehicleModel(vehicle,name);
		if (vehicle.isNew()) {
			 Integer vehicleId= vehicleRepository.saveVehicle(vehicleModel);
			 vehicleModel.setId(vehicleId);
			if(0!=vehicleId){
				status="Vehicle added successfully";
			}else{
				status="Error creating vehicle";
			}
		} else {
			 status=vehicleRepository.updateVehicle(getVehicleModel(vehicle,name));
		}
		vehicelRepoElasticSearch.save(vehicleModel);
		return status;
	}

	private Vehicle getVehicleModel(VehicleDTO vehicle,String name) {
		Vehicle modelVehicle = new Vehicle();
				if(null!=vehicle.getId()){
					modelVehicle.setId(vehicle.getId());	
				}
				modelVehicle.setUsername(name);
				modelVehicle.setVehiclename(vehicle.getVehiclename());
				modelVehicle.setBrand(vehicle.getBrand());
				modelVehicle.setModel(vehicle.getModel());
				modelVehicle.setType(vehicle.getType());
				modelVehicle.setLattitude(vehicle.getLattitude());
				modelVehicle.setLongitude(vehicle.getLongitude());
				
				//modelVehicle.setLattitude(vehicle.getLattitude());
				//modelVehicle.setLongitude(vehicle.getLongitude());
		return modelVehicle;
	}

	@Override
	public List<Vehicle> listVehicles() {
		Iterable<Vehicle>vehicles=vehicelRepoElasticSearch.findAll();
		List<Vehicle> myList = Lists.newArrayList(vehicles);
		for(Vehicle name : myList){
			logger.info("Vehicle Name :"+name.getVehiclename());
		}
		return vehicleRepository.getVehicles();
	}

	@Override
	public String delete(int id) {
		String status=vehicleRepository.deleteVehicle(id);
		vehicelRepoElasticSearch.delete(id);
		return status;
		
	}

	@Override
	public Vehicle findById(int id) {
		return vehicleRepository.findVehicle(id);
	}

	@Override
	public List<Vehicle> findbyUser(String name) {
		return vehicleRepository.findVehicle(name);
	}

	@Override
	public Set<Vehicle> search(SearchDTO vehicle) {
		EsConfig config = new EsConfig();
		Set<Vehicle> vehicleList = new HashSet<Vehicle>();
		QueryDecider decider =getSearchCriteria(vehicle);
		
		SearchQuery searchQuery = new NativeSearchQueryBuilder()
				  .withQuery(new MultiMatchQueryBuilder(decider.getSearchParam())
				    .field("vehiclename")
				    .field("brand")
				    .field("model")
				    .field("type")
				    .operator(Operator.AND)
				    .type(MultiMatchQueryBuilder.Type.BEST_FIELDS))
				  .build();
		try {
			Iterable<Vehicle> articles =  config.elasticsearchTemplate().queryForList(searchQuery, Vehicle.class);
			Set<Vehicle> myLists = Sets.newHashSet(articles);
			vehicleList.addAll(myLists);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			SearchQuery searchQuery1 = new NativeSearchQueryBuilder()
					  .withQuery(new MultiMatchQueryBuilder(decider.getSearchParam())
					    .field("vehiclename")
					    .field("brand")
					    .field("model")
					    .field("type")
					    .operator(Operator.OR)
					    .type(MultiMatchQueryBuilder.Type.BEST_FIELDS))
					  .build(); 
			
			try {
				Iterable<Vehicle> articles =  config.elasticsearchTemplate().queryForList(searchQuery1, Vehicle.class);
				Set<Vehicle> myLists = Sets.newHashSet(articles);
				vehicleList.addAll(myLists);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 
				SearchQuery searchQuery3 = new NativeSearchQueryBuilder()
						  .withQuery(new MultiMatchQueryBuilder(decider.getSearchParam())
						    .field("vehiclename")
						    .field("brand")
						    .field("model")
						    .field("type")
						    .operator(Operator.AND)
						    .type(MultiMatchQueryBuilder.Type.MOST_FIELDS))
						  .build(); 
				
				try {
					Iterable<Vehicle> articles =  config.elasticsearchTemplate().queryForList(searchQuery3, Vehicle.class);
					Set<Vehicle> myLists = Sets.newHashSet(articles);
					vehicleList.addAll(myLists);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				SearchQuery searchQuery2 = new NativeSearchQueryBuilder()
						  .withQuery(new MultiMatchQueryBuilder(decider.getSearchParam())
						    .field("vehiclename")
						    .field("brand")
						    .field("model")
						    .field("type")
						    .operator(Operator.OR)
						    .type(MultiMatchQueryBuilder.Type.MOST_FIELDS))
						  .build(); 
				
				try {
					Iterable<Vehicle> articles =  config.elasticsearchTemplate().queryForList(searchQuery2, Vehicle.class);
					Set<Vehicle> myLists = Sets.newHashSet(articles);
					vehicleList.addAll(myLists);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				SearchQuery searchQuery4 = new NativeSearchQueryBuilder()
						  .withQuery(new MultiMatchQueryBuilder(decider.getSearchParam())
						    .field("vehiclename")
						    .field("brand")
						    .field("model")
						    .field("type")
						    .operator(Operator.OR)
						    .type(MultiMatchQueryBuilder.Type.PHRASE))
						  .build(); 
				
				try {
					Iterable<Vehicle> articles =  config.elasticsearchTemplate().queryForList(searchQuery4, Vehicle.class);
					Set<Vehicle> myLists = Sets.newHashSet(articles);
					vehicleList.addAll(myLists);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		 
				String[] arr=decider.getSearchParam().split("\\s+");
		    	for(String s: arr){
		    		SearchQuery searchQuery5 = new NativeSearchQueryBuilder()
							  .withQuery(new MultiMatchQueryBuilder(s)
							    .field("vehiclename")
							    .field("brand")
							    .field("model")
							    .field("type")
							    .operator(Operator.OR)
								.fuzziness(Fuzziness.ONE)
								.prefixLength(3))
							  .build(); 
					
					try {
						Iterable<Vehicle> articles =  config.elasticsearchTemplate().queryForList(searchQuery5, Vehicle.class);
						Set<Vehicle> myLists = Sets.newHashSet(articles);
						vehicleList.addAll(myLists);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		    	}
				
	return vehicleList;
	}

	private QueryDecider getSearchCriteria(SearchDTO vehicle) {
		QueryDecider decider = new QueryDecider();
		String inputSearchParam=vehicle.getSearch();
		String searchParam=null;
		String[] terms;
		boolean whiteSpace=whitespaceCheck(inputSearchParam);
		boolean specialCharSeparated=specialCharCheck(inputSearchParam);
		if(specialCharSeparated && whiteSpace){
			 terms =inputSearchParam.split("[\\s@&.?$+-,]");
			 for(String arrString :terms){
				 if(null==searchParam){
					 searchParam=arrString;
				 }else{
					 searchParam=searchParam+" "+ arrString;
				 }
			 }
		}
		else if(specialCharSeparated){
			 terms =inputSearchParam.split("[@&.?$+-,]");
			 for(String arrString :terms){
				 if(null==searchParam){
					 searchParam=arrString;
				 }else{
					 searchParam=searchParam+" "+ arrString;
				 }
				 
			 }
		}
		else{
			searchParam=vehicle.getSearch();
		}
		decider.setSearchParam(searchParam);
		decider.setSpecialChar(specialCharSeparated);
		decider.setWhitespace(whiteSpace);
		
		return decider;
		
	}

	private boolean specialCharCheck(String s) {
		Pattern pattern = Pattern.compile("[$&+,:;=?@#|]");
		Matcher matcher = pattern.matcher(s);
		boolean found = matcher.find();
		return found;
	}

	private boolean whitespaceCheck(String s) {
		Pattern pattern = Pattern.compile("\\s");
		Matcher matcher = pattern.matcher(s);
		boolean found = matcher.find();
		return found;
	}

	@Override
	public Set<Vehicle> searchByType(SearchDTO vehicle) {
		EsConfig config = new EsConfig();
		Set<Vehicle> tempLists = new HashSet<Vehicle>();
		Set<Vehicle> myLists = new HashSet<Vehicle>();
		SearchQuery searchQuery3 = new NativeSearchQueryBuilder()
				  .withQuery(new MultiMatchQueryBuilder(vehicle.getSearch())
					.queryName("type:"+vehicle.getVehicleType())
				    .field("vehiclename")
				    .field("brand")
				    .field("model")
				    .field("type")
				    .operator(Operator.AND)
				    .type(MultiMatchQueryBuilder.Type.BEST_FIELDS))
				  .build(); 
		
		try {
			Iterable<Vehicle> articles =  config.elasticsearchTemplate().queryForList(searchQuery3, Vehicle.class);
			tempLists = Sets.newHashSet(articles);
		} catch (Exception e) {
			logger.info("error fetching from elasticSearch"+e.getMessage());
		}
		for(Vehicle myVehicle:tempLists){
			if(myVehicle.getType().equalsIgnoreCase(vehicle.getVehicleType())){
				myLists.add(myVehicle);
			}
		}

		return myLists;
	}
	

}
