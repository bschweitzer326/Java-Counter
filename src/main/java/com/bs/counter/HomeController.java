package com.bs.counter;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@RequestMapping("/your_server")
	public String home(HttpSession session) {
		return "your_server.jsp";	
	}
	
	@RequestMapping("/your_server/counter")
	public String counter(HttpSession session) {
		Integer count = (Integer) session.getAttribute("count");
        session.setAttribute("count", count = count + 1);
		return "counter.jsp";
	}
	
	@RequestMapping("/your_server/countertwo")
	public String two(HttpSession session) {
        Integer count = (Integer) session.getAttribute("count");
        session.setAttribute("count", count = count + 2);
//        session.setAttribute("again", count = 0);
		return "two.jsp";
	}
	
	@RequestMapping("/reset")
	public String reset(HttpSession session) {
        session.setAttribute("count", 0);
        return "redirect:/your_server";
	}

}
