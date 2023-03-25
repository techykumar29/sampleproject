package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api")
public class MyController {
	
	public MyController()
	{
		System.out.println("Controller scanned.");
	}
	
	@RequestMapping(value = "/test",method = RequestMethod.GET)
	public String test() {
		return "index";
	}
	
	@ResponseBody
	@RequestMapping(value = "/test1",method = RequestMethod.GET)
	public String test1() {
		return "Application is working fine, Go ahead.";
	}

}
