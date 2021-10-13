package com.example.demo.dto;

import java.time.LocalDate;



import org.springframework.stereotype.Component;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Component
@FieldDefaults(level= AccessLevel.PRIVATE)
public class Donor {

	@Length(max=4)
	int regId;
	String donorName;
	
	String bloodGrp;
	@Length(min=10,max=10)
	long phoneNumber;
	@DateTimeFormat(iso=ISO.DATE)
	LocalDate lastDonated;
	String location;

	int campId;

}
