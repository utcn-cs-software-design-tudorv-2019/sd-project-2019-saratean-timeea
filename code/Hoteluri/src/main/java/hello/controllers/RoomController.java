package hello.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import hello.dataAccess.RoomAccess;
import hello.entities.Room;

@Controller
public class RoomController {
	@Autowired
	private RoomAccess roomAccess;
	
	@RequestMapping(value = "/createRoom", method = RequestMethod.POST)
	public ModelAndView createHotelForm(@ModelAttribute("SpringWeb")Room room,
			ModelMap model) {
		model.addAttribute("room",room);
		roomAccess.addRoom(room);
		System.out.println("2");
		return new ModelAndView("home");
	}
	@RequestMapping(value = "/deleteRoom", method = RequestMethod.POST)
	public ModelAndView deleteHotelForm(@ModelAttribute("SpringWeb")Room room,
			ModelMap model) {
		model.addAttribute("room",room);
		roomAccess.deleteRoom(room.getNumber());
		System.out.println("2");
		return new ModelAndView("home");
	}
	@RequestMapping(value = "/updateRoom", method = RequestMethod.POST)
	public ModelAndView updateHotelForm(@ModelAttribute("SpringWeb")Room room,
			ModelMap model) {
		model.addAttribute("room",room);
		roomAccess.updateRoom(room);
		System.out.println("2");
		return new ModelAndView("home");
	}
	@RequestMapping(value = "/readRoom", method = RequestMethod.POST)
	public ModelAndView readHotelForm(@ModelAttribute("SpringWeb")Room room,
			ModelMap model) {
		model.addAttribute("room",room);
		Room hot =roomAccess.getRoom(room.getNumber());
		model.addAttribute("hot",hot);
		System.out.println("2");
		return new ModelAndView("showroom","command",hot);
	}
	@RequestMapping(value = "/deleteRoom2", method = RequestMethod.POST)
	public ModelAndView deleteOfferForm2(@ModelAttribute("SpringWeb")Room room,
			ModelMap model) {
		model.addAttribute("room",room);
		roomAccess.deleteRoom(room.getNumber());
		System.out.println(room.getNumber());
		List<Room> rooms=roomAccess.getAll();
		model.addAttribute("rooms",rooms);
		System.out.println("2");
		return new ModelAndView("home2");
	}
}
