package com.example.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "taxi_reservation")
public class TaxiReservation {

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
    private String reservationPhoneNumber;

    @Column(nullable = true)
    private LocalDateTime reservationDatetime;

    @Column(nullable = true)
    private LocalDateTime createdAt;

    @Column(nullable = true)
    private LocalDateTime updatedAt;

    @Column(nullable = true)
    private String callType;

    @Column(nullable = true)
    private String boardingType;

    @Column(nullable = true)
    private String status;

    @Column(nullable = true)
    private String togethers;

    @Column(nullable = true)
    private String memo;

    // Getters and Setters
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

    public String getReservationPhoneNumber() {
        return reservationPhoneNumber;
    }

    public void setReservationPhoneNumber(String reservationPhoneNumber) {
        this.reservationPhoneNumber = reservationPhoneNumber;
    }

    public LocalDateTime getReservationDatetime() {
        return reservationDatetime;
    }

    public void setReservationDatetime(LocalDateTime reservationDatetime) {
        this.reservationDatetime = reservationDatetime;
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

    public String getCallType() {
        return callType;
    }

    public void setCallType(String callType) {
        this.callType = callType;
    }

    public String getBoardingType() {
        return boardingType;
    }

    public void setBoardingType(String boardingType) {
        this.boardingType = boardingType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTogethers() {
        return togethers;
    }

    public void setTogethers(String togethers) {
        this.togethers = togethers;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}
