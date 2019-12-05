package co.gc.HeartbeatCountDown;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TylerHomeController {

	RestTemplate rt = new RestTemplate();

	@RequestMapping("/")
	public ModelAndView home() {

		String response = rt.getForObject("http://apps.who.int/gho/athena/api/GHO/WHOSIS_000001?filter=COUNTRY:BWA;Year:2003", String.class);
		System.out.println(response);

		return new ModelAndView("index", "blah", "blah");

	}
}
