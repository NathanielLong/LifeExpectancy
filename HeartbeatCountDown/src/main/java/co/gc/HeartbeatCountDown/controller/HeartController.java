package co.gc.HeartbeatCountDown.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import co.gc.HeartbeatCountDown.model.PeopleResults;

@Controller
public class HeartController {

	RestTemplate rt = new RestTemplate();

	@RequestMapping("/")
	public ModelAndView home() {

		//COUNTRY:BWA;Year:2003
		String countryInput = "BWA";
		int yearInput = 2003;
		String testUrl = "http://apps.who.int/gho/athena/api/COUNTRY?format=json";
		PeopleResults response = rt.getForObject("http://apps.who.int/gho/athena/api/GHO/WHOSIS_000001?profile=simple&filter=Year:"+yearInput+";&COUNTRY:"+countryInput+";&format=json", PeopleResults.class);
		int year = response.getPeopleArray().get(0).getpDetails().getYear();
		System.out.println(year);
		String output = "";
		for(int i=0;i<6;i++)
		{
		double die = response.getPeopleArray().get(i).getDeathAge();
		output += "This dude born in " + year + " will die at the age of " + die + ".\n";
		}
		return new ModelAndView("index", "blah", output);

	}
}