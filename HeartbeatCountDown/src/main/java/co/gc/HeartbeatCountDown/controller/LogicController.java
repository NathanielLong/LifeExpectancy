package co.gc.HeartbeatCountDown.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import StatisticsModels.StatisticsModels;
import co.gc.HeartbeatCountDown.model.User;
import co.gc.HeartbeatCountDown.model.UserWithHeartBeats;
import co.gc.HeartbeatCountDown.repo.UserRepo;

@Controller
public class LogicController {
	
	@Autowired
	HttpSession session;
	
	@Autowired
	UserRepo ur;
	
	RestTemplate rt = new RestTemplate();
	
	public long findBeatDrop(User user){
		System.out.println(user);
		long heartBeatsLeft = (long) (user.getDeathYear()*StatisticsModels.heartbeatsPerYear);
		System.out.println(heartBeatsLeft);
		heartBeatsLeft -= StatisticsModels.smokingBeatsReduced(user.getAmount(), user.getYears());
		System.out.println(heartBeatsLeft);
		heartBeatsLeft -= StatisticsModels.alcoholBeatsReduced(user.getAlcohol());
		System.out.println(heartBeatsLeft);
		heartBeatsLeft -= StatisticsModels.incomeBeatsLost(user.getIncome(), user.getGender());
		System.out.println(heartBeatsLeft);
		heartBeatsLeft -= StatisticsModels.ethnicityBeatsLost(user.getEthnicity());
		System.out.println(heartBeatsLeft);
		heartBeatsLeft -= StatisticsModels.bmiBeatsReduced(user.getHeight(), user.getWeight(), user.getGender());
		System.out.println(heartBeatsLeft);
		heartBeatsLeft -= findHeartbeatsSpent(user.getDob());
		System.out.println(heartBeatsLeft);
		if(user.getStillSmokin().equals("ismoke"))
				{
			Double keepSmoking = (double) (heartBeatsLeft/StatisticsModels.heartbeatsPerYear);
			heartBeatsLeft -= StatisticsModels.smokingBeatsReduced(user.getAmount(), keepSmoking);
				}
		return heartBeatsLeft;
		
	}
		
		
	public long findHeartbeatsSpent(LocalDate birthday)	{
		
		LocalDate currentDate = LocalDate.now();
		Double currentYear = currentDate.getYear()+(double)(currentDate.getDayOfYear()/365);
		
		Double birthYear = birthday.getYear()+(double)(birthday.getDayOfYear()/365);
		
		Double yearsSpent = currentYear-birthYear;
		return (long) (yearsSpent*StatisticsModels.heartbeatsPerYear);
	}
	
	@RequestMapping("/hiscores")
	public ModelAndView hiScoreTable() {
		List<UserWithHeartBeats> userList = new ArrayList<>();
		for(User u : ur.findAll())
		{
			userList.add(new UserWithHeartBeats(findBeatDrop(u)));
		}
		
		return new ModelAndView("hiscores", "scores", userList);
	}
}
	

		
