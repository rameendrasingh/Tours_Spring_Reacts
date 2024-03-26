package com.hughes.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hughes.dto.TourRequest;
import com.hughes.dto.TourResponse;
import com.hughes.dto.UpdateTourRequest;
import com.hughes.mapper.TourMapper;
import com.hughes.model.Tour;
import com.hughes.repository.TourRepository;
import com.hughes.service.TourService;

@Service
public class TourImpl implements TourService {
	
	@Autowired
	private TourRepository tourRepository;

	@Override
	public void createTour(TourRequest tourRequest) {
		Tour tour = new Tour();
		tour.setCountry(tourRequest.getCountry());
		tour.setCity(tourRequest.getCity());
		tour.setDays(tourRequest.getDays());
		tour.setDescription(tourRequest.getDescription());
		tour.setStartDate(tourRequest.getStartDate());
		tour.setEndDate(tourRequest.getEndDate());
		tour.setFlightName(tourRequest.getFlightName());
		tour.setHotelName(tourRequest.getHotelName());
		tour.setPrice(tourRequest.getPrice());
		tour.setSeats(tourRequest.getSeats());
		tour.setTourName(tourRequest.getTourName());
		tour.setState(tourRequest.getState());
		tourRepository.save(tour);
	}

	@Override
	public void editTour(Long id, UpdateTourRequest updateTourRequest) {
		// TODO Auto-generated method stub
		boolean exists = tourRepository.existsById(id);
		if(exists) {
			Tour tour = tourRepository.findById(id).get();
			tour.setDays(updateTourRequest.getDays());
			tour.setHotelName(updateTourRequest.getHotelName());
			tour.setFlightName(updateTourRequest.getFlightName());
			tour.setStartDate(updateTourRequest.getStartDate());
			tour.setEndDate(updateTourRequest.getEndDate());
			tourRepository.save(tour);
		} else {
			throw new IllegalArgumentException("Id not exists!");
		}
		
	}

	@Override
	public TourResponse getTourDetails(Long tourId) {
		boolean exists = tourRepository.existsById(tourId);
		if(exists) {

			return tourRepository.findById(tourId)
					.map(TourMapper::mapTourResponse)
					.orElseThrow(() -> new IllegalArgumentException("Tour Not Found for Id: " + tourId));
		}
		else {
			return tourRepository.findById(tourId)
					.map(TourMapper::mapTourResponse)
					.orElseThrow(() -> new IllegalArgumentException("Tour Not Found for Id: " + tourId));
		}
	}

	
	@Override
	public List<TourResponse> getAllTourResponses() {
		List<Tour> tourList = tourRepository.findAll();
		List<TourResponse> tourResponses = new ArrayList<>();

        // Map each Tour object to TourResponse
        for (Tour tour : tourList) {
            TourResponse tourResponse = TourMapper.mapTourResponse(tour);
            tourResponses.add(tourResponse);
        }

        return tourResponses;
	}

	
	@Override
	public String deleteTour(Long tourId) {
		boolean exists = tourRepository.existsById(tourId);
		if(exists) {
			tourRepository.deleteById(tourId);
			return "DELETED";
		}
		else {
			return "NOT FOUND";
		}
	}
		
}
