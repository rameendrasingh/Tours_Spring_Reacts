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
public class UpdateTourRequest {

	private String hotelName;
	private String flightName;
	private Integer days;
	private String startDate;
	private String endDate;
}
