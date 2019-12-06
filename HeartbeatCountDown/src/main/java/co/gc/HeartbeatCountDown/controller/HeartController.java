package co.gc.HeartbeatCountDown.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import co.gc.HeartbeatCountDown.model.PeopleResults;
import co.gc.HeartbeatCountDown.model.Person;

@Controller
public class HeartController {

	RestTemplate rt = new RestTemplate();

//	@RequestMapping("/")
	public ModelAndView home() {

		//COUNTRY:BWA;Year:2003
		String countryInput = "BWA";
		int yearInput = 2015;
		String testUrl = "http://apps.who.int/gho/athena/api/COUNTRY?format=json";
		PeopleResults response = rt.getForObject("http://apps.who.int/gho/athena/api/GHO/WHOSIS_000001?profile=simple&filter=Year:"+yearInput+";&COUNTRY:"+countryInput+";&format=json", PeopleResults.class);
		String year = response.getPeopleArray().get(0).getpDetails().getSex();
		System.out.println(year);
		String output = "";
		for(int i=0;i<response.getPeopleArray().size();i++)
		{
		double die = response.getPeopleArray().get(i).getDeathAge();
		output += "According life expectancy from the year of " + year + ",  will die at the age of " + die + ".\n";
		}
		return new ModelAndView("index", "toString", output);
		
	}
	@RequestMapping("start-form")
	public ModelAndView creatForm(String name)
	{
		
		return new ModelAndView("form","name", name);
	}
	
	@RequestMapping("results-page")
	public ModelAndView heartCountdown(int dob, String smoke, String gender, String country)
	{
		
		String url = "http://apps.who.int/gho/athena/api/GHO/WHOSIS_000001?profile=simple&format=json&filter=Year:2015;&COUNTRY:"+country+"&SEX="+gender;
		PeopleResults response = rt.getForObject(url, PeopleResults.class);
		Person sample = response.getPeopleArray().get(0);
		double death= sample.getDeathAge();
		if(smoke.equalsIgnoreCase("y"))
			death=death-6.5;
		String out = "As a " +dob+" year old " + sample.getpDetails().getSex() + " from "
			+ sample.getpDetails().getCountry()+", you have " + ((double)death-dob) + "years left";
		return new ModelAndView("results", "math", out);
	}
}