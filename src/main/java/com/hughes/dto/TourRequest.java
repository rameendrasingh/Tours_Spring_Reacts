package com.hughes.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TourRequest {

	private String country;
	private String hotelName;
	private String state;
	private String city;
	private String flightName;
	private Double price;
	private Integer days;
	private String description;
	private String tourName;
	private String startDate;
	private String endDate;
	private Integer seats;
	private byte[] imageData;
	
}
