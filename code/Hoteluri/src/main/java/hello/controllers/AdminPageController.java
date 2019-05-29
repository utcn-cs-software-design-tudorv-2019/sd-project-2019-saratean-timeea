package hello.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import hello.entities.Room;

@Controller
public class AdminPageController {

	@RequestMapping(value ="/roomCreate", method = RequestMethod.GET)
	 public ModelAndView adminChoice1() {
		System.out.println("9");
			return new ModelAndView("roomform1","command",new Room());
		}
	@RequestMapping(value ="/roomDelete", method = RequestMethod.GET)
	 public ModelAndView adminChoice12() {
		System.out.println("9");
			return new ModelAndView("roomform2","command",new Room());
		}
	@RequestMapping(value ="/roomUpdate", method = RequestMethod.GET)
	 public ModelAndView adminChoice13() {
		System.out.println("9");
			return new ModelAndView("roomform3","command",new Room());
		}
	@RequestMapping(value ="/roomRead", method = RequestMethod.GET)
	 public ModelAndView adminChoice14() {
		System.out.println("9");
			return new ModelAndView("roomform4","command",new Room());
		}
}
