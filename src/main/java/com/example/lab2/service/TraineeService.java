package com.example.lab2.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lab2.entity.Trainee;
import com.example.lab2.interfac.TraineeServiceInterfac;
import com.example.lab2.interfac.TraineeInterfac;


@Service
@Transactional

public class TraineeService implements TraineeServiceInterfac
{

	@Autowired
	TraineeInterfac traineeInterfac;
	@Override
	public boolean saveTrainee(Trainee trainee) {
		// TODO Auto-generated method stub
		return traineeInterfac.saveTrainee(trainee);  
	}

	@Override
	public List<Trainee> getTrainee() {
		// TODO Auto-generated method stub
		return traineeInterfac.getTrainee();  
	}

	@Override
	public Trainee findbyid(int traineeid) {
		// TODO Auto-generated method stub
		 return traineeInterfac.findbyid(traineeid);
	}
	
	@Override
	public void deleteTrainee(int traineeid) {
		// TODO Auto-generated method stub
		traineeInterfac.deleteTrainee(traineeid);
	}

	@Override
	public boolean updateTrainee(int traineeid) {
		// TODO Auto-generated method stub
		return traineeInterfac.updateTrainee(traineeid);
	}

	
	
	
	

}
