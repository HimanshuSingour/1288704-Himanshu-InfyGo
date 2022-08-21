package com.infosys.irs.dto;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import com.infosys.irs.entity.Passenger;

public class PassengerDetails {
	@NotEmpty(message = "Passenger List cannot be empty for booking!")
	List<Passenger> passengerList;

	public List<Passenger> getPassengerList() {
		return passengerList;
	}

	public PassengerDetails() {
		super();
	}

	public PassengerDetails(List<Passenger> passengerList) {
		super();
		this.passengerList = passengerList;
	}

	public void setPassengerList(List<Passenger> passengerList) {
		this.passengerList = passengerList;
	}

	@Override
	public String toString() {
		return "PassengerDetails [passengerList=" + passengerList + "]";
	}

}
