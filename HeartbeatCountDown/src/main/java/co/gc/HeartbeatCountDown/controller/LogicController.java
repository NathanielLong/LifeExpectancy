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
		heartBeatsLeft -= StatisticsModels.smokingBeatsReduced(user.getNumOfCigarettes(), user.getYearsSmoked());
		System.out.println("Smoking" + heartBeatsLeft);
		heartBeatsLeft -= StatisticsModels.alcoholBeatsReduced(user.getAlcohol());
		System.out.println("alcohol" + heartBeatsLeft);
		heartBeatsLeft -= StatisticsModels.incomeBeatsLost(user.getIncome(), user.getGender());
		System.out.println("income" + heartBeatsLeft);
		heartBeatsLeft -= StatisticsModels.ethnicityBeatsLost(user.getEthnicity());
		System.out.println("ethnicity" + heartBeatsLeft);
		heartBeatsLeft -= StatisticsModels.bmiBeatsReduced(user.getHeight(), user.getWeight(), user.getGender());
		System.out.println("bmi" + heartBeatsLeft);
		heartBeatsLeft -= findHeartbeatsSpent(LocalDate.parse(user.getDob()));
		System.out.println("subtract age" + heartBeatsLeft);
		heartBeatsLeft -= StatisticsModels.educationBeatsReduced(user.getEducation(), user.getGender());
		System.out.println("Education" + heartBeatsLeft);
		if(user.getSmoke().equals("smokeTrue"))
				{
			Double keepSmoking = (double) (heartBeatsLeft/StatisticsModels.heartbeatsPerYear);
			heartBeatsLeft -= StatisticsModels.smokingBeatsReduced(user.getNumOfCigarettes(), keepSmoking);
				System.out.println("keep smoking" + heartBeatsLeft);
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
			System.out.println(u.getCountry());
			userList.add(new UserWithHeartBeats(u, findBeatDrop(u)));
			
		}
		System.out.println(userList.size());
		System.out.println("hi");
		System.out.println(userList.get(0).getHeartBeats());
		System.out.println(userList.get(0).getUser());
		for(UserWithHeartBeats u : userList)
			System.out.println(u.getUser().getUserName());
		
		
		return new ModelAndView("hiscores", "scores", userList);
	}
}
	

		
