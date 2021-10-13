package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.DonationCamp;
import com.example.demo.services.DonationCampService;

@RestController
@RequestMapping(path="/api/v1/camps")
public class DonationCampControllers {
	
	@Autowired
	private DonationCampService service;
	

	@GetMapping
	public List<DonationCamp> findAll(){
		
		return this.service.findAll();
	}
	@GetMapping(path="/srch/{campId}")
	public List<DonationCamp> findByName(@PathVariable("campId") int campId){
		
		return this.service.findByCampId(campId);
	}
	@PutMapping(path="/{campId}/{location}")
	public ResponseEntity<String> updateLocation(@PathVariable("campId") int campId,
			@PathVariable("location") String location){
		int count =this.service.updateLocation(campId, location);
		return ResponseEntity.ok().body(count+":=Records Updated");
	}
	
	@DeleteMapping(path="/{campId}")
	public ResponseEntity<String> removeCamp(@PathVariable("campId") int campId)
			{
		int count =this.service.remove(campId);
		HttpStatus status =HttpStatus.NOT_FOUND;
		String message ="Record Not Found";
		if (count==1) {
			status =HttpStatus.OK;
			message ="One Record Deleted";
			
		}
			
					return ResponseEntity.status(status).body(message);
	}
	
	@PostMapping
	public ResponseEntity<DonationCamp>  add(@RequestBody DonationCamp entity) {
		DonationCamp addedEntity =this.service.addCamp(entity);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(addedEntity);
	}
}

