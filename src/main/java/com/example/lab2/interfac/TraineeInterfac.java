package com.example.lab2.interfac;

import java.util.List;

import com.example.lab2.entity.Trainee;

public interface TraineeInterfac {

	public boolean saveTrainee(Trainee trainee);  
    public List<Trainee> getTrainee();  
    public void deleteTrainee(int traineeid);    
    public Trainee findbyid(int traineeid);
    public boolean updateTrainee(int traineeid);
	 

}

