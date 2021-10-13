package com.example.demo.dto;

import java.time.LocalDate;



import org.springframework.stereotype.Component;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Component
@FieldDefaults(level= AccessLevel.PRIVATE)
public class Donor {
	
	int regId;
	String donorName;
	String bloodGrp;
	
	long phoneNumber;
	@DateTimeFormat(iso=ISO.DATE)
	LocalDate lastDonated;
	String location;

	int campId;

}
