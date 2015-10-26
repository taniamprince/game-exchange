package edu.osu.cse5234.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/about")
public class About {
	@RequestMapping(method = RequestMethod.GET)
	public String viewHomePage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "About";
	}
}
