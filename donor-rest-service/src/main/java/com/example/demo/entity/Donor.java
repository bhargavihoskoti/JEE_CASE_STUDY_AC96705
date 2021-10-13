package com.example.demo.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name="donor_details")
@Data
@FieldDefaults(level =AccessLevel.PRIVATE)
public class Donor {
	@Id
	@Column(name="regid")
	int regId;
	
	@Column(name="donorname")
	String donorName;
	
	@Column(name="bloodgrp")
	String bloodGrp;
	
	@Column(name="phonenumber")
	long phoneNumber;
	
	@Column(name="lastdonoted")
	LocalDate lastDonoted;
	
	@Column(name="city")
	String city;
}
