package com.hughes.service;

import java.util.List;

import com.hughes.dto.TourRequest;
import com.hughes.dto.TourResponse;
import com.hughes.dto.UpdateTourRequest;

public interface TourService {

	void createTour(TourRequest tourRequest);
	void editTour(Long id, UpdateTourRequest updateTourRequest);
	TourResponse getTourDetails(Long tourId);
	List<TourResponse> getAllTourResponses();
	String deleteTour(Long tourId);
}
