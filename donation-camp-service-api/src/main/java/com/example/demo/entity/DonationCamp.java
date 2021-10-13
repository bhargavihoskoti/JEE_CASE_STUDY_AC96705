package com.example.demo.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="camp")
public class DonationCamp {
	
	@Id
	@Column(name="campid")
	int campId;
	@Column(name="campname")
	String campName;
	@Column(name="organizername")
	String organizerName;
	@Column(name="location")
	String location;
	@Column(name="conductdate")
	LocalDate conductDate;
		

}