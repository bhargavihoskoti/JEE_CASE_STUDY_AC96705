package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Donor;
import com.example.demo.ifaces.DonorRepository;

@Service
public class Donorservice {
	
	@Autowired
	private DonorRepository repo;
	
	public List<Donor> findAll(){
		
		return this.repo.findAll();
	}
	
	public Donor add(Donor entity) {
		
		return this.repo.save(entity);
	}
	
	

}
