package com.vehicle.daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vehicle.dao.VehicleRepository;
import com.vehicle.dto.LoginDTO;
import com.vehicle.dto.Login;


@Repository
public class VehicleRepositoryImpl implements VehicleRepository {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public String authenticateUser(LoginDTO login) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Login where username=:name and password=:password");
		query.setParameter("name", login.getUsername());
		query.setParameter("password", login.getPassword());
		List<Login> list = query.list();
		

			try {
				List user=  (List) list.get(0);
			} catch (Exception e) {
				return null;
			
			}
			return null;
	

		
	}

}
