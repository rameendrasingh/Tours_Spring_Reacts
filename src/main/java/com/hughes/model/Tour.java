package com.hughes.model;

import java.util.Date;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name = "tour")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Tour {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String country;
	private String hotelName;
	private String state;
	private String city;
	private String flightName;
	private Double price;
	private Integer days;
	@CreationTimestamp
	private Date timestamp;
	private String description;
	private String tourName;
	private String startDate;
	private String endDate;
	private Integer seats;
	
	
	
	
	
//	FOR IMAGE ONLY
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "tour_images",
			joinColumns = {
					@JoinColumn(name = "id")
			},
			inverseJoinColumns = {
					@JoinColumn(name = "image_id")
			}
			)
    private Set<ImageModel> tourImages;

}
