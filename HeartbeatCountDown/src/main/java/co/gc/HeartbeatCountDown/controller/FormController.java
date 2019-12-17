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

//	@RequestMapping("/")
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
		if(uRepo.findByUserName(userName) != null)
			return new ModelAndView("index", "sorry", "That username is already taken, please try again.");
		
		userInfo.setUserName(userName);
		userInfo.setName(name);
		userInfo.setPassword(passWord);
		session.setAttribute("user", userInfo);
		System.out.println(userInfo.getUserName());

		return new ModelAndView("date-of-birth");
	}

	@PostMapping("/smoke")
	public ModelAndView smoke(String borned) {
		LocalDate date = LocalDate.parse(borned);
		userInfo = (User) (session.getAttribute("user"));
		userInfo.setDob(date);
		LogicController lc = new LogicController();
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
		
		if(education != null)
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
		ModelAndView mv = new ModelAndView();
		mv.addObject("results");
		userInfo = (User) (session.getAttribute("user"));
//		if(education != null)
//		userInfo.setEducation(education);
//		else
//		userInfo.setEducation("none");
//		userInfo.setEthnicity(ethnicity);
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
	public ModelAndView goToResultsFromScrooge(String alcohol, Integer amount, String amountDrunk, String country,
			Integer income, String smoke, String stillSmokin, Integer weight, Integer years) {
		userInfo = (User) (session.getAttribute("user"));
		userInfo.setAlcohol(alcohol);
		userInfo.setAmount(amount);
		userInfo.setAmountDrunk(amountDrunk);
		userInfo.setCountry(country);
		userInfo.setIncome(income);
		userInfo.setSmoke(smoke);
		userInfo.setStillSmokin(stillSmokin);
		userInfo.setYears(years);
		session.setAttribute("user", userInfo);

//		System.out.println(user.getAlcohol() + " " + user.getCountry() + " " + user.getDob() + " " + user.getEducation()
//				+ " " + user.getEthnicity() + " " + user.getGender() + " " + user.getSmoke() + " " + user.getUserName()
//				+ " ");
		uRepo.save(userInfo);
		long hBeats;
		LogicController lc = new LogicController();
		hBeats = lc.findBeatDrop(userInfo);
		return new ModelAndView("results", "hBeat", hBeats);

	}
	
	

	@PostMapping("/confirmation")
	public ModelAndView confirmation(String ethnicity) {
		userInfo = (User) (session.getAttribute("user"));
		userInfo.setEthnicity(ethnicity);
		userInfo.setEducation("none");
		uRepo.save(userInfo);
		return new ModelAndView("confirmation");
	}


	@PostMapping("/scrooge")
	public ModelAndView scrooge() {
		ArrayList<Country> boogaloo = (ArrayList<Country>) cRepo.findAll();
		return new ModelAndView("scrooge", "countries", boogaloo);
	}

	public Double getDeathYear() {
		userInfo = (User) (session.getAttribute("user"));
		String gender = userInfo.getGender();
		String country = userInfo.getCountry();
		System.out.println(userInfo.getGender() + " " + userInfo.getCountry());
		String url = "http://apps.who.int/gho/athena/api/GHO/WHOSIS_000001?profile=simple&filter=Year:2015;COUNTRY:"
				+ country + ";SEX:" + gender + ";&format=json";
		Double deathYear = rt.getForObject(url, PeopleResults.class).getPeopleArray().get(0).getDeathAge();
		return deathYear;
	}
	
	public String dateOfDeath(long hBeats)
	{
		
		int deathDays = (int)(hBeats/StatisticsModels.StatisticsModels.heartbeatsPerYear*365);
		LocalDate dDay = LocalDate.now().plusDays(deathDays);
		String deathSentence = "I estimate you make it to " + dDay.getMonth() + " " + dDay.getDayOfMonth()
		+ ", " + dDay.getYear() + ".";
		return deathSentence;
	}

//	@RequestMapping("/education")
//	public ModelAndView education(String alc) {
//
//		String educationString = "<form action=\"/ethnicity\"> Name: <input type = \"text\" name = \"name\"></input> <input type=\"submit\" Value=\"Begin.\" class = \"btn btn-primary\"></input> </form>";
//		return new ModelAndView("form", "formtype", educationString);
//	}

//	@RequestMapping("/ethnicity")
//	public ModelAndView ethnicity(String edu) {
//		return new ModelAndView("ethnicity");
//	}

//	@RequestMapping("/education")
//	public ModelAndView education(String alc) {
//
//		String educationString = "<form action=\"/ethnicity\"> Name: <input type = \"text\" name = \"name\"></input> <input type=\"submit\" Value=\"Begin.\" class = \"btn btn-primary\"></input> </form>";
//		return new ModelAndView("form", "formtype", educationString);
//	}

//	@RequestMapping("start-form/fmh")
//	public ModelAndView familyMedicalHistory(String inc) {
//
//		String fmhString = "<form action=\"/illness\"> Name: <input type = \"text\" name = \"name\"></input> <input type=\"submit\" Value=\"Begin.\" class = \"btn btn-primary\"></input> </form>";
//		return new ModelAndView("form", "formtype", fmhString);
//	}
//
//	@RequestMapping("start-form/illness")
//	public ModelAndView currentIllness(String fmh) {
//
//		String currentillnessString = "<form action=\"/results\"> Name: <input type = \"text\" name = \"name\"></input> <input type=\"submit\" Value=\"Begin.\" class = \"btn btn-primary\"></input> </form>";
//		return new ModelAndView("form", "formtype", currentillnessString);
//	}
//	

	// gotta ad ill to database
}
