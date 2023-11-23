package com.spring.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import com.spring.pojo.*;
import com.spring.dao.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class DoorController {
	
	DoorDao doorDao = new DoorDao();
	
	@RequestMapping(value = "/doors/{id}", method=RequestMethod.GET)
	
	public ModelAndView doorPageByID (@PathVariable int id) throws SQLException, IOException {
		ModelAndView mav = new ModelAndView("single-door");
		
		Door door = doorDao.getById(id);
		
		if (door == null) {
			ModelAndView mavError = new ModelAndView("errorPage");
			return mavError;
		}
		mav.addObject("door", door);
		
		return mav;
		
	}

	@GetMapping("/doors")
	public ModelAndView getAllDoors() throws SQLException {
		ModelAndView mav = new ModelAndView();
		
		ArrayList<Door> doors = doorDao.getAllDoors();
		System.out.println("Doors size is:" + doors.size());
		
		mav.addObject("doors", doors);

		mav.setViewName(doors.isEmpty() ? "dbErrorPage" : "doors");
		
		return mav;
	}
	
	@GetMapping("/doors/create")
	public ModelAndView createDoor() {
		return new ModelAndView("addDoor");
	}
	
	//RedirectView 
	@PostMapping("/doors/create")
	public RedirectView createNewDoor(@RequestParam String material, @RequestParam double height, @RequestParam double width, @RequestParam LocalDate installationDate) throws SQLException {
		Door door = new Door(material, height, width, installationDate);
		
		doorDao.insertDoor(door);
		
		return new RedirectView("/doors", true);
	}

	@GetMapping("/doors/delete")
	public ModelAndView deleteDoor() {
		ModelAndView mav = new ModelAndView("deleteDoor");
		return mav;
	}

	
	@PostMapping("/doors/delete")
	public ModelAndView deleteDoor(@RequestParam int id) throws SQLException, IOException {
		ModelAndView mav = new ModelAndView("redirect:/doors");
		
		Door toBeDeleted = doorDao.getById(id);
		if( toBeDeleted != null) {
			doorDao.deleteDoor(id);
		}
		
		return mav;
	}
	
	@GetMapping("/doors/update")
	public ModelAndView updateDoor() {
		return new ModelAndView("updateDoor");
	}
	
	@PostMapping("/doors/update")
	public ModelAndView updateDoor(@RequestParam int id, @RequestParam String material, @RequestParam double height,
			 @RequestParam double width,  @RequestParam LocalDate installationDate) throws SQLException, IOException {
		ModelAndView mav = new ModelAndView("redirect:/doors");
		System.out.println("id ul este: " + id);
		Door toBeUpdated = doorDao.getById(id);
		if (toBeUpdated != null) {
			doorDao.updateDoor(new Door(id, material, height, width, installationDate));
		}
		
		return mav;
	}
	
}
