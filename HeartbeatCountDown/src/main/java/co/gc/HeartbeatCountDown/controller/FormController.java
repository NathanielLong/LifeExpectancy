package co.gc.HeartbeatCountDown.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import co.gc.HeartbeatCountDown.CountryRepo.CountryRepo;
import co.gc.HeartbeatCountDown.countriesmodel.Country;

@Controller
public class FormController {

	@Autowired
	CountryRepo cRepo;
	
	@RequestMapping("/")
	public ModelAndView userName() {
		return new ModelAndView("index");
	}

	@RequestMapping("/date")
	public ModelAndView dateOfBirth(String userName) {
		return new ModelAndView("date-of-birth");
	}

	@RequestMapping("/smoke")
	public ModelAndView smoke(String dob) {
		return new ModelAndView("smoke");
	}

	@RequestMapping("/gender")
	public ModelAndView gender(String smoke) {
		return new ModelAndView("gender");
	}

	@RequestMapping("/country")
	public ModelAndView country(String gender) {

		ArrayList<Country> boogaloo = (ArrayList<Country>) cRepo.findAll();
//		boogaloo.get(0).getDisplay();

		return new ModelAndView("country", "countries", boogaloo);
	}

	@RequestMapping("start-form/alcohol")
	public ModelAndView alcohol(String country) {

		String alcoholString = "<form action=\"education\"> Name: <input type = \"text\" name = \"name\"></input> <input type=\"submit\" Value=\"Begin.\" class = \"btn btn-primary\"></input> </form>";
		return new ModelAndView("form", "formtype", alcoholString);
	}

	@RequestMapping("start-form/education")
	public ModelAndView education(String alc) {

		String educationString = "<form action=\"/ethnicity\"> Name: <input type = \"text\" name = \"name\"></input> <input type=\"submit\" Value=\"Begin.\" class = \"btn btn-primary\"></input> </form>";
		return new ModelAndView("form", "formtype", educationString);
	}

	@RequestMapping("start-form/ethnicity")
	public ModelAndView ethnicity(String edu) {

		String ethnicityString = "<form action=\"/income\"> Name: <input type = \"text\" name = \"name\"></input> <input type=\"submit\" Value=\"Begin.\" class = \"btn btn-primary\"></input> </form>";
		return new ModelAndView("form", "formtype", ethnicityString);
	}

	@RequestMapping("start-form/income")
	public ModelAndView income(String eth) {

		String incomeString = "<form action=\"/fmh\"> Name: <input type = \"text\" name = \"name\"></input> <input type=\"submit\" Value=\"Begin.\" class = \"btn btn-primary\"></input> </form>";
		return new ModelAndView("form", "formtype", incomeString);
	}

	@RequestMapping("start-form/fmh")
	public ModelAndView familyMedicalHistory(String inc) {

		String fmhString = "<form action=\"/illness\"> Name: <input type = \"text\" name = \"name\"></input> <input type=\"submit\" Value=\"Begin.\" class = \"btn btn-primary\"></input> </form>";
		return new ModelAndView("form", "formtype", fmhString);
	}

	@RequestMapping("start-form/illness")
	public ModelAndView currentIllness(String fmh) {

		String currentillnessString = "<form action=\"/results\"> Name: <input type = \"text\" name = \"name\"></input> <input type=\"submit\" Value=\"Begin.\" class = \"btn btn-primary\"></input> </form>";
		return new ModelAndView("form", "formtype", currentillnessString);
	}
	// gotta ad ill to database
}
