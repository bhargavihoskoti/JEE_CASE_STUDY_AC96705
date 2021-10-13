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
@Table(name="camp_details")
@Data
@FieldDefaults(level= AccessLevel.PRIVATE)
public class DonationCamp {
	
	@Id
	@Column(name="id")
	int id;
	
	@Column(name=" campname")
	String campName;
	
	@Column(name="organizername")	
	String organizerName;
	
	@Column(name="fixdate;")
	LocalDate fixDate;
	
	@Column(name="location")
	String location;
	
	
	
	
	
	

}
