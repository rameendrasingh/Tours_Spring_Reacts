package com.hughes.mapper;

import com.hughes.dto.TourResponse;
import com.hughes.model.Tour;

public class TourMapper {

	public static TourResponse mapTourResponse(Tour tour) {
		return TourResponse.builder()
				.days(tour.getDays())
				.country(tour.getCountry())
				.city(tour.getCity())
				.hotelName(tour.getHotelName())
				.state(tour.getState())
				.flightName(tour.getFlightName())
				.price(tour.getPrice())
				.timestamp(tour.getTimestamp())
				.description(tour.getDescription())
				.startDate(tour.getStartDate())
				.endDate(tour.getEndDate())
				.seats(tour.getSeats())
				.tourName(tour.getTourName())
				.build();
	}
}
