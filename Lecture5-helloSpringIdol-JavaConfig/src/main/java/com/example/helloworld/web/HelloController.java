package com.example.helloworld.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.helloworld.service.HelloService;
import com.example.springidol.SpringIdol;

@Controller
public class HelloController {
	
	@Autowired
	private HelloService helloSvc;

	@Autowired
	public HelloController(SpringIdol springIdol) {
		springIdol.run();
	}
	
	@RequestMapping("/perform")			// request handler method
	public ModelAndView perform1(			
		@RequestParam("performer") String performerId,
		@RequestParam String requester,
		@RequestParam(required=false, defaultValue="1") int number) {
		
		System.out.println("perform1(" + performerId + ", " + requester + ", " + number + ")");

		String greeting = helloSvc.getGreeting() 
						+ requester + "!" + " I'm " + performerId + '.';

		String result = helloSvc.makePerformance(performerId, number); 
	
		ModelAndView mav = new ModelAndView();
		mav.setViewName("perform");
		mav.addObject("greeting", greeting);
		mav.addObject("performResult", result);
		return mav;
	}
	
	@RequestMapping(value={
			"/performer/{performerId}/requested-by/{requester}",
			"/performer/{performerId}/requested-by/{requester}/{number}"
	})
	public ModelAndView perform2(			
		@PathVariable String performerId,
		@PathVariable String requester,
		@PathVariable(required=false) Integer number) {
		//@PathVariable Optional<Integer> number) {
		
		System.out.println("perform2(" + performerId + ", " + requester + ", " + number + ")");

		String greeting = helloSvc.getGreeting() 
				+ requester + "!" + " I'm " + performerId + '.';

		if (number == null) number = 1;
		String result = helloSvc.makePerformance(performerId, number); 

		ModelAndView mav = new ModelAndView();
		mav.setViewName("perform");
		mav.addObject("greeting", greeting);
		mav.addObject("performResult", result);
		return mav;
	}
	
	@RequestMapping("/performWithCommand")		
	public String perform3(PerformRequest req, Model model) {	// command class 이용		

		System.out.println("perform3(" + req + ")");

		String greeting = helloSvc.getGreeting() 
				+ req.getRequester() + "!" + " I'm " + req.getPerformer() + '.';

		String result = helloSvc.makePerformance(req.getPerformer(), req.getNumber()); 
		
		model.addAttribute("greeting", greeting);
		model.addAttribute("performResult", result);
		return "perform";
	}
}
