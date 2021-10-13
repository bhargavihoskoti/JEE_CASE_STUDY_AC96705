package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.DonationCamp;
import com.example.demo.ifaces.DonationCampRepository;

@Service
public class DonationCampService {
	
	@Autowired
	private DonationCampRepository repo;
	
	public List<DonationCamp> findAll(){
		
		return this.repo.findAll();
	}
	
	public DonationCamp addCamp(DonationCamp entity) {
		
		return this.repo.save(entity);
	}

	public List<DonationCamp> findByCampId(int campId) {
		
		return this.repo.findByCampId(campId);
	}
	public int updateLocation(int campId, String location) {
		// TODO Auto-generated method stub
		return this.repo.updateLocation(campId, location);
	}

	public int remove(int campId) {
		
		int rowDeleted=0;
	    	if(this.repo.existsById(campId)) {
	    	 this.repo.deleteById(campId);
	    	rowDeleted=1;
	    }
	    return	rowDeleted;
	}

	
 

}

