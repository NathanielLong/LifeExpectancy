package co.gc.HeartbeatCountDown.controller;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import co.gc.HeartbeatCountDown.CountryRepo.CountryRepo;
import co.gc.HeartbeatCountDown.countriesmodel.Country;
import co.gc.HeartbeatCountDown.model.User;

@Controller
public class FormController {

	@Autowired
	HttpSession session;
	
	@Autowired
	CountryRepo cRepo;
	
	User user = new User();
	
	@RequestMapping("/")
	public ModelAndView userName() {
		return new ModelAndView("index");
	}

	@RequestMapping("/date")
	public ModelAndView dateOfBirth(String userName) {
		user.setUserName(userName);
		session.setAttribute("user", user);
		System.out.println(user.getUserName());
		
		return new ModelAndView("date-of-birth");
	}

	@RequestMapping("/smoke")
	public ModelAndView smoke(String borned) {
		LocalDate date = LocalDate.parse(borned);
		User user = (User)(session.getAttribute("user"));
		user.setDob(date);
		session.setAttribute("user", user);
		return new ModelAndView("smoke");
	}

	@RequestMapping("/gender")
	public ModelAndView gender(String smoke, Integer amount, Integer years, Integer number, String stillsmokin) {
		user = (User)(session.getAttribute("user"));
//		StatisticsModels.StatisticsModels.smokingBeatsReduced(amount, years);
		
		session.setAttribute("user", user);
		System.out.println(smoke + amount + " " + years + stillsmokin);
		return new ModelAndView("gender");
	}

	
	@RequestMapping("/country")
	public ModelAndView country(String gender) {
		
		user = (User)(session.getAttribute("user"));
		user.setGender(gender);
		session.setAttribute("user", user);
		ArrayList<Country> boogaloo = (ArrayList<Country>) cRepo.findAll();
//		boogaloo.get(0).getDisplay();

		return new ModelAndView("country", "countries", boogaloo);
	}

	@RequestMapping("/alcohol")
	public ModelAndView alcohol(String country) {
		user = (User)(session.getAttribute("user"));
		user.setCountry(country);
		session.setAttribute("user", user);
		
		return new ModelAndView("alcohol");
	}

	@RequestMapping("/bmi")
	public ModelAndView bmi(String yesno) {
		return new ModelAndView("bmi");
	}
	@RequestMapping("/income")
	public ModelAndView income(int height, int weight) {
		
		return new ModelAndView("income");
	}
	
	
	@RequestMapping("/ethnicity")
	public ModelAndView ethnicity(int income) {
		User user = (User)(session.getAttribute("user"));
		user.setIncome(income);
		session.setAttribute("user", user);
		return new ModelAndView("ethnicity");
		
	}
	

	

	@RequestMapping("/results")
	public ModelAndView goToResults(String ethnicity) {
		User user = (User)(session.getAttribute("user"));
		user.setEthnicity(ethnicity);
		session.setAttribute("user", user);
		System.out.println(user.getAlcohol() + " " + user.getCountry() + " " + user.getDob() + " " + user.getStillSmokin() + user.getSmoke() + user.getNumber() + user.getYears() + " " + user.getEthnicity() + " " + user.getGender() + " " + user.getSmoke() + " " + user.getUserName() + " ");
		return new ModelAndView("results");
	}

	
	@RequestMapping("/scrooge")
	public ModelAndView scrooge() {
		return new ModelAndView("scrooge");
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
