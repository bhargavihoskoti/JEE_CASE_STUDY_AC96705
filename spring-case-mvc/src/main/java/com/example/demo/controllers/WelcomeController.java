package com.example.demo.controllers;

import java.util.Arrays;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	//Search by Location
	
	@GetMapping(path="/searchByLoc")
	public String sendForm2(Model model)
	{

	model.addAttribute("data",object);
	return "searchByLoc";

	}
	@GetMapping(path = "/getDonorByLoc")
	public String findByLoc(@RequestParam("location") String location, Model model) {

	Donor[] resp =template.getForObject("http://localhost:1010/api/v1/donors/srch/"+location,
	Donor[].class);

	model.addAttribute("data",resp);
	
	return "showall";

	}
	
	//Search by Blood Group
	
	@GetMapping(path="/searchByBloodGroup")
	public String sendFormBlood(Model model)
	{

	model.addAttribute("data",object);
	return "searchByBloodGroup";

	}
	
	@GetMapping(path = "/getDonorByBloodGroup")
	public String findByBloodGroup(@Valid @RequestParam("bloodGrp") String bloodGrp, Model model) {

	Donor[] resp =template.getForObject("http://localhost:1010/api/v1/donors/srchby/"+bloodGrp,
	Donor[].class);

	model.addAttribute("data",resp);
	
	return "showall";

	}
	
	
	//Delete Method
	
	@GetMapping(path="/deleteById")
	public String sendForm3(Model model) {
	model.addAttribute("data",object);
	return "deleteById";
	}
	@RequestMapping(path = "/deleteDonorById")
	public ResponseEntity<String> deleteDonorById(@RequestParam("regId") int regId, Model model) {

	HttpHeaders headers = new HttpHeaders();
	headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	headers.setContentType(MediaType.APPLICATION_JSON);

	HttpEntity<Donor> requestBody = new HttpEntity<>( headers);
	ResponseEntity<String> resp = template.exchange("http://localhost:1010/api/v1/donors/"+regId, HttpMethod.DELETE, requestBody, String.class);
	if(resp.getBody().contains("One Record Deleted")) {
	return ResponseEntity.ok().body("One Donor Deleted");
	}
	else {
	return ResponseEntity.status(HttpStatus.NOT_FOUND).body("404 Record Not Found");
	}

	}
	
	//Update the location by RegId
	
	@GetMapping(path="/updateById")
	public String sendForm4(Model model) {
	model.addAttribute("data",object);
	return "updateById";
	}
	@RequestMapping(path = "/updateDonorById")
	public ResponseEntity<String> updateDonorById(@RequestParam("regId") int regId,@RequestParam("location") String location, Model model) {

	HttpHeaders headers = new HttpHeaders();
	headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	headers.setContentType(MediaType.APPLICATION_JSON);

	HttpEntity<Donor> requestBody = new HttpEntity<>( headers);
	ResponseEntity<String> resp = template.exchange("http://localhost:1010/api/v1/donors/"+regId+"/"+location, HttpMethod.PUT, requestBody, String.class);
	if(resp.getBody().contains("One Record Updated")) {
		return ResponseEntity.ok().body("One Donor Updated");
		}
		else {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("404 Record Not Found");
		}

	}
	
}


