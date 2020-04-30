package com.example.lab2.reposritory;

import java.util.List;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.websocket.Session;

import org.hibernate.SessionFactory ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.lab2.entity.Trainee;
import com.example.lab2.interfac.TraineeInterfac;
@Transactional
@Repository
public class TraineeDAO implements TraineeInterfac{

	
	@PersistenceContext
	EntityManager em;
	
	
	@Override
	public boolean saveTrainee(Trainee trainee) {
		// TODO Auto-generated method stub
	   em.persist(trainee);
	   return true;
	}
	
	@Override
	public List<Trainee> getTrainee() {
		// TODO Auto-generated method stub
		String Qstr="select trainee FROM Trainee trainee";
		TypedQuery<Trainee> query =em.createQuery(Qstr, Trainee.class);
		return query.getResultList();
	}

	
	@Override
	public Trainee findbyid(int traineeid) {
		// TODO Auto-generated method stub
		return em.find(Trainee.class, traineeid);
	}  
	
	
	@Override
	public void deleteTrainee(int traineeid) {
		// TODO Auto-generated method stub
		Trainee trainee=em.find(Trainee.class, traineeid);
		em.remove(trainee);
	}

	@Override
	public boolean updateTrainee( int traineeid) {
		// TODO Auto-generated method stub
		Trainee trainee=em.find(Trainee.class, traineeid);
		em.remove(trainee);
		 em.persist(trainee);
		return true;
	}


	
	


}
