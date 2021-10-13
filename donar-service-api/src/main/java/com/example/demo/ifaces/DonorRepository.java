package com.example.demo.ifaces;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Donor;

@Repository
public interface DonorRepository extends JpaRepository<Donor, Integer> {
	
  public List<Donor> findByLocation(String location);
  
  public List<Donor> findByBloodGrp(String bloodGrp);
	
	@Query(nativeQuery = true,
			value = "update donor set location =:location where regId=:regId")
	@Modifying
	@Transactional
	public int updateLocation(@Param("regId") int regId ,@Param("location") String location);
	
	
	

}
