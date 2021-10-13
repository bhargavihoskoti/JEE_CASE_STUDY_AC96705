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

import com.example.demo.entity.Donor;
import com.example.demo.services.DonorService;

@RestController
@RequestMapping(path="/api/v1/donors")
public class DonorController {
	
	@Autowired
	private DonorService service;
	
	@GetMapping
	public List<Donor> getAll(){
		return this.service.findAll();
	}
	
	@GetMapping(path="/srch/{location}")
	public List<Donor> findByLocation(@PathVariable("location") String location){
		
		return this.service.findByLocation(location);
	}
	
	@GetMapping(path="/srchby/{bloodGrp}")
	public List<Donor> findByBloodGrp(@PathVariable("bloodGrp") String bloodGrp){
		
		return this.service.findByBloodGrp(bloodGrp);
	}
	
	@PutMapping(path="/{regId}/{location}")
	public ResponseEntity<String> updateLocation(@PathVariable("regId") int regId,
			@PathVariable("location") String location)
	{
		int count =this.service.updateLocation(regId, location);
		HttpStatus status=HttpStatus.NOT_FOUND;
		String message= "Record Not Found";
		if(count==1) {
			status=HttpStatus.OK;
			message="One Record Updated";
		}
		
		return ResponseEntity.status(status).body(message);
	
	}
	
	@DeleteMapping(path="/{donorId}")
	public ResponseEntity<String> removeDonor(@PathVariable("donorId") int donorId)
			{
		int count =this.service.remove(donorId);
		HttpStatus status =HttpStatus.NOT_FOUND;
		String message ="Record Not Found";
		if (count==1) {
			status =HttpStatus.OK;
			message ="One Record Deleted";
			
		}
			
					return ResponseEntity.status(status).body(message);
	}
	
	
	@PostMapping
	public ResponseEntity<Donor>  add(@RequestBody Donor entity) {
		Donor addedEntity =this.service.addDonor(entity);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(addedEntity);
	}
}

