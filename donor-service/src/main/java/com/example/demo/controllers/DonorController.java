package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Donor;
import com.example.demo.services.Donorservice;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping(path="/api/v1")
public class DonorController {
	
	@Autowired
	private Donorservice service;
	
	@GetMapping(path="/donors")
	public List<Donor> getAll(){
		return this.service.findAll();
	}
	
	@PostMapping(path="/donors")
	public Donor add(@RequestBody Donor entity) {
		return this.service.add(entity);
	}

}