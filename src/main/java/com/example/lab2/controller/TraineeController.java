package com.example.lab2.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.lab2.entity.Trainee;
//import com.cg.lab2.trainee.entity.User;
import com.example.lab2.interfac.TraineeServiceInterfac;

@Controller
public class TraineeController {
	
	@Autowired
	TraineeServiceInterfac traineeservice;
	
	@RequestMapping("/")
	public String login(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_LOGIN");
		return "welcome";
	}
	
////	@RequestMapping("/login")
////	public String loginUser(@ModelAttribute User user, HttpServletRequest request) {
////		if (userService.findByUsernameAndPassword(user.getUsername(), user.getPassword()) != null) {
//			return "home";
//		} else {
//			request.setAttribute("error", "Invalid Username or Password");
//			request.setAttribute("mode", "MODE_LOGIN");
//			return "addtrainee";
//
//	}

	@RequestMapping("/addtrainee")
	public String registration(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_REGISTER");
		return "welcome";
	}
	@PostMapping("/save-trainee")
	public String registerUser(@ModelAttribute Trainee trainee, BindingResult bindingResult,
			HttpServletRequest request) {
		traineeservice.saveTrainee(trainee);

		return "home";
	}
	
	@GetMapping("/show-trainee")
	public String showAllUsers(HttpServletRequest request) {
		request.setAttribute("trainees", traineeservice.getTrainee());
		request.setAttribute("mode", "ALL_USERS");
		return "welcome";
	}
	@RequestMapping("/delete-trainee")
	public String deleteUser(@RequestParam int traineeid, HttpServletRequest request) {
		traineeservice.deleteTrainee(traineeid);
		request.setAttribute("trainees", traineeservice.getTrainee());
		request.setAttribute("mode", "ALL_USERS");
		return "welcome";
	}
	
	@RequestMapping (value="/update")
	public String update( @ModelAttribute Trainee trainee,@PathVariable int traineeid,HttpServletRequest request)
	{
		traineeservice.updateTrainee(traineeid);
		request.setAttribute("trainees", traineeservice.updateTrainee(traineeid));
		request.setAttribute("mode", "MODE_UPDATE");
				return "welcome";
	}

	
}
