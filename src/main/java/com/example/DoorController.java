package com.example;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DoorController {
	
	DoorDao doorDao = new DoorDao();
	
	@RequestMapping(value = "/doors/{id}", method=RequestMethod.GET)
	
	public ModelAndView doorPageByID (@PathVariable int id) throws SQLException, IOException {
		System.out.println("id-ul este : " + id);
		
		int totalDoors = doorDao.getTotalDoors();
		
		if (id > totalDoors) {
			ModelAndView mavError = new ModelAndView("errorPage");
			return mavError;
		}
		
		ModelAndView mav = new ModelAndView("single-door");
		Door door = doorDao.getById(id);
		mav.addObject("door", door);
		
		return mav;
		
	}


	@GetMapping("/doors")
	 ModelAndView getAllDoors() throws SQLException {
		ModelAndView mav = new ModelAndView();
		
		ArrayList<Door> doors = doorDao.getAllDoors();
		System.out.println("Doors size is:" + doors.size());
		
		mav.addObject("doors", doors);

		mav.setViewName(doors.isEmpty() ? "dbErrorPage" : "doors");
		
		return mav;
	}
}
