package com.example.demo.ifaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.DonationCamp;

@Repository
public interface DonationCampRepository extends JpaRepository<DonationCamp, Integer> {

}
