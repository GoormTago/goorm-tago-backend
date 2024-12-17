package com.example.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "matching_data")
public class MatchingData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true)
    private Long userId;

    @Column(nullable = true)
    private String startingPoint;

    @Column(nullable = true)
    private String startingPointLatitude;

    @Column(nullable = true)
    private String startingPointLongitude;

    @Column(nullable = true)
    private String arrivalPoint;

    @Column(nullable = true)
    private String arrivalPointLatitude;

    @Column(nullable = true)
    private String arrivalPointLongitude;

    @Column(nullable = true)
    private Long priority;

    @Column(nullable = true)
    private LocalDateTime createdAt;

    @Column(nullable = true)
    private LocalDateTime updatedAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getStartingPoint() {
		return startingPoint;
	}

	public void setStartingPoint(String startingPoint) {
		this.startingPoint = startingPoint;
	}

	public String getStartingPointLatitude() {
		return startingPointLatitude;
	}

	public void setStartingPointLatitude(String startingPointLatitude) {
		this.startingPointLatitude = startingPointLatitude;
	}

	public String getStartingPointLongitude() {
		return startingPointLongitude;
	}

	public void setStartingPointLongitude(String startingPointLongitude) {
		this.startingPointLongitude = startingPointLongitude;
	}

	public String getArrivalPoint() {
		return arrivalPoint;
	}

	public void setArrivalPoint(String arrivalPoint) {
		this.arrivalPoint = arrivalPoint;
	}

	public String getArrivalPointLatitude() {
		return arrivalPointLatitude;
	}

	public void setArrivalPointLatitude(String arrivalPointLatitude) {
		this.arrivalPointLatitude = arrivalPointLatitude;
	}

	public String getArrivalPointLongitude() {
		return arrivalPointLongitude;
	}

	public void setArrivalPointLongitude(String arrivalPointLongitude) {
		this.arrivalPointLongitude = arrivalPointLongitude;
	}

	public Long getPriority() {
		return priority;
	}

	public void setPriority(Long priority) {
		this.priority = priority;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

    // Getters and Setters
}
