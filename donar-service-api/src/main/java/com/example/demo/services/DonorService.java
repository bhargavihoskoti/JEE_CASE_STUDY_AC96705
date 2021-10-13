package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Donor;
import com.example.demo.ifaces.DonorRepository;

@Service
public class DonorService {
	
	@Autowired
	private DonorRepository repo;
	
	public List<Donor> findAll(){
		
		return this.repo.findAll();
	}
	
	public Donor addDonor(Donor entity) {
		
		return this.repo.save(entity);
	}
	

	public List<Donor> findByLocation(String location) {
		
		return this.repo.findByLocation(location);
	}
	
    public List<Donor> findByBloodGrp(String bloodGrp) {
		
		return this.repo.findByBloodGrp(bloodGrp);
	}
	
	public int updateLocation(int regId, String location) {
		int updateRow=0;
		if(this.repo.existsById(regId)) {
			this.repo.updateLocation(regId, location);
			updateRow=1;
		}
		return updateRow;

		 
	}

	public int remove(int regId) {
		
		int rowDeleted=0;
	    	if(this.repo.existsById(regId)) {
	    	 this.repo.deleteById(regId);
	    	rowDeleted=1;
	    }
	    return	rowDeleted;
	}

	
	

}
