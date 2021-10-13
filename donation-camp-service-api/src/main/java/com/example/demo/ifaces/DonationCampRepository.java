package com.example.demo.ifaces;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.DonationCamp;

@Repository
public interface DonationCampRepository extends JpaRepository<DonationCamp, Integer> {
	
   public List<DonationCamp> findByCampId(int campId);
	
	@Query(nativeQuery = true,
			value = "update camp set location =:city where campId=:cmpid")
	@Modifying
	@Transactional
	public int updateLocation(@Param("cmpid") int campId ,@Param("city") String location);
	
	
}
