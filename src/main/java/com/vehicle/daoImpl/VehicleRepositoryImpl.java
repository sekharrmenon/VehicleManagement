
package com.vehicle.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vehicle.dao.VehicleRepository;
import com.vehicle.dto.LoginDTO;
import com.vehicle.dto.Vehicle;
import com.vehicle.dto.VehicleDTO;
import com.vehicle.serviceImpl.VehicleServiceImpl;
import com.vehicle.dto.Login;


@Repository
public class VehicleRepositoryImpl implements VehicleRepository {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private static final Logger logger = LoggerFactory
	        .getLogger(VehicleRepositoryImpl.class);
	
	
	@Override
	public Login authenticateUser(LoginDTO login) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Login where username=:name and password=:password");
		query.setParameter("name", login.getUsername());
		query.setParameter("password", login.getPassword());
		List<Login> list = query.list();
		

			try {
				Login user=  list.get(0);
				logger.info("User authenticated");
				return user;
			} catch (Exception e) {
				return new Login();
			
			}finally{
				session.close();
			}
		
	}

	@Override
	public String save(Vehicle vehicle) {
		Session session = sessionFactory.openSession();
	    try {
			Transaction tx = session.beginTransaction();
			session.save(vehicle);
			tx.commit();
			logger.info("Vehicle added successfully");
			
		} catch (Exception e) {
			logger.info("Error creating vehicle"+e.getMessage());
			return "Error creating vehicle";
		}finally{
			session.close();
		}
	    
	    return "Vehicle added successfully";
	}

	@Override
	public String update(Vehicle vehicle) {
		Session session = sessionFactory.openSession();
	    try {
			Transaction tx = session.beginTransaction();
			session.update(vehicle);
			tx.commit();
			logger.info("Vehicle update successfully");
			
		} catch (Exception e) {
			logger.info("Error updating vehicle"+e.getMessage());
			return "Error updating vehicle";
		}finally{
			session.close();
		}
	    
	    return "Vehicle updated successfully";
		
	}

	@Override
	public List<Vehicle> getVehicles() {
		List<Vehicle> list= new ArrayList<Vehicle>();
		Session session = sessionFactory.openSession();
		try {
			list = session.createQuery("from Vehicle").list();
			logger.info("Vehicle fetch success");
		} catch (HibernateException e) {
			logger.info("No vehicle in the db");
			e.printStackTrace();
		}finally{
			session.close();
		}
		return list;
	}

	@Override
	public String delete(int id) {
		Session session = sessionFactory.openSession();
		try {
			Query q = session.createQuery("delete Vehicle where id=:vehicleId");
			q.setParameter("vehicleId", id);
			q.executeUpdate();
			logger.info("Vehicle deleted success");
		} catch (HibernateException e) {
			logger.info("Vehicle Deletion Failed");
			e.printStackTrace();
			return "Vehicle Deletion Failed";
		}finally{
			session.close();
		}
		return "Vehicle Deleted Successfully";
	}

	@Override
	public Vehicle findVehicle(int id) {
		
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Vehicle where vehicle_id=:id");
		query.setParameter("id", id);
		List<Vehicle> list = query.list();
			try {
				Vehicle vehicle=  list.get(0);
				logger.info("Vehicle fetch success");
				return vehicle;
			} catch (Exception e) {
				return new Vehicle();
			
			}finally{
				session.close();
			}
	}

	@Override
	public List<Vehicle> findVehicle(String name) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Vehicle where vehicle_user=:name");
		query.setParameter("name", name);
		List<Vehicle> list = query.list();
		session.close();
		return list;
		
	}

}