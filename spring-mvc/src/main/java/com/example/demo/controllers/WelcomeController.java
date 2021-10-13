package com.example.demo.controllers;

import java.util.Arrays;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dto.Donor;


@Controller
public class WelcomeController {
	
	@Autowired
	private Donor object;
	
	@Autowired
	private RestTemplate template;
	
	@Autowired
	private ModelAndView mdlView;
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String init(Model model) {
		//model
		model.addAttribute("majHeading","Red Cross Blood Bank");
		//view
		return "index";
	}
	
	@GetMapping(path="/addDonor")
	public String sendForm(Model model) {
		
		model.addAttribute("command",object);
		return "addDonor";
	}

	@PostMapping(path="/addDonor")
	public String submitForm(@Valid @ModelAttribute("command") Donor donor,BindingResult result) {
		
		String nextStep="success";
		
		//this.template.postForObject("http://localhost:6060/api/v1/students", student, Student.class);
		
		if(result.hasErrors()) {
			nextStep= "addDonor";
		}else {
			HttpHeaders headers=new HttpHeaders();
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			headers.setContentType(MediaType.APPLICATION_JSON);
			
			HttpEntity<Donor> requestBody = new HttpEntity<>(donor,headers);
			template.postForObject("http://localhost:1010/api/v1/donors",requestBody,Donor.class);
		}
			return nextStep;
		
		
	}
	@GetMapping(path = "/getAllDonors")
	public String findAll(Model model) {

	Donor[] resp =template.getForObject("http://localhost:1010/api/v1/donors",
	Donor[].class);

	model.addAttribute("data",resp);
	return "showall";

	}
}


