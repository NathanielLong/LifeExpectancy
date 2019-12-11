package co.gc.HeartbeatCountDown.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SessionController {

	
	@Autowired
	HttpSession session;
	
	public ModelAndView createUser(String sex)
	{
		session.setAttribute("sex", sex);
		return null;
	}
}
