package hello.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import externalServices.MailService;
import hello.dataAccess.ProfileAccess;
import hello.dataAccess.RoomAccess;
import hello.dataAccess.UserAccess;
import hello.entities.Profile;
import hello.entities.Room;
import hello.entities.User;

@Controller
public class LoginController {
	@Autowired
	private UserAccess userAccess;
	
	@Autowired
	private RoomAccess roomAccess;
	
	@Autowired
	private ProfileAccess profileAccess;
	private int userID;
	
	@RequestMapping(value = "/loginForm", method = RequestMethod.GET)
	public ModelAndView loginForm() {
		return new ModelAndView("loginform", "command", new User());
	}
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("SpringWeb") User user, ModelMap model) {
		int result = userAccess.loginUser(user.getName(), user.getPassword());
		System.out.println(user.getName() + user.getPassword());
		if (result == 1) {

			return new ModelAndView("home");
		} else if (result == 0) {
			List<Room> rooms=roomAccess.getAll();
			model.addAttribute("rooms",rooms);
			return new ModelAndView("home2", "command", new User());
		} else {
			return new ModelAndView("registerform");
		}
	}
	
	

	@RequestMapping(value = "/registerForm", method = RequestMethod.GET)
	public ModelAndView registerForm() {
		return new ModelAndView("registerform", "command", new User());
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView addUser(@ModelAttribute("SpringWeb") User user, ModelMap model) {
		model.addAttribute("user", user);

		userID = userAccess.addUser(user.getName(), user.getPassword());
		return new ModelAndView("profileform", "command", new Profile());
	}

	@RequestMapping(value = "/profileForm", method = RequestMethod.GET)
	public ModelAndView profileForm() {
		return new ModelAndView("profileform", "command", new Profile());
	}

	@RequestMapping(value = "/profile", method = RequestMethod.POST)
	public ModelAndView addProfile(@ModelAttribute("SpringWeb") Profile profile, ModelMap model) {
		model.addAttribute("profile", profile);

		profile.setId(userID);
		String p=profile.getEmail();
		MailService mailService = new MailService("timisarateannn@gmail.com","steaua2586");
		mailService.sendMail(p,"Validation","Your account has been created!");
		profileAccess.updateProfile(profile);
		return new ModelAndView("loginform", "command", new User());
	}
}
