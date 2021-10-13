package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.DonationCamp;
import com.example.demo.services.DonationCampServices;

@RestController
@RequestMapping(path="/api/v1/donationcamp")
public class DonationCampController {
	
private DonationCampServices service;
	
	@Autowired
	public void setService(DonationCampServices service) {
		this.service=service;
	}

	@GetMapping
	public List<DonationCamp> findAll(){
		
		return this.service.findAll();
	}
	
	@PostMapping
	public ResponseEntity<DonationCamp>  add(@RequestBody DonationCamp entity) {
		DonationCamp addedEntity =this.service.addCamp(entity);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(addedEntity);
	}
}
