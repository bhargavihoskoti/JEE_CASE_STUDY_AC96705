package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.DonationCamp;
import com.example.demo.ifaces.DonationCampRepository;

@Service
public class DonationCampServices {
	
	@Autowired
	private DonationCampRepository repo;
	
	public List<DonationCamp> findAll(){
		
		return this.repo.findAll();
	}
	
	public DonationCamp addCamp(DonationCamp entity) {
		
		return this.repo.save(entity);
	}

}
