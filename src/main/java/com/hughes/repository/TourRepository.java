package com.hughes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hughes.model.Tour;

public interface TourRepository extends JpaRepository<Tour, Long> {

}
