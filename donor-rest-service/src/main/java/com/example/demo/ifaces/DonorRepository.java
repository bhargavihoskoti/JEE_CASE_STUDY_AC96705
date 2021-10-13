package com.example.demo.ifaces;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Donor;

@Repository
public interface DonorRepository extends JpaRepository<Donor, Integer> {
	
	public List<Donor> findByDonorName(String srchName);
	
	@Query(nativeQuery = true,
			value="update student set bloodGrp =:bloodgrp where regId=:regid")
	@Modifying
	@Transactional
	public List<Donor> updateMark(@Param("regid") int regId ,@Param("bloodgrp") double bloodGrp);

	
	
	

}
