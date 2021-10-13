package com.example.demo.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="donor")
public class Donor {
	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "regid_seq")
//	@SequenceGenerator(name="regid_seq", sequenceName = "regid_seq", initialValue = 100)
	@Column(name="regid")
	int regId;
	
	@Column(name="donorname")
	String donorName;
	
	@Column(name="bloodgrp")
	String bloodGrp;
	
	@Column(name="phonenumber")
	long phoneNumber;
	
	@Column(name="lastdonated")
	LocalDate lastDonated;
	
	
	@Column(name="location")
	String location;
	
	
	@Column(name="campid")
	int campId;
}
