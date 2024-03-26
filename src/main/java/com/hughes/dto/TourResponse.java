package com.hughes.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TourResponse {

	private String country;
	private String hotelName;
	private String state;
	private String city;
	private String flightName;
	private Double price;
	private Integer days;
	private Date timestamp;
	private String description;
	private String tourName;
	private String startDate;
	private String endDate;
	private Integer seats;
	private byte[] imageData;
}
