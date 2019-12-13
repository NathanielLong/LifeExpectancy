package co.gc.HeartbeatCountDown.controller;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

	@RequestMapping("/date")
	public ModelAndView dateOfBirth(String userName) {
		userInfo.setUserName(userName);
		session.setAttribute("user", userInfo);
		System.out.println(userInfo.getUserName());

		return new ModelAndView("date-of-birth");
	}

	@RequestMapping("/smoke")
	public ModelAndView smoke(String borned) {
		LocalDate date = LocalDate.parse(borned);
		User user = (User) (session.getAttribute("user"));
		user.setDob(date);
		LogicController lc = new LogicController();
		long yearsOld = (lc.findHeartbeatsSpent(date) / StatisticsModels.StatisticsModels.heartbeatsPerYear);
		user.setAge(yearsOld);
		session.setAttribute("user", user);
		return new ModelAndView("smoke");
	}

	@RequestMapping("/gender")
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

	@RequestMapping("/country")
	public ModelAndView country(String gender) {

		userInfo = (User) (session.getAttribute("user"));
		userInfo.setGender(gender);
		session.setAttribute("user", userInfo);
		ArrayList<Country> boogaloo = (ArrayList<Country>) cRepo.findAll();
//		boogaloo.get(0).getDisplay();

		return new ModelAndView("country", "countries", boogaloo);
	}

	@RequestMapping("/alcohol")
	public ModelAndView alcohol(String country) {

		userInfo = (User) (session.getAttribute("user"));
		userInfo.setCountry(country);
		userInfo.setDeathYear(getDeathYear());
		System.out.println(userInfo.getDeathYear());
		session.setAttribute("user", userInfo);

		return new ModelAndView("alcohol");
	}

	@RequestMapping("/bmi")
	public ModelAndView bmi(String alcohol, String amountDrunk) {
		System.out.println(alcohol + amountDrunk);
		userInfo.setAlcohol(alcohol);
		userInfo.setAmountDrunk(amountDrunk);
		return new ModelAndView("bmi");
	}

	@RequestMapping("/income")
	public ModelAndView income(Integer height, Integer weight) {
		userInfo.setWeight(weight);
		userInfo.setHeight(height);

		return new ModelAndView("income");
	}

	@RequestMapping("/ethnicity")
	public ModelAndView ethnicity(Integer income) {
		User user = (User) (session.getAttribute("user"));
		user.setIncome(income);
		//long age = user.getAge();
		session.setAttribute("user", user);
		return new ModelAndView("ethnicity");

	}

	@RequestMapping("/education")
	public ModelAndView education(String ethnicity, String gender) {
		User user = (User) (session.getAttribute("user"));
		user.setEthnicity(ethnicity);
		uRepo.save(user);
		long age = user.getAge();
		if (age < 25) {
			return new ModelAndView("redirect:/confirmation?ethnicity=" + ethnicity);
		} else {
			return new ModelAndView("education");
		}
		

	}

	@RequestMapping("/results")
	public ModelAndView goToResults() {
//		System.out.println(userInfo.getAlcohol() + " " + userInfo.getCountry() + " " + userInfo.getDob() + " " + userInfo.getEducation()
//				+ " " + userInfo.getEthnicity() + " " + userInfo.getGender() + " " + userInfo.getSmoke() + " " + userInfo.getUserName()
//				+ " ");
		uRepo.save(userInfo);
		long hBeats;
		LogicController lc = new LogicController();
		hBeats = lc.findBeatDrop(userInfo);
		return new ModelAndView("results", "hBeat", hBeats);

	}

	@RequestMapping("/scroogeresults")
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

	@RequestMapping("/confirmation")
	public ModelAndView confirm(String ethnicity) {
		User user = (User) (session.getAttribute("user"));
//		User user = (User) (session.getAttribute("user"));
		userInfo.setEthnicity(ethnicity);
		userInfo.setEducation("none");
		uRepo.save(user);
		System.out.println(userInfo.getAlcohol() + " " + userInfo.getCountry() + " " + userInfo.getDob() + " " + userInfo.getEducation()
				+ " " + userInfo.getEthnicity() + " " + userInfo.getGender() + " " + userInfo.getSmoke() + " " + userInfo.getUserName()
				+ " ");
		return new ModelAndView("confirmation");
	}

	@RequestMapping("/scrooge")
	public ModelAndView scrooge() {
		ArrayList<Country> boogaloo = (ArrayList<Country>) cRepo.findAll();
		return new ModelAndView("scrooge", "countries", boogaloo);
	}

	public Double getDeathYear() {
		User user = (User) (session.getAttribute("user"));
		String gender = user.getGender();
		String country = user.getCountry();
		System.out.println(user.getGender() + " " + user.getCountry());
		String url = "http://apps.who.int/gho/athena/api/GHO/WHOSIS_000001?profile=simple&filter=Year:2015;COUNTRY:"
				+ country + ";SEX:" + gender + ";&format=json";
		Double deathYear = rt.getForObject(url, PeopleResults.class).getPeopleArray().get(0).getDeathAge();
		return deathYear;
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
