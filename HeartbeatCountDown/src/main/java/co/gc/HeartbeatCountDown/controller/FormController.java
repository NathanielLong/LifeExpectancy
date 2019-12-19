package co.gc.HeartbeatCountDown.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import StatisticsModels.StatisticsModels;
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
		userInfo = new User();
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
		Integer yearsOld =Integer.parseInt((Long.toString((lc.findHeartbeatsSpent(date) / StatisticsModels.heartbeatsPerYear))));
		System.out.println("CAN I GET AN AGE " + yearsOld);
		userInfo.setAge(yearsOld);
		session.setAttribute("user", userInfo);
		return new ModelAndView("smoke");
	}

	@PostMapping("/gender")
	public ModelAndView gender(String smoke, Integer numOfCigarettes, Integer yearsSmoked) {
		userInfo = (User) (session.getAttribute("user"));
//		StatisticsModels.StatisticsModels.smokingBeatsReduced(amount, years);
		userInfo.setSmoke(smoke);
		userInfo.setNumOfCigarettes(numOfCigarettes);
		userInfo.setYearsSmoked(yearsSmoked);
		session.setAttribute("user", userInfo);
		System.out.println(smoke + " " + numOfCigarettes + " " + yearsSmoked + " " + userInfo.getSmoke());
		return new ModelAndView("gender");
	}

	@PostMapping("/country")
	public ModelAndView country(String gender) {

		userInfo = (User) (session.getAttribute("user"));
		userInfo.setGender(gender);
		session.setAttribute("user", userInfo);
		ArrayList<Country> countryList = (ArrayList<Country>) cRepo.findAll();

		return new ModelAndView("country", "countries", countryList);
	}

	@PostMapping("/alcohol")
	public ModelAndView alcohol(String country) {

		userInfo = (User) (session.getAttribute("user"));
		userInfo.setCountry(country);
		System.out.println("Late night test" + userInfo.getCountry() + " " + userInfo.getGender() + " " + userInfo.getAge());
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

	@PostMapping("/bpm")
	public ModelAndView bpm(Integer height, Integer weight) {
		userInfo = (User) (session.getAttribute("user"));
		userInfo.setWeight(weight);
		userInfo.setHeight(height);
		session.setAttribute("user", userInfo);
		return new ModelAndView("bpm");
	}
	
	
	@PostMapping("/ethnicity")
	public ModelAndView ethnicity(Integer bpm) {
		userInfo = (User) (session.getAttribute("user"));
		StatisticsModels sm = new StatisticsModels();
		sm.setBpm(bpm);
		userInfo.setBpm(bpm);
		session.setAttribute("user", userInfo);
		return new ModelAndView("ethnicity");

	}

	@PostMapping("/education")
	public ModelAndView education(String ethnicity) {
		userInfo = (User) (session.getAttribute("user"));
		System.out.println("the real ethnicity");
		userInfo.setEthnicity(ethnicity);
		session.setAttribute("user", userInfo);
		Integer age = userInfo.getAge();
		if (age < 25) {
			String education = "none";
			return income(education);
		} else {
			return new ModelAndView("education");
		}

	}

	@PostMapping("/income")
	public ModelAndView income(String education) {
			userInfo.setEducation(education);
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
		userInfo.setId(uRepo.findByUserName(userInfo.getUserName()).getId());
		long hBeats;
		LogicController lc = new LogicController();
		hBeats = lc.findBeatDrop(userInfo);
		if(hBeats < 1000)
			hBeats = 1000;
		mv.addObject("beatRate", userInfo.getBpm()/60);
		mv.addObject("yearsLeft", hBeats/StatisticsModels.heartbeatsPerYear);
		mv.addObject("hBeat", hBeats);
		mv.addObject("deathDay", dateOfDeath(hBeats));
		uRepo.save(userInfo);
		return mv;

	}

	@PostMapping("/scroogeresults")
	public ModelAndView goToResultsFromScrooge(User user) {
		userInfo = user;
		session.setAttribute("user", userInfo);
		ModelAndView mv = new ModelAndView("results");
		uRepo.save(userInfo);
		System.out.println(userInfo);
		long hBeats;
		LogicController lc = new LogicController();
		hBeats = lc.findBeatDrop(userInfo);
		mv.addObject("hBeat", hBeats);
		mv.addObject("deathDay", dateOfDeath(hBeats));
		return mv;

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
		ArrayList<Country> countryList = (ArrayList<Country>) cRepo.findAll();
		System.out.println(user.getEthnicity());
		System.out.println("This is the user: " + user);
		System.out.println(userInfo);
		Long hBeats;
		Long nHBeats;
		LogicController lc = new LogicController();
		hBeats = lc.findBeatDrop(userInfo);
		System.out.println("old beats: " + hBeats);
		nHBeats = lc.findBeatDrop(user);
		System.out.println("new beats: " + nHBeats);
		mv.addObject("beatsPerYear", hBeats/StatisticsModels.heartbeatsPerYear);
		System.out.println(hBeats/StatisticsModels.heartbeatsPerYear);
		mv.addObject("newHBeat", nHBeats);
		mv.addObject("currentHBeat", hBeats);
		mv.addObject("choices", true);
		mv.addObject("countries", countryList);
		mv.addObject("userDeets",userInfo);
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
			if (userInfo.getAge() < 60)
				url = "http://apps.who.int/gho/athena/api/GHO/WHOSIS_000001?profile=simple&filter=Year:2015;COUNTRY:"
						+ country + ";SEX:" + gender + ";&format=json";
			else {
				url = "http://apps.who.int/gho/athena/api/GHO/WHOSIS_000015?profile=simple&filter=Year:2015;COUNTRY:"
						+ country + ";SEX:" + gender + ";&format=json";
				deathYear += 60;
			}
			deathYear += rt.getForObject(url, PeopleResults.class).getPeopleArray().get(0).getDeathAge();
		} catch (IndexOutOfBoundsException e) {
			country = "USA";
			if (userInfo.getAge() < 60)
				url = "http://apps.who.int/gho/athena/api/GHO/WHOSIS_000001?profile=simple&filter=Year:2015;COUNTRY:"
						+ country + ";SEX:" + gender + ";&format=json";
			else {
				url = "http://apps.who.int/gho/athena/api/GHO/WHOSIS_000015?profile=simple&filter=Year:2015;COUNTRY:"
						+ country + ";SEX:" + gender + ";&format=json";
				deathYear += 60;
			}
			deathYear += rt.getForObject(url, PeopleResults.class).getPeopleArray().get(0).getDeathAge();
		}
		return deathYear;
	}

	public String dateOfDeath(long hBeats) {
		int deathDays = (int) (hBeats / StatisticsModels.heartbeatsPerYear * 365);
		LocalDate dDay = LocalDate.now().plusDays(deathDays);
		userInfo.setDeathDay(String.valueOf(dDay));
		String deathSentence = dDay.getMonth() + " " + dDay.getDayOfMonth() + ", " + dDay.getYear() + ".";
		System.out.println(deathSentence + "test");
		return deathSentence;
	}

	@PostMapping("/login-result")
	public ModelAndView login(String userName, String passWord) {

		if (uRepo.findByUserName(userName) == null)
			return new ModelAndView("index", "wrong", "Sorry, your username was not found, please create an account!");

		if (uRepo.findByUserName(userName).getPassword().equals(passWord)) {
			userInfo = uRepo.findByUserName(userName);
			session.setAttribute("user", userInfo);
			ModelAndView mv = new ModelAndView("results");
			long hBeats;
			LogicController lc = new LogicController();
			hBeats = lc.findBeatDrop(userInfo);
			mv.addObject("hBeat", hBeats);
			mv.addObject("deathDay", dateOfDeath(hBeats));
			return mv;
		} else
			return new ModelAndView("index", "wrong", "Sorry, your credentials did not match, please try again!");

	}

	@RequestMapping("death-buddies")
	public ModelAndView dBuddy() {
		userInfo=(User) session.getAttribute("user");
		uRepo.save(userInfo);
		ModelAndView mv = new ModelAndView("death-buddies");
		int emailCount = 0;
		String emailString = "";
		List<User> buddyList = new ArrayList<>();
		System.out.println(userInfo.getDeathDay() + "test");
		for (User u : uRepo.findAll()) {
			System.out.println(u.getDeathDay());
			if (u.getDeathDay().equals(userInfo.getDeathDay()))
			{
				buddyList.add(u);
				if(u.getEmail()!=null)
					emailCount++;
				emailString+=u.getEmail() + "@@@";
			}
		}
		String[]eArray = emailString.split("@@@");
		emailString = "";
		if(emailCount>0)
		{
			for(int i = 0; i<emailCount-1; i++)
			emailString += eArray[i] + ",";
			emailString += eArray[emailCount-1];
		}
		String budCount = "";
		if(buddyList.size()==1)
			budCount = "Well, looks like you're going to die alone. You should add your email to your account.<br>"
					+ "That way, when a death buddy comes along, you can plan a fun last day!";
		mv.addObject("deathDay", userInfo.getDeathDay());
		mv.addObject("lonelyBud", budCount);
		mv.addObject("emailList", emailString);
		mv.addObject("budInfo",userInfo);
		mv.addObject("buds", buddyList);
		System.out.println(buddyList.get(0).getUserName());
		
		return mv;
	}
	
	@PostMapping("add-email")
	public ModelAndView addEmail(String email)
	{
	userInfo = (User) session.getAttribute("user");
	userInfo.setEmail(email);
	uRepo.save(userInfo);
	session.setAttribute("user",userInfo);
	return dBuddy();
	
	}
}
