package com.hughes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.hughes.dto.TourRequest;
import com.hughes.dto.TourResponse;
import com.hughes.dto.UpdateTourRequest;
import com.hughes.service.TourService;

@RestController
@RequestMapping("/tours")
public class TourController {

	@Autowired
	private TourService tourService;

	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> createTour(@RequestBody TourRequest tourRequest) {
		try {
			tourService.createTour(tourRequest);
			return ResponseEntity.ok("TOUR CREATED SUCCESSFULLY");
		} catch (IllegalArgumentException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	

	@PutMapping("/edit/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<String> editTour(@PathVariable Long id, @RequestBody UpdateTourRequest updateTourRequest) {
		try {
			tourService.editTour(id, updateTourRequest);
			return ResponseEntity.ok("Tour Updated Successfully");
		} catch (IllegalArgumentException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}

	}

	@GetMapping("/view/{id}")
	@ResponseStatus(HttpStatus.FOUND)
	public ResponseEntity<?> getTour (@PathVariable Long id) {
		try {
			TourResponse tourResponse = tourService.getTourDetails(id);
			return ResponseEntity.ok(tourResponse);
           } catch (IllegalArgumentException e) {
   			return ResponseEntity.badRequest().body("Id not found!");
   		}
	}
	
	@GetMapping("/view/all")
	@ResponseStatus(HttpStatus.FOUND)
	public List<TourResponse> getToursList() {
		List<TourResponse> list = tourService.getAllTourResponses();
		return list;
	}
	
	@DeleteMapping("/delete/{id}")
	@ResponseStatus(HttpStatus.OK)
	public String deleteTour(@PathVariable Long id) {
			String responseString = tourService.deleteTour(id);
			return responseString;
	}

}
