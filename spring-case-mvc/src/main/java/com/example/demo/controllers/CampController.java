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
import org.springframework.web.client.RestTemplate;

import com.example.demo.dto.DonationCamp;


@Controller
public class CampController {
	@Autowired
	private DonationCamp object;
	
	@Autowired
	private RestTemplate template;
	
	@GetMapping(path="/addCamp")
	public String sendFormCamp(Model model) {
		
		model.addAttribute("command",object);
		return "addCamp";
	}
	
	@PostMapping(path="/addCamp")
	public String submitForm(@Valid @ModelAttribute("command") DonationCamp camp,BindingResult result) {
		
		String nextStep="successCamp";
		
		
		if(result.hasErrors()) {
			nextStep= "addCamp";
		}else {
			HttpHeaders headers=new HttpHeaders();
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			headers.setContentType(MediaType.APPLICATION_JSON);
			
			HttpEntity<DonationCamp> requestBody = new HttpEntity<>(camp,headers);
			template.postForObject("http://localhost:2020/api/v1/camps",requestBody,DonationCamp.class);
		}
			return nextStep;
		
		
	}

	@GetMapping(path = "/getAllCamps")
	public String findAllCamp(Model model) {

	DonationCamp[] resp =template.getForObject("http://localhost:2020/api/v1/camps",
	DonationCamp[].class);

	model.addAttribute("data",resp);
	return "showCamps";

	}

	
	
	

}
