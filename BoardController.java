package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {
	
	@Autowired
	HttpSession session;
	
	@RequestMapping
	public String index() {
		session.invalidate();
		return "board";
	}
	
	@RequestMapping(value="/apply", method=RequestMethod.POST)
	public ModelAndView apply(
		@RequestParam("name") String name,
		@RequestParam("contents") String contents,
		@RequestParam("mood") String mood,
		ModelAndView mv
		) {
		@SuppressWarnings("unchecked")
		List<Record> allContents = (List<Record>)session.getAttribute("contentsList");
		if(allContents == null) {
			allContents = new ArrayList<>();
			session.setAttribute("contentsList", allContents);
		}
		
		
		
		allContents.add(new Record(name, contents, mood));
		
		mv.addObject("allContents", allContents);
		
		mv.setViewName("board");
		return mv;
	}


}
