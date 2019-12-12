package co.gc.HeartbeatCountDown.controller;

import java.time.LocalDate;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import StatisticsModels.StatisticsModels;
import co.gc.HeartbeatCountDown.model.User;

public class LogicController {
	
	@Autowired
	HttpSession session;
	
	RestTemplate rt = new RestTemplate();
	
	@RequestMapping
	public ModelAndView findBeatDrop(){
		User user = (User) session.getAttribute("user");
		int heartBeatsLeft = (int) (user.getDeathYear()*StatisticsModels.heartbeatsPerYear);
		heartBeatsLeft -= StatisticsModels.smokingBeatsReduced(user.getAmount(), user.getYears());
		heartBeatsLeft -= StatisticsModels.alcoholBeatsReduced(user.getAlcohol());
		heartBeatsLeft -= StatisticsModels.incomeBeatsLost(user.getIncome(), user.getGender());
		heartBeatsLeft -= StatisticsModels.ethnicityBeatsLost(user.getEthnicity());
		heartBeatsLeft -= findHeartbeatsSpent(user.getDob());
		if(user.getStillSmokin().equals("ismoke"))
				{
			Double keepSmoking = (double) (heartBeatsLeft/StatisticsModels.heartbeatsPerYear);
			heartBeatsLeft -= StatisticsModels.smokingBeatsReduced(user.getAmount(), keepSmoking);
				}
		return new ModelAndView("results","heartBeat",heartBeatsLeft);
		
	}
		
		
	public int findHeartbeatsSpent(LocalDate birthday)	{
		
		LocalDate currentDate = LocalDate.now();
		Double currentYear = currentDate.getYear()+(double)(currentDate.getDayOfYear()/365);
		
		Double birthYear = currentDate.getYear()+(double)(currentDate.getDayOfYear()/365);
		
		Double yearsSpent = currentYear-birthYear;
		return (int) (yearsSpent*StatisticsModels.heartbeatsPerYear);
	}
	
}
	

		
