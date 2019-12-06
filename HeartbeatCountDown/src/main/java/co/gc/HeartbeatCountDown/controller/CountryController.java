package co.gc.HeartbeatCountDown.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import co.gc.HeartbeatCountDown.CountryRepo.CountryRepo;
import co.gc.HeartbeatCountDown.countriesmodel.Country;
import co.gc.HeartbeatCountDown.countriesmodel.CountryResults;

@Controller
public class CountryController {

	
	@Autowired
	CountryRepo cRepo;
	
	RestTemplate rt = new RestTemplate();
	
	@RequestMapping("/")
	public ModelAndView createTables()
	{
		String testUrl = "http://apps.who.int/gho/athena/api/COUNTRY?format=json";
		ArrayList<Country> countryList =rt.getForObject(testUrl, CountryResults.class).getDimension().get(0).getCode();		
		for(Country c: countryList)
		{
			cRepo.save(c);
			
		}
		
		return new ModelAndView("index");
	}
	
}
