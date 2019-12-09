package co.gc.HeartbeatCountDown.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FormController {
	
	@RequestMapping("/")
	public ModelAndView userName() {

		String nameString = "<form action=\"/date\"> Name: <input type = \"text\" name = \"name\"></input> <input type=\"submit\" Value=\"Begin.\" class = \"btn btn-primary\"></input> </form>";
		return new ModelAndView("form", "formtype", nameString);
	}

	@RequestMapping("/date")
	public ModelAndView dateOfBirth(String userName) {

		//add userName to table
		String dateString = "<form action=\"/smoke\"> Date: <input type = \"text\" name = \"dateOfBirth\"></input> <input type=\"submit\" Value=\"Enter.\" class = \"btn btn-primary\"></input> </form>";
		return new ModelAndView("form", "formtype", dateString);
	}

	@RequestMapping("/smoke")
	public ModelAndView smoke(String dob) {

		
		String smokeString = "<form action=\"/gender\"> Smoke: <input type = \"text\" name = \"smoke\"></input> <input type=\"submit\" Value=\"Enter.\" class = \"btn btn-primary\"></input> </form>";
		System.out.println("test");
		return new ModelAndView("form", "formtype", smokeString);
	}
	
	@RequestMapping("start-form/gender")
	public ModelAndView gender(String smoke) {

		String genderString = "<form action=\"start-form/country\"> Name: <input type = \"text\" name = \"name\"></input> <input type=\"submit\" Value=\"Begin.\" class = \"btn btn-primary\"></input> </form>";
		return new ModelAndView("form", "formtype", genderString);
	}
	
	@RequestMapping("start-form/country")
	public ModelAndView country(String gender) {

		String countryString = "<form action=\"start-form/alcohol\"> Name: <input type = \"text\" name = \"name\"></input> <input type=\"submit\" Value=\"Begin.\" class = \"btn btn-primary\"></input> </form>";
		return new ModelAndView("form", "formtype", countryString);
	}
	
	@RequestMapping("start-form/alcohol")
	public ModelAndView alcohol(String country) {

		String alcoholString = "<form action=\"start-form/education\"> Name: <input type = \"text\" name = \"name\"></input> <input type=\"submit\" Value=\"Begin.\" class = \"btn btn-primary\"></input> </form>";
		return new ModelAndView("form", "formtype", alcoholString);
	}
	
	@RequestMapping("start-form/education")
	public ModelAndView education(String alc) {

		String educationString = "<form action=\"start-form/ethnicity\"> Name: <input type = \"text\" name = \"name\"></input> <input type=\"submit\" Value=\"Begin.\" class = \"btn btn-primary\"></input> </form>";
		return new ModelAndView("form", "formtype", educationString);
	}
	
	@RequestMapping("start-form/ethnicity")
	public ModelAndView ethnicity(String edu) {

		String ethnicityString = "<form action=\"start-form/income\"> Name: <input type = \"text\" name = \"name\"></input> <input type=\"submit\" Value=\"Begin.\" class = \"btn btn-primary\"></input> </form>";
		return new ModelAndView("form", "formtype", ethnicityString);
	}
	
	@RequestMapping("start-form/income")
	public ModelAndView income(String eth) {

		String incomeString = "<form action=\"start-form/fmh\"> Name: <input type = \"text\" name = \"name\"></input> <input type=\"submit\" Value=\"Begin.\" class = \"btn btn-primary\"></input> </form>";
		return new ModelAndView("form", "formtype", incomeString);
	}
	
	@RequestMapping("start-form/fmh")
	public ModelAndView familyMedicalHistory(String inc) {

		String fmhString = "<form action=\"start-form/illness\"> Name: <input type = \"text\" name = \"name\"></input> <input type=\"submit\" Value=\"Begin.\" class = \"btn btn-primary\"></input> </form>";
		return new ModelAndView("form", "formtype", fmhString);
	}
	
	@RequestMapping("start-form/illness")
	public ModelAndView currentIllness(String fmh) {

		String currentillnessString = "<form action=\"results\"> Name: <input type = \"text\" name = \"name\"></input> <input type=\"submit\" Value=\"Begin.\" class = \"btn btn-primary\"></input> </form>";
		return new ModelAndView("form", "formtype", currentillnessString);
	}
	//gotta ad ill to database
}
