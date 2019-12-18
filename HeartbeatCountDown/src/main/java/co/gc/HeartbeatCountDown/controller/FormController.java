package co.gc.HeartbeatCountDown.controller;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import co.gc.HeartbeatCountDown.CountryRepo.CountryRepo;
import co.gc.HeartbeatCountDown.countriesmodel.Country;
import co.gc.HeartbeatCountDown.model.PeopleResults;
import co.gc.HeartbeatCountDown.model.User;
import co.gc.HeartbeatCountDown.repo.UserRepo;

@Controller
public class FormController {

	@Autowired
	UserRepo uRepo;

	@Autowired
	HttpSession session;

	@Autowired
	CountryRepo cRepo;

	RestTemplate rt = new RestTemplate();

	User userInfo = new User();

	@RequestMapping("/")
	public ModelAndView userName() {
		return new ModelAndView("index");
	}

//	@PostMapping("/")
//	public ModelAndView userNamePost(String userName) {
//		return new ModelAndView("index");
//	}	

//	@RequestMapping("/date")
//	public ModelAndView dateOfBirth(String userName) {
//		userInfo.setUserName(userName);
//		session.setAttribute("user", userInfo);
//		System.out.println(userInfo.getUserName());
//
//		return new ModelAndView("date-of-birth");
//	}

	@PostMapping("/date")
	public ModelAndView dateOfBirthPost(String userName, String name, String passWord) {
		if (uRepo.findByUserName(userName) != null)
			return new ModelAndView("index", "sorry", "That username is already taken, please try again.");

		userInfo.setUserName(userName);
		userInfo.setName(name);
		userInfo.setPassword(passWord);
		session.setAttribute("user", userInfo);
		System.out.println(userInfo.getUserName());

		return new ModelAndView("date-of-birth");
	}

	@PostMapping("/smoke")
	public ModelAndView smoke(String dob) {
		userInfo = (User) (session.getAttribute("user"));
		userInfo.setDob(dob);
		LogicController lc = new LogicController();
		LocalDate date = LocalDate.parse(dob);
		long yearsOld = (lc.findHeartbeatsSpent(date) / StatisticsModels.StatisticsModels.heartbeatsPerYear);
		userInfo.setAge(yearsOld);
		session.setAttribute("user", userInfo);
		return new ModelAndView("smoke");
	}

	@PostMapping("/gender")
	public ModelAndView gender(String smoke, Integer amount, Integer years, Integer number, String stillsmokin) {
		userInfo = (User) (session.getAttribute("user"));
//		StatisticsModels.StatisticsModels.smokingBeatsReduced(amount, years);
		userInfo.setSmoke(smoke);
		userInfo.setAmount(amount);
		userInfo.setYears(years);
		userInfo.setStillSmokin(stillsmokin);
		session.setAttribute("user", userInfo);
		System.out.println(smoke + " " + amount + " " + years + " " + userInfo.getStillSmokin());
		return new ModelAndView("gender");
	}

	@PostMapping("/country")
	public ModelAndView country(String gender) {

		userInfo = (User) (session.getAttribute("user"));
		userInfo.setGender(gender);
		session.setAttribute("user", userInfo);
		ArrayList<Country> boogaloo = (ArrayList<Country>) cRepo.findAll();
//		boogaloo.get(0).getDisplay();

		return new ModelAndView("country", "countries", boogaloo);
	}

	@PostMapping("/alcohol")
	public ModelAndView alcohol(String country) {

		userInfo = (User) (session.getAttribute("user"));
		userInfo.setCountry(country);
		userInfo.setDeathYear(getDeathYear());
		System.out.println(userInfo.getDeathYear());
		session.setAttribute("user", userInfo);

		return new ModelAndView("alcohol");
	}

	@PostMapping("/bmi")
	public ModelAndView bmi(String alcohol, String amountDrunk) {
		System.out.println(alcohol + amountDrunk);
		userInfo.setAlcohol(alcohol);
		userInfo.setAmountDrunk(amountDrunk);
		return new ModelAndView("bmi");
	}

	@PostMapping("/ethnicity")
	public ModelAndView ethnicity(Integer height, Integer weight) {
		userInfo = (User) (session.getAttribute("user"));
//		userInfo.setIncome(income);
		// long age = user.getAge();
		userInfo.setWeight(weight);
		userInfo.setHeight(height);
		session.setAttribute("user", userInfo);
		return new ModelAndView("ethnicity");

	}

	@PostMapping("/education")
	public ModelAndView education(String ethnicity) {
		userInfo = (User) (session.getAttribute("user"));
		userInfo.setEthnicity(ethnicity);

		long age = userInfo.getAge();
		if (age < 25) {
			return new ModelAndView("income", "ethnicity", ethnicity);
		} else {
			return new ModelAndView("education", "ethnicity", ethnicity);
		}

	}

	@PostMapping("/confirm")
	public ModelAndView confirm(String education) {
		userInfo = (User) (session.getAttribute("user"));
		userInfo.setEducation(education);
		uRepo.save(userInfo);
		return new ModelAndView("confirmation");
	}

	@PostMapping("/income")
	public ModelAndView income(String ethnicity, String education) {
		System.out.println("ethnicity" + ethnicity);

		if (education != null)
			userInfo.setEducation(education);
		else
			userInfo.setEducation("none");
		userInfo.setEthnicity(ethnicity);
		System.out.println(userInfo.getEthnicity());
		uRepo.save(userInfo);
		return new ModelAndView("income");
	}

	@PostMapping("/results")
	public ModelAndView goToResults(Integer income) {
//		System.out.println(userInfo.getAlcohol() + " " + userInfo.getCountry() + " " + userInfo.getDob() + " " + userInfo.getEducation()
//				+ " " + userInfo.getEthnicity() + " " + userInfo.getGender() + " " + userInfo.getSmoke() + " " + userInfo.getUserName()
//				+ " ");
		ModelAndView mv = new ModelAndView("results");
		userInfo = (User) (session.getAttribute("user"));
		userInfo.setIncome(income);
		System.out.println(userInfo);
		uRepo.save(userInfo);
		long hBeats;
		LogicController lc = new LogicController();
		hBeats = lc.findBeatDrop(userInfo);
		mv.addObject("hBeat", hBeats);
		mv.addObject("deathDay", dateOfDeath(hBeats));
		return mv;

	}

	@PostMapping("/scroogeresults")
	public ModelAndView goToResultsFromScrooge(String userName, String country, String gender, String alcohol,
			String dob, String education, String smoke, Integer income, String ethnicity, Integer amount, Integer years,
			String stillSmokin, String amountDrunk, Integer height, Integer weight) {
		System.out.print(userName + "," + country + "," + gender + "," + alcohol + "," + dob + "," + "," + education
				+ "," + smoke + "," + "," + income + "," + ethnicity + "," + amount + "," + years + "," + stillSmokin
				+ "," + amountDrunk + "," + height + "," + weight);
		userInfo = (User) (session.getAttribute("user"));
		userInfo.setAlcohol(alcohol);
		userInfo.setAmount(amount);
		userInfo.setAmountDrunk(amountDrunk);
		userInfo.setCountry(country);
		userInfo.setIncome(income);
		userInfo.setSmoke(smoke);
		userInfo.setWeight(weight);
		userInfo.setYears(years);
		userInfo.setEducation(education);

		session.setAttribute("user", userInfo);
		uRepo.save(userInfo);
		long hBeats;
		LogicController lc = new LogicController();
		hBeats = lc.findBeatDrop(userInfo);
		return new ModelAndView("results", "hBeat", hBeats);

	}

	@RequestMapping("/scrooge")
	public ModelAndView scrooge() {
		ArrayList<Country> countryList = (ArrayList<Country>) cRepo.findAll();
		ModelAndView mv = new ModelAndView("scrooge");
		mv.addObject("countries", countryList);
		mv.addObject("userDeets", userInfo);
		return mv;
	}

	@RequestMapping("/newresults")
	public ModelAndView newHeartBeats(User user) {
		ModelAndView mv = new ModelAndView("scrooge");
		System.out.println("This is the user: " + user);
		System.out.println(userInfo);
		long hBeats;
		long nHBeats;
		LogicController lc = new LogicController();
		hBeats = lc.findBeatDrop(userInfo);
		System.out.println("old beats: " + hBeats);
		nHBeats = lc.findBeatDrop(user);
		System.out.println("new beats: " + nHBeats);
		mv.addObject("newHBeat", nHBeats);
		mv.addObject("currentHBeat", hBeats);
		return mv;
		
	}
	
	public Double getDeathYear() {
		userInfo = (User) (session.getAttribute("user"));
		String gender = userInfo.getGender();
		String country = userInfo.getCountry();
		String url = "";
		Double deathYear = 0.0;
		System.out.println(userInfo.getGender() + " " + userInfo.getCountry());
		try {
		if(userInfo.getAge()<60)
		url = "http://apps.who.int/gho/athena/api/GHO/WHOSIS_000001?profile=simple&filter=Year:2015;COUNTRY:"
				+ country + ";SEX:" + gender + ";&format=json";
		else
		{url = "http://apps.who.int/gho/athena/api/GHO/WHOSIS_000015?profile=simple&filter=Year:2015;COUNTRY:"
				+ country + ";SEX:" + gender + ";&format=json";
		deathYear+=60;
		}
		deathYear += rt.getForObject(url, PeopleResults.class).getPeopleArray().get(0).getDeathAge();
		}
		catch(IndexOutOfBoundsException e)
		{
			country = "USA";
			if(userInfo.getAge()<60)
			url = "http://apps.who.int/gho/athena/api/GHO/WHOSIS_000001?profile=simple&filter=Year:2015;COUNTRY:"
					+ country + ";SEX:" + gender + ";&format=json";
			else
			{url = "http://apps.who.int/gho/athena/api/GHO/WHOSIS_000015?profile=simple&filter=Year:2015;COUNTRY:"
					+ country + ";SEX:" + gender + ";&format=json";
			deathYear+=60;
			}
			deathYear += rt.getForObject(url, PeopleResults.class).getPeopleArray().get(0).getDeathAge();
		}
		return deathYear;
	}

	public String dateOfDeath(long hBeats) {

		int deathDays = (int) (hBeats / StatisticsModels.StatisticsModels.heartbeatsPerYear * 365);
		LocalDate dDay = LocalDate.now().plusDays(deathDays);
		userInfo.setDeathDay(dDay);
		String deathSentence = dDay.getMonth() + " " + dDay.getDayOfMonth() + ", " + dDay.getYear() + ".";
		return deathSentence;
	}
	
	@PostMapping("/login-result")
	public ModelAndView login(String userName, String passWord)
	{
		
		if(uRepo.findByUserName(userName) == null)
return new ModelAndView("index","wrong","Sorry, your username was not found, please create an account!");

		userInfo = uRepo.findByUserName(userName);
		if(userInfo.getPassword().equals(passWord))
		{
			ModelAndView mv = new ModelAndView("results");
			long hBeats;
			LogicController lc = new LogicController();
			hBeats = lc.findBeatDrop(userInfo);
			mv.addObject("hBeat", hBeats);
			mv.addObject("deathDay", dateOfDeath(hBeats));
			return mv;
		}
		else
			return new ModelAndView("index","wrong","Sorry, your credentials did not match, please try again!");
		
	}
	
	@RequestMapping("death-buddies")
	public ModelAndView dBuddy()
	{
		
		
		return new ModelAndView("death-buddies");
	}

}
